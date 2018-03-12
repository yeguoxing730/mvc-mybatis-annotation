package com.mvc.service;

import com.mvc.entity.Student;

import java.util.List;

/**
 * Created by yeguo on 2018/3/11.
 */
public interface IStudentService {
    int deleteByPrimaryKey(int uid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(int uid);

    List<Student> selectByCondition(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

}
