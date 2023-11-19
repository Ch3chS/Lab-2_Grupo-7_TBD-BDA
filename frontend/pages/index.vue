<template>
  <div class="container">
    <h1 class="text--center">Laboratorio 1 TBD, grupo 7</h1>
    
    <!-- Botón para ir al login -->
    <form action="/login" class="form-container" @submit.prevent="goToLogin">
      <button type="submit" class="form__field input[type='submit'] success button-large">
        Ir al login
      </button>
    </form>

    <!-- Botón para ver la tabla -->
    <form action="/table" class="form-container" @submit.prevent="goToTable">
      <button type="submit" class="form__field input[type='submit'] success button-large">
        Ver Tabla
      </button>
    </form>

    <!-- Botón para ver emergencias por voluntario -->
    <form action="/emergenciesByVoluntary" class="form-container" @submit.prevent="goToEmergencies">
      <button type="submit" class="form__field input[type='submit'] success button-large">
        Ver Emergencias por Voluntario
      </button>
    </form>
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

.container {
  display: flex;
  flex-direction: column; /* Cambio a una disposición de columna */
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #f0f0f0;
}

.button-large {
  width: 100%; /* Ancho completo */
  padding: 16px; /* Aumenta el espacio alrededor del botón */
  font-size: 20px; /* Aumenta el tamaño del texto */
}

.form-container {
  width: 100%;
  max-width: 500px;
  padding: 16px;
}

.form {
  width: 100%;
  padding: 16px;
  background-color: white;
  border-radius: 8px;
}

.form__field {
  margin-bottom: 16px;
}

.form__field label {
  display: block;
  margin-bottom: 8px;
}

.form__field input[type="submit"] {
  border-radius: 8px; /* Mayor redondez en los bordes */
  font-size: 18px; /* Aumenta el tamaño del texto en el botón */
  padding: 12px; /* Aumenta el espacio interior del botón */
}

.text--center {
  text-align: center;
}

.message {
  margin-top: 16px;
  padding: 8px;
  border-radius: 4px;
}

.success {
  color: white;
  background-color: #28a745;
}

.error {
  color: white;
  background-color: #dc3545;
}
</style>
