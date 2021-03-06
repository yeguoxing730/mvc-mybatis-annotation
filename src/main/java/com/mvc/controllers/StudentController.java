package com.mvc.controllers;

import com.mvc.entity.Student;
import com.mvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping()
    public String Get() {
        System.out.println(studentService.selectByPrimaryKey(2));
        List<Student> students = studentService.selectByCondition(new Student());
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(students);
        return jsonResult;
    }
}
