import axios from 'axios';

const SERVER = import.meta.env.VITE_URL_API;

const apiDietas = axios.create({
  baseURL: SERVER,
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  }
});

export default {
  async getAllDietas() {
    try {
      const response = await apiDietas.get('/api/dietas/');
      return response.data; // Asegúrate de devolver solo los datos
    } catch (error) {
      console.error('Error al obtener las dietas:', error);
      throw error; // Lanza el error para que sea manejado por el componente
    }
  },
  async getDietaById(id) {
    try {
      const response = await apiDietas.get(`/api/dietas/${id}`);
      return response.data; // Asegúrate de devolver solo los datos
    } catch (error) {
      console.error('Error al obtener la dieta:', error);
      throw error; // Lanza el error para que sea manejado por el componente
    }
  }
};
