package restWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RealRest {
	//@Test
	public void Web_123() {
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts/3";
		RequestSpecification request=RestAssured.given();
		Response response=request.get();
		System.out.println(response.getStatusCode());
		
	}
	
	//@Test
	public void Web_1234() {
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/photos/1";
		RequestSpecification request=RestAssured.given();
		Response response=request.get();
		
		String ar=response.path("url");
		System.out.println(ar);
		
		
	}
	@Test
	public void Web_2234() {
		
		RestAssured.baseURI="http://services.groupkt.com/country/get/iso2code/IN";
		RequestSpecification request=RestAssured.given();
		Response response=request.get();
		
		String ar=response.path("RestResponse.result.name");
		System.out.println(ar);
		System.out.println(response.contentType());
		
	}
}
