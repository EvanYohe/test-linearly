package com.linearly.controller;

import com.linearly.model.Matrix;
import com.linearly.model.MatrixService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/matrices")
public class TestMatrixController {

    private final MatrixService matrixService;

    public TestMatrixController(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    @GetMapping("/{id}")
    public Matrix getMatrixById(@PathVariable String id) {
        return matrixService.getMatrix(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void addMatrix(@RequestBody Matrix matrix) {
        matrixService.addMatrix(matrix);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateMatrix(@RequestBody Matrix matrix, @PathVariable String id){
        if(!matrixService.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        matrixService.setMatrix(id, matrix);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void removeMatrix(@PathVariable String id){
        if(!matrixService.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        matrixService.removeMatrix(id);
    }
}