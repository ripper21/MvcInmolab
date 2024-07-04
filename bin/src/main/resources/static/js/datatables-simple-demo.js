window.addEventListener('DOMContentLoaded', event => {
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple, {
            labels: {
                placeholder: "Buscar...", // Placeholder del campo de búsqueda
                perPage: "{select} registros por página", // Opción para seleccionar cuántos registros mostrar por página
                noRows: "No se encontraron registros", // Mensaje cuando no se encuentran registros
                info: "Mostrando registros del {start} al {end} de un total de {rows} registros", // Información de los registros mostrados
            },
            // Aquí puedes seguir añadiendo otras opciones y etiquetas necesarias
        });
    }
});