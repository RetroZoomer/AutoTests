import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class APITests {

    // https://petstore.swagger.io/

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    private static final String PET_ENDPOINT = "/pet";
    private Long petId;

    private static final String USER_ENDPOINT = "/user";
    private String username;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = BASE_URL;

        String petJson = """
                {
                                    "id": 0,
                                    "category": {
                                        "id": 1,
                                        "name": "dogs"
                                    },
                                    "name": "Buddy",
                                    "photoUrls": ["https://example.com/buddy.jpg"],
                                    "tags": [
                                        {
                                            "id": 1,
                                            "name": "friendly"
                                        }
                                    ],
                                    "status": "available"
                }
                """;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(petJson)
                .post(PET_ENDPOINT);

        petId = response.jsonPath().getLong("id");
        System.out.println("Create pet with ID: " + petId);
    }

    @Test
    public void getPetId() {
        Response response = given()
                .get(PET_ENDPOINT + "/" + petId);

        Long petId = response.jsonPath().getLong("id");
        System.out.println("Pet ID = " + petId);

        assertEquals(200, response.getStatusCode(), "Failed to get pet by ID");
        assertEquals(this.petId, response.jsonPath().getLong("id"));

    }

    @Test
    public void createUser() {
        this.username = "User123";
        String userJson = """
                {
                  "id": 0,
                  "username": "%s",
                  "firstName": "Artem",
                  "lastName": "Mironov",
                  "email": "x@x.com",
                  "password": "password123",
                  "phone": "79585631789",
                  "userStatus": 1
                }
                """.formatted(this.username);

        // POST зпрос на создание пользователя
        given()
                .contentType(ContentType.JSON)
                .body(userJson)
                .when()
                .post(USER_ENDPOINT)
                .then()
                .statusCode(200);

        System.out.println("Created user with Username: " + username);
    }

    @AfterEach
    public void tearDown() {
        if (petId != null) {
            Response response = given()
                    .delete(PET_ENDPOINT + "/" + petId);

            assertEquals(200, response.statusCode(), "Failed to delete pet");
            System.out.println("Deleted pet with ID: " + petId);
        }


        if (username != null) {
            Response response = given()
                    .delete(USER_ENDPOINT + "/" + username);

            assertEquals(200, response.getStatusCode(), "Failed to delete user");
            System.out.println("Deleted user with ID: " + username);
        }
    }


}
