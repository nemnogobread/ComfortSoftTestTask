package com.example.ComfortSoftTestTask;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository {
    public List<Integer> getDataFromCSV(String path);
}
