package com.linearly.controller;

import com.linearly.model.Matrix;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
* Currently working on this Controller.
* The intention is to have the user input the values of the matrix
* into the input fields of the table and then grab the values and
* store them in the Matrix object when any of the operation buttons are clicked
* 
* The operation buttons would then use the Matrix object(s) with the operation
* logic and then write the values of the matrix to the output matrix table
*/
@Controller
public class MatrixController {

    /*
     * This method loads the matrix-module.jte render into the module-container
     * div on the index page.
     */
    @GetMapping("/matrix-module")
    public String loadMatrixModule(Model model) {

        model.addAttribute("matrixA", new Matrix(3, 3));
        model.addAttribute("matrixB", new Matrix(3, 3));

        return "matrix-module";
    }

    /*
     * Right now, this method works and can sucessfully resize the table
     * to the dimensions the user puts in the input field. But I have one method
     * for each input matrix and it feels like this could be done in one method.
     */
    @GetMapping("/submit-matrix-A")
    public String submitInputA( @RequestParam int rowsMatrixA,
                                @RequestParam int colsMatrixA,
                                Matrix matrixA,
                                Model model) {

        matrixA.setRowDimension(rowsMatrixA);
        matrixA.setColDimension(colsMatrixA);
        model.addAttribute("matrixA", matrixA);
        model.addAttribute("rowsMatrixA", rowsMatrixA);
        model.addAttribute("colsMatrixA", colsMatrixA);

        return "input-matrix-A";
    }

    @GetMapping("/submit-matrix-B")
    public String submitInputB( @RequestParam int rowsMatrixB,
                                @RequestParam int colsMatrixB,
                                Matrix matrixB,
                                Model model) {

        matrixB.setRowDimension(rowsMatrixB);
        matrixB.setColDimension(colsMatrixB);
        model.addAttribute("matrixB", matrixB);
        model.addAttribute("rowsMatrixB", rowsMatrixB);
        model.addAttribute("colsMatrixB", colsMatrixB);

        return "input-matrix-B";
    }

    /*
     * This is the part that I got stuck on. Trying to retrieve the
     * values from the input fields of the table and store them in the
     * Matrix object.
     * I temporarily have this set up to use the addition button but ideally 
     * this would be called by any of the operations buttons to get the matrix
     * values for the logic to do the calculations.
     */
    @PostMapping("/build-matrix-A")
    public String buildMatrixA( @RequestParam Matrix matrixA, 
                                Model model) {
        
        return "redirect";
    }
}