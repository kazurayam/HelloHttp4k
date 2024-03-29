package quickstart

import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer

/*
 * https://qiita.com/toastkidjp/items/738b28546bc40eed6e40
 */

fun main() {
    routes("/hello" bind Method.GET to { _: Request -> Response(OK).body("hello!!") })
        .asServer(SunHttp(8000))
        .start()
}

