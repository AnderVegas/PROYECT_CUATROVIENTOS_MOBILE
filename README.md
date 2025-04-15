<a id="readme-top"></a>

<!-- Variables definidas al final de la página -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]

<!-- Logo del proyecto -->
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="https://www.cuatrovientos.org/wp-content/uploads/2019/07/logo-cuatrovientos-2.png" alt="Logo" width="300" height="80">
  </a>
  <h3 align="center">PROYECT_CUATROVIENTOS_MOBILE</h3>
  <p align="center"> 
    ODS_PROYECT_CUATROVIENTOS es una aplicación desarrollada para gestionar iniciativas vinculadas a los Objetivos de Desarrollo Sostenible (ODS), permitiendo su creación, consulta, actualización y eliminación lógica. También ofrece gestión de dimensiones, metas, profesores, entidades externas, módulos, cursos, y más.
    <br />
    <a href="https://github.com/Foxriel13/PROYECT_CUATROVIENTOS_MOBILE"><strong>Explorar la documentación»</strong></a>
    <br />
    <br />
    <a href="https://github.com/Foxriel13/PROYECT_CUATROVIENTOS_MOBILE/issues/new?labels=bug&template=bug-report---.md">Reportar Bug</a>
    &middot;
    <a href="https://github.com/Foxriel13/PROYECT_CUATROVIENTOS_MOBILE/issues/new?labels=enhancement&template=feature-request---.md">Solicitar Funcionalidad</a>
  </p>
</div>

<!-- Sobre el proyecto -->
# 🌍 Sobre el Proyecto
**ODS_PROYECT_CUATROVIENTOS** es una aplicación desarrollada para gestionar **iniciativas** vinculadas a los Objetivos de Desarrollo Sostenible (ODS), permitiendo su creación, consulta, actualización y eliminación lógica. También ofrece gestión de dimensiones, metas, profesores, entidades externas, módulos, cursos, y más.

<p align="right">(<a href="#readme-top">vuelta arriba</a>)</p>

## 🛠️ Requisitos Previos
- **Android Studio**: Versión más reciente.
- **Java**: Lenguaje principal del desarrollo.
- **Gradle**: Administrador de dependencias.
- **Emulador o Dispositivo Físico**: Android 7.0 o superior.
- **Conexión a Internet**: Para la comunicación con el backend.
- **Backend**: Tener instalado y corriendo el backend del proyecto https://github.com/Foxriel13/ODS_PROYECT_CUATROVIENTOS_BACKEND (instalación siguiendo los pasos de su Readme.md)

## 🚀 Instalación y Configuración
Sigue estos pasos para poner en marcha la aplicación en tu entorno de desarrollo:
### 1. Clonar el repositorio
Puedes trabajar sobre la rama que necesites:
```bash
# Clonar desde Entrega 1
git clone --branch Entrega1 --single-branch https://github.com/AnderVegas/PROYECT_CUATROVIENTOS_MOBILE.git
cd PROYECT_CUATROVIENTOS_MOBILE

# O desde Entrega 2
git clone --branch Entrega2 --single-branch https://github.com/AnderVegas/PROYECT_CUATROVIENTOS_MOBILE.git
cd PROYECT_CUATROVIENTOS_MOBILE
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

## 📱 Principales Funcionalidades
- 🔍 **Consulta** de iniciativas, cursos, dimensiones y ODSs.
- ❌ **Eliminación lógica** de iniciativas.
- 🔗 **Sincronización en tiempo real** con el backend.

## 🎨 Diseño de Interfaz
La aplicación sigue las guías de diseño **Material Design**, con un enfoque en:
- **UI intuitiva** y fácil de usar.
- **Modo claro**.
- **Compatibilidad con múltiples resoluciones de pantalla**.

## 🔧 Tecnologías Utilizadas
- **Lenguaje**: Java ☕
- **Framework**: Android SDK
- **Networking**: Retrofit
- **Gestión de Dependencias**: Gradle

## 🗺️ Oja de Ruta
- [x] Listar y Filtrar iniciativas
- [x] Visualizar Indicadores
- [ ] Diseño apropiado de vistas

## 📅 Estado del Proyecto
🚧 **En desarrollo activo**  
Actualmente el proyecto se encuentra en constante evolución. Se están implementando nuevas funcionalidades, corrigiendo errores y optimizando el rendimiento para su uso en producción.
> Si encuentras un bug o tienes sugerencias, ¡no dudes en abrir un issue o una pull request!

<p align="right">(<a href="#readme-top">vuelta arriba</a>)</p>

## 👥 Autores
Proyecto desarrollado por:
- [@Ander](https://www.github.com/AnderVegas)  
- [@Aitor](https://www.github.com/AitorLopez057)

<!-- MARKDOWN LINKS -->
[contributors-shield]: https://img.shields.io/github/contributors/AnderVegas/PROYECT_CUATROVIENTOS_MOBILE.svg?style=for-the-badge
[contributors-url]: https://github.com/AnderVegas/PROYECT_CUATROVIENTOS_MOBILE/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/AnderVegas/PROYECT_CUATROVIENTOS_MOBILE.svg?style=for-the-badge
[forks-url]: https://github.com/AnderVegas/PROYECT_CUATROVIENTOS_MOBILE/network/members

[stars-shield]: https://img.shields.io/github/stars/AnderVegas/PROYECT_CUATROVIENTOS_MOBILE.svg?style=for-the-badge
[stars-url]: https://github.com/AnderVegas/PROYECT_CUATROVIENTOS_MOBILE/stargazers

[issues-shield]: https://img.shields.io/github/issues/AnderVegas/PROYECT_CUATROVIENTOS_MOBILE.svg?style=for-the-badge
[issues-url]: https://github.com/AnderVegas/PROYECT_CUATROVIENTOS_MOBILE/issues
