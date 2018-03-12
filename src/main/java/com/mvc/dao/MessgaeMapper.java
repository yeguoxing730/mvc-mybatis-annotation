package com.mvc.dao;

import com.mvc.entity.Messgae;

public interface MessgaeMapper {
    int insert(Messgae record);

    int insertSelective(Messgae record);
}