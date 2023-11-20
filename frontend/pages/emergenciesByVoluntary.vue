<template>
  <div>
    <nav class="navbar">
      <router-link to="/" class="back-link">Volver</router-link>
    </nav>

    <div class="main-container">
      <label for="volunteerSelect">Selecciona un voluntario:</label>
      <select v-model="selectedVolunteer" @change="getEmergencies">
        <option value="" disabled>Selecciona un voluntario</option>
        <option v-for="volunteer in volunteers" :key="volunteer.rut" :value="volunteer.rut">
          {{ volunteer.name }} - {{ volunteer.rut }}
        </option>
      </select>

      <div v-if="selectedVolunteer">
        <h2>Emergencias cercanas al voluntario seleccionado:</h2>
        <table class="emergencies-table">
          <thead>
            <tr>
              <th>Descripción</th>
              <th>Fecha</th>
              <th>Estado</th>
            </tr>
          </thead>
          <tbody v-if="emergencies.length > 0">
            <tr v-for="emergency in emergencies" :key="emergency.id">
              <td>{{ emergency.description }}</td>
              <td>{{ emergency.date }}</td>
              <td>{{ emergency.active ? 'Activa' : 'Inactiva' }}</td>
            </tr>
          </tbody>
          <tbody v-else>
            <tr>
              <td colspan="3">No se encontraron emergencias cercanas.</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      volunteers: [],
      selectedVolunteer: null,
      emergencies: [],
    };
  },
  methods: {
    async getEmergencies() {
      if (this.selectedVolunteer) {
        try {
          const response = await this.$axios.get(`/api/emergencies/byVoluntaryLocation/${this.selectedVolunteer}`);
          this.emergencies = response.data;
        } catch (error) {
          console.error('Error al obtener emergencias:', error);
        }
      }
    },
  },
  async mounted() {
    try {
      const response = await this.$axios.get('/api/voluntaries');
      this.volunteers = response.data;
    } catch (error) {
      console.error('Error al obtener la lista de voluntarios:', error);
    }
  },
};
</script>

<style>
.navbar {
  background-color: #333;
  padding: 10px;
  color: white;
}

.back-link {
  color: white;
  text-decoration: none;
  font-weight: bold;
  margin-left: auto;
}

.main-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: #ffffff; /* Fondo de color gris */
}

.emergencies-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 10px;
}

.emergencies-table th, .emergencies-table td {
  border: 1px solid #ffffff;
  padding: 8px;
  text-align: left;
}

.emergencies-table th {
  background-color: #333;
  color: white;
}
</style>
