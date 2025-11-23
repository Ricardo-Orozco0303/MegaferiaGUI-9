# 📚 Sistema de Gestión Megaferia (MegaferiaGUI)

Este proyecto es una aplicación de escritorio desarrollada en **Java** utilizando **Swing** para la interfaz gráfica. Su objetivo es la gestión integral de una feria del libro ("Megaferia"), permitiendo la administración de editoriales, stands, libros, autores y transacciones de venta.

El sistema destaca por su arquitectura robusta y el uso de patrones de diseño avanzados para garantizar la escalabilidad y el mantenimiento del código.

## 🚀 Características Principales

El sistema permite realizar las siguientes operaciones:

*   **Gestión de Libros:**
    *   Creación y administración de diferentes formatos: **Impresos**, **Digitales** y **Audiolibros**.
    *   Clasificación por autores y editoriales.
*   **Gestión de Personas:**
    *   Administración de roles: **Autores**, **Gerentes** y **Narradores**.
*   **Gestión de Editoriales y Stands:**
    *   Asignación de stands a editoriales.
    *   Control de inventario por stand.
*   **Sistema de Ventas:**
    *   Procesamiento de compras en los stands.
    *   Cálculo de costos y facturación.
*   **Reportes y Consultas:**
    *   Rankings de autores.
    *   Consultas de disponibilidad y estadísticas.

## 🛠️ Arquitectura y Patrones de Diseño

Este proyecto no es solo una aplicación funcional, sino una demostración de buenas prácticas de ingeniería de software. Se han implementado los siguientes patrones:

*   **MVC (Modelo-Vista-Controlador):** Separación clara entre la lógica de negocio (`core.models`), la interfaz de usuario (`core.views`) y la lógica de control (`core.controllers`).
*   **Observer Pattern:** Implementado en `core.observer` para notificar a la interfaz gráfica (`MegaferiaFrame`) sobre cambios en los datos en tiempo real, manteniendo la vista sincronizada con el modelo.
*   **Strategy Pattern:** Utilizado en `core.strategies` (ej. `BookCreationStrategy`, `PrintedBookStrategy`) para manejar de forma flexible la creación y comportamiento de diferentes tipos de libros sin acoplar el código.
*   **Dependency Injection (Inyección de Dependencias):** Gestionado por `DependencyInjector` para desacoplar la creación de objetos y facilitar las pruebas y la mantenibilidad.
*   **Repository Pattern:** Capa de abstracción (`core.repositories`) para el acceso a datos, permitiendo cambiar la fuente de datos sin afectar la lógica de negocio.
*   **DTO (Data Transfer Object):** Uso extensivo de DTOs (`core.controllers.dto`) para transferir datos entre capas de forma segura y eficiente.

## 💻 Tecnologías Utilizadas

*   **Lenguaje:** Java (JDK 17+ recomendado).
*   **Interfaz Gráfica:** Java Swing.
*   **Look & Feel:** [FlatLaf](https://www.formdev.com/flatlaf/) (Flat Dark Theme) para una apariencia moderna y oscura.
*   **IDE Recomendado:** NetBeans (el proyecto contiene estructura `nbproject`), aunque es compatible con IntelliJ IDEA o Eclipse.

## 📂 Estructura del Proyecto

```text
src/core/
├── controllers/      # Lógica de control y orquestación
│   ├── dto/          # Objetos de transferencia de datos
│   ├── handlers/     # Manejadores de eventos específicos
│   ├── interfaces/   # Contratos para los controladores
│   ├── strategies/   # Implementación del patrón Strategy
│   └── utils/        # Utilidades y Mappers
├── models/           # Entidades del dominio (Book, Person, Stand, etc.)
├── observer/         # Implementación del patrón Observer
├── repositories/     # Capa de acceso a datos
├── views/            # Interfaz gráfica (JFrame y formularios)
└── main/             # Punto de entrada (Main.java)
```

## ▶️ Cómo Ejecutar

1.  **Requisitos:** Asegúrate de tener instalado el JDK de Java.
2.  **Clonar/Descargar:** Descarga el código fuente.
3.  **Abrir en IDE:**
    *   Si usas **NetBeans**, abre la carpeta del proyecto directamente (reconocerá la carpeta `nbproject`).
    *   Si usas otro IDE, importa el proyecto desde las fuentes existentes.
4.  **Ejecutar:**
    *   Localiza la clase principal: `src/core/main/Main.java`.
    *   Ejecuta el método `main`.

## 👥 Autores

*   **jjlora**
*   **edangulo**
*   **Ricardo-Orozco0303** (Owner)

---
*Generado para documentación del proyecto MegaferiaGUI.*