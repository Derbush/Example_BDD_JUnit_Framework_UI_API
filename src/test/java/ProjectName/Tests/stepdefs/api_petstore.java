package ProjectName.Tests.stepdefs;

import ProjectName.Tests.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class api_petstore {

    User user;
    User createdUser;

    @Given("Create a new User using {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public User create_a_new_user_using(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus){

       user = new User();

        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setUserStatus(userStatus);

        System.out.println("user = " + user);

        return user;
    }
    @When("POST the below sample json to the createWithArray endpoint")
    public void post_the_below_sample_json_to_the_create_with_array_endpoint() throws JsonProcessingException {
        List<User> allUsers = new ArrayList<>();
        allUsers.add(user);
        ObjectMapper objectMapper = new ObjectMapper();
        String arrayOfUsersJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allUsers);

        System.out.println("arrayOfUsersJson = " + arrayOfUsersJson);


        RestAssured.given()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .body(arrayOfUsersJson)
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithArray")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract().jsonPath();


    }
    @Then("GET the information calling GET service and {string} param")
    public User get_the_information_calling_get_service_and_param(String username) {
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .and().pathParam("username", username)
                .when().get("https://petstore.swagger.io/v2/user/{username}")
                .then().statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        createdUser = response.as(User.class);
        System.out.println("createdUser = " + createdUser);
        return createdUser;
    }
    @Then("Verify the record is retrieved successfully with all the details")
    public void verify_the_record_is_retrieved_successfully_with_all_the_details() {
      //  Assertions.assertThat(user).isEqualTo(createdUser);
    }
    @Then("Delete the {string}")
    public void delete_the(String username) {

        RestAssured.given()
                .accept(ContentType.JSON)
                .and().pathParam("username", username)
                .when().delete("https://petstore.swagger.io/v2/user/{username}")
                .then().statusCode(200);

        System.out.println("Record is deleted");
    }



}
