package com.example.ComfortSoftTestTask;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Controller {
    @Autowired
    private final Service service;

    @GetMapping("/get-n-statistics")
    public Integer getNStatisrics(@RequestBody String path, int n){
        return service.findNStatistics(path, n);
    }
}
