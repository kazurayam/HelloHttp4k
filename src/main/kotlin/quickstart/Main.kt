package quickstart

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.server.asServer
import org.http4k.server.Undertow

/**
 * https://www.http4k.org/quickstart/
 */
fun main() {
    val app = { request: Request -> Response(OK).body("Hello, ${request.query("name")}!")}
    val server = app.asServer(Undertow(9000)).start()
    val client = ApacheClient()
    val request =
        Request(Method.GET, "http://localhost:9000")
            .query("name", "John Doe")
    val response = client(request)
    println(response)
    server.stop()
}