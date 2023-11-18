<template>
  <div class="home">
    <button @click="redirectToTasks" class="message-box-button">
      <div class="button-content">
        Ver tareas para aceptar
      </div>
    </button>
  </div>
</template>

<script>
export default {
  name: 'Home',
  methods: {
    redirectToTasks() {
      window.location.href = '/taskVoluntary';
    }
  }
}

</script>

<style scoped>
.home {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f0f0f0;
}

.message-box-button {
  padding: 0; /* Remove the default padding */
  background: none;
  border: none;
  cursor: pointer;
  outline: none;
}

.button-content {
  padding: 16px;
  background-color: #007BFF;
  border: none;
  border-radius: 8px;
  color: white;
  font-size: 18px;
  text-align: center;
  text-transform: uppercase;
}

.button-content:hover {
  background-color: #0056b3;
}
</style>
