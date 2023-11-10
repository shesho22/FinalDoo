// Archivo "tipo_documento.js"
const { v4: uuidv4 } = require('uuid'); // Importa la función v4 de la biblioteca uuid

// Función para crear un Tipo de Documento
function createDocumentType() {
  const codigo = document.getElementById("codigo").value;
  const nombre = document.getElementById("nombre").value;
  const estado = true;
  const id = uuidv4(); // Genera un UUID aleatorio

  const newDocumentType = {
    id: id, // Asigna el UUID aleatorio
    codigo: codigo,
    nombre: nombre,
    estado: estado,
  };

  fetch('http://localhost/gestorgimnasio/api/v1/tipoidentificacion', {
    method: 'POST',
    headers: {
      'accept': '*/*',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(newDocumentType),
  })
    .then((response) => response.json())
    .then((data) => {
      // Procesa la respuesta o realiza alguna acción
      console.log('Tipo de Documento creado:', data);

      // Limpia los campos de entrada después de crear el registro
      document.getElementById("codigo").value = "";
      document.getElementById("nombre").value = "";

      // Muestra un mensaje de éxito en la página
      const responseMessage = document.getElementById("response-message");
      responseMessage.innerText = 'Tipo de Documento creado con éxito';

      // Puedes realizar otras acciones, como actualizar la lista de tipos de documento
      // o mostrar un mensaje de éxito en la página
    })
    .catch((error) => {
      console.error('Error al crear el Tipo de Documento:', error);
    });
}
