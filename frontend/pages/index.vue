<template>
  <div class="container">
    <h1 class="text--center">Emergencias</h1>

    <!-- Botones alineados en la parte inferior -->
    <div class="button-container">
      <!-- Botón para ir al login -->
      <button type="button" class="button-large success" @click="goToLogin">
        Ir al login
      </button>

      <!-- Botón para ver la tabla -->
      <button type="button" class="button-large success" @click="goToTable">
        Ver Tabla
      </button>

      <!-- Botón para ver emergencias por voluntario -->
      <button type="button" class="button-large success" @click="goToEmergencies">
        Emergencias por Voluntario
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'index',
  methods: {
    // Función para redirigir al login
    goToLogin() {
      this.$router.push('/login');
    },
    // Función para redirigir a ver la tabla
    goToTable() {
      this.$router.push('/table');
    },
    // Función para redirigir a ver emergencias por voluntario
    goToEmergencies() {
      this.$router.push('/emergenciesByVoluntary');
    }
  }
}
</script>

<style scoped>
* {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px; /* Reducido el margen superior */
}

body {
  background-color: black; /* Cambiado a color negro de fondo para toda la página */
}

.container {
  height: 100vh;
}

.button-container {
  display: flex;
  justify-content: space-around;
  padding: 20px;
}

.button-large {
  flex: 1;
  margin: 8px;
  border-radius: 12px;
  font-size: 30px; /* Aumenta el tamaño de fuente */
  padding: 40px 20px; /* Ajusta el padding: arriba/abajo, izquierda/derecha */
  box-sizing: border-box;
  max-width: calc(100% / 3); /* Aproximadamente 1/3 del ancho de la página */
  background-color: #4CAF50; /* Color blanco de fondo para los botones */
}

.text--center {
  text-align: center;
}
</style>
