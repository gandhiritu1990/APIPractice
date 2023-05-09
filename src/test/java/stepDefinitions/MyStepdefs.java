package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import resources.TestDataBuild;
import resources.Utilities;


import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;


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

    @And("launch browser")
    public void launchBrowser() throws IOException {

    }
}
