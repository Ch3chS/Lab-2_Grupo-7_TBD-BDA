<template>
    <div class="grid">
      <div class="scroll-container">
        <form class="form register" @submit.prevent="submitForm">
          <!-- Campo para el RUT -->
          <div class="form__field">
            <label for="register__rut">RUT</label>
            <input id="register__rut" v-model="formData.rut" type="text" name="rut" placeholder="Ingrese RUT 12345678-9" required>
          </div>
          <!-- Campo para el nombre -->
          <div class="form__field">
            <label for="register__name">Nombre</label>
            <input id="register__name" v-model="formData.name" type="text" name="name" placeholder="Ingrese nombre" required>
          </div>
          <!-- Campo para los apellidos -->
          <div class="form__field">
            <label for="register__lastnames">Apellidos</label>
            <input id="register__lastnames" v-model="formData.lastnames" type="text" name="lastnames" placeholder="Ingrese apellidos" required>
          </div>
          <!-- Campo para el correo electrónico -->
          <div class="form__field">
            <label for="register__email">Correo electrónico</label>
            <input id="register__email" v-model="formData.email" type="email" name="email" placeholder="Ingrese correo electrónico" required>
          </div>
          <!-- Campo para la contraseña -->
          <div class="form__field">
            <label for="register__password">Contraseña</label>
            <input id="register__password" v-model="formData.password" type="password" name="password" placeholder="Ingrese una contraseña" required>
          </div>
          <!-- Campo para el teléfono -->
          <div class="form__field">
            <label for="register__phone">Teléfono</label>
            <input id="register__phone" v-model="formData.phone" type="tel" name="phone" placeholder="Ingrese teléfono" required>
          </div>
          <!-- Campo para la disponibilidad -->
          <div class="form__field">
            <label for="register__avaible">Disponibilidad</label>
            <input id="register__avaible" v-model="formData.avaible" type="checkbox" name="avaible">
          </div>

          <!-- Botón de envío del formulario -->
          <div class="form__field">
            <input type="submit" value="Registrar">
          </div>

        </form>

        <!-- Mensaje para el usuario -->
        <div v-if="message" :class="`message ${messageType}`">
            {{ message }}
        </div>

        <!-- Enlace para usuarios ya registrados -->
        <p class="text--center">¿Ya estás registrado? <a href="/login">Ingresa ahora</a></p>
      </div>

    </div>
  </template>


  <script>
import axios from 'axios';

export default {
  data() {
    return {
      formData: {
        rut: '',
        password: ''
      },
      message: '', // Mensaje para el usuario
      messageType: '' // 'success' o 'error'
    }
  },
  methods: {
    async submitForm() {
      try {
        const response = await axios.post('/api/voluntaries/register', this.formData);
        // Aquí puedes manejar la respuesta del servidor
        console.log(response.data);
        this.message = 'Registro exitoso!'; // Mensaje de éxito
        this.messageType = 'success';
      } catch (error) {
        // Aquí puedes manejar los errores
        console.error(error);
        if (error.response) {
          // El servidor respondió con un estado de error
          console.error(error.response.data);
          console.error(error.response.status);
          console.error(error.response.headers);
          this.message = `Error: ${error.response.data.message || 'Error en el registro. Por favor, inténtalo de nuevo.'}`; // Mensaje de error
          this.messageType = 'error';
        } else if (error.request) {
          // La solicitud fue hecha pero no se recibió ninguna respuesta
          console.error(error.request);
          this.message = 'Error: No se recibió ninguna respuesta del servidor';
          this.messageType = 'error';
        } else if (error.response && error.response.status === 404) {
          // Algo sucedió en la configuración de la solicitud que desencadenó un error
          this.message = 'Error: El servidor no está disponible o la ruta solicitada no se encontró.';
          this.messageType = 'error';
        } else {
          console.error('Error', error.message);
          this.message = `Error: ${error.message}`;
          this.messageType = 'error';
        }
      }
    }
  }
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

.scroll-container {
  margin-top: 100px;
  overflow-y: auto;
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
  color: white;
  background-color: #28a745;
}

.error {
  color: white;
  background-color: #dc3545;
}

  </style>
