import axios from 'axios';

const SERVER = import.meta.env.VITE_URL_API;

const apiIngredientes = axios.create({
  baseURL: SERVER,
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  }
});

export default {
  async getAllIngredientes() {
    try {
      const response = await apiIngredientes.get('/api/ingredientes/');
      return response.data; // Devolver solo los datos
    } catch (error) {
      console.error('Error al obtener los ingredientes:', error);
      throw error; // Lanzar el error para que sea manejado por el componente
    }
  },
  async getIngredienteById(id) {
    try {
      const response = await apiIngredientes.get(`/api/ingredientes/${id}`);
      return response.data; // Devolver solo los datos
    } catch (error) {
      console.error('Error al obtener el ingrediente:', error);
      throw error; // Lanzar el error para que sea manejado por el componente
    }
  }
};
