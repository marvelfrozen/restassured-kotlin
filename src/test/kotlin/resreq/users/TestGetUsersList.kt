package resreq.users

import io.restassured.RestAssured
import io.restassured.filter.log.ErrorLoggingFilter
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.path.json.JsonPath
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import resreq.Users

class TestGetUsersList {

    init {
        // this tutorial set the base uri here, but in real use case, you can use configuration file or any other method to set the base uri
        RestAssured.baseURI = "https://reqres.in/"

        // add filters here, you can use the available default filters, its will print the logs to console, can help with debugging the test
        RestAssured.filters(RequestLoggingFilter(), ResponseLoggingFilter(), ErrorLoggingFilter())
    }

    @Test
    fun `Check Get Users List`() {
        // call the module class and function here, and return the response to a variable
        val usersListResponse = Users.getUsersList(2)

        // parse the response body to a json object
        val responseJsonPath = JsonPath(usersListResponse.asString())

        // assert the json object
        Assertions.assertAll("Asserting response body",
            // for example, here we assert that the responve value of `page` is expected to be 2
            Executable { Assertions.assertEquals(2, responseJsonPath.get("page"), "assert page is 2") },
            Executable { Assertions.assertEquals(2, responseJsonPath.get("total_pages"), "assert total_pages is 2") },
            Executable {
                Assertions.assertEquals(
                    "michael.lawson@reqres.in",
                    // and this is an example of how we get a nested json object value
                    // we get the first index of array `data` and then get the value of `email`
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