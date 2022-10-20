package com.github.ngoanh2n.pagesAPI;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.github.ngoanh2n.test_framework.logging.Log.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;

public class TestAPI{
    @Test
    public void jsonIterateArr() {

        //base URI with Rest Assured class
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        //obtain Response from GET request
        Response res = given()
                .when()
                .get("/employees");

        //convert string to JSON
        try {
            JSONObject jsonObject = new JSONObject(res.asString());
            System.out.println(jsonObject.get("data"));

//            for (int i = 0; i < jsonarray.length(); i++) {
//                JSONObject jsonobject = jsonarray.getJSONObject(i);
//                String name = jsonobject.getString("name");
//                String url = jsonobject.getString("url");
//                System.out.println(i);
//            }

        }catch (JSONException err){
            System.out.println("ERoare");
        }


//        JsonPath j = new JsonPath(res.asString());



//        //get values of JSON array after getting array size
//        int s = j.getInt("Location.size()");
//        for(int i = 0; i < s; i++) {
////            String state = j.getString("Location["+i+"].State");
////            String zip = j.getString("Location["+i+"].zip");
//            System.out.println(j);
////            System.out.println(zip);
//        }
    }
}
