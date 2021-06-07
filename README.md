# Ejemplo de testing automático con Selenium + Cucumber

### Ejecutar features de cucumber

Para correr todos los tests, simplemente ejecuta

    mvn clean test

Podes especificar archivos para ejecutar a partir de su *path*:

    mvn clean test -Dcucumber.options="src/test/resources/features/Ejemplo.feature"

Tambien puedes especificar qué correr usando un *tag*:

    mvn clean test -Dcucumber.filter.tags="@TEST_ID-123"