@api
  Feature: Checking GET request in Platzi Store API
    # https://api.escuelajs.co/docs#/products/ProductsController_getProduct

    Scenario: Checking GET request with products in Platzi Store API
      Given User uses "products" part of Platzi API url
      When User sends GET request using path param id "10"
      Then Verify status code is "200" and ContentType is "json"
