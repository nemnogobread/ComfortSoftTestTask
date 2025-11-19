package com.example.ComfortSoftTestTask;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository {

    @Override
    public List<Integer> getDataFromXLSX(String path) {
        List<Integer> data = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(path);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    try {
                        int value = (int) cell.getNumericCellValue();
                        data.add(value);
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping non-integer value in cell: " + cell.getAddress());
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + path, e);
        }

        return data;
    }
}