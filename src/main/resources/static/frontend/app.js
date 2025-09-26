// Cambia la URL si tu backend corre en otro puerto
const BASE_URL = "http://localhost:8080/api";

// Cargar usuarios
async function cargarUsuarios() {
  const res = await fetch(`${BASE_URL}/usuarios`);
  const data = await res.json();
  let tbody = document.getElementById("tablaUsuarios");
  tbody.innerHTML = "";
  data.forEach(u => {
    tbody.innerHTML += `
      <tr>
        <td>${u.idUsuario}</td>
        <td>${u.nombre}</td>
        <td>${u.carrera || "-"}</td>
        <td>${u.correo}</td>
      </tr>`;
  });
}

// Cargar salas
async function cargarSalas() {
  const res = await fetch(`${BASE_URL}/salas`);
  const data = await res.json();
  let tbody = document.getElementById("tablaSalas");
  tbody.innerHTML = "";
  data.forEach(s => {
    tbody.innerHTML += `
      <tr>
        <td>${s.idSala}</td>
        <td>${s.nombreSala}</td>
        <td>${s.capacidad}</td>
        <td>${s.estado}</td>
      </tr>`;
  });
}

// Cargar reservas
async function cargarReservas() {
  const res = await fetch(`${BASE_URL}/reservas`);
  const data = await res.json();
  let tbody = document.getElementById("tablaReservas");
  tbody.innerHTML = "";
  data.forEach(r => {
    tbody.innerHTML += `
      <tr>
        <td>${r.idReserva}</td>
        <td>${r.usuario.nombre}</td>
        <td>${r.sala.nombreSala}</td>
        <td>${r.fechaReserva}</td>
        <td>${r.horaInicio}</td>
        <td>${r.horaFin}</td>
      </tr>`;
  });
}

// Ejecutar al cargar
cargarUsuarios();
cargarSalas();
cargarReservas();
