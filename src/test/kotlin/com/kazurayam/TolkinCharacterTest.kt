package com.kazurayam

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

/**
 * Introduction to AssertJ Core
 * https://assertj.github.io/doc/#assertj-overview
 */
class TolkinCharacter(val name: String, val age: Int = 35) {
    override fun toString(): String {
        return this.name
    }
}

class TolkinCharacterTest {

    private val frodo = TolkinCharacter("Frodo", 35)
    private val samwise = TolkinCharacter("Samwise", 43)
    private val pippin = TolkinCharacter("Pippin", 58)
    private val merry = TolkinCharacter("Merry", 34)
    private val gandalf = TolkinCharacter("Gandalf", 99)
    private val legolas = TolkinCharacter("legolas", 76)
    private val gimli = TolkinCharacter("Gimli", 52)
    private val boromir = TolkinCharacter("Boromir", 65)
    private val aragorn = TolkinCharacter("Aragorn", 120)
    private val sauron = TolkinCharacter("Sauron", 300)


    private val fellowshipOfTheRing: List<TolkinCharacter> =
        listOf(frodo, samwise, pippin, merry, gandalf,
            legolas, gimli, boromir, aragorn)
    @Test
    fun basicAssertions() {
        assertThat(frodo.name).isEqualTo("Frodo")
        //assertThat(frodo).isEqualTo(frodoAlt)
        assertThat(frodo).isNotEqualTo(sauron)
    }

    @Test
    fun chainingStringSpecificAssertions() {
        assertThat(frodo.name).startsWith("Fro")
            .endsWith("do")
            .isEqualToIgnoringCase("frodo")
    }

    @Test
    fun collectionAssertions() {
        assertThat(fellowshipOfTheRing).hasSize(9)
            .contains(frodo, samwise)
            .doesNotContain(sauron)
    }

    /* as() is used to describe the test and will be shown before the error message
     */
    @Test
    fun `as`() {
        //assertThat(frodo.age).as("check ${frodo.name}'s age").isEqualTo(33)
    }

    @Test
    fun `Exception assertion`() {
        assertThatThrownBy { throw Exception("boom!"); }.hasMessage("boom!")
    }

    @Test
    fun `using the extracting feature`() {
        //assertThat(fellowshipOfTheRing).extracting(TolkinCharacter::name).doesNotContain(sauron);
    }
}