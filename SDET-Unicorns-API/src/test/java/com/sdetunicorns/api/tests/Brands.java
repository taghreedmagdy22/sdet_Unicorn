package com.sdetunicorns.api.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import com.sdetunicorns.api.properties_reading.ReadProperties;
import java.io.IOException;
import java.util.Properties;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Brands {

    Properties properties;
    String brandApi = properties.getProperty("base_url").concat("/brands");
    String brandHasID;
    String brandHasName;


    @BeforeTest
    public void setBaseUri() throws IOException {
        RestAssured.baseURI = brandApi;
        properties = ReadProperties.setProperties();
        brandHasID = properties.getProperty("brand_id");
        brandHasName = properties.getProperty("brand_name");
    }


    @Test
    public void validateBrandResponseStatus(){
        given().when().get().then().assertThat().statusCode(200);
    }

    @Test
    public void validateBrandsListEntries(){
        get().then().assertThat()
                .body("size()", greaterThan(1));

            get().then().assertThat()
                    .body("",everyItem(hasKey(brandHasID)));
        get().then().assertThat()
                .body("",everyItem(hasKey(brandHasName)));
    }

}
