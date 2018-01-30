package com.github.ypconstante

class InversionCount {
    fun count(array: List<Int>): Long {
        val inversionCountMergeCallback = InversionCountMergeCallback()
        val sorter = MergeSortWithCallback<Int>(inversionCountMergeCallback)
        sorter.sort(array)
        return inversionCountMergeCallback.inversionCount
    }

    class InversionCountMergeCallback : MergeSortWithCallback.MergeCallback<Int> {
        var inversionCount = 0L

        override fun onMerge(
            insertedValueSource: MergeSortWithCallback.InsertedValueSource, insertedValueIndex: Int,
            firstArray: List<Int>, firstArrayIndex: Int,
            secondArray: List<Int>, secondArrayIndex: Int) {
            if (insertedValueSource == MergeSortWithCallback.InsertedValueSource.SECOND_ARRAY) {
                inversionCount += (firstArray.size - firstArrayIndex)
            }
        }
    }
}
