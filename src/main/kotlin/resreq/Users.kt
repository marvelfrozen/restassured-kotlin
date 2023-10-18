@file:Suppress("unused")

package resreq

import io.restassured.RestAssured.given
import io.restassured.response.Response

object Users {

    fun getUsersList(page: Int?): Response {
        val queryParams = buildMap {
            page?.let { put("page", page) }
        }
        return given().queryParams(queryParams).get("/api/users")
    }
}