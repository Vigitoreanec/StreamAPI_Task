package org.top.httpparamsexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    // GET http://localhost:8080
    @GetMapping("")
    public String status() {
        return "server is running";
    }

    // GET http://localhost:8080/ping
    @GetMapping("ping")
    public String ping() {
        return "pong";
    }
}
