package com.github.ypconstante

class MergeSort {

    fun sort(array: IntArray): IntArray {
        val sorter = MergeSortWithCallback(MergeSortWithCallback.EmptyMergeCallback())
        return sorter.sort(array)
    }
}
