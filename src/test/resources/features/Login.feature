Feature: Login

  @TEST_JIRA_001
  Scenario: Puedo loguearme cuando utilizo credenciales correctas
    Given el usuario abre la pagina de login
    When el usuario ingresa credenciales correctas
    And el usuario hace click en Login
    Then se muestra la pagina de productos

  @TEST_JIRA_002
  Scenario: No puedo loguearme cuando utilizo credenciales incorrectas
    Given el usuario abre la pagina de login
    When el usuario ingresa credenciales incorrectas
    And el usuario hace click en Login
    Then se muestra un mensaje de error de credenciales
    And el mensaje de error contiene el texto "Username and password do not match any user in this service"