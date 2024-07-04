function mostrarContrasenas() {
    // Obtener todos los elementos de tipo contraseña en el formulario
    var contrasenas = document.querySelectorAll('input[type="password"]');

    // Iterar sobre cada campo de contraseña y cambiar su tipo a texto
    contrasenas.forEach(function(contrasena) {
        contrasena.type = "text";
    });

    // Después de 2 segundos, ocultar nuevamente las contraseñas
    setTimeout(function() {
        contrasenas.forEach(function(contrasena) {
            contrasena.type = "password";
        });
    }, 2000);
}

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});

var myModal = document.getElementById('myModal')
var myInput = document.getElementById('myInput')

myModal.addEventListener('shown.bs.modal', function () {
  myInput.focus()
})

window.addEventListener('DOMContentLoaded', event => {
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple, {
            labels: {
                placeholder: "Buscar...", // Placeholder del campo de búsqueda
                perPage: " registros por página", // Opción para seleccionar cuántos registros mostrar por página
                noRows: "No se encontraron registros", // Mensaje cuando no se encuentran registros
                info: "Mostrando registros del {start} al {end} de un total de {rows} registros", // Información de los registros mostrados
            },
            // Aquí puedes seguir añadiendo otras opciones y etiquetas necesarias
        });
    }
});