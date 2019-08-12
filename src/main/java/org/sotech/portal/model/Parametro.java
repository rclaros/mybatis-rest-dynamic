package org.sotech.portal.model;

import java.io.Serializable;

public class Parametro implements Serializable {

    private String ubigeo;
    private String marco;
    private String queryId;
    private Integer periodo;
    private Integer pnum;
    private Integer psize;

    private Object items;
    private Integer size;

    public Parametro() {
    }

    public Parametro(String ubigeo, String marco) {
        this.ubigeo = ubigeo;
        this.marco = marco;
    }

    public Parametro(String ubigeo, String marco, String queryId) {
        this.ubigeo = ubigeo;
        this.marco = marco;
        this.queryId = queryId;
    }

    public Parametro(String ubigeo, String marco, String queryId, Integer periodo) {
        this.ubigeo = ubigeo;
        this.marco = marco;
        this.queryId = queryId;
        this.periodo = periodo;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getMarco() {
        return marco;
    }

    public void setMarco(String marco) {
        this.marco = marco;
    }

    public Object getItems() {
        return items;
    }

    public void setItems(Object items) {
        this.items = items;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public Integer getPsize() {
        return psize;
    }

    public void setPsize(Integer psize) {
        this.psize = psize;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
