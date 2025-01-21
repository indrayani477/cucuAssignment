package stepDefinationFiles;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Booking;
import pojo.BookingDates;
import org.junit.Assert;

public class apiSteps {

    private Response response;
    private RequestSpecification request;

    @Given("I set up the base URI")
    public void setUpBaseURI() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @When("I send a POST request to {string} with valid payload")
    public void sendPostRequest(String endpoint) {
        Booking booking = new Booking("Raj", "Das", 150, true, new BookingDates("2025-01-20", "2025-01-25"));
        request = RestAssured.given().header("Content-Type", "application/json").body(booking);
        response = request.post(endpoint);
    }

    @When("I send a PUT request to {string} with updated payload")
    public void sendPutRequest(String endpoint) {
        Booking updatedBooking = new Booking("Akshya", "More", 200, false, new BookingDates("2025-02-01", "2025-02-05"));
        request = RestAssured.given().header("Content-Type", "application/json").body(updatedBooking);
        response = request.put(endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void sendDeleteRequest(String endpoint) {
        request = RestAssured.given();
        response = request.delete(endpoint);
    }

    @Then("the response status should be {int}")
    public void validateResponseStatus(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response contains {string}")
    public void validateResponseBody(String content) {
        Assert.assertTrue(response.asString().contains(content));
    }
}
