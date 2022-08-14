if (document.getElementsByClassName('eliminarPersona') != null) {
    function swEliminar(id) {
        if (id != null) {
            swal({
                    title: "¿Esta seguro de eliminar?",
                    text: "Una vez eliminado no podrás recuperarlo",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonClass: "btn-danger",
                    confirmButtonText: "Eliminar",
                    cancelButtonClass: "btn-success",
                    cancelButtonText: "Cancelar",
                    closeOnConfirm: false,
                    closeOnCancel: true
                },
                function (isConfirm) {
                    if (isConfirm) {
                        eliminar(id);
                        setTimeout(function () {
                            parent.location.href = "consultar?result=true&message=Persona%20eliminada%20correctamente&status=200";
                        }, 2500);
                    }
                });
        } else {
            swal("Error", "Un error interno ocurrió dentro del sistema", "error");
        }

        function eliminar(id) {
            var url = "eliminar?id=" + id;
            $.ajax({
                type: 'POST',
                url: url,
                async: true,
                timeout: 2500,
                success: function () {
                    swal("¡Eliminado!", "La persona se ha eliminado correctamente", "success");
                },
                error: function () {
                    swal("Error", "Un error interno ocurrió dentro del sistema", "error");
                }

            });
        }
    }
}