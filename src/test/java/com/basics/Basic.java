package com.basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class Basic {
    public static void main(String[] args){
        //given - all input details
        // when - submit API (POST/GET/PUT/DELETE) and resource
        //then  -validate response
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n"
                        + "  \"location\": {\n"
                        + "    \"lat\": -38.383494,\n"
                        + "    \"lng\": 33.427362\n"
                        + "  },\n"
                        + "  \"accuracy\": 50,\n"
                        + "  \"name\": \"Frontline house\",\n"
                        + "  \"phone_number\": \"(+91) 983 893 3937\",\n"
                        + "  \"address\": \"30, side layout, cohen 09\",\n"
                        + "  \"types\": [\n"
                        + "    \"shoe park\",\n"
                        + "    \"shop\"\n"
                        + "  ],\n"
                        + "  \"website\": \"http://google.com\",\n"
                        + "  \"language\": \"French-IN\"\n"
                        + "}\n").when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        //log().all() method with given and then is used to log complete request & response


        System.out.println("response: " +response);
        //JSONPath is used to parse parse string as json and takes string as input
        JsonPath js = new JsonPath(response);
        System.out.println(js.getString("place_id"));


    }
}
