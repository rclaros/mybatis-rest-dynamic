package org.sotech.portal.service;

import java.util.HashMap;
import org.sotech.portal.model.Parametro;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import org.sotech.portal.mapper.DataMapper;
import org.sotech.portal.model.Result;

@Service
public class DataService {

    @Resource
    private DataMapper userMapper;


    public Result getListData(String ubigeo, String marco, String periodo, String queryId, String pnum, String psize) {
        Parametro param = new Parametro(ubigeo, marco, queryId, (periodo != null ? Integer.parseInt(periodo.trim()) : null));
        if (pnum != null) {
            param.setPnum(Integer.parseInt(pnum));
        }
        if (psize != null) {
            param.setPsize(Integer.parseInt(psize));
        }
        userMapper.getData(param);
        Result result = new Result();
        result.setMaps((List<HashMap>) param.getItems());
        result.setSize(param.getSize());
        return result;
    }

}
