package com.basics;

import com.testData.SampleJSON;
import io.restassured.path.json.JsonPath;

public class ParseComplexJSON {

    public static void main(String[] args){
        JsonPath js = new JsonPath(SampleJSON.complexJSON());
        //Total no. of courses
        System.out.println("Total no. of courses: " +js.getInt("courses.size()"));
        // purchase amount
        System.out.println("Purchase amount: " +js.getInt("dashboard.purchaseAmount"));
        // Title of first course
        System.out.println("Title of first course: " +js.getString("courses[0].title"));
    }
}
