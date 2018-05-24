package edu.nwafu.paper.controller;

import edu.nwafu.paper.beans.Teacher;
import edu.nwafu.paper.module.ResponseBody;
import edu.nwafu.paper.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/login")
    public ResponseBody checkLogin(String username, String password) {
        Teacher checkLogin = teacherService.checkLogin(username, password);
        return new ResponseBody(checkLogin);
    }
}
