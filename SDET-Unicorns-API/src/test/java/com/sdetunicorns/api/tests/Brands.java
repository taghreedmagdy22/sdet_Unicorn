package com.sdetunicorns.api.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import com.sdetunicorns.api.properties_reading.ReadProperties;
import java.io.IOException;
import java.util.Properties;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;


public class Brands {

    Properties properties = ReadProperties.setProperties();;
    String brandApi = properties.getProperty("base_url").concat("/brands");
    String brandHasID;
    String brandHasName;
    String idParam,idValue,brandName;

    public Brands() throws IOException {
    }


    @BeforeTest
    public void setBaseUri() throws IOException {
        RestAssured.baseURI = brandApi;
        brandHasID = properties.getProperty("brand_id");
        brandHasName = properties.getProperty("brand_name");
        idParam  = properties.getProperty("param");
        idValue  = properties.getProperty("paramValue");
        brandName  = properties.getProperty("paramName");

    }



    @Test(description = "Validate get request status code for brands")
    public void validateBrandResponseStatus() {
        given().when().get().then().assertThat().statusCode(200);
    }

    @Test(description = "Validate the brands list elements")
    public void validateBrandsListEntries() {
        given()
                .get().then().assertThat()
                .body("size()", greaterThan(1));

        given()
                .get().then().assertThat()
                    .body("",everyItem(hasKey(brandHasID)));

        given()
                .get().then().assertThat()
                .body("",everyItem(hasKey(brandHasName)));
    }

    @Test
    public void validateBrandItem(){
        given().pathParam(idParam, idValue)
                .when()
                .get("/{"+idParam+"}").then().assertThat().statusCode(200);


        given()
                .pathParam(idParam, idValue)
                .when()
                .get("/{"+idParam+"}")
                .then()
                .body("name", containsString(brandName));
    }


}


