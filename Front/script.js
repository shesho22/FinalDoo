// Archivo: api.js

// Funciones comunes para realizar solicitudes a la API
async function fetchData(url, options) {
    try {
      const response = await fetch(url, options);
      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }
  
  // Funciones CRUD para Tipos de Identificación
  export async function consultarTiposIdentificacion() {
    const apiUrl = 'https://api.example.com/api/v1/tipoidentificacion';
    return fetchData(apiUrl);
  }
  
  export async function registrarTipoIdentificacion(tipoIdentificacion) {
    const apiUrl = 'http://localhost/gestorgimnasio/api/v1/tipoidentificacion';
    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(tipoIdentificacion),
    };
    return fetchData(apiUrl, options);
  }
  
  export async function modificarTipoIdentificacion(id, tipoIdentificacion) {
    const apiUrl = `https://api.example.com/api/v1/tipoidentificacion/${id}`;
    const options = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(tipoIdentificacion),
    };
    return fetchData(apiUrl, options);
  }
  
  export async function eliminarTipoIdentificacion(id) {
    const apiUrl = `https://api.example.com/api/v1/tipoidentificacion/${id}`;
    const options = {
      method: 'DELETE',
    };
    return fetchData(apiUrl, options);
  }
  
  // Funciones CRUD para Entrenador
  export async function consultarEntrenadores() {
    const apiUrl = 'https://api.example.com/api/v1/entrenador';
    return fetchData(apiUrl);
  }
  
  export async function registrarEntrenador(entrenador) {
    const apiUrl = 'https://api.example.com/api/v1/entrenador';
    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(entrenador),
    };
    return fetchData(apiUrl, options);
  }
  
  export async function modificarEntrenador(id, entrenador) {
    const apiUrl = `https://api.example.com/api/v1/entrenador/${id}`;
    const options = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(entrenador),
    };
    return fetchData(apiUrl, options);
  }
  
  export async function eliminarEntrenador(id) {
    const apiUrl = `https://api.example.com/api/v1/entrenador/${id}`;
    const options = {
      method: 'DELETE',
    };
    return fetchData(apiUrl, options);
  }
  
  // Funciones CRUD para Ejercicio
  export async function consultarEjercicios() {
    const apiUrl = 'https://api.example.com/api/v1/ejercicio';
    return fetchData(apiUrl);
  }
  
  export async function registrarEjercicio(ejercicio) {
    const apiUrl = 'https://api.example.com/api/v1/ejercicio';
    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(ejercicio),
    };
    return fetchData(apiUrl, options);
  }
  
  export async function modificarEjercicio(id, ejercicio) {
    const apiUrl = `https://api.example.com/api/v1/ejercicio/${id}`;
    const options = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(ejercicio),
    };
    return fetchData(apiUrl, options);
  }
  
  export async function eliminarEjercicio(id) {
    const apiUrl = `https://api.example.com/api/v1/ejercicio/${id}`;
    const options = {
      method: 'DELETE',
    };
    return fetchData(apiUrl, options);
  }
  
  // Funciones CRUD para Rutina
  export async function consultarRutinas() {
    const apiUrl = 'https://api.example.com/api/v1/rutina';
    return fetchData(apiUrl);
  }
  
  export async function registrarRutina(rutina) {
    const apiUrl = 'https://api.example.com/api/v1/rutina';
    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(rutina),
    };
    return fetchData(apiUrl, options);
  }
  
  export async function modificarRutina(id, rutina) {
    const apiUrl = `https://api.example.com/api/v1/rutina/${id}`;
    const options = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(rutina),
    };
    return fetchData(apiUrl, options);
  }
  
  export async function eliminarRutina(id) {
    const apiUrl = `https://api.example.com/api/v1/rutina/${id}`;
    const options = {
      method: 'DELETE',
    };
    return fetchData(apiUrl, options);
  }
  