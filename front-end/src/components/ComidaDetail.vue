<template>
  <div class="container">
    <h1 class="titulo-detalle">Detalle de Comida</h1>
    <div v-if="comida">
      <table>
        <tr>
          <th>Nombre</th>
          <td>{{ comida.nombre }}</td>
        </tr>
        <tr>
          <th>Día de la Semana</th>
          <td>{{ comida.diaSemana }}</td>
        </tr>
        <tr>
          <th>Momento del Día</th>
          <td>{{ comida.momentoDia }}</td>
        </tr>
        <tr>
          <th>Descripción</th>
          <td>{{ comida.descripcion }}</td>
        </tr>
        <tr>
          <th>Ingredientes</th>
          <td>
            <div class="ingredientes-container">
              <div v-for="ingrediente in comida.ingredientes" :key="ingrediente.id" class="ingrediente-card">
                <h4>{{ ingrediente.nombre }}</h4>
                <div class="propiedad">
                  <span class="icon">🔥</span>
                  <span class="value">Calorías: {{ ingrediente.calorias }}</span>
                </div>
                <div class="propiedad">
                  <span class="icon">💪</span>
                  <span class="value">Proteínas: {{ ingrediente.proteinas }}g</span>
                </div>
                <div class="propiedad">
                  <span class="icon">🍞</span>
                  <span class="value">Carbohidratos: {{ ingrediente.carbohidratos }}g</span>
                </div>
                <div class="propiedad">
                  <span class="icon">🧈</span>
                  <span class="value">Grasas: {{ ingrediente.grasas }}g</span>
                </div>
                <div class="propiedad">
                  <span class="icon">💰</span>
                  <span class="value">Precio aprox: {{ ingrediente.precioAprox }}€</span>
                </div>
                <p class="descripcion">{{ ingrediente.descripcion }}</p>
              </div>
            </div>
          </td>
        </tr>
      </table>
    </div>
    <div v-else>
      <p>Cargando detalles de la comida...</p>
    </div>
    <router-link to="/" class="back-link">Volver a Dietas</router-link>
  </div>
</template>

<script>
import apiComidas from '@/services/apiComidas';

export default {
  data() {
    return {
      comida: null,
      error: null
    };
  },
  async created() {
    try {
      const data = await apiComidas.getComidaById(this.$route.params.id);
      this.comida = data;
    } catch (error) {
      this.error = 'Error al obtener los detalles de la comida';
      console.error(this.error, error);
    }
  }
};
</script>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.titulo-detalle {
  background-color: #f1f1f1;
  border-radius: 8px;
  padding: 15px;
  color: #333;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  text-align: center;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

th, td {
  border: 1px solid #dee2e6;
  padding: 12px;
  text-align: left;
}

th {
  background-color: #333;
  color: #fff;
}

.ingredientes-container {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
}

.ingrediente-card {
  background-color: #f1f1f1;
  border-radius: 8px;
  padding: 15px;
  width: calc(50% - 10px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s, box-shadow 0.3s;
}

.ingrediente-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.ingrediente-card h4 {
  margin-bottom: 10px;
  color: #333;
}

.propiedad {
  display: flex;
  align-items: center;
  margin-bottom: 8px;
}

.icon {
  margin-right: 5px;
}

.value {
  color: #555;
}

.descripcion {
  margin-top: 10px;
  color: #777;
  font-style: italic;
}

a {
  color: #333;
  text-decoration: none;
  transition: color 0.3s, transform 0.3s;
}

a:hover {
  color: #000;
  transform: scale(1.1);
  text-decoration: underline;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.back-link {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 15px;
  border-radius: 5px;
  background-color: #f8f9fa;
  transition: background-color 0.3s, color 0.3s, transform 0.3s;
}

.back-link:hover {
  background-color: #333;
  color: #fff;
  transform: scale(1.05);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}
</style>
