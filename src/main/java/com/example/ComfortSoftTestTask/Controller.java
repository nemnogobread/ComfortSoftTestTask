package com.example.ComfortSoftTestTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/get-n-statistics")
    public Integer getNStatisrics(
            @RequestParam String path,
            @RequestParam Integer n
    ){
        return service.findNStatistics(path, n);
    }
}
