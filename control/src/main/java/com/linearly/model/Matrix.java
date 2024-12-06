package com.linearly.model;

public class Matrix {

    private int rowDimension;
    private int colDimension;
    private double[][] matrix;
    final double EPSILON = 1.0e-6;

    /**
     * Default constructor for creating an empty matrix
     * 
     */
    public Matrix() {
        this.rowDimension = 3;
        this.colDimension = 3;
        this.matrix = new double[rowDimension][colDimension];
    }

    /**
     * Constructor for creating a matrix from a 2D array
     * 
     * @param matrix
     */
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.rowDimension = matrix.length;
        this.colDimension = matrix[0].length;
    }

    /**
     * Constructor for creating an empty matrix of zeros with size m x n
     * 
     * @param rowDimension
     * @param colDimension
     */
    public Matrix(int rowDimension, int colDimension) {
        this.rowDimension = rowDimension;
        this.colDimension = colDimension;
        this.matrix = new double[rowDimension][colDimension];
    }

    /**
     * Returns the number of rows in the matrix
     * 
     * @return int
     */
    public int getRowDimension() {
        return rowDimension;
    }

    public void setRowDimension(int rowDimension) {
        this.rowDimension = rowDimension;
    }

    /**
     * Returns the number of columns in the matrix
     * 
     * @return int
     */
    public int getColDimension() {
        return colDimension;
    }
    
    public void setColDimension(int colDimension) {
        this.colDimension = colDimension;
    }

    /**
     * Returns the matrix as a 2D array of doubles
     * 
     * @return double[][]
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * Sets the matrix to a 2D array of doubles
     * 
     * @param matrix
     */
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Gets the value of a matrix entry at a given row and column
     * 
     * @param row
     * @param col
     */
    public double getEntry(int row, int col) {
        return matrix[row][col];
    }

    /**
     * Sets the value of a matrix entry at a given row and column
     * 
     * @param row
     * @param col
     * @param value
     */
    public void setEntry(int row, int col, double value) {
        matrix[row][col] = value;
    }

    /**
     * Internal print function for terminal testing
     * 
     */
    public void printMatrix() {

        String format = "| %5.3f ";

        for (int i = 0; i < colDimension; i++) {
            System.out.print("+-------");
        }
        System.out.println("+");
		for (int i = 0; i < rowDimension; i++) {
			for (int j = 0; j < colDimension; j++) {
				System.out.printf(format, getEntry(i, j));
			}
			System.out.println("|");
            for (int k = 0; k < colDimension; k++) {
                System.out.print("+-------");
            }
            System.out.println("+");
		}
    }
}
