package com.utnaf.skeleton.backend.controller;

import com.utnaf.skeleton.backend.entity.Movie;
import com.utnaf.skeleton.backend.service.Neo4jConnector;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:3030")
    public List<Movie> getList() {
        Neo4jConnector neo4j = new Neo4jConnector();

        return neo4j.getAll();
    }
}
