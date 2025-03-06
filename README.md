# PROYECT_CUATROVIENTOS_MOBILE 📱🌍


Esta aplicación móvil está diseñada para gestionar **iniciativas** y sus datos asociados, permitiendo la creación, lectura, actualización y eliminación (lógica) de registros.


---


## 🛠️ Requisitos Previos


- **Android Studio**: Versión más reciente.
- **Java**: Lenguaje principal del desarrollo.
- **Gradle**: Administrador de dependencias.
- **Emulador o Dispositivo Físico**: Android 7.0 o superior.
- **Conexión a Internet**: Para la comunicación con el backend.
- **Backend**: Tener instalado y corriendo el backend del proyecto https://github.com/Foxriel13/ODS_PROYECT_CUATROVIENTOS_BACKEND (instalación siguiendo los pasos de su Readme.md)

---


## 🚀 Instalación y Configuración


Sigue estos pasos para poner en marcha la aplicación en tu entorno de desarrollo:


1. **Clonar el repositorio**


   ```bash
   git clone https://github.com/Foxriel13/ODS_PROYECT_CUATROVIENTOS_MOBILE.git
   cd ODS_PROYECT_CUATROVIENTOS_MOBILE
   ```


2. **Abrir en Android Studio**


   - Abre **Android Studio**.
   - Selecciona **"Open an existing project"**.
   - Navega hasta la carpeta del proyecto y ábrelo.


3. **Configurar dependencias**


   Android Studio descargará automáticamente las dependencias requeridas. Si hay errores, ejecuta:


   ```bash
   ./gradlew build
   ```


4. **Configurar el Backend**


   Asegúrate de que el backend está corriendo en tu máquina local o en un servidor accesible.
   Para ello, una vez instalado el backend nos sacaremos la consola y ejecutaremos los siguientes comandos.


    Instalación de composer en el proyecto:
    ```bash
   composer install
   ```

    Inicio del servidor de Symfony
   ```bash
   symfony server:start
   ```

    Levantar la base de datos:
   ```bash
   php bin/console doctrine:database:create
   ```

    Crear la migración:
   ```bash
   php bin/console make:migration
   ```

    Subir la migración:
   ```bash
   php bin/console doctrine:migrations:migrate
   ```

5. **Ejecutar la aplicación**


   - Conecta un dispositivo físico o inicia un emulador.
   - Presiona **Run ▶** en Android Studio.


---


## 📡 Endpoints Consumidos


### **1. Obtener todas las iniciativas**


- **Método**: `GET`
- **Ruta**: `/iniciativas`
- **Descripción**: Retorna todas las iniciativas activas y eliminadas.
- **Ejemplo en Java (Retrofit)**:


   ```java
   @GET("iniciativas")
   Call<List<Iniciativa>> getIniciativas();
   ```


### **2. Crear una nueva iniciativa**


- **Método**: `POST`
- **Ruta**: `/iniciativas`
- **Ejemplo de envío de datos con Retrofit**:


   ```java
   @POST("iniciativas")
   Call<ResponseBody> crearIniciativa(@Body Iniciativa iniciativa);
   ```


### **3. Actualizar una iniciativa existente**


- **Método**: `PUT`
- **Ruta**: `/iniciativas/{id}`
- **Ejemplo en Java**:


   ```java
   @PUT("iniciativas/{id}")
   Call<ResponseBody> actualizarIniciativa(@Path("id") int id, @Body Iniciativa iniciativa);
   ```


### **4. Eliminar (marcar como eliminado) una iniciativa**


- **Método**: `DELETE`
- **Ruta**: `/iniciativas/{id}`


   ```java
   @DELETE("iniciativas/{id}")
   Call<ResponseBody> eliminarIniciativa(@Path("id") int id);
   ```


---


## 📱 Principales Funcionalidades


- 🔍 **Consulta** de iniciativas, cursos, dimensiones y ODSs.
- ✏️ **Creación y edición** de iniciativas.
- ❌ **Eliminación lógica** de iniciativas.
- 🔗 **Sincronización en tiempo real** con el backend.


---


## 🎨 Diseño de Interfaz


La aplicación sigue las guías de diseño **Material Design**, con un enfoque en:


- **UI intuitiva** y fácil de usar.
- **Modo claro**.
- **Compatibilidad con múltiples resoluciones de pantalla**.


---


## 🔧 Tecnologías Utilizadas


- **Lenguaje**: Java ☕
- **Framework**: Android SDK
- **Networking**: Retrofit
- **Gestión de Dependencias**: Gradle



---


💡 *Desarrollado por el equipo de formado por Karla, Danel, Xabier, Luismi, Ander y Aitor.* 🚀