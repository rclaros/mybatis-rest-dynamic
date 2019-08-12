package org.sotech.portal.model;

import java.util.HashMap;
import java.util.List;

public class Result {

    private List<HashMap> maps;
    private Integer size;

    public List<HashMap> getMaps() {
        return maps;
    }

    public void setMaps(List<HashMap> maps) {
        this.maps = maps;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
