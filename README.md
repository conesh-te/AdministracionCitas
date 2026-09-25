# Sistema de Administración de Citas

Aplicación de consola desarrollada en Java para la gestión de citas medicas. Permite administrar doctores, pacientes y citas mediante el almacenamiento de informacion en archivos separados por comas (CSV), asegurando el control de acceso mediante la codificacion de credenciales.

## Instalación y Configuración

1. **Requisitos previos:** Asegúrate de tener instalado **Java JDK 21 o posterior** y **Apache Maven**.
2. **Clonar el proyecto mediante SSH:**
   ```bash
   git clone git@github.com:conesh-te/AdministracionCitas.git
   cd AdministracionCitas
   ```
3. **Compilar y generar el ejecutable (FAT JAR):**
   ```bash
   mvn clean package
   ```

## 🚀 Uso del Programa

Para ejecutar la aplicación de manera portable e independiente del IDE, corre el FAT JAR generado en la carpeta `target`:

```bash
java -jar target/AdministracionCitas-1.0-SNAPSHOT-jar-with-dependencies.jar
```

*Nota: Si es la primera vez que se ejecuta, el sistema creará automáticamente la carpeta `db/` y te pedirá registrar la cuenta del Administrador Principal.*

## Créditos

Proyecto final desarrollado para la materia por:
* Conesh - [@conesh-te](https://github.com)

## Licencia

Este proyecto se distribuye bajo la licencia abierta y puede ser usado por todos.
