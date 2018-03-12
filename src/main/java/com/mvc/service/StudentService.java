package com.mvc.service;

import com.mvc.dao.StudentMapper;
import com.mvc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")

public class StudentService implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    public int deleteByPrimaryKey(int uid) {
        return studentMapper.deleteByPrimaryKey(uid);
    }
    @CachePut(value = "localCacheService", key="#record.uid")
    public int insert(Student record) {
        printInfo("insert");
        return studentMapper.insert(record);
    }

    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }
    @Cacheable(value = "localCacheService", key="#uid")
    public Student selectByPrimaryKey(int uid) {
        printInfo("selectByPrimaryKey");
        return studentMapper.selectByPrimaryKey(uid);
    }

    public List<Student> selectByCondition(Student record) {
        return studentMapper.selectByCondition(record);
    }
    @CacheEvict(value = "localCacheService", key="#record.uid")
    public int updateByPrimaryKeySelective(Student record) {
        printInfo("updateByPrimaryKeySelective");
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }
    private void printInfo(Object str){
        System.out.println("非缓存查询----------"+str);
    }
}
