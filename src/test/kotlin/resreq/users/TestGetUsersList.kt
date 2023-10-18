package resreq.users

import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import resreq.Users

class TestGetUsersList {
    init {
        RestAssured.baseURI = "https://reqres.in/"
    }

    @Test
    fun `Check Get Users List`() {
        val usersListResponse = Users.getUsersList(2)
        val responseJsonPath = JsonPath(usersListResponse.asString())
        Assertions.assertAll("Asserting response body",
            Executable { Assertions.assertEquals(2, responseJsonPath.get("page"), "assert page is 2") },
            Executable { Assertions.assertEquals(2, responseJsonPath.get("total_pages"), "assert total_pages is 2") },
            Executable {
                Assertions.assertEquals(
                    "michael.lawson@reqres.in",
                    responseJsonPath.get("data[0].email"),
                    "asserting first email in the list is michael.lawson@reqres.in"
                )
            }
        )
    }

    @Test
    fun `Intentionally Fails Check Get Users List`() {
        val usersListResponse = Users.getUsersList(2)
        val responseJsonPath = JsonPath(usersListResponse.asString())
        Assertions.assertAll("Asserting response body",
            Executable { Assertions.assertEquals(3, responseJsonPath.get("page"), "assert page is 3") }
        )
    }

}