<template>
  <div class="grid">
    <div class="form-container">
      <form class="form login" @submit.prevent="login">
        <!-- Campo para el RUT -->
        <div class="form__field">
          <label for="login__rut">RUT</label>
          <input id="login__rut" v-model="rut" type="text" name="rut" placeholder="Ingrese RUT" required>
        </div>
        <!-- Campo para la contraseña -->
        <div class="form__field">
          <label for="login__password">Contraseña</label>
          <input id="login__password" v-model="password" type="password" name="password" placeholder="Ingrese una contraseña" required>
        </div>

        <!-- Botón de envío del formulario -->
        <div class="form__field">
          <input type="submit" value="Iniciar sesión">
        </div>

      </form>

      <!-- Mensaje para el usuario -->
      <div v-if="error_msg" :class="`message ${messageType}`">
        {{ error_msg }}
      </div>

      <!-- Enlace para usuarios no registrados -->
      <p class="text--center">¿No estás registrado? <a href="/register">Regístrate ahora</a></p>
    </div>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Home',
    components: {

    },
  data: function() {

    return {
      rut: "",
      password: "",
      messageType: false,
      error_msg: "",
    }
  },
  methods: {
    login() {
      const json = {
        "rut" : this.rut,
        "password" : this.password
      };
      axios.post('/api/voluntaries/login', json)
      .then(response => {
        console.log('Response:', response); // Agrega un registro de consola para la respuesta completa
        if(response && response.data && response.data.rut){
          console.log("todo piola");
          this.messageType = 'success';
          this.error_msg = 'Inicio de sesión exitoso!';
          this.$router.push('/home');
        }
        else {
          console.error('Response or response data is undefined');
          this.messageType = 'error';
          this.error_msg = response.data && response.data.result ? response.data.result.error_msg : 'Error desconocido';
        }
      })
      .catch(error => {
        console.error('Request error:', error); // Agrega un registro de consola para el error de la solicitud
        this.messageType = 'error';
        this.error_msg = 'Datos incorrectos';
      });
    }
  },
}
</script>

<style scoped>
  .grid {
 display: flex;
 justify-content: center;
 align-items: center;
 height: 100vh;
 background-color: #f0f0f0;
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

.form__field input[type="text"],
.form__field input[type="email"],
.form__field input[type="password"],
.form__field input[type="tel"] {
 width: 100%;
 padding: 8px;
 border-radius: 4px;
 border: 1px solid #ddd;
}

.form__field input[type="submit"] {
 width: 100%;
 padding: 8px;
 border-radius: 4px;
 border: none;
 color: white;
 background-color: #007BFF;
}

.text--center {
   text-align: center;
}

/* Estilos para pantallas con una anchura máxima de 600px */
@media (max-width:600px) {
   .form-container {
       width: calc(100% -32px);
   }
}

.message {
  margin-top: 16px;
  padding: 8px;
  border-radius: 4px;
}

.success {
 color:white;
 background-color:#28a745;
}

.error {
 color:white;
 background-color:#dc3545;
}
</style>
