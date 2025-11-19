package com.example.ComfortSoftTestTask;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    public Integer findNStatistics(String path, int n){
        List<Integer> list = repository.getDataFromXLSX(path);

        return 1;
    }
}
