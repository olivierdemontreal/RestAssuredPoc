package demo.restassured;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.DataProvider;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class DemoProjectTest {
 
  @Test
  public void PostUserDetails() {
	  
			// Specify the base URL to the RESTful web service
			RestAssured.baseURI = "https://reqres.in/api";

			// Get the RequestSpecification of the request 
			RequestSpecification request = RestAssured.given();

			// JSONObject is a class that represents a Simple JSON.
			// We can add Key - Value pairs using the put method
			JSONObject requestParams = new JSONObject();
			requestParams.put("name ", "Jack Ryan"); 
			requestParams.put("job", "spy");

			
			// Add a header stating the Request body is a JSON
			request.header("Content-Type", "application/json");

			// Add the Json to the body of the request
			request.body(requestParams.toJSONString());

			// Post the request and check the response
			Response response = request.post("/users");
			
			//Validate the status code
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
			Assert.assertEquals(statusCode, 201);

		}

  
  @Test
  public void GetUserDetails() {
	  
			// Specify the base URL to the RESTful web service
			RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
			//RestAssured.baseURI = "https://reqres.in/api/users";

			// Get the RequestSpecification of the request 
			RequestSpecification httpRequest = RestAssured.given();

			// Make a request to the server by specifying the method Type and the method URL.
			// Store the response in a variable.
			Response response = httpRequest.request(Method.GET, "/12");

			//Print the body of the message
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);
			
			// Get the status code from the Response. 
			int statusCode = response.getStatusCode();

			// Assert that correct status code is returned.
			Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Status code returned");

		}

  }


