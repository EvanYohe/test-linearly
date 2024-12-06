package com.linearly.operations;

import com.linearly.model.Matrix;

public class MatrixOperations {

    /**
     * Determines if a matrix is n x n dimensional (square)
     * 
     * @param matrix
     * @return boolean
     */
    public static boolean isSquare(Matrix matrix) {

        return matrix.getRowDimension() == matrix.getColDimension();
    }

    /**
     * Determines if a matrix is invertible using gaussian elimination
     * 
     * @param matrix
     * @return boolean
     */
    // TODO: REVISIT WITH GAUSSIAN ELIMINATION TO REDUCE COMPUTATION
    public static boolean isInvertible(Matrix matrix) {

        Matrix copy = new Matrix(matrix.getMatrix());
        copy = EliminationOperations.reducedRowEchelonForm(copy);

        if (!isIdentity(copy)) return false;

        return true;
    }

    /**
     * Determines if the ij-th entry is equal to the ji-th entry for all i, j
     * i.e. if the matrix is symmetrix along the main diagonal
     * 
     * @param matrix
     * @return boolean
     */
    public static boolean isSymmetric(Matrix matrix) {

        if (!isSquare(matrix)) return false;

        for (int i = 0; i < matrix.getRowDimension(); i++) {
            for (int j = 0; j < matrix.getColDimension(); j++) {
                if (matrix.getEntry(i, j) != matrix.getEntry(j, i)) return false;
            }
        }
        return true;
    }

    /**
     * Determines if the ij-th entry is equal to zero for all i != j
     * i.e. if the matrix entry has a value of zero when i != j
     * 
     * @param matrix
     * @return boolean
     */
    public static boolean isDiagonal(Matrix matrix) {

        if (!isSquare(matrix)) return false;

        for (int i = 0; i < matrix.getRowDimension(); i++) {
            for (int j = 0; j < matrix.getColDimension(); j++) {
                if (matrix.getEntry(i, j) != matrix.getEntry(j, i)) return false;
            }
        }
        return true;
    }

    /**
     * Determines if the ij-th entry is equal to 1 for all i == j
     * i.e. if the matrix entry has a value of one when i == j
     * 
     * @param matrix
     * @return boolean
     */
    public static boolean isIdentity(Matrix matrix) {

        if (!isDiagonal(matrix)) return false;

        for (int i = 0; i < matrix.getRowDimension(); i++) {
            if (matrix.getEntry(i, i) != 1) return false;
        }
        return true;
    }

    /**
     * Returns the sum of two matrices
     * 
     * @param matrixOne
     * @param matrixTwo
     * @return Matrix
     */
    public static Matrix add(Matrix matrixOne, Matrix matrixTwo) {

        if (matrixOne.getRowDimension() != matrixTwo.getRowDimension() ||
            matrixOne.getColDimension() != matrixTwo.getColDimension()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        Matrix result = new Matrix(matrixOne.getRowDimension(), matrixOne.getColDimension());

        for (int i = 0; i < matrixOne.getRowDimension(); i++) {
            for (int j = 0; j < matrixOne.getColDimension(); j++) {
                result.setEntry(i, j, matrixOne.getEntry(i, j) + matrixTwo.getEntry(i, j));
            }
        }
        return result;
    }

    /**
     * Returns the difference of two matrices
     * 
     * @param matrixOne
     * @param matrixTwo
     * @return Matrix
     */
    public static Matrix subtract(Matrix matrixOne, Matrix matrixTwo) {
            
            if (matrixOne.getRowDimension() != matrixTwo.getRowDimension() ||
                matrixOne.getColDimension() != matrixTwo.getColDimension()) {
                throw new IllegalArgumentException("Matrices must have the same dimensions");
            }
    
            Matrix result = new Matrix(matrixOne.getRowDimension(), matrixOne.getColDimension());
    
            for (int i = 0; i < matrixOne.getRowDimension(); i++) {
                for (int j = 0; j < matrixOne.getColDimension(); j++) {
                    result.setEntry(i, j, matrixOne.getEntry(i, j) - matrixTwo.getEntry(i, j));
                }
            }
            return result;
    }

    /**
     * Returns the product of two matrices
     * 
     * @param matrixOne
     * @param matrixTwo
     * @return Matrix
     */
    public static Matrix multiply(Matrix matrixOne, Matrix matrixTwo) {

        if (matrixOne.getColDimension() != matrixTwo.getRowDimension()) {
            throw new IllegalArgumentException("Matrix A must have the same number of columns as the number of rows in Matrix B");
        }

        Matrix result = new Matrix(matrixOne.getRowDimension(), matrixTwo.getColDimension());

        for (int i = 0; i < matrixOne.getRowDimension(); i++) {
            for (int j = 0; j < matrixTwo.getColDimension(); j++) {
                double sum = 0;
                for (int k = 0; k < matrixOne.getColDimension(); k++) {
                    sum += matrixOne.getEntry(i, k) * matrixTwo.getEntry(k, j);
                }
                result.setEntry(i, j, sum);
            }
        }
        return result;
    }

    /**
     * Returns the transpose of the matrix
     * i.e rows become columns and columns become rows
     * 
     * @param matrix
     * @return Matrix
     */
    public static Matrix getTranspose(Matrix matrix) {

        Matrix transpose = new Matrix(matrix.getColDimension(), matrix.getRowDimension());

        for (int i = 0; i < matrix.getRowDimension(); i++) {
            for (int j = 0; j < matrix.getColDimension(); j++) {
                transpose.setEntry(j, i, matrix.getEntry(i, j));
            }
        }        
        return transpose;
    }

    /**
     * Returns the inverse of the matrix
     * i.e. the matrix that when multiplied by the original matrix gives the identity matrix
     * 
     * @param matrix
     * @return Matrix
     */
    public static Matrix getInverse(Matrix matrix) {

        Matrix copy = new Matrix(matrix.getMatrix());
        Matrix identity = new Matrix(matrix.getRowDimension(), matrix.getColDimension());

        //if (!isSquare(copy)) throw new IllegalArgumentException("Matrix must be square");
        //if (!isInvertible(copy)) throw new IllegalArgumentException("Matrix is not invertible");

        copy = new Matrix(copy.getRowDimension(), copy.getColDimension() * 2);

        for (int i = 0; i < matrix.getRowDimension(); i++) {
            for (int j = 0; j < matrix.getColDimension(); j++) {
                copy.setEntry(i, j, matrix.getEntry(i, j));
            }
            copy.setEntry(i, i + matrix.getColDimension(), 1);
        }

        EliminationOperations.reducedRowEchelonForm(copy);

        for (int i = 0; i < matrix.getRowDimension(); i++) {
           for (int j = 0; j < matrix.getColDimension(); j++) {
               identity.setEntry(i, j, copy.getEntry(i, j + matrix.getColDimension()));
           }
        }
        return identity;
    }

    // TODO: REVISIT
    public static double getDeterminant(Matrix matrix) {

        if (!isSquare(matrix)) throw new IllegalArgumentException("Matrix must be square");
        if (isIdentity(matrix)) return 1;

        if (matrix.getRowDimension() == 1) return matrix.getEntry(0, 0);

        if (matrix.getRowDimension() == 2) {
            return (matrix.getEntry(0, 0) * matrix.getEntry(1, 1)) - 
                    (matrix.getEntry(0, 1) * matrix.getEntry(1, 0));
        }
        if (matrix.getRowDimension() == 3) {
            return (matrix.getEntry(0, 0) * matrix.getEntry(1, 1) * matrix.getEntry(2, 2)) +
                    (matrix.getEntry(0, 1) * matrix.getEntry(1, 2) * matrix.getEntry(2, 0)) +
                    (matrix.getEntry(0, 2) * matrix.getEntry(1, 0) * matrix.getEntry(2, 1)) -
                    (matrix.getEntry(0, 2) * matrix.getEntry(1, 1) * matrix.getEntry(2, 0)) -
                    (matrix.getEntry(0, 0) * matrix.getEntry(1, 2) * matrix.getEntry(2, 1)) -
                    (matrix.getEntry(0, 1) * matrix.getEntry(1, 0) * matrix.getEntry(2, 2));
        }
        if (isDiagonal(matrix)) {
            double determinant = 1;
            for (int i = 0; i < matrix.getRowDimension(); i++) {
                determinant *= matrix.getEntry(i, i);
            }
            return determinant;
        }
        
        return laplaceExpansion(matrix);
    }

    // TODO: REVISIT
    private static double laplaceExpansion(Matrix matrix) {

        if (matrix.getRowDimension() == 3) {
            return (matrix.getEntry(0, 0) * matrix.getEntry(1, 1) * matrix.getEntry(2, 2)) +
                    (matrix.getEntry(0, 1) * matrix.getEntry(1, 2) * matrix.getEntry(2, 0)) +
                    (matrix.getEntry(0, 2) * matrix.getEntry(1, 0) * matrix.getEntry(2, 1)) -
                    (matrix.getEntry(0, 2) * matrix.getEntry(1, 1) * matrix.getEntry(2, 0)) -
                    (matrix.getEntry(0, 0) * matrix.getEntry(1, 2) * matrix.getEntry(2, 1)) -
                    (matrix.getEntry(0, 1) * matrix.getEntry(1, 0) * matrix.getEntry(2, 2));
        }

        double determinant = 0;

        for (int i = 0; i < matrix.getRowDimension(); i++) {
            int sign = ((i & 1) == 0) ? + 1 : - 1;
            determinant += sign * matrix.getEntry(0, i) * laplaceExpansion(subMatrix(matrix, 0, i));
        }

        return determinant;
    }

    // TODO: REVISIT
    private static Matrix subMatrix(Matrix matrix, int excludedRow, int excludedCol) {

        Matrix subMatrix = new Matrix(matrix.getRowDimension() - 1, matrix.getColDimension() - 1);
        int rowPointer = -1;

        for (int i = 0; i < matrix.getRowDimension(); i++) {
          if (i == excludedRow) continue;
          
          ++rowPointer;
          int colPointer = -1;

          for (int j = 0; j < matrix.getRowDimension(); j++) {
            if (j == excludedCol) continue;

            subMatrix.setEntry(rowPointer, ++colPointer, matrix.getEntry(i, j));
          }
        }
        return subMatrix;
    }
}
