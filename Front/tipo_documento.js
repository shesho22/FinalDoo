// Espera a que el documento HTML se cargue completamente
document.addEventListener('DOMContentLoaded', function () {

  // Función para obtener la lista de Tipos de Documento
  function getDocumentTypes() {
    fetch('http://localhost/gestorgimnasio/api/v1/tipoidentificacion')
      .then(response => response.json())
      .then(data => {
        const documentTypes = document.getElementById('documentTypes');
        documentTypes.innerHTML = '';

        data.forEach(documentType => {
          const row = document.createElement('tr');
          row.innerHTML = `
            <td>${documentType.codigo}</td>
            <td>${documentType.nombre}</td>
            <td>
              <button onclick="editDocumentType('${documentType.id}')">Editar</button>
              <button onclick="deleteDocumentType('${documentType.id}')">Eliminar</button>
            </td>
          `;
          documentTypes.appendChild(row);
        });
      });
  }

  // Función para crear un nuevo Tipo de Documento
  function createDocumentType() {
    // Genera un UUID aleatorio utilizando la biblioteca 'uuidv4' que ahora está disponible globalmente
    const id = uuidv4();
    const codigo = document.getElementById('codigo').value;
    const nombre = document.getElementById('nombre').value;
    const estado = true;

    const newDocumentType = {
      id: id,
      codigo: codigo,
      nombre: nombre,
      estado: estado
    };

    fetch('http://localhost/gestorgimnasio/api/v1/tipoidentificacion', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newDocumentType)
    })
      .then(response => response.json())
      .then(data => {
        console.log('Nuevo Tipo de Documento creado:', data);
        // Limpia los campos de entrada después de crear el Tipo de Documento
        document.getElementById('codigo').value = '';
        document.getElementById('nombre').value = '';
        // Actualiza la lista de Tipos de Documento
        getDocumentTypes();
      })
      .catch(error => {
        console.error('Error al crear un nuevo Tipo de Documento:', error);
      });
  }

  // Resto del código (como se proporcionó en respuestas anteriores)

  // Al cargar la página, obtén la lista de Tipos de Documento
  getDocumentTypes();
});
