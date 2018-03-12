package com.mvc.dao;

import com.mvc.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(int uid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(int uid);

    List<Student> selectByCondition(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
