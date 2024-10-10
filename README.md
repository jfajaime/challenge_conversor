# Conversor de Monedas 💱

## Descripción del Proyecto 📄
Este proyecto es una aplicación de conversión de monedas que utiliza una API para obtener las tasas de cambio actuales. La aplicación está desarrollada en Java y utiliza IntelliJ IDEA como entorno de desarrollo.

## Estructura del Proyecto 📂
```plaintext
├── README.md
├── src
│   ├── com
│   │   ├── alura
│   │   │   ├── fer
│   │   │   │   ├── Principal.java
│   │   │   │   ├── PrincipalConMenu.java
│   │   │   ├── api
│   │   │   │   ├── ApiKey.java
│   │   │   │   ├── ConsultaAPI.java
│   │   │   ├── modelo
│   │   │   │   ├── Moneda.java
│   │   │   │   ├── MonedaOmdb.java
│   │   │   ├── servicio
│   │   │   │   ├── GeneradorDeArchivo.java
│   │   │   │   ├── ListaSiglaDeMonedas.java
etc..........

```
## Tecnologías Usadas 🛠️
- **Java** ☕
- **IntelliJ IDEA** 🖥️
- **Git** 🌳
- **API de Conversión de Monedas** 🌐

## Dificultades y Soluciones 🚧
### Dificultades Encontradas ⚠️
1. **Estructuración del Proyecto**: Inicialmente, la organización de las clases y paquetes no era clara, lo que dificultaba la navegación y el mantenimiento del código.
2. **Integración con la API**: Hubo problemas al manejar las respuestas de la API y al gestionar las claves de API de manera segura.
3. **Gestión de Git**: Al principio, hubo confusión con los comandos de Git, especialmente al renombrar y mover archivos.

### Soluciones Aplicadas 🔧
1. **Reestructuración de Paquetes**: Se reorganizaron las clases en subpaquetes (`api`, `modelo`, `servicio`) para mejorar la claridad y la mantenibilidad.
2. **Manejo de la API**: Se creó una clase `ConsultaAPI` dedicada a manejar las solicitudes y respuestas de la API, y una clase `ApiKey` para gestionar las claves de API de manera segura.
3. **Mejora en el Uso de Git**: Se aprendieron y aplicaron comandos de Git para manejar mejor los cambios en el proyecto, como `git add`, `git commit`, y `git push`.

## Cómo Ejecutar el Proyecto ▶️
1. Abre el proyecto en IntelliJ IDEA.
2. Configura tu clave de API en `src/com/alura/fer/api/ApiKey.java`.
3. Ejecuta la clase `PrincipalConMenu.java` para iniciar la aplicación.

## Contribuciones 🤝
¡Las contribuciones son bienvenidas! Si deseas contribuir, por favor, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia 📄
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.
```plaintext
