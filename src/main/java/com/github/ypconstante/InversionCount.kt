package com.github.ypconstante

class InversionCount {
    fun count(array: IntArray): Long {
        val inversionCountMergeCallback = InversionCountMergeCallback()
        val sorter = MergeSortWithCallback(inversionCountMergeCallback)
        sorter.sort(array)
        return inversionCountMergeCallback.inversionCount
    }

    class InversionCountMergeCallback : MergeSortWithCallback.MergeCallback {
        var inversionCount = 0L

        override fun onMerge(
            insertedValueSource: MergeSortWithCallback.InsertedValueSource, insertedValueIndex: Int,
            firstArray: IntArray, firstArrayIndex: Int,
            secondArray: IntArray, secondArrayIndex: Int) {
            if (insertedValueSource == MergeSortWithCallback.InsertedValueSource.SECOND_ARRAY) {
                inversionCount += (firstArray.size - firstArrayIndex)
            }
        }
    }
}
