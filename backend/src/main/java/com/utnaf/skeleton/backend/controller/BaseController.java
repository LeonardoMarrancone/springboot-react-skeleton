package com.utnaf.skeleton.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class BaseController {

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:3030")
    public ArrayList<String> getList() {
        ArrayList<String> response = new ArrayList<String>();
        response.add("Alex");
        response.add("Andrea");
        response.add("Davide");
        response.add("Leonardo");

        return response;
    }
}
