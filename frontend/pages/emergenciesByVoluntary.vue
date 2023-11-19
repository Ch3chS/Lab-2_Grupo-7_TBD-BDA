<template>
    <div>
      <label for="volunteerSelect">Selecciona un voluntario:</label>
      <select v-model="selectedVolunteer" @change="getEmergencies">
        <option value="" disabled>Selecciona un voluntario</option>
        <option v-for="volunteer in volunteers" :key="volunteer.rut" :value="volunteer.rut">
          {{ volunteer.name }} - {{ volunteer.rut }}
        </option>
      </select>
  
      <div v-if="selectedVolunteer">
        <h2>Emergencias cercanas al voluntario seleccionado:</h2>
        <ul v-if="emergencies.length > 0">
          <li v-for="emergency in emergencies" :key="emergency.id">
            Descripción: {{ emergency.description }}<br>
            Fecha: {{ emergency.date }}<br>
            Estado: {{ emergency.active ? 'Activa' : 'Inactiva' }}
          </li>
        </ul>
        <p v-else>No se encontraron emergencias cercanas.</p>
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
  