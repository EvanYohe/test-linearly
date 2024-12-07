package com.linearly.model;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MatrixService {

    private final List<Matrix> matrices = new ArrayList<>();

    public MatrixService() {
    }

    public int getIndexById(String id) {
        for (int i = 0; i < matrices.size(); i++) {
            if (matrices.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void addMatrix(Matrix matrix) {
        matrices.add(matrix);
    }

    public void removeMatrix(String id) {
        matrices.remove(getIndexById(id));
    }

    public Optional<Matrix> getMatrix(String id){
        return Optional.ofNullable(matrices.get(getIndexById(id)));
    }

    public void setMatrix(String id, Matrix matrix) {
        matrices.set(getIndexById(id), matrix);
    }

    public boolean existsById(String id) {
        for (Matrix matrix : matrices) {
            if (matrix.getId().equals(id)) { return true; }
        }
        return false;
    }

    @PostConstruct
    public void init() {
        matrices.add(new Matrix(3, 3));
        matrices.add(new Matrix(3, 3));
        matrices.add(new Matrix(3, 3));
    }
}
