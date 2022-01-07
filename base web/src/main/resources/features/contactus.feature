# language: es
@FeatureName:ContactoConPaginaWeb
Característica: Contacto con pagina Web
  Yo como cliente de la página web automationpractice.com
  deseo enviar un mensaje
  para realizar consultas a la empresa

  @ScenarioName:MensajeAServicioCliente
  Escenario: Mensaje a servicio al cliente
    Dado el cliente se encuentra en la pagina de inicio para escribir a servicio al cliente
    Cuando el cliente realizara envia un mensaje para conocer ofertas adicionales
    Entonces el cliente  debera ver que ha recibido el mensaje de confirmacion de confirmacion consulta a servicio al cliente

  @ScenarioName:MensajeAAdministradorWeb
  Escenario: : Mensaje al administrador web de la pagina
    Dado el cliente se encuentra en la pagina de inicio para escribir al administrador
    Cuando el cliente realizara el proceso para enviar un mensaje vacio
    Entonces el cliente  debera ver que ha recibido el mensaje de error



