package com.github.ypconstante

class MergeSort {

    fun sort(array: List<Int>): List<Int> {
        val sorter = MergeSortWithCallback<Int>()
        return sorter.sort(array)
    }
}
