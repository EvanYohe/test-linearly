<!-- Header of Module -->
<h2 class="text-center">Elimination Calculator</h2>
<!-- Row Wrapper for double matricies -->
<div class="row m-2">
    <!-- Input matrix -->
    <div class="col">
        <table id="input-matrix" class="m-2 table table-bordered border-secondary mx-auto border border-3 border-primary text-center">
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
         <!-- Add/Remove matrix rows or columns button group -->
        <div class="row">
            <div class="col-6"><input type="number" class="form-control" id="row-input" placeholder="Rows"></div>
            <div class="col-6"><input type="number" class="form-control" id="col-input" placeholder="Columns"></div>
        </div>
    </div>
    <!-- Button group for matrix operations -->
    <div class="container">
        <div class="row m-2">
            <div class="row m-1 justify-content-center align-items-center text-center">
                <div class="col-6 d-grid gap-2 mx-auto"><button type="button" class="btn btn-secondary">Row-Echelon Form</button></div>
                <div class="col-6 d-grid gap-2 mx-auto"><button type="button" class="btn btn-secondary">Reduced Row-Echelon Form</button></div>
            </div>
        </div>
    </div>
</div>