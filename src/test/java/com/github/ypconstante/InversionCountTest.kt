package com.github.ypconstante

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InversionCountTest {

    private val inversionCount = InversionCount()

    @Test
    fun countInversionsEmptyArray() {
        val input = intArrayOf()
        val actual = inversionCount.count(input)
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith1Element() {
        val input = intArrayOf(1)
        val actual = inversionCount.count(input)
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith2ElementsAlreadySorted() {
        val input = intArrayOf(1, 2)
        val actual = inversionCount.count(input)
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith2ElementsReversed() {
        val input = intArrayOf(2, 1)
        val actual = inversionCount.count(input)
        val expected = 1
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith2ElementsRepeatedValues() {
        val input = intArrayOf(1, 1)
        val actual = inversionCount.count(input)
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith3ElementsAlreadySorted() {
        val input = intArrayOf(1, 2, 3)
        val actual = inversionCount.count(input)
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith3ElementsReversed() {
        val input = intArrayOf(3, 2, 1)
        val actual = inversionCount.count(input)
        val expected = 3
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith3ElementsElementsInTheBeginOutOfOrder() {
        val input = intArrayOf(2, 1, 3)
        val actual = inversionCount.count(input)
        val expected = 1
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith3ElementsElementsInTheEndOutOfOrder() {
        val input = intArrayOf(1, 3, 2)
        val actual = inversionCount.count(input)
        val expected = 1
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith3ElementsRepeatedValues() {
        val input = intArrayOf(1, 1, 3)
        val actual = inversionCount.count(input)
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsAlreadySorted() {
        val input = intArrayOf(1, 2, 3, 4)
        val actual = inversionCount.count(input)
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsReversed() {
        val input = intArrayOf(4, 3, 2, 1)
        val actual = inversionCount.count(input)
        val expected = 6
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsElementsInTheBeginOutOfOrder() {
        val input = intArrayOf(2, 1, 3, 4)
        val actual = inversionCount.count(input)
        val expected = 1
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsElementsInTheMiddleOutOfOrder() {
        val input = intArrayOf(1, 3, 2, 4)
        val actual = inversionCount.count(input)
        val expected = 1
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsElementsInTheEndOutOfOrder() {
        val input = intArrayOf(1, 2, 4, 3)
        val actual = inversionCount.count(input)
        val expected = 1
        assertEquals(expected, actual)
    }

    @Test
    fun countInversionsArrayWith4ElementsRepeatedValues() {
        val input = intArrayOf(1, 2, 2, 4)
        val actual = inversionCount.count(input)
        val expected = 0
        assertEquals(expected, actual)
    }
}
