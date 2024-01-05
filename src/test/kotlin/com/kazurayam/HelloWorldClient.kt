package com.kazurayam

import org.http4k.client.JavaHttpClient
import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters.PrintResponse

/**
 * https://www.http4k.org/guide/tutorials/your_first_http4k_app/
 */
fun main() {
    val client: HttpHandler = JavaHttpClient()
    val printingClient: HttpHandler = PrintResponse().then(client)
    val response: Response = printingClient(Request(GET, "http://localhost:9000/pong"))
    println("-----------------\n" + response.bodyString())
}
