package com.utnaf.skeleton.backend.service;

import com.utnaf.skeleton.backend.entity.Movie;
import org.neo4j.driver.*;

import java.util.List;
import java.util.stream.Collectors;

public class Neo4jConnector implements AutoCloseable {
    private Driver driver;

    public Neo4jConnector() {
        driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "admin"));
    }

    public Driver getDriver() {
        return driver;
    }

    public List<Movie> getAll() {
        try (Session session = this.driver.session()) {
            Result result = session.run(
                    "MATCH (m:Movie)" +
                            " RETURN m.title as title, COALESCE(m.tagline, '(no tagline)') as tagline," +
                            " m.released as released"
            );

            return result.stream()
                    .map(Record::asMap)
                    .map(m -> new Movie(
                            m.get("title").toString(),
                            m.get("tagline").toString(),
                            (Long) m.get("released")
                    ))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }
}
