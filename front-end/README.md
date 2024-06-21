# Bolsa de Trabajo del CIP FP Batoi

## Introducción

Este proyecto tiene como finalidad la creación de una aplicación web responsiva destinada a gestionar la Bolsa de Trabajo del Centro Integrado Público de Formación Profesional (CIP FP) Batoi. La aplicación permitirá a estudiantes y ex-estudiantes del centro inscribirse e indicar los ciclos formativos cursados. Por otro lado, las empresas podrán registrarse en la bolsa de trabajo y publicar ofertas laborales especificando los ciclos formativos requeridos para los candidatos.

La plataforma asegurará una interacción eficiente entre los alumnos y las empresas, facilitando la inserción laboral de los estudiantes en campos relacionados con su formación. Además, se contará con un sistema de validación a cargo de profesores responsables de cada ciclo, quienes verificarán tanto los ciclos cursados por los alumnos como las ofertas publicadas por las empresas, garantizando la fiabilidad de la información proporcionada.

## Tecnologías Asociadas

- **Frontend**: Vue.js, aprovechando las capacidades de Vue para la gestión de estados y Vue Router para el manejo de rutas.
- **Backend**: Laravel, utilizado para desarrollar la API REST que facilita la comunicación entre el frontend y la base de datos.
- **Base de datos**: Mariadbd, empleada para almacenar información sobre usuarios, empresas, ofertas de trabajo, entre otros datos relevantes.
- **Autenticación**: Implementación de autenticación utilizando credenciales propias y opciones de inicio de sesión a través de servicios externos como Google y Github.

## Autores

- Alejandro Fernández Martí
- Ethan Tomás Horsman
- Arthur Dias Teixeira
- Antoni Medina Sanjuan
- Germán Juan Ribera

## Licencia

Este proyecto se distribuye bajo la Licencia Apache 2.0. La Licencia Apache 2.0 es una licencia de software libre que permite la reutilización del software dentro de proyectos de software libre y cerrado bajo las condiciones de la Licencia Apache.

La Licencia Apache 2.0 permite a los usuarios del software:

- Usarlo libremente en sus propios proyectos.
- Modificarlo según sus necesidades.
- Distribuirlo a terceros.
- Colocar su propio software bajo la Licencia Apache 2.0, entre otros derechos.

Para más detalles sobre los términos y condiciones, así como las limitaciones bajo la Licencia Apache 2.0, por favor consulta el texto completo de la licencia en: [https://www.apache.org/licenses/LICENSE-2.0](https://www.apache.org/licenses/LICENSE-2.0).

## Puesta en Marcha

Este proyecto ofrece tres métodos de despliegue distintos:

### 1. Despliegue Local: Uso Directo

1. Clonar el repositorio:
    ```
    git clone https://github.com/Bolsa-de-Treball/front-end.git
    ```
2. Instalar dependencias:
    ```
    cd front-end
    npm install
    ```
3. Iniciar el servidor de desarrollo:
    ```
    npm run dev
    ```
    La aplicación estará accesible a través de `http://localhost:5173`.

### 2. Despliegue Local: Docker

Para dockerizar el frontend y servir la aplicación a través de un contenedor Docker, sigue estos pasos:
1. Clonar el repositorio:
    ```
    git clone https://github.com/Bolsa-de-Treball/front-end.git
    ```

2. **Ir a la raíz del proyecto** en la rama master.

3. **Crear una carpeta "nginx"** y dentro un archivo llamado `default.conf` con el siguiente contenido:

    ```nginx
    server {
        listen 80;
        location / {
            root   /usr/share/nginx/html;
            index  index.html index.htm;
            try_files $uri $uri/ /index.html;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   /usr/share/nginx/html;
        }
    }
    ```

4. **Crear el Dockerfile** para configurar el entorno de la aplicación SPA:

    ```Dockerfile
    FROM node:lts as build-stage
    WORKDIR /app
    COPY package*.json ./
    RUN npm install
    COPY . .
    RUN npm run build

    FROM nginx:stable-alpine as production-stage
    COPY --from=build-stage /app/dist /usr/share/nginx/html
    COPY nginx/default.conf /etc/nginx/conf.d/default.conf

    EXPOSE 80
    CMD ["nginx", "-g", "daemon off;"]
    ```

5. **Construir y ejecutar el contenedor**:

    ```
    docker build --no-cache -t vue-app-front-end .
    docker run -d -p 8080:80 --name front-end-docker vue-app-front-end
    ```

    Accede a la aplicación a través de `http://localhost:8080`.

En caso de modificaciones o fallos:

- Detener y remover el contenedor:

    ```
    docker stop front-end-docker
    docker rm front-end-docker
    ```

> [!NOTE]
> Es importante no subir los cambios de la configuración de Docker del entorno local al repositorio si se utiliza también un despliegue automatizado. Considera incluir `Dockerfile` y la carpeta `nginx` en el `.gitignore` para evitar mezclar configuraciones.

### 3. Despliegue Automatizado: GitHub Actions con Nginx

1. Clonar el repositorio:
    ```
    git clone https://github.com/Bolsa-de-Treball/front-end.git
    ```

2. **GitHub Actions** realizará el despliegue automáticamente con cada cambio en la rama `master`.

3. **Acceso a la aplicación**: Una vez desplegado, accede a través de `front.projecteg3.ddaw.es`.

#### Consideraciones Adicionales

- Para los despliegues locales, es posible que necesites preparar manualmente el archivo `.env` con las variables necesarias, como la URL de conexión al backend.

## Flujo de Trabajo

Nuestro proyecto sigue un flujo de trabajo basado en ramas que garantiza la organización y eficiencia en el desarrollo. Este proceso se describe a continuación:

### Creación de Subramas para Tareas

Para cada nueva tarea o característica, creamos una subrama específica desde `develop`. Esta práctica nos permite trabajar en múltiples funcionalidades de manera simultánea sin interferir con el código base estable.

### Desarrollo y Pruebas

Una vez asignada la tarea, el desarrollo se lleva a cabo en la subrama correspondiente. Durante este proceso, se realizan pruebas para asegurar que la nueva funcionalidad cumpla con los requisitos establecidos y no introduzca errores en el sistema.

### Merge a Develop

Cuando una tarea se completa y se valida a través de pruebas, se realiza un merge de la subrama a `develop`. Este paso nos permite integrar las nuevas características o correcciones en una rama central de desarrollo, donde se pueden realizar pruebas adicionales en conjunto con otras funcionalidades.

### Eliminación de la Subrama

Tras el merge exitoso y la confirmación de que la funcionalidad se integra correctamente en `develop`, procedemos a eliminar la subrama utilizada para la tarea. Esto ayuda a mantener limpio nuestro repositorio y facilita la gestión de ramas.

### Merge a Master

Una vez que `develop` se encuentra en un estado estable y funcional, con todas las tareas programadas para la versión actual completadas y probadas, realizamos un merge de `develop` a `master`. Este paso marca la finalización de un ciclo de desarrollo y prepara el proyecto para su despliegue o entrega.

Este flujo de trabajo nos permite mantener un control riguroso sobre el desarrollo del proyecto, asegurando que solo las características probadas y estables sean incorporadas en la rama principal (`master`) para su despliegue.

> [!CAUTION]
> La rama `master` nunca se puede modificar desde local, solo se hará un *pull request* desde `develop` cuando exista una versión estable de la app. 

### Buenas Prácticas

- **Revisión de Código**: Antes de realizar un merge, especialmente de `develop` a `master`, es recomendable llevar a cabo revisiones de código por parte de otros miembros del equipo para asegurar la calidad y coherencia del proyecto.
- **Pruebas Continuas**: A lo largo de todo el proceso, es esencial realizar pruebas continuas para detectar y corregir errores lo antes posible.


## Casos de Uso

A continuación, se detallan los casos de uso implementados en la plataforma "Bolsa de Trabajo del CIP FP Batoi":

### Caso de Uso 1: Registro de Alumnos

Los nuevos usuarios (alumnos y ex-alumnos) pueden registrarse en la plataforma proporcionando la siguiente información:

- Usuario (su email) y contraseña.
- Nombre y apellidos.
- Dirección.
- Ciclo(s) estudiados en Batoi y año de finalización de cada uno.
- Opcionalmente, un enlace a su CV (LinkedIn, InfoJobs, Drive, etc.).
- Aceptación de la cesión de datos para gestionar la bolsa de trabajo.

Tras completar el registro, el usuario recibe un email para validar sus datos y activar su cuenta.

### Caso de Uso 2: Registro de Empresas

Las empresas pueden registrarse en la plataforma completando un formulario con la siguiente información:

- Usuario (su email) y contraseña.
- CIF de la empresa (para evitar duplicidades).
- Nombre de la empresa.
- Dirección.
- Nombre del contacto.
- Opcionalmente, web de la empresa.
- Aceptación de la cesión de datos para gestionar la bolsa de trabajo.

### Caso de Uso 3: Asignación de Responsables

Un administrador asigna el responsable de cada ciclo formativo. Cada ciclo debe tener un responsable asignado, aunque un profesor puede ser responsable de más de un ciclo.

### Caso de Uso 4: Inicio de Sesión

Cualquier usuario registrado (alumno, empresa, responsable o administrador) puede iniciar sesión utilizando su email y contraseña. También se ofrece la opción de iniciar sesión con credenciales de Google o Github.

### Caso de Uso 5: Modificación del Perfil

Tanto los alumnos como las empresas pueden acceder y modificar su perfil, incluyendo la opción de cambiar su contraseña.

### Caso de Uso 6: Validación de Ciclos

Cuando un alumno se activa o añade un ciclo a su perfil, el responsable de dicho ciclo recibe un email para validar la información. Los administradores también pueden realizar esta validación.

### Caso de Uso 7: Alta de Ofertas

Las empresas pueden publicar nuevas ofertas de trabajo, especificando los detalles del puesto, los ciclos formativos requeridos, y el método de inscripción de candidatos.

### Caso de Uso 8: Validación de Ofertas

Cuando se publica una nueva oferta, los responsables de los ciclos requeridos reciben un email para validar la oferta. Una vez validada, todos los alumnos que cumplan con los requisitos son informados.

### Caso de Uso 10: Apuntarse a una Oferta

Los alumnos pueden inscribirse como interesados en las ofertas de trabajo disponibles que coincidan con su formación.

### Caso de Uso 11: Consulta de Candidatos

Las empresas pueden consultar los perfiles de los alumnos inscritos en sus ofertas de trabajo.

### Caso de Uso 12: Desactivación y Eliminación de Ofertas

Las empresas tienen la opción de desactivar o eliminar sus ofertas de trabajo. Las ofertas eliminadas no se borran permanentemente sino que se marcan como borradas para estadísticas (soft delete).

### Caso de Uso 13: Eliminación de Empresas

Al eliminar una empresa, se borran todos sus datos excepto las ofertas, que quedan sin empresa asociada para fines estadísticos.

### Caso de Uso 14: Eliminación de Alumnos

Al eliminar un alumno, se borran todos sus datos pero no su inscripción en ofertas, que quedan sin alumno asociado para fines estadísticos.
