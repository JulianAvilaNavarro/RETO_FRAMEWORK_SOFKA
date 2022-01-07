# language: es
  @FeatureName:ComprarPorMediodelCarroDeCompras
Característica:Comprar por medio del carro de compras en la pagina web automationpractice
  Como usuario registrado de la pagina
  quiero agregar productos al carrito de compras
  para saber realizar el pedido

  @ScenarioName:CompraProductosEnLaCategoriaWomen
  Escenario: Compra productos en la categoria women
    Dado el cliente esta logeado esta en la pagina y desea compar un producto
    Cuando el cliente entra a la categoria women y agrega un producto
    Entonces el cliente completa los pasos y debera ver el mensaje "Your order on My Store is complete."
  @ScenarioName:CompraProductosEnLaCategoriaDresses
  Escenario: : Compra productos en la categoria dresses
    Dado el cliente esta logeado esta en la pagina y desea compar dos productos
    Cuando el usuario entra a dresses y agrega dos productos
    Entonces el usuario completa la compra y deberia ver el mensaje "Your order on My Store is complete."