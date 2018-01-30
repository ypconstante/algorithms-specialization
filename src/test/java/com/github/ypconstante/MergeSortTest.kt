package com.github.ypconstante

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeSortTest {

    private val mergeSort = MergeSort()

    @Test
    fun sortEmptyArray() {
        val input = emptyList<Int>()
        val actual = mergeSort.sort(input)
        val expected = emptyList<Int>()
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith1Element() {
        val input = listOf(1)
        val actual = mergeSort.sort(input)
        val expected = listOf(1)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith2ElementsAlreadySorted() {
        val input = listOf(1, 2)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith2ElementsReversed() {
        val input = listOf(2, 1)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith2ElementsRepeatedValues() {
        val input = listOf(1, 1)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 1)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith3ElementsAlreadySorted() {
        val input = listOf(1, 2, 3)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2, 3)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith3ElementsReversed() {
        val input = listOf(3, 2, 1)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2, 3)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith3ElementsElementsInTheBeginOutOfOrder() {
        val input = listOf(2, 1, 3)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2, 3)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith3ElementsElementsInTheEndOutOfOrder() {
        val input = listOf(1, 3, 2)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2, 3)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith3ElementsRepeatedValues() {
        val input = listOf(1, 1, 3)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 1, 3)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsAlreadySorted() {
        val input = listOf(1, 2, 3, 4)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsReversed() {
        val input = listOf(4, 3, 2, 1)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsElementsInTheBeginOutOfOrder() {
        val input = listOf(2, 1, 3, 4)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsElementsInTheMiddleOutOfOrder() {
        val input = listOf(1, 3, 2, 4)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsElementsInTheEndOutOfOrder() {
        val input = listOf(1, 2, 4, 3)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsRepeatedValues() {
        val input = listOf(1, 2, 2, 4)
        val actual = mergeSort.sort(input)
        val expected = listOf(1, 2, 2, 4)
        assertEquals(expected, actual)
    }
}
