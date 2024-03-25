package com.mini.rpc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface roleMapper {
    @Select("select pwd from role where name = #{name} and ative = '1'")
    public String queryPwd(String name);

}
