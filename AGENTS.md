# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Refactorización de código para cumplir con principios de código limpio**.

| | |
|---|---|
| Tema | Aplicación de Código limpio y eficiente |
| Nivel | senior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.5.6
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-test n/a
- org.junit.jupiter:junit-jupiter-api n/a
- org.mockito:mockito-core 5.12.0
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.9.1
- org.postgresql:postgresql 42.7.3
- org.projectlombok:lombok 1.18.34

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Análisis del código existente**: Informe de análisis que detalla las áreas del código que no cumplen con los principios de código limpio.
- **Fase 2 — Refactorización del código**: Código refactorizado que cumple con los principios de código limpio y pruebas unitarias asociadas.
- **Fase 3 — Revisión y documentación**: Código refactorizado revisado y documentación de los cambios realizados.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/test/java/com/banco/prestamos/domain/services/CalculoInteresServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/banco/prestamos/application/usecases/CalcularInteresUseCaseTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapterTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (22)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `org.slf4j`
      El import org.slf4j.Logger pertenece a org.slf4j, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/banco/prestamos/infrastructure/config/SwaggerConfig.java` — `io.swagger.v3`
      El import io.swagger.v3.oas.models.Components pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java` — `Prestamo.getFechaInicio`
      Se invoca `getFechaInicio` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java` — `Prestamo.getId`
      Se invoca `getId` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java` — `Prestamo.getMonto`
      Se invoca `getMonto` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java` — `Prestamo.getTasaInteres`
      Se invoca `getTasaInteres` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `Prestamo.getId`
      Se invoca `getId` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `Prestamo.getMonto`
      Se invoca `getMonto` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `Prestamo.getTasaInteres`
      Se invoca `getTasaInteres` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `Interes.getMontoInteres`
      Se invoca `getMontoInteres` sobre `Interes`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java` — `Prestamo.getFechaInicio`
      Se invoca `getFechaInicio` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapter.java` — `Prestamo.getMonto`
      Se invoca `getMonto` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapter.java` — `Prestamo.getTasaInteres`
      Se invoca `getTasaInteres` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapter.java` — `Prestamo.getFechaInicio`
      Se invoca `getFechaInicio` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapter.java` — `Prestamo.getFechaVencimiento`
      Se invoca `getFechaVencimiento` sobre `Prestamo`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `InteresCompuestoRequest.prestamoId`
      Se invoca `prestamoId` sobre `InteresCompuestoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `InteresCompuestoRequest.fechaCalculo`
      Se invoca `fechaCalculo` sobre `InteresCompuestoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `CalcularInteresUseCase.ejecutarCalculoSimple`
      Se invoca `ejecutarCalculoSimple` sobre `CalcularInteresUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `CalcularInteresUseCase.ejecutarCalculoCompuesto`
      Se invoca `ejecutarCalculoCompuesto` sobre `CalcularInteresUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `InteresCompuestoRequest.periodos`
      Se invoca `periodos` sobre `InteresCompuestoRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java` — `CalcularInteresUseCase.obtenerInteresTotal`
      Se invoca `obtenerInteresTotal` sobre `CalcularInteresUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (16)

- `pom.xml`
- `src/main/java/com/banco/prestamos/PrestamosApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/banco/prestamos/domain/model/Cliente.java`
- `src/main/java/com/banco/prestamos/domain/model/Prestamo.java`
- `src/main/java/com/banco/prestamos/domain/model/Interes.java`
- `src/main/java/com/banco/prestamos/domain/ports/CalculoInteresPort.java`
- `src/main/java/com/banco/prestamos/domain/services/CalculoInteresService.java`
- `src/main/java/com/banco/prestamos/application/usecases/CalcularInteresUseCase.java`
- `src/main/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapter.java`
- `src/main/java/com/banco/prestamos/infrastructure/controllers/InteresController.java`
- `src/main/java/com/banco/prestamos/infrastructure/config/SwaggerConfig.java`
- `src/test/java/com/banco/prestamos/domain/services/CalculoInteresServiceTest.java`
- `src/test/java/com/banco/prestamos/application/usecases/CalcularInteresUseCaseTest.java`
- `src/test/java/com/banco/prestamos/infrastructure/adapters/CalculoInteresAdapterTest.java`
- `README.md`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/banco/prestamos/domain/model`
- `src/main/java/com/banco/prestamos/domain/ports`
- `src/main/java/com/banco/prestamos/domain/services`
- `src/main/java/com/banco/prestamos/application/usecases`
- `src/main/java/com/banco/prestamos/infrastructure/adapters`
- `src/main/java/com/banco/prestamos/infrastructure/controllers`
- `src/main/java/com/banco/prestamos/infrastructure/config`
- `src/test/java/com/banco/prestamos/domain/services`
- `src/test/java/com/banco/prestamos/application/usecases`
- `src/test/java/com/banco/prestamos/infrastructure/adapters`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2
- Brecha que el reto ataca: Aplica principios y herramientas de verificación para escribir código limpio (KISS, SOLID, YAGNI y DRY)., Aplica principios y herramientas de verificación para escribir código limpio (KISS, SOLID, YAGNI y DRY).

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
