@param com.linearly.model.Matrix matrixB
@param int rowsMatrixB
@param int colsMatrixB


<table id="input-matrix-A" modelAttribute="matrixB" class="m-2 table table-bordered border-secondary mx-auto border border-3 border-primary text-center">
    @for (int i = 0; i < rowsMatrixB; i++)
        <tr>
            @for (int j = 0; j < colsMatrixB; j++)
                <td><input type="text" name="${1}" class="form-control"></td>
            @endfor
        </tr>
    @endfor
</table>