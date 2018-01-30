package com.github.ypconstante

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InversionCountTest {

    private val inversionCount = InversionCount()

    @Test
    fun countInversionsEmptyArray() {
        val input = emptyList<Int>()
        val actual = inversionCount.count(input)
        val expected = 0L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith1Element() {
        val input = listOf(1)
        val actual = inversionCount.count(input)
        val expected = 0L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith2ElementsAlreadySorted() {
        val input = listOf(1, 2)
        val actual = inversionCount.count(input)
        val expected = 0L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith2ElementsReversed() {
        val input = listOf(2, 1)
        val actual = inversionCount.count(input)
        val expected = 1L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith2ElementsRepeatedValues() {
        val input = listOf(1, 1)
        val actual = inversionCount.count(input)
        val expected = 0L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith3ElementsAlreadySorted() {
        val input = listOf(1, 2, 3)
        val actual = inversionCount.count(input)
        val expected = 0L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith3ElementsReversed() {
        val input = listOf(3, 2, 1)
        val actual = inversionCount.count(input)
        val expected = 3L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith3ElementsElementsInTheBeginOutOfOrder() {
        val input = listOf(2, 1, 3)
        val actual = inversionCount.count(input)
        val expected = 1L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith3ElementsElementsInTheEndOutOfOrder() {
        val input = listOf(1, 3, 2)
        val actual = inversionCount.count(input)
        val expected = 1L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith3ElementsRepeatedValues() {
        val input = listOf(1, 1, 3)
        val actual = inversionCount.count(input)
        val expected = 0L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsAlreadySorted() {
        val input = listOf(1, 2, 3, 4)
        val actual = inversionCount.count(input)
        val expected = 0L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsReversed() {
        val input = listOf(4, 3, 2, 1)
        val actual = inversionCount.count(input)
        val expected = 6L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsElementsInTheBeginOutOfOrder() {
        val input = listOf(2, 1, 3, 4)
        val actual = inversionCount.count(input)
        val expected = 1L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsElementsInTheMiddleOutOfOrder() {
        val input = listOf(1, 3, 2, 4)
        val actual = inversionCount.count(input)
        val expected = 1L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsElementsInTheEndOutOfOrder() {
        val input = listOf(1, 2, 4, 3)
        val actual = inversionCount.count(input)
        val expected = 1L
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsRepeatedValues() {
        val input = listOf(1, 2, 2, 4)
        val actual = inversionCount.count(input)
        val expected = 0L
        assertEquals(expected, actual)
    }
}
