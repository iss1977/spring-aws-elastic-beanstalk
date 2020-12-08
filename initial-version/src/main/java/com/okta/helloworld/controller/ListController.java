package com.okta.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {

    class Student implements Serializable {
        public Integer studentId;
        public Character gender;

        public Student(Integer studentId, String studentName , Character gender) {
            this.studentId = studentId;
            this.studentName = studentName;
            this.gender = gender;
        }

        public String getStudentName() {
            return studentName;
        }

        public String studentName;

    }

    @GetMapping({"getlist"})
    String getList (@RequestParam(required = false, defaultValue = "id_01") String id, Model model){
        model.addAttribute("myattr_id", id);

        // Define an array and loop in Thymeleaf template through it.
        List<Student> data = new ArrayList<Student>();
        data.add(new Student(1,"Stundent 01 Bangalez",'M'));
        data.add(new Student(2,"Stundent 02 Somalezoaica", 'F'));
        data.add(new Student(3,"Stundent 03 Olandez", 'M'));

        model.addAttribute("data",data);
        return "list-view";

    }

}
