package com.kazurayam

import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer

/**
 * https://www.http4k.org/guide/tutorials/your_first_http4k_app/
 */
val app: HttpHandler = routes(
    ("/ping" bind GET) to {
        Response(OK).body("pong")
    },
    ("/pong" bind GET) to { _ : Request ->
        Response(OK).body("ping")
    }
)

fun main() {
    val printingApp: HttpHandler = PrintRequest().then(app)
    val server = printingApp.asServer(SunHttp(9000)).start()
    println("Server started on " + server.port())
}
