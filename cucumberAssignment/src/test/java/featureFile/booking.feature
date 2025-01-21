Feature: Restful Booker API Testing

  Scenario: Test GET API
    Given I set up the base URI
    When I send a GET request to "/booking"
    Then the response status should be 200

  Scenario: Test POST API
    Given I set up the base URI
    When I send a POST request to "/booking" with valid payload
    Then the response status should be 200

  Scenario: Test PUT API
    Given I set up the base URI
    When I send a PUT request to "/booking/1" with updated payload
    Then the response status should be 403
    
    Scenario: Test DELETE API
    Given I set up the base URI
    When I send a DELETE request to "/booking/1"
    Then the response status should be 403

  
