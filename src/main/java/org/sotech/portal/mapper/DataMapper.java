package org.sotech.portal.mapper;

import org.apache.ibatis.annotations.Param;
import org.sotech.portal.model.Parametro;

public interface DataMapper {
    void getData(@Param("param") Parametro param);
}
