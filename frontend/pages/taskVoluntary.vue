<template>
  <div class="task-voluntary">
    <h1><b>Tareas disponibles para voluntarios</b></h1>
    <div class="rut-input">
      <label for="voluntaryRut">Escribe tu RUT:</label>
      <input type="text" id="voluntaryRut" v-model="voluntaryRut" />
      <button @click="loadTasks(voluntaryRut)">Cargar tareas</button>
    </div>
    <table class="task-table">
      <thead>
      <tr>
        <th>Nombre de la tarea</th>
        <th>Descripción de la tarea</th>
        <th>Acepta tarea</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="task in tasks" :key="task.id_task">
        <td>{{ task.name }}</td>
        <td>{{ task.description }}</td>
        <td>
          <button @click="acceptTask(task.id_task)">Aceptar</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'TaskVoluntary',
  data() {
    return {
      tasks: [] // Initialize the tasks as an empty array
    };
  },
  methods: {
    async loadTasks(voluntaryRut) {
      try {
        console.log(voluntaryRut);
        const response = await fetch(`/api/taskStatuses/availableTasksForVoluntary/${voluntaryRut}`);
        if (response.ok) {
          // Parse the response data and update the tasks data property
          this.tasks = await response.json();
        } else {
          console.error('Error al cargar las tareas');
          this.tasks = []; // Set tasks to an empty array on error
        }
      } catch (error) {
        console.error('Error al cargar las tareas:', error);
        this.tasks = []; // Set tasks to an empty array on error
      }
    }
  }
};
</script>


<style scoped>
.task-voluntary {
  background: #262626;
  font-family: sans-serif;
  padding: 16px;
}

h1 {
  text-align: center;
  color: white;
  font-size: 24px;
  margin-bottom: 16px;
}

.task-table {
  width: 100%;
  border-collapse: collapse;
}

thead {
  background-color: #009879;
  color: white;
}

thead th {
  padding: 10px;
}

tbody {
  background-color: #fff;
}

tr:hover {
  background: #e84393;
  color: #fff;
}

td {
  padding: 10px;
  text-align: center;
}

button {
  background-color: #007BFF;
  color: white;
  border: none;
  padding: 5px 10px;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
