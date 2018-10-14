package restWork;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestWeatherService {
	@Test
	public void firstTest() {
		
		RestAssured.baseURI="http://parabank.parasoft.com/parabank/services/bank/customers/12212/";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.get();
		
		String Str=response.getBody().asString();
		
		System.out.println(Str);
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		Assert.assertEquals(200, response.getStatusCode());
		JsonPath jp=response.jsonPath();
		System.out.println(jp.getInt("id"));
		
	}
	
}
