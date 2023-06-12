$(document).ready(function () {
    cargar();
});

async function cargar() {
    const request = await fetch('/listarNotas', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    const notas = await request.json();

    let listadoHTML = "";
    for (let nota of notas) {
        let fila = '<tr><td>' + nota.id + '</td><td>' + fruta.frutas + '</td><td><button onclick="eliminar(' + nota.id + ')">Eliminar</button></td><td><button onclick="editar(' + nota.id + ')">Editar</button></td></tr>';
        listadoHTML = listadoHTML + fila;
    }

    document.querySelector('#frutas tbody').innerHTML = listadoHTML;
}

async function eliminar(id) {
    const request = await fetch('/eliminar/' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    location.reload();
}


async function crear() {
    let datos = {};
    datos.frutas = document.getElementById('txt').value;

    const request = await fetch('/add', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    location.reload();

}

async function editar(id, frutita) {
    const request = await fetch('/editar/' + document.getElementById('idFruta').value + '/' + document.getElementById('nuevo').value, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

    });

    location.reload();
}