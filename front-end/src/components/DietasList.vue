<template>
  <div class="container">
    <h1 class="titulo-lista">Lista de Dietas</h1>
    <div v-if="dietas.length" v-for="dieta in dietas" :key="dieta.id" class="dieta-container">
      <h2 class="titulo-dieta">{{ dieta.nombre }}</h2>
      <div class="table-responsive">
        <table>
          <thead>
            <tr>
              <th></th>
              <th>Lunes</th>
              <th>Martes</th>
              <th>Miércoles</th>
              <th>Jueves</th>
              <th>Viernes</th>
              <th>Sábado</th>
              <th>Domingo</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="momento in momentos" :key="momento">
              <th>{{ momento }}</th>
              <td v-for="dia in dias" :key="dia">
                <div v-if="getComidas(dieta.comidas, dia, momento).length">
                  <div v-for="comida in getComidas(dieta.comidas, dia, momento)" :key="comida.id" class="comida-container">
                    <ul>
                      <li v-for="ingrediente in comida.ingredientes" :key="ingrediente.id">{{ ingrediente.nombre }}</li>
                    </ul>
                    <router-link :to="{ name: 'ComidaDetail', params: { id: comida.id } }" class="info-link">Ver info</router-link>
                  </div>
                </div>
                <div v-else>
                  Libre
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div v-else>
      <p>No se encontraron dietas.</p>
    </div>
  </div>
</template>

<script>
import apiDietas from '@/services/apiDietas';

export default {
  data() {
    return {
      dietas: [],
      dias: ['LUNES', 'MARTES', 'MIERCOLES', 'JUEVES', 'VIERNES', 'SABADO', 'DOMINGO'],
      momentos: ['DESAYUNO', 'ALMUERZO', 'COMIDA', 'MERIENDA', 'CENA'],
      error: null
    };
  },
  methods: {
    getComidas(comidas, dia, momento) {
      return comidas.filter(comida => comida.diaSemana === dia && comida.momentoDia === momento);
    }
  },
  async created() {
    try {
      const data = await apiDietas.getAllDietas();
      this.dietas = data;
    } catch (error) {
      this.error = 'Error al obtener las dietas';
      console.error(this.error, error);
    }
  }
};
</script>

<style scoped>
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

.titulo-lista, .titulo-dieta {
  background-color: #f1f1f1;
  border-radius: 8px;
  padding: 15px;
  color: #333;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.dieta-container {
  margin-bottom: 40px;
}

.table-responsive {
  overflow-x: auto;
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

ul {
  list-style-type: none;
  padding: 0;
}

ul li {
  background-color: #f1f1f1;
  margin: 2px 0;
  padding: 5px;
  border-radius: 5px;
  color: #000000;
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

.info-link {
  display: inline-block;
  margin-top: 10px;
  padding: 5px 10px;
  border-radius: 5px;
  background-color: #f8f9fa;
  transition: background-color 0.3s, color 0.3s, transform 0.3s;
}

.info-link:hover {
  background-color: #333;
  color: #fff;
  transform: scale(1.05);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.comida-container {
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #eee;
  border-radius: 5px;
  background-color: #fafafa;
  transition: background-color 0.3s, box-shadow 0.3s;
}

.comida-container:hover {
  background-color: #f1f1f1;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

@media (max-width: 1024px) {
  .container {
    padding: 10px;
  }

  th, td {
    padding: 10px;
  }

  .info-link {
    padding: 5px 8px;
  }
}

@media (max-width: 768px) {
  .dieta-container h2 {
    font-size: 1.2em;
  }

  .table-responsive {
    overflow-x: scroll;
  }

  table, thead, tbody, th, td, tr {
    display: block;
  }

  thead tr {
    display: none;
  }

  tr {
    border: 1px solid #ccc;
    margin-bottom: 10px;
  }

  td {
    border: none;
    border-bottom: 1px solid #eee;
    position: relative;
    padding-left: 50%;
    text-align: right;
  }

  td:before {
    position: absolute;
    top: 12px;
    left: 10px;
    width: 45%;
    padding-right: 10px;
    white-space: nowrap;
    content: attr(data-label);
    text-align: left;
    font-weight: bold;
  }

  th, td {
    text-align: left;
  }

  .info-link {
    display: block;
    margin-top: 5px;
    text-align: center;
  }
}
</style>
