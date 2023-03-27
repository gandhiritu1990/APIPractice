package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utilities {

    public RequestSpecification reqSpecBuilder() throws IOException {
        PrintStream printLogs = new PrintStream(new FileOutputStream("logging.txt"));
        RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(getProperty("baseURL")).addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(printLogs))
                .addFilter(ResponseLoggingFilter.logResponseTo(printLogs))
                .setContentType(ContentType.JSON).build();
        return reqSpec;
    }

    public static String getProperty(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\gandh\\Downloads\\APIPractice\\APIPractice\\src\\test\\java\\resources\\GlobalVariables.properties"));
        prop.load(fis);
        return prop.getProperty(key);
    }
}
