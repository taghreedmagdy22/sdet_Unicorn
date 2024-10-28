package com.sdetunicorns.api.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.greaterThan;
import com.sdetunicorns.api.properties_reading.ReadProperties;
import java.io.IOException;
import java.util.Properties;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Brands {

    Properties properties = ReadProperties.setProperties();
    String brandApi = properties.getProperty("base_url").concat("/brands");


    public Brands() throws IOException {
    }

    @BeforeTest
    public void setBaseUri(){
        RestAssured.baseURI = brandApi;
    }

    @Test
    public void validateBrandResponseStatus(){
        setBaseUri();
        given().when().get().then().assertThat().statusCode(200);
    }

    @Test
    public void validateBrandsListEntries(){
        setBaseUri();
        get().then().assertThat()
                .body("size()", greaterThan(1));
    }


}
