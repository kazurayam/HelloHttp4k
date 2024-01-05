package com.kazurayam

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

/*
 https://www.baeldung.com/introduction-to-assertj
 */
class AssertJLesson {

    val fido: Dog = Dog("Fido", 5.25)
    val fidosClone = Dog("Fido", 5.25)

    @Test
    fun `Object Equality Assertions`() {
        //assertThat(fido).isEqualTo(fidosClone)
        assertThat(fido).usingRecursiveComparison().isEqualTo(fidosClone)
    }

    @Test
    fun `Boolean Assertions`() {
        assertThat("".isEmpty()).isTrue()
    }

    @Test
    fun `list contains`() {
        val list: List<String> = listOf("1", "2", "3")
        assertThat(list).contains("1")
    }

    @Test
    fun `using as`() {
        //assertThat("hoge").as("説明だよ").isEqualTo("Hoge")
    }
}

public class Dog (val name: String, val weight: Double)
