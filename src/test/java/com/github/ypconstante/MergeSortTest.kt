package com.github.ypconstante

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MergeSortTest {

    private val mergeSort = MergeSort()

    @Test
    fun sortEmptyArray() {
        val input = intArrayOf()
        val actual = mergeSort.sort(input)
        val expected = intArrayOf()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith1Element() {
        val input = intArrayOf(1)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith2ElementsAlreadySorted() {
        val input = intArrayOf(1, 2)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith2ElementsReversed() {
        val input = intArrayOf(2, 1)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith2ElementsRepeatedValues() {
        val input = intArrayOf(1, 1)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 1)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith3ElementsAlreadySorted() {
        val input = intArrayOf(1, 2, 3)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2, 3)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith3ElementsReversed() {
        val input = intArrayOf(3, 2, 1)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2, 3)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith3ElementsElementsInTheBeginOutOfOrder() {
        val input = intArrayOf(2, 1, 3)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2, 3)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith3ElementsElementsInTheEndOutOfOrder() {
        val input = intArrayOf(1, 3, 2)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2, 3)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith3ElementsRepeatedValues() {
        val input = intArrayOf(1, 1, 3)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 1, 3)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsAlreadySorted() {
        val input = intArrayOf(1, 2, 3, 4)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2, 3, 4)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsReversed() {
        val input = intArrayOf(4, 3, 2, 1)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2, 3, 4)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsElementsInTheBeginOutOfOrder() {
        val input = intArrayOf(2, 1, 3, 4)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2, 3, 4)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsElementsInTheMiddleOutOfOrder() {
        val input = intArrayOf(1, 3, 2, 4)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2, 3, 4)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsElementsInTheEndOutOfOrder() {
        val input = intArrayOf(1, 2, 4, 3)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2, 3, 4)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun sortArrayWith4ElementsRepeatedValues() {
        val input = intArrayOf(1, 2, 2, 4)
        val actual = mergeSort.sort(input)
        val expected = intArrayOf(1, 2, 2, 4)
        assertArrayEquals(expected, actual)
    }
}
