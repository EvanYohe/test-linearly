@param com.linearly.model.Matrix matrixA
@param int rowsMatrixA
@param int colsMatrixA


<table id="input-matrix-A" modelAttribute="matrixA" class="m-2 table table-bordered border-secondary mx-auto border border-3 border-primary text-center">
    @for (int i = 0; i < rowsMatrixA; i++)
        <tr>
            @for (int j = 0; j < colsMatrixA; j++)
                <td><input type="text" name="${1}" class="form-control"></td>
            @endfor
        </tr>
    @endfor
</table>