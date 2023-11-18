<template>
  <div>
    <div style="display: flex; justify-content: center; margin-bottom: 20px;">
      <input type="date" v-model="startDate" @change="getEmergencies">
      <input type="date" v-model="endDate" @change="getEmergencies">
    </div>
    <div style="display: flex;">
      <table>
        <thead>
          <tr>
            <th>Emergencia</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="emergency in emergencies" :key="emergency.id_emergency">
            <td @click="getTasks(emergency.id_emergency)">{{ emergency.description }}</td>
          </tr>
        </tbody>
      </table>

      <table v-if="selectedEmergency">
        <thead>
          <tr>
            <th>Tarea</th>
            <th>Voluntario con menor puntaje</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="task in tasks[selectedEmergency]" :key="task.id_task">
            <td>{{ task.name }}</td>
            <td v-if="volunteers[task.id_task]">{{ volunteers[task.id_task].name }} {{ volunteers[task.id_task].lastnames }}</td>
          </tr>

        </tbody>
      </table>
    </div>
  </div>
</template>

<script>

export default {
  data() {
    return {
      startDate: null,
      endDate: null,
      emergencies: [],
      selectedEmergency: null,
      tasks: {},
      volunteers: {}
    }
  },
  methods: {
    async getEmergencies() {
      if (this.startDate && this.endDate) {
        const start = new Date(this.startDate + 'T00:00:00').toISOString();
        const end = new Date(this.endDate + 'T23:59:59').toISOString();
        try {
          const response = await this.$axios.$post('/api/emergencies/byDate', { startDate: start, endDate: end });
          console.log(response); // Imprime la respuesta en la consola
          this.emergencies = response; // Asigna los datos recibidos a una propiedad reactiva
        } catch (error) {
          console.error(error)
        }
      } else {
        // ('Por favor, selecciona las fechas de inicio y fin.') // Era muy molesto asi que lo quite
      }
    },
    async getTasks(id_emergency) {
      try {
        const response = await this.$axios.$get('/api/tasks/byEmergency/' + id_emergency);
        console.log('Tareas cargadas: ', response);
        this.tasks[id_emergency] = response;
        this.selectedEmergency = id_emergency;

        for (const task of response) {
          console.log('Cargando voluntario para la tarea: ', task.id_task);
          this.getVolunteer(task.id_task);
        }
      } catch (error) {
        console.error(error)
      }
    },

    async getVolunteer(id_task) {
      try {
        console.log('Obteniendo voluntario para la tarea: ', id_task);
        const response = await this.$axios.$get('/api/rankings/minRanking/voluntary/' + id_task);
        console.log('Voluntario cargado: ', response);
        this.$set(this.volunteers, id_task, response);
      } catch (error) {
        console.error(error)
      }
    }


  },
}
</script>

<style scoped>
table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>

