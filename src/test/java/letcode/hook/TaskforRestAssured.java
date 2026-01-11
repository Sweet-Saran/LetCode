package letcode.hook;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TaskforRestAssured {
	public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // 1. POST - Add Place
        // Note: I've kept the string body for now to fix your immediate error, 
        // but using the POJO classes you defined is recommended.
        String response = RestAssured.given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\"shoe park\", \"shop\"],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}")
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .extract().asString();

        // FIX: Pass the 'response' variable, not the string "response"
        JsonPath jp = new JsonPath(response); 
        String place_id = jp.getString("place_id");
        System.out.println("Extracted Place ID: " + place_id);

        // 2. PUT - Update Address
        String newAddress = "70 winter walk, USA";
        
        RestAssured.given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + place_id + "\",\n" +
                        "\"address\":\"" + newAddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when().put("/maps/api/place/update/json")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        // 3. GET - Verify Update
        RestAssured.given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", place_id)
                .when().get("/maps/api/place/get/json")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("address", equalTo(newAddress));    
        }

	private static ResponseAwareMatcher<Response> equalTo(String newAddress) {
		return null;
	}
}
