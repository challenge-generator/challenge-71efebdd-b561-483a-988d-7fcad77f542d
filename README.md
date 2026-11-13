# Refactorización de código para cumplir con principios de código limpio

La división de préstamos de un banco necesita refactorizar un módulo de cálculo de intereses para que cumpla con los principios de código limpio: KISS, SOLID, YAGNI y DRY. El módulo actual tiene una estructura compleja y difícil de mantener. Los actores involucrados son el Cliente, el Sistema de Préstamos y el Servicio de Cálculo de Intereses. El objetivo es mejorar la mantenibilidad y escalabilidad del código.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Aplicación de Código limpio y eficiente |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Análisis del código existente

**Objetivo:** Identificar las áreas del código que no cumplen con los principios de código limpio.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Revisar el código del módulo de cálculo de intereses.
- Identificar las violaciones a los principios KISS, SOLID, YAGNI y DRY.

**Entregable:** Informe de análisis que detalla las áreas del código que no cumplen con los principios de código limpio.

<details>
<summary>Pistas de conocimiento</summary>

- Principios de diseño de software.
- Patrones de diseño comunes.

</details>

### Fase 2: Refactorización del código

**Objetivo:** Aplicar los principios de código limpio para refactorizar el módulo de cálculo de intereses.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Aplicar los principios KISS, SOLID, YAGNI y DRY para refactorizar el código.
- Escribir pruebas unitarias para verificar el funcionamiento correcto del código refactorizado.

**Entregable:** Código refactorizado que cumple con los principios de código limpio y pruebas unitarias asociadas.

<details>
<summary>Pistas de conocimiento</summary>

- Técnicas de refactorización.
- Escritura de pruebas unitarias.

</details>

### Fase 3: Revisión y documentación

**Objetivo:** Revisar el código refactorizado y documentar los cambios realizados.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Revisar el código refactorizado para asegurar que cumple con los principios de código limpio.
- Documentar los cambios realizados y las razones detrás de cada decisión.

**Entregable:** Código refactorizado revisado y documentación de los cambios realizados.

<details>
<summary>Pistas de conocimiento</summary>

- Prácticas de revisión de código.
- Técnicas de documentación.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los principios de código limpio y por qué son importantes?
- **paraQueSirve**: ¿Cómo aplican los principios de código limpio en la refactorización del módulo de cálculo de intereses?
- **comoSeUsa**: ¿Cómo se aplican los principios KISS, SOLID, YAGNI y DRY en la refactorización del código?
- **erroresComunes**: ¿Cuáles son los errores comunes al aplicar los principios de código limpio?
- **queDecisionesImplica**: ¿Qué decisiones implica la refactorización del código para cumplir con los principios de código limpio?

## Criterios de Evaluacion

- Identificación de áreas del código que no cumplen con los principios de código limpio.
- Aplicación de los principios KISS, SOLID, YAGNI y DRY en la refactorización del código.
- Escritura de pruebas unitarias para verificar el funcionamiento correcto del código refactorizado.
- Revisión del código refactorizado para asegurar que cumple con los principios de código limpio.
- Documentación de los cambios realizados y las razones detrás de cada decisión.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
