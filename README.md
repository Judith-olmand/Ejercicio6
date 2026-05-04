# 🗄️ Ejercicio6 [ConexionOracleMaven] — Eliminación con PreparedStatement

Este proyecto Java gestionado con Maven permite establecer una conexión con una base de datos Oracle para realizar operaciones de eliminación de registros (DML) de forma segura y controlada mediante el uso de sentencias preparadas.

## 📋 Descripción del Proyecto
El propósito de esta aplicación es demostrar la eliminación selectiva de registros en una base de datos Oracle utilizando JDBC. El programa se centra en la instrucción `DELETE`, permitiendo remover un empleado específico de la tabla `empleado` basándose en su identificador único (ID), asegurando que la operación sea precisa y esté protegida contra errores de sintaxis o inyecciones mediante parámetros.

## 🎯 Funcionalidades del Menú
Al ejecutarse, el programa realiza las siguientes acciones automáticas:
* **Conexión Robusta**: Accede a la base de datos Oracle utilizando las credenciales almacenadas en el archivo externo `db.properties`.
* **Sentencia Parametrizada**: Prepara una instrucción SQL de tipo `DELETE` con un marcador de posición (`?`) para el criterio de búsqueda.
* **Mapeo de Identificador**: Asigna dinámicamente el valor del ID (en este caso, el ID: 10) al parámetro de la consulta.
* **Confirmación de Eliminación**: Ejecuta la sentencia en el servidor y muestra por consola el número total de registros eliminados satisfactoriamente.

## 🏗️ Estructura del Proyecto
```text
Ejercicio6 [ConexionOracleMaven]/
│
├── 📁 src/
│   └── 📁 main/
│       ├── 📁 java/
│       │   └── 📁 org/example/
│       │       ├── ☕ DBConfig.java        # Clase para la carga de configuración externa
│       │       └── ☕ Main.java            # Lógica principal para la eliminación (DELETE)
│       └── 📁 resources/
│           └── 📄 db.properties           # Archivo con URL, usuario y contraseña
│
├── 📁 target/                             # Directorio de salida de compilación de Maven
├── 🚫 .gitignore                          # Exclusión de archivos de configuración y binarios
└── 📄 pom.xml                             # Archivo de configuración Maven y dependencias
```

## 📄 Formato del Archivo de Entrada
El archivo `src/main/resources/db.properties` debe seguir este formato para permitir la conexión:
```properties
db.url=jdbc:oracle:thin:@localhost:1521:xe
db.user=TU_USUARIO
db.password=TU_CONTRASEÑA
```

## 🚀 Compilación y Ejecución
### Requisitos
* Java JDK 17 o superior.
* Maven 3.8 o superior.
* Base de datos Oracle activa con la tabla `empleado` y datos existentes.

### Comandos
```bash
# Limpiar y compilar el proyecto
mvn clean compile

# Ejecutar la aplicación
mvn exec:java -Dexec.mainClass="org.example.Main"
```

## 🔧 Características Técnicas Implementadas
* **Uso de PreparedStatement**: Implementación de borrado seguro para evitar vulnerabilidades y mejorar el rendimiento.
* **Cierre Automático**: Uso de la estructura `try-with-resources` para liberar automáticamente la conexión y el statement.
* **Feedback de Operación**: Captura del valor de retorno de `executeUpdate()` para informar sobre el impacto real en la base de datos.
* **Manejo de Excepciones**: Gestión de `SQLException` para reportar fallos de red o de permisos directamente en la consola.

## 🎮 Ejemplo de Uso Visual

**Lógica aplicada en el código:**
* **Operación**: Eliminar registro.
* **Criterio**: Registro con `ID = 10`.

**Salida en Consola:**
```bash
Conexión establecida con Oracle.
Empleado eliminado con éxito: 1
```

---
**Autor:** Judith Olmedo Andrés  
*Ejercicio 6 - Gestión de Eliminación de Datos en Oracle con JDBC*
```