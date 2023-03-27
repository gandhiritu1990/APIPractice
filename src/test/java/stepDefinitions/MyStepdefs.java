package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class MyStepdefs extends Utilities {
    RequestSpecification req;
    ResponseSpecification resSpec;
    TestDataBuild testData = new TestDataBuild();
    Response res;
        @Given("^API AddPlace request$")
            public void addPlaceRequest() throws IOException {

            req = given().spec(reqSpecBuilder()).body(testData.addPlace());
            resSpec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        }

    @When("user calls AddPlace API")
    public void userCallsAddPlaceAPI() {
        res=given().spec(req)
                .when().post("/maps/api/place/add/json").
                then().spec(resSpec).extract().response();
    }

    @Then("API call got success status code")
    public void apiCallGotSuccessStatusCode() {
        Assert.assertEquals(res.getStatusCode(),200,"Got incorrect status code");
    }
}
