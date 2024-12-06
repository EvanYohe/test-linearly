@import com.linearly.model.Matrix

@param Matrix matrixA
@param Matrix matrixB

@param int rowsMatrixA = 3
@param int colsMatrixA = 3

@param int rowsMatrixB = 3
@param int colsMatrixB = 3

<h2 class="text-center">Matrix Calculator</h2>
<div class="row m-2">
    <div class="col-6">
        <div class="container" id="matrix-A">
             @template.input-matrix-A(matrixA, rowsMatrixA, colsMatrixA)
        </div>
        <div class="row m-1">
            <form 
                hx-get="/submit-matrix-A"
                hx-target="#matrix-A"
                hx-swap="innerHTML">
                <input
                    type="text"
                    name="rowsMatrixA"><!-- These correspond to the @RequestParam in the Controller class -->
                <input
                    type="text"
                    name="colsMatrixA"><!-- These correspond to the @RequestParam in the Controller class -->
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
    <div class="col-6">
        <div class="container" id="matrix-B">
             @template.input-matrix-B(matrixB, rowsMatrixB, colsMatrixB)
        </div>
        <div class="row m-1">
            <form 
                hx-get="/submit-matrix-B"
                hx-target="#matrix-B"
                hx-swap="innerHTML">
                <input
                    type="text"
                    name="rowsMatrixB"><!-- These correspond to the @RequestParam in the Controller class -->
                <input
                    type="text"
                    name="colsMatrixB"><!-- These correspond to the @RequestParam in the Controller class -->
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
    <div class="container m-1">
        <div class="row m-1 justify-content-center align-items-center text-center">
            <div class="col-4 d-grid gap-2 mx-auto">
            
                <button type="button" 
                        class="btn btn-secondary"
                        hx-post="/build-matrix-A"
                        hx-target="#matrix-A">Add</button></div>

            <div class="col-4 d-grid gap-2 mx-auto"><button type="button" class="btn btn-secondary">Subtract</button></div>
            <div class="col-4 d-grid gap-2 mx-auto"><button type="button" class="btn btn-secondary">Multiply</button></div>
        </div>
        <div class="row m-1 justify-content-center align-items-center text-center">
            <div class="col-4 d-grid gap-2 mx-auto"><button type="button" class="btn btn-secondary">Inverse</button></div>
            <div class="col-4 d-grid gap-2 mx-auto"><button type="button" class="btn btn-secondary">Transpose</button></div>
            <div class="col-4 d-grid gap-2 mx-auto"><button type="button" class="btn btn-secondary">Determinant</button></div>
        </div>
    </div>

    <div class="container border border-top border-primary">
        <div class="row m-2">
            <div class="col-8">
                <table id="output-matrix" class="m-2 table table-bordered border-secondary mx-auto border border-3 border-primary text-center">
                <tr>
                    <td><input type="text" class="form-control"></td>
                    <td><input type="text" class="form-control"></td>
                    <td><input type="text" class="form-control"></td>
                </tr>
                <tr>
                    <td><input type="text" class="form-control"></td>
                    <td><input type="text" class="form-control"></td>
                    <td><input type="text" class="form-control"></td>
                </tr>
                <tr>
                    <td><input type="text" class="form-control"></td>
                    <td><input type="text" class="form-control"></td>
                    <td><input type="text" class="form-control"></td>
                </tr>
            </table>
            </div>
            <div class="col-4">
                <h2>Operation</h2>
                <p>This paragraph will describe the output based on the operation</p>
            </div>
        </div>
    </div>
</div>