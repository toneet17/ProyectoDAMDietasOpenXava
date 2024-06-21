import axios from 'axios';

const SERVER = import.meta.env.VITE_URL_API;

const apiComidas = axios.create({
  baseURL: SERVER,
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  }
});

export default {
  async getAllComidas() {
    try {
      const response = await apiComidas.get('/api/comidas/');
      return response.data; // Devolver solo los datos
    } catch (error) {
      console.error('Error al obtener las comidas:', error);
      throw error; // Lanzar el error para que sea manejado por el componente
    }
  },
  async getComidaById(id) {
    try {
      const response = await apiComidas.get(`/api/comidas/${id}`);
      return response.data; // Devolver solo los datos
    } catch (error) {
      console.error('Error al obtener la comida:', error);
      throw error; // Lanzar el error para que sea manejado por el componente
    }
  }
};
