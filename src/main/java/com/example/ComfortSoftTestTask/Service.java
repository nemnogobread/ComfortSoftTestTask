package com.example.ComfortSoftTestTask;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    public Integer findNStatistics(String path, int n){
        return 1;
    }
}
