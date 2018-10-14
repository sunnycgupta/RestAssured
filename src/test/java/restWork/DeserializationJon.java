package restWork;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DeserializationJon {
	@Test
	public void webServiceSerial() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RequestSpecification request=RestAssured.given();
		JSONObject requestParameter=new JSONObject();
		requestParameter.put("FirstName", "Sunny");
		requestParameter.put("LastName", "Gupta");
		requestParameter.put("Age", "30");
		requestParameter.put("Sex", "Male");
		request.header("Content-Type","Application/Json");
		request.body(requestParameter.toJSONString());
		Response response=request.post("/enroll");
		ResponseBody responseBody=response.getBody();
		response.getStatusCode();
		
		RegistrationSuccessResponse registrationSuccessResponse=responseBody.as(RegistrationSuccessResponse.class);
		Assert.assertEquals("Success", registrationSuccessResponse.Message);
		Assert.assertEquals("SuccessfullOnline", registrationSuccessResponse.SuccessCode);
		
	}
}
