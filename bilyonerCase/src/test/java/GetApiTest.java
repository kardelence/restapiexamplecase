import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetApiTest {

    private static final String BASE_URL = "https://dummy.restapiexample.com/api/v1";

    @Test
    public void testStatusCode() throws InterruptedException {
        given()
                .when()
                .get(BASE_URL + "/employees")
                .then()
                .statusCode(200);
    }

    @Test
    public void testNumberOfEmployees() throws InterruptedException {
        given()
                .when()
                .get(BASE_URL + "/employees")
                .then()
                .body("data.size()", equalTo(24));
    }

    @Test
    public void testEmployeeNameBySalary() throws InterruptedException {
        given()
                .when()
                .get(BASE_URL + "/employees")
                .then()
                .body("data.findAll{it.employee_salary == 313500}.employee_name", hasItem("Haley Kennedy"));
    }
}




