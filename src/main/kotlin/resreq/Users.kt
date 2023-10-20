@file:Suppress("unused")

package resreq

import io.restassured.RestAssured.given
import io.restassured.response.Response

// use object here, so it can be called directly in test classes
object Users {

    fun getUsersList(page: Int?): Response {
        // rest-assured accepts map as parameter, so we use one to build the request parameter
        // ...?.let is used here so if the parameter is null, it will not be included in the api call
        val queryParams = buildMap {
            page?.let { put("page", page) }
        }

        // declare the api url path and method, and include the map above as parameter (in this example, query)
        // and then return the response object
        return given().queryParams(queryParams).get("/api/users")
    }
}