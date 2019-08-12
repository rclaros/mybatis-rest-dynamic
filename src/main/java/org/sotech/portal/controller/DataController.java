package org.sotech.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sotech.portal.service.DataService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.sotech.portal.model.Result;

@Controller
public class DataController {

    @Resource
    private DataService userService;

    final static Logger log = Logger.getLogger(DataController.class);

    @RequestMapping("datos")
    public void getDatos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] query_list = (req.getParameter("querys") != null ? req.getParameter("querys").split(",") : new String[]{});
        JsonObjectBuilder json_data = Json.createObjectBuilder();
        for (String queryId : query_list) {
            JsonObjectBuilder json_item = Json.createObjectBuilder();
            JsonArrayBuilder lista_datos = Json.createArrayBuilder();
            Result result = userService.getListData(req.getParameter("ubigeo"), req.getParameter("marco"), req.getParameter("periodo"), queryId, req.getParameter("pnum"), req.getParameter("psize"));
            List<HashMap> datos = result.getMaps();
            if (!datos.isEmpty()) {
                for (HashMap map : datos) {
                    Iterator entries = map.entrySet().iterator();
                    JsonObjectBuilder registro = Json.createObjectBuilder();
                    while (entries.hasNext()) {
                        Map.Entry entry = (Map.Entry) entries.next();
                        registro.add(entry.getKey().toString(), entry.getValue().toString());
                    }
                    lista_datos.add(registro);
                }
                json_item.add("size", result.getSize() != null ? result.getSize() : datos.size());
            }
            json_item.add("data", lista_datos);
            json_data.add(queryId, json_item);
        }
        json_data.add("success", true);
        resp.setContentType(MediaType.APPLICATION_JSON);
        try (JsonWriter jsonWriter = Json.createWriter(resp.getOutputStream())) {
            jsonWriter.writeObject(json_data.build());
        }
    }

}
