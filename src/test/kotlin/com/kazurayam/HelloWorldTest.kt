package com.kazurayam

import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

/**
 * https://www.http4k.org/guide/tutorials/your_first_http4k_app/
 */
class HelloWorldTest {

    @Test
    fun `Ping test`() {
        //assertEquals(Response(OK).body("pong"), app(Request(GET, "/ping")))
        assertThat(app(Request(GET, "/ping"))).isEqualTo(Response(OK).body("pong"))
    }
    @Test
    fun `Pong test`() {
        //assertEquals(Response(OK).body("pong"), app(Request(GET, "/ping")))
        assertThat(app(Request(GET, "/pong"))).isEqualTo(Response(OK).body("ping"))
    }

    @Test
    fun `Never fails`() {
        assertThat(true)
    }

    @Test
    fun testAssertEquals() {
        assertThat("foo").isEqualTo("foo")
    }

}
