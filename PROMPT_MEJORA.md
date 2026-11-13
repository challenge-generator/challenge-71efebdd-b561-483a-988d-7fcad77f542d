# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/java/com/banco/prestamos/domain/services/CalculoInteresServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/banco/prestamos/application/usecases/CalcularInteresUseCaseTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapterTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `org.slf4j`: El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/banco/prestamos/infrastructure/config/SwaggerConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.Components pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java` — `Prestamo.getFechaInicio`: Se invoca `getFechaInicio` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java` — `Prestamo.getId`: Se invoca `getId` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java` — `Prestamo.getMonto`: Se invoca `getMonto` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java` — `Prestamo.getTasaInteres`: Se invoca `getTasaInteres` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `Prestamo.getId`: Se invoca `getId` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `Prestamo.getMonto`: Se invoca `getMonto` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `Prestamo.getTasaInteres`: Se invoca `getTasaInteres` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `Interes.getMontoInteres`: Se invoca `getMontoInteres` sobre `Interes`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `Prestamo.getFechaInicio`: Se invoca `getFechaInicio` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapter.java` — `Prestamo.getMonto`: Se invoca `getMonto` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapter.java` — `Prestamo.getTasaInteres`: Se invoca `getTasaInteres` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapter.java` — `Prestamo.getFechaInicio`: Se invoca `getFechaInicio` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapter.java` — `Prestamo.getFechaVencimiento`: Se invoca `getFechaVencimiento` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `InteresCompuestoRequest.prestamoId`: Se invoca `prestamoId` sobre `InteresCompuestoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `InteresCompuestoRequest.fechaCalculo`: Se invoca `fechaCalculo` sobre `InteresCompuestoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `CalcularInteresUseCase.ejecutarCalculoSimple`: Se invoca `ejecutarCalculoSimple` sobre `CalcularInteresUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `CalcularInteresUseCase.ejecutarCalculoCompuesto`: Se invoca `ejecutarCalculoCompuesto` sobre `CalcularInteresUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `InteresCompuestoRequest.periodos`: Se invoca `periodos` sobre `InteresCompuestoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `CalcularInteresUseCase.obtenerInteresTotal`: Se invoca `obtenerInteresTotal` sobre `CalcularInteresUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2

### Brecha de conocimiento
Aplica principios y herramientas de verificación para escribir código limpio (KISS, SOLID, YAGNI y DRY)., Aplica principios y herramientas de verificación para escribir código limpio (KISS, SOLID, YAGNI y DRY).

### Reto
- Tema: Aplicación de Código limpio y eficiente
- Seniority: senior-l2
- Tipo: practical
- Título: Refactorización de código para cumplir con principios de código limpio
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Análisis del código existente — objetivo: Identificar las áreas del código que no cumplen con los principios de código limpio. — entregable (NO resolver): Informe de análisis que detalla las áreas del código que no cumplen con los principios de código limpio.
- Fase 2: Refactorización del código — objetivo: Aplicar los principios de código limpio para refactorizar el módulo de cálculo de intereses. — entregable (NO resolver): Código refactorizado que cumple con los principios de código limpio y pruebas unitarias asociadas.
- Fase 3: Revisión y documentación — objetivo: Revisar el código refactorizado y documentar los cambios realizados. — entregable (NO resolver): Código refactorizado revisado y documentación de los cambios realizados.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.banco</groupId>
    <artifactId>prestamos</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>prestamos</name>
    <description>Servicio de cálculo de intereses para préstamos bancarios</description>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.12.0</version>
            <scope>test</scope>
        </dependency>

        <!-- Documentation -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.9.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/banco/prestamos/PrestamosApplication.java ===
package com.banco.prestamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase principal de la aplicación Spring Boot para el servicio de préstamos.
 * Inicializa el contexto de Spring y escanea los componentes en el paquete base.
 *
 * Arquitectura:
 * - Patrón hexagonal con capas claras de dominio, aplicación e infraestructura.
 * - Los puertos (interfaces) son definidos por el dominio.
 * - Los adaptadores implementan los puertos y se ubican en infraestructura.
 * - La comunicación entre capas se realiza mediante interfaces, nunca directamente.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.banco.prestamos")
public class PrestamosApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrestamosApplication.class, args);
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
server:
  port: 8080
  servlet:
    context-path: /api/prestamos

spring:
  application:
    name: prestamos-service
  datasource:
    url: jdbc:postgresql://localhost:5432/prestamos_db
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    operationsSorter: alpha
    tagsSorter: alpha

logging:
  level:
    com.banco.prestamos: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE

// === ARCHIVO: src/main/java/com/banco/prestamos/domain/model/Cliente.java ===
package com.banco.prestamos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    @Size(max = 100, message = "El nombre del cliente no puede exceder los 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El identificador fiscal no puede estar vacío")
    @Size(max = 20, message = "El identificador fiscal no puede exceder los 20 caracteres")
    @Column(nullable = false, unique = true, length = 20)
    private String identificadorFiscal;

    @Positive(message = "La edad debe ser un valor positivo")
    @Column(nullable = false)
    private Integer edad;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 200, message = "La dirección no puede exceder los 200 caracteres")
    @Column(nullable = false, length = 200)
    private String direccion;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(max = 15, message = "El teléfono no puede exceder los 15 caracteres")
    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false)
    private Boolean activo = true;

    public Cliente(String nombre, String identificadorFiscal, Integer edad, String direccion, String telefono) {
        this.nombre = nombre;
        this.identificadorFiscal = identificadorFiscal;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.activo = true;
    }
}

// === ARCHIVO: src/main/java/com/banco/prestamos/domain/model/Prestamo.java ===
package com.banco.prestamos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "El cliente asociado al préstamo no puede ser nulo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @NotNull(message = "El monto del préstamo no puede ser nulo")
    @Positive(message = "El monto del préstamo debe ser positivo")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal monto;

    @NotNull(message = "La tasa de interés no puede ser nula")
    @Positive(message = "La tasa de interés debe ser positiva")
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal tasaInteres;

    @NotNull(message = "La fecha de inicio no puede ser nula")
    @Column(nullable = false)
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de vencimiento no puede ser nula")
    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPrestamo estado;

    @Column(nullable = false)
    private Boolean activo = true;

    public Prestamo(Cliente cliente, BigDecimal monto, BigDecimal tasaInteres, LocalDate fechaInicio, LocalDate fechaVencimiento) {
        this.cliente = cliente;
        this.monto = monto;
        this.tasaInteres = tasaInteres;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = EstadoPrestamo.ACTIVO;
        this.activo = true;
    }

    public enum EstadoPrestamo {
        ACTIVO,
        LIQUIDADO,
        MOROSO,
        REFINANCIADO
    }
}

// === ARCHIVO: src/main/java/com/banco/prestamos/domain/model/Interes.java ===
package com.banco.prestamos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "El préstamo asociado al cálculo de intereses no puede ser nulo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prestamo_id", nullable = false)
    private Prestamo prestamo;

    @NotNull(message = "El monto de intereses no puede ser nulo")
    @Positive(message = "El monto de intereses debe ser positivo")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal montoInteres;

    @NotNull(message = "La fecha de cálculo no puede ser nula")
    @Column(nullable = false)
    private LocalDate fechaCalculo;

    @Column(nullable = false)
    private Boolean pagado = false;

    public Interes(Prestamo prestamo, BigDecimal montoInteres, LocalDate fechaCalculo) {
        this.prestamo = prestamo;
        this.montoInteres = montoInteres;
        this.fechaCalculo = fechaCalculo;
        this.pagado = false;
    }

    public static BigDecimal calcularInteresSimple(BigDecimal capital, BigDecimal tasa, long dias) {
        if (capital == null || tasa == null || dias <= 0) {
            throw new IllegalArgumentException("Capital, tasa y días deben ser valores válidos");
        }
        BigDecimal tasaDiaria = tasa.divide(BigDecimal.valueOf(360), 10, BigDecimal.ROUND_HALF_UP);
        return capital.multiply(tasaDiaria).multiply(BigDecimal.valueOf(dias));
    }

    public static BigDecimal calcularInteresCompuesto(BigDecimal capital, BigDecimal tasa, int periodos) {
        if (capital == null || tasa == null || periodos <= 0) {
            throw new IllegalArgumentException("Capital, tasa y periodos deben ser valores válidos");
        }
        BigDecimal tasaPeriodo = tasa.divide(BigDecimal.valueOf(100), 10, BigDecimal.ROUND_HALF_UP);
        return capital.multiply(BigDecimal.ONE.add(tasaPeriodo).pow(periodos)).subtract(capital);
    }
}

// === ARCHIVO: src/main/java/com/banco/prestamos/domain/ports/CalculoInteresPort.java ===
package com.banco.prestamos.domain.ports;

import java.math.BigDecimal;

public interface CalculoInteresPort {
    BigDecimal calcularInteresSimple(BigDecimal capital, BigDecimal tasa, long dias);
    BigDecimal calcularInteresCompuesto(BigDecimal capital, BigDecimal tasa, int periodos);
    BigDecimal calcularInteresDiario(BigDecimal capital, BigDecimal tasaAnual);
    BigDecimal calcularInteresMensual(BigDecimal capital, BigDecimal tasaAnual);
}

// === ARCHIVO: src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java ===
package com.banco.prestamos.domain.services;

import com.banco.prestamos.domain.model.Interes;
import com.banco.prestamos.domain.model.Prestamo;
import com.banco.prestamos.domain.ports.CalculoInteresPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculoInteresService implements CalculoInteresPort {

    private static final Logger logger = LoggerFactory.getLogger(CalculoInteresService.class);
    private static final int ESCALA_DECIMAL = 10;
    private static final int DIAS_POR_ANO = 365;
    private static final int MESES_POR_ANO = 12;

    public CalculoInteresService() {
    }

    @Override
    public BigDecimal calcularInteresSimple(BigDecimal capital, BigDecimal tasa, long dias) {
        if (capital == null || capital.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El capital debe ser mayor que cero");
        }
        if (tasa == null || tasa.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La tasa no puede ser negativa");
        }
        if (dias < 0) {
            throw new IllegalArgumentException("Los días no pueden ser negativos");
        }
        
        logger.debug("Calculando interés simple para capital={}, tasa={}, dias={}", capital, tasa, dias);
        BigDecimal resultado = Interes.calcularInteresSimple(capital, tasa, dias);
        logger.info("Interés simple calculado: {}", resultado);
        return resultado.setScale(ESCALA_DECIMAL, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calcularInteresCompuesto(BigDecimal capital, BigDecimal tasa, int periodos) {
        if (capital == null || capital.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El capital debe ser mayor que cero");
        }
        if (tasa == null || tasa.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La tasa no puede ser negativa");
        }
        if (periodos <= 0) {
            throw new IllegalArgumentException("Los períodos deben ser mayores que cero");
        }
        
        logger.debug("Calculando interés compuesto para capital={}, tasa={}, periodos={}", capital, tasa, periodos);
        BigDecimal resultado = Interes.calcularInteresCompuesto(capital, tasa, periodos);
        logger.info("Interés compuesto calculado: {}", resultado);
        return resultado.setScale(ESCALA_DECIMAL, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calcularInteresDiario(BigDecimal capital, BigDecimal tasaAnual) {
        if (capital == null || tasaAnual == null) {
            throw new IllegalArgumentException("El capital y la tasa no pueden ser nulos");
        }
        
        BigDecimal tasaDiaria = tasaAnual.divide(BigDecimal.valueOf(DIAS_POR_ANO), ESCALA_DECIMAL, RoundingMode.HALF_UP);
        logger.debug("Tasa diaria calculada: {}", tasaDiaria);
        
        return capital.multiply(tasaDiaria).setScale(ESCALA_DECIMAL, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calcularInteresMensual(BigDecimal capital, BigDecimal tasaAnual) {
        if (capital == null || tasaAnual == null) {
            throw new IllegalArgumentException("El capital y la tasa no pueden ser nulos");
        }
        
        BigDecimal tasaMensual = tasaAnual.divide(BigDecimal.valueOf(MESES_POR_ANO), ESCALA_DECIMAL, RoundingMode.HALF_UP);
        logger.debug("Tasa mensual calculada: {}", tasaMensual);
        
        return capital.multiply(tasaMensual).setScale(ESCALA_DECIMAL, RoundingMode.HALF_UP);
    }

    public BigDecimal calcularInteresPorPeriodo(Prestamo prestamo, LocalDate fechaCalculo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo");
        }
        if (fechaCalculo == null) {
            fechaCalculo = LocalDate.now();
        }
        
        long diasTranscurridos = ChronoUnit.DAYS.between(prestamo.getFechaInicio(), fechaCalculo);
        if (diasTranscurridos < 0) {
            throw new IllegalArgumentException("La fecha de cálculo no puede ser anterior a la fecha de inicio del préstamo");
        }
        
        logger.info("Calculando interés para préstamo {} con {} días transcurridos", prestamo.getId(), diasTranscurridos);
        return calcularInteresSimple(prestamo.getMonto(), prestamo.getTasaInteres(), diasTranscurridos);
    }

    public BigDecimal calcularTotalAPagar(Prestamo prestamo) {
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo");
        }
        
        BigDecimal intereses = calcularInteresPorPeriodo(prestamo, LocalDate.now());
        BigDecimal total = prestamo.getMonto().add(intereses);
        logger.info("Total a pagar calculado para préstamo {}: {}", prestamo.getId(), total);
        return total.setScale(ESCALA_DECIMAL, RoundingMode.HALF_UP);
    }
}

// === ARCHIVO: src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java ===
package com.banco.prestamos.application.usecases;

import com.banco.prestamos.domain.model.Interes;
import com.banco.prestamos.domain.model.Prestamo;
import com.banco.prestamos.domain.ports.CalculoInteresPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class CalcularInteresUseCase {

    private static final Logger logger = LoggerFactory.getLogger(CalcularInteresUseCase.class);
    private final CalculoInteresPort calculoInteresPort;

    public CalcularInteresUseCase(CalculoInteresPort calculoInteresPort) {
        if (calculoInteresPort == null) {
            throw new IllegalArgumentException("El puerto de cálculo de interés no puede ser nulo");
        }
        this.calculoInteresPort = calculoInteresPort;
    }

    public Interes ejecutar(Prestamo prestamo) {
        logger.info("Iniciando cálculo de interés para préstamo: {}", prestamo.getId());
        
        validarPrestamo(prestamo);
        
        BigDecimal montoInteres = calculoInteresPort.calcularInteresSimple(
            prestamo.getMonto(),
            prestamo.getTasaInteres(),
            calcularDiasTranscurridos(prestamo)
        );
        
        Interes interes = new Interes(
            prestamo,
            montoInteres,
            LocalDate.now()
        );
        
        logger.info("Interés calculado exitosamente para préstamo {}: {}", prestamo.getId(), montoInteres);
        return interes;
    }

    public BigDecimal calcularInteresSimple(Prestamo prestamo, long dias) {
        logger.debug("Calculando interés simple para préstamo {} con {} días", prestamo.getId(), dias);
        return calculoInteresPort.calcularInteresSimple(prestamo.getMonto(), prestamo.getTasaInteres(), dias);
    }

    public BigDecimal calcularInteresCompuesto(Prestamo prestamo, int periodos) {
        logger.debug("Calculando interés compuesto para préstamo {} con {} períodos", prestamo.getId(), periodos);
        return calculoInteresPort.calcularInteresCompuesto(prestamo.getMonto(), prestamo.getTasaInteres(), periodos);
    }

    public BigDecimal calcularTotalAPagar(Prestamo prestamo) {
        logger.info("Calculando total a pagar para préstamo: {}", prestamo.getId());
        validarPrestamo(prestamo);
        
        Interes interes = ejecutar(prestamo);
        BigDecimal total = prestamo.getMonto().add(interes.getMontoInteres());
        
        logger.info("Total a pagar para préstamo {}: {}", prestamo.getId(), total);
        return total;
    }

    private void validarPrestamo(Prestamo prestamo) {
        if (prestamo == null) {
            logger.error("Préstamo nulo proporcionado");
            throw new IllegalArgumentException("El préstamo no puede ser nulo");
        }
        if (prestamo.getMonto() == null || prestamo.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Monto inválido para préstamo: {}", prestamo.getId());
            throw new IllegalArgumentException("El monto del préstamo debe ser mayor que cero");
        }
        if (prestamo.getTasaInteres() == null || prestamo.getTasaInteres().compareTo(BigDecimal.ZERO) < 0) {
            logger.error("Tasa de interés inválida para préstamo: {}", prestamo.getId());
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa");
        }
        if (prestamo.getFechaInicio() == null) {
            logger.error("Fecha de inicio nula para préstamo: {}", prestamo.getId());
            throw new IllegalArgumentException("La fecha de inicio del préstamo no puede ser nula");
        }
    }

    private long calcularDiasTranscurridos(Prestamo prestamo) {
        LocalDate fechaInicio = prestamo.getFechaInicio();
        LocalDate fechaActual = LocalDate.now();
        
        if (fechaInicio.isAfter(fechaActual)) {
            logger.warn("La fecha de inicio {} es posterior a la fecha actual {}", fechaInicio, fechaActual);
            return 0;
        }
        
        long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaActual);
        logger.debug("Días transcurridos desde {} hasta {}: {}", fechaInicio, fechaActual, dias);
        return dias;
    }

    public Interes calcularInteresParaFecha(Prestamo prestamo, LocalDate fechaCalculo) {
        logger.info("Calculando interés para préstamo {} en fecha {}", prestamo.getId(), fechaCalculo);
        
        validarPrestamo(prestamo);
        
        if (fechaCalculo == null) {
            fechaCalculo = LocalDate.now();
        }
        
        if (fechaCalculo.isBefore(prestamo.getFechaInicio())) {
            logger.error("Fecha de cálculo {} anterior a fecha de inicio {} del préstamo", 
                fechaCalculo, prestamo.getFechaInicio());
            throw new IllegalArgumentException("La fecha de cálculo no puede ser anterior a la fecha de inicio del préstamo");
        }
        
        long dias = java.time.temporal.ChronoUnit.DAYS.between(prestamo.getFechaInicio(), fechaCalculo);
        BigDecimal montoInteres = calculoInteresPort.calcularInteresSimple(
            prestamo.getMonto(),
            prestamo.getTasaInteres(),
            dias
        );
        
        return new Interes(prestamo, montoInteres, fechaCalculo);
    }

    public BigDecimal calcularInteresDiario(BigDecimal capital, BigDecimal tasaAnual) {
        logger.debug("Calculando interés diario para capital={}, tasaAnual={}", capital, tasaAnual);
        return calculoInteresPort.calcularInteresDiario(capital, tasaAnual);
    }

    public BigDecimal calcularInteresMensual(BigDecimal capital, BigDecimal tasaAnual) {
        logger.debug("Calculando interés mensual para capital={}, tasaAnual={}", capital, tasaAnual);
        return calculoInteresPort.calcularInteresMensual(capital, tasaAnual);
    }
}

// === ARCHIVO: src/main/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapter.java ===
package com.banco.prestamos.infrastructure.adapters;

import com.banco.prestamos.domain.model.Interes;
import com.banco.prestamos.domain.model.Prestamo;
import com.banco.prestamos.domain.ports.CalculoInteresPort;
import com.banco.prestamos.domain.services.CalculoInteresService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class CalculoInteresAdapter implements CalculoInteresPort {

    private final CalculoInteresService calculoInteresService;

    public CalculoInteresAdapter(CalculoInteresService calculoInteresService) {
        this.calculoInteresService = calculoInteresService;
    }

    @Override
    public Interes calcularInteresSimple(Prestamo prestamo, LocalDate fechaCalculo) {
        BigDecimal montoInteres = calculoInteresService.calcularInteresSimple(
            prestamo.getMonto(),
            prestamo.getTasaInteres(),
            calcularDiasEntreFechas(prestamo.getFechaInicio(), fechaCalculo)
        );
        return new Interes(prestamo, montoInteres, fechaCalculo);
    }

    @Override
    public Interes calcularInteresCompuesto(Prestamo prestamo, LocalDate fechaCalculo, int periodos) {
        BigDecimal montoInteres = calculoInteresService.calcularInteresCompuesto(
            prestamo.getMonto(),
            prestamo.getTasaInteres(),
            periodos
        );
        return new Interes(prestamo, montoInteres, fechaCalculo);
    }

    @Override
    public BigDecimal calcularInteresTotal(Prestamo prestamo) {
        long diasTotales = calcularDiasEntreFechas(
            prestamo.getFechaInicio(),
            prestamo.getFechaVencimiento()
        );
        return calculoInteresService.calcularInteresSimple(
            prestamo.getMonto(),
            prestamo.getTasaInteres(),
            diasTotales
        );
    }

    private long calcularDiasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }
}

// === ARCHIVO: src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java ===
package com.banco.prestamos.infrastructure.controllers;

import com.banco.prestamos.application.usecases.CalcularInteresUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/intereses")
public class InteresController {

    private final CalcularInteresUseCase calcularInteresUseCase;

    public InteresController(CalcularInteresUseCase calcularInteresUseCase) {
        this.calcularInteresUseCase = calcularInteresUseCase;
    }

    @PostMapping("/simple")
    public ResponseEntity<InteresResponse> calcularInteresSimple(
            @RequestBody InteresSimpleRequest request) {
        UUID prestamoId = request.prestamoId();
        LocalDate fechaCalculo = request.fechaCalculo() != null 
            ? request.fechaCalculo() 
            : LocalDate.now();
        
        var resultado = calcularInteresUseCase.ejecutarCalculoSimple(prestamoId, fechaCalculo);
        
        return ResponseEntity.ok(InteresResponse.from(
            resultado.getId(),
            resultado.getPrestamo().getId(),
            resultado.getMontoInteres(),
            resultado.getFechaCalculo(),
            resultado.getPagado()
        ));
    }

    @PostMapping("/compuesto")
    public ResponseEntity<InteresResponse> calcularInteresCompuesto(
            @RequestBody InteresCompuestoRequest request) {
        UUID prestamoId = request.prestamoId();
        LocalDate fechaCalculo = request.fechaCalculo() != null 
            ? request.fechaCalculo() 
            : LocalDate.now();
        
        var resultado = calcularInteresUseCase.ejecutarCalculoCompuesto(
            prestamoId, 
            fechaCalculo, 
            request.periodos()
        );
        
        return ResponseEntity.ok(InteresResponse.from(
            resultado.getId(),
            resultado.getPrestamo().getId(),
            resultado.getMontoInteres(),
            resultado.getFechaCalculo(),
            resultado.getPagado()
        ));
    }

    @GetMapping("/prestamo/{prestamoId}/total")
    public ResponseEntity<Map<String, BigDecimal>> obtenerInteresTotal(
            @PathVariable UUID prestamoId) {
        BigDecimal interesTotal = calcularInteresUseCase.obtenerInteresTotal(prestamoId);
        return ResponseEntity.ok(Map.of("interesTotal", interesTotal));
    }

    public record InteresSimpleRequest(
        UUID prestamoId,
        LocalDate fechaCalculo
    ) {}

    public record InteresCompuestoRequest(
        UUID prestamoId,
        LocalDate fechaCalculo,
        int periodos
    ) {}

    public record InteresResponse(
        UUID id,
        UUID prestamoId,
        BigDecimal montoInteres,
        LocalDate fechaCalculo,
        Boolean pagado
    ) {
        public static InteresResponse from(UUID id, UUID prestamoId, BigDecimal monto, 
                LocalDate fecha, Boolean pagado) {
            return new InteresResponse(id, prestamoId, monto, fecha, pagado);
        }
    }
}

// === ARCHIVO: src/main/java/com/banco/prestamos/infrastructure/config/SwaggerConfig.java ===
package com.banco.prestamos.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Cálculo de Intereses - Préstamos Bancarios")
                .version("1.0.0")
                .description("""
                    Esta API permite calcular intereses simples y compuestos 
                    para préstamos bancarios. Proporciona endpoints para el 
                    cálculo de intereses por período y el interés total acumulado.
                    """)
                .contact(new Contact()
                    .name("Equipo de Desarrollo - Banco")
                    .email("desarrollo@banco.com")
                    .url("https://www.banco.com"))
                .license(new License()
                    .name("Licencia Proprietaria")
                    .url("https://www.banco.com/licencia")))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(new Components()
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")
                    .description("Autenticación mediante token JWT")));
    }
}

// === ARCHIVO: src/test/java/com/banco/prestamos/domain/services/CalculoInteresServiceTest.java ===
package com.banco.prestamos.domain.services;

import com.banco.prestamos.domain.model.Cliente;
import com.banco.prestamos.domain.model.Prestamo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Disabled("Superficie de práctica - el candidato debe implementar los tests")
@ExtendWith(MockitoExtension.class)
class CalculoInteresServiceTest {

    @Mock
    private Cliente cliente;

    @Mock
    private Prestamo prestamo;

    @InjectMocks
    private CalculoInteresService calculoInteresService;

    @Test
    void calcularInteresSimple_deberiaRetornarMontoCorrecto() {
        // Given: un capital de 10000 y tasa del 5% anual para 365 días
        BigDecimal capital = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        long dias = 365;

        // When: se calcula el interés simple
        BigDecimal resultado = CalculoInteresService.calcularInteresSimple(capital, tasa, dias);

        // Then: el resultado debe ser 500
        assertNotNull(resultado);
        // TODO: implementar assertions
    }

    @Test
    void calcularInteresCompuesto_deberiaRetornarMontoCorrecto() {
        // Given: un capital de 10000 con tasa del 5% y 12 períodos
        BigDecimal capital = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        int periodos = 12;

        // When: se calcula el interés compuesto
        BigDecimal resultado = CalculoInteresService.calcularInteresCompuesto(capital, tasa, periodos);

        // Then: verificar el resultado esperado
        assertNotNull(resultado);
        // TODO: implementar assertions
    }

    @Test
    void calcularInteresSimple_conMontoCero_deberiaRetornarCero() {
        // Given
        BigDecimal capital = BigDecimal.ZERO;
        BigDecimal tasa = new BigDecimal("0.05");
        long dias = 365;

        // When
        BigDecimal resultado = CalculoInteresService.calcularInteresSimple(capital, tasa, dias);

        // Then
        assertEquals(BigDecimal.ZERO, resultado);
    }

    @Test
    void calcularInteresCompuesto_conMontoCero_deberiaRetornarCero() {
        // Given
        BigDecimal capital = BigDecimal.ZERO;
        BigDecimal tasa = new BigDecimal("0.05");
        int periodos = 12;

        // When
        BigDecimal resultado = CalculoInteresService.calcularInteresCompuesto(capital, tasa, periodos);

        // Then
        assertEquals(BigDecimal.ZERO, resultado);
    }
}

// === ARCHIVO: src/test/java/com/banco/prestamos/application/usecases/CalcularInteresUseCaseTest.java ===
package com.banco.prestamos.application.usecases;

import com.banco.prestamos.domain.ports.CalculoInteresPort;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@Disabled("Superficie de práctica - el candidato debe implementar los tests")
@ExtendWith(MockitoExtension.class)
class CalcularInteresUseCaseTest {

    @Mock
    private CalculoInteresPort calculoInteresPort;

    @InjectMocks
    private CalcularInteresUseCase calcularInteresUseCase;

    @Test
    void ejecutar_deberiaCalcularInteresSimple() {
        // Given: un préstamo con parámetros válidos
        UUID prestamoId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        LocalDate fechaInicio = LocalDate.now();

        when(calculoInteresPort.calcularInteresSimple(any(), any(), anyLong()))
            .thenReturn(new BigDecimal("500.00"));

        // When: se ejecuta el caso de uso
        BigDecimal resultado = calcularInteresUseCase.ejecutar(prestamoId, monto, tasa, fechaInicio, true);

        // Then: verificar que se calculó correctamente
        assertNotNull(resultado);
        verify(calculoInteresPort).calcularInteresSimple(any(), any(), anyLong());
    }

    @Test
    void ejecutar_deberiaCalcularInteresCompuesto() {
        // Given: un préstamo para cálculo compuesto
        UUID prestamoId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        LocalDate fechaInicio = LocalDate.now();

        when(calculoInteresPort.calcularInteresCompuesto(any(), any(), anyInt()))
            .thenReturn(new BigDecimal("500.00"));

        // When: se ejecuta con interés compuesto
        BigDecimal resultado = calcularInteresUseCase.ejecutar(prestamoId, monto, tasa, fechaInicio, false);

        // Then
        assertNotNull(resultado);
        verify(calculoInteresPort).calcularInteresCompuesto(any(), any(), anyInt());
    }

    @Test
    void ejecutar_conMontoNulo_deberiaLanzarExcepcion() {
        // Given
        UUID prestamoId = UUID.randomUUID();
        BigDecimal monto = null;
        BigDecimal tasa = new BigDecimal("0.05");
        LocalDate fechaInicio = LocalDate.now();

        // When/Then
        assertThrows(IllegalArgumentException.class, () ->
            calcularInteresUseCase.ejecutar(prestamoId, monto, tasa, fechaInicio, true)
        );
    }

    @Test
    void ejecutar_conTasaNula_deberiaLanzarExcepcion() {
        // Given
        UUID prestamoId = UUID.randomUUID();
        BigDecimal monto = new BigDecimal("10000.00");
        BigDecimal tasa = null;
        LocalDate fechaInicio = LocalDate.now();

        // When/Then
        assertThrows(IllegalArgumentException.class, () ->
            calcularInteresUseCase.ejecutar(prestamoId, monto, tasa, fechaInicio, true)
        );
    }
}

// === ARCHIVO: src/test/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapterTest.java ===
package com.banco.prestamos.infrastructure.adapters;

import com.banco.prestamos.domain.model.Prestamo;
import com.banco.prestamos.domain.ports.CalculoInteresPort;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@Disabled("Superficie de práctica - el candidato debe implementar los tests")
@ExtendWith(MockitoExtension.class)
class CalculoInteresAdapterTest implements CalculoInteresPort {

    @Mock
    private Prestamo prestamo;

    @InjectMocks
    private CalculoInteresAdapter calculoInteresAdapter;

    @Test
    void calcularInteresSimple_deberiaDelegarAlServicio() {
        // Given
        BigDecimal capital = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        long dias = 365;

        // When
        BigDecimal resultado = calculoInteresAdapter.calcularInteresSimple(capital, tasa, dias);

        // Then
        assertNotNull(resultado);
    }

    @Test
    void calcularInteresCompuesto_deberiaDelegarAlServicio() {
        // Given
        BigDecimal capital = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        int periodos = 12;

        // When
        BigDecimal resultado = calculoInteresAdapter.calcularInteresCompuesto(capital, tasa, periodos);

        // Then
        assertNotNull(resultado);
    }

    @Test
    void calcularInteresSimple_conParametrosInvalidos_deberiaLanzarExcepcion() {
        // Given
        BigDecimal capital = new BigDecimal("-1000.00");
        BigDecimal tasa = new BigDecimal("0.05");
        long dias = 365;

        // When/Then
        assertThrows(IllegalArgumentException.class, () ->
            calculoInteresAdapter.calcularInteresSimple(capital, tasa, dias)
        );
    }

    @Test
    void calcularInteresCompuesto_conParametrosInvalidos_deberiaLanzarExcepcion() {
        // Given
        BigDecimal capital = new BigDecimal("10000.00");
        BigDecimal tasa = new BigDecimal("-0.05");
        int periodos = 12;

        // When/Then
        assertThrows(IllegalArgumentException.class, () ->
            calculoInteresAdapter.calcularInteresCompuesto(capital, tasa, periodos)
        );
    }

    @Override
    public BigDecimal calcularInteresSimple(BigDecimal capital, BigDecimal tasa, long dias) {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal calcularInteresCompuesto(BigDecimal capital, BigDecimal tasa, int periodos) {
        return BigDecimal.ZERO;
    }
}

// === ARCHIVO: README.md ===
# Préstamos Banking Service

Servicio RESTful para el cálculo de intereses de préstamos bancarios, desarrollado con Spring Boot 3.5 y Java 21. Implementa arquitectura hexagonal (ports & adapters) para garantizar separación de responsabilidades y facilidad de mantenimiento.

## Descripción del Proyecto

Este servicio forma parte del sistema de gestión de préstamos de un banco y proporciona funcionalidades para:

- Cálculo de intereses simples y compuestos
- Gestión de clientes y préstamos
- Cálculo de cuotas e intereses por período
- API RESTful documentada con OpenAPI/Swagger

## Arquitectura

El proyecto sigue los principios de **Arquitectura Hexagonal** (también conocida como Ports & Adapters):

```
┌─────────────────────────────────────────────────────────────┐
│                    CAPA DE APLICACIÓN                        │
│  (Use Cases - Casos de Uso)                                  │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                      CAPA DE DOMINIO                         │
│  (Modelos, Servicios de Dominio, Puertos/Interfaces)        │
└─────────────────────────────────────────────────────────────┘
                              │
                              ▼
┌─────────────────────────────────────────────────────────────┐
│                   CAPA DE INFRAESTRUCTURA                    │
│  (Controladores, Adaptadores, Configuración)                │
└─────────────────────────────────────────────────────────────┘
```

### Estructura de Paquetes

```
src/main/java/com/banco/prestamos/
├── domain/
│   ├── model/           # Entidades del dominio (Cliente, Prestamo, Interes)
│   ├── ports/           # Interfaces/Puertos (contratos)
│   └── services/        # Lógica de negocio pura
├── application/
│   └── usecases/        # Casos de uso (orquestación)
├── infrastructure/
│   ├── adapters/        # Implementaciones de puertos
│   ├── controllers/     # Controladores REST
│   └── config/          # Configuración de Spring
└── PrestamosApplication.java  # Punto de entrada
```

## Prerequisites

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **Java Development Kit (JDK) 21** o superior
- **Apache Maven 3.9+** para la construcción del proyecto
- **PostgreSQL 15+** como base de datos (o configurar otra base de datos compatible)
- **Git** para clonar el repositorio

Verificar instalación de Java:
```bash
java -version
```

Verificar instalación de Maven:
```bash
mvn -version
```

## Configuración

### Variables de Entorno

El proyecto utiliza las siguientes variables de entorno. También puedes configurarlas en el archivo `application.yml`:

| Variable | Descripción | Valor por defecto |
|----------|-------------|-------------------|
| `SPRING_DATASOURCE_URL` | URL de conexión a la base de datos | `jdbc:postgresql://localhost:5432/prestamos` |
| `SPRING_DATASOURCE_USERNAME` | Usuario de la base de datos | `postgres` |
| `SPRING_DATASOURCE_PASSWORD` | Contraseña de la base de datos | `postgres` |
| `SERVER_PORT` | Puerto del servidor | `8080` |

### Configuración de Base de Datos

El proyecto está configurado para usar PostgreSQL por defecto. Para otras bases de datos, modifica las dependencias en `pom.xml` y la configuración en `application.yml`.

**Crear base de datos:**
```sql
CREATE DATABASE prestamos;
```

## Ejecución

### Desarrollo Local

1. **Clonar el repositorio**
```bash
git clone <repositorio-url>
cd prestamos
```

2. **Compilar el proyecto**
```bash
mvn clean compile
```

3. **Ejecutar la aplicación**
```bash
mvn spring-boot:run
```

La aplicación arrancará en `http://localhost:8080`

### Construcción del JAR

Para generar el ejecutable:
```bash
mvn clean package -DskipTests
```

El JAR generado estará en: `target/prestamos-0.0.1-SNAPSHOT.jar`

Ejecutar el JAR:
```bash
java -jar target/prestamos-0.0.1-SNAPSHOT.jar
```

### Docker

El proyecto incluye soporte para Docker. Para construir y ejecutar:

```bash
# Construir imagen
docker build -t prestamos-service .

# Ejecutar contenedor
docker run -p 8080:8080 prestamos-service
```

O usando Docker Compose:
```bash
docker-compose up --build
```

## API Documentation

Una vez iniciada la aplicación, la documentación interactiva está disponible en:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

### Endpoints Principales

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/interes/calcular` | Calcular interés de un préstamo |
| GET | `/api/interes/{id}` | Obtener interés por ID |
| GET | `/api/prestamo/{id}` | Obtener préstamo por ID |
| GET | `/api/cliente/{id}` | Obtener cliente por ID |

## Pruebas

### Ejecutar Pruebas Unitarias
```bash
mvn test
```

### Ejecutar Pruebas con Coverage
```bash
mvn test -Dcoverage
```

### Generar Reporte de Tests
```bash
mvn surefire-report:report
```

## Tecnologías Utilizadas

- **Java 21** - Lenguaje de programación
- **Spring Boot 3.5** - Framework de aplicación
- **Spring Data JPA** - Persistencia de datos
- **PostgreSQL** - Base de datos relacional
- **Lombok** - Reducción de boilerplate
- **SpringDoc OpenAPI** - Documentación de API
- **JUnit 5** - Framework de testing
- **Mockito** - Mocking para tests

## Principios de Código Limpio

Este proyecto implementa los siguientes principios:

- **KISS** (Keep It Simple, Stupid): Código simple y legible
- **SOLID**: Principios de diseño orientado a objetos
  - Single Responsibility Principle
  - Open/Closed Principle
  - Liskov Substitution Principle
  - Interface Segregation Principle
  - Dependency Inversion Principle
- **YAGNI** (You Aren't Gonna Need It): Solo funcionalidades necesarias
- **DRY** (Don't Repeat Yourself): Evitar duplicación de código

## Contribución

Para contribuir al proyecto:

1. Fork del repositorio
2. Crear rama de feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit de cambios (`git commit -am 'Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Crear Pull Request

## Licencia

Este proyecto está bajo la licencia propietaria de Banco. Todos los derechos reservados.

## Contacto

Para consultas técnicas: equipo-desarrollo@banco.com
```
