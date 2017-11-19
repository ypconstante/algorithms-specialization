package com.github.ypconstante

class MergeSortWithCallback(private val callback: MergeCallback) {

    fun sort(array: IntArray): IntArray {
        if (array.size <= 1) {
            return array
        } else {
            val left = sort(array.sliceArray(IntRange(0, (array.size / 2) - 1)))
            val right = sort(array.sliceArray(IntRange(array.size / 2, array.size - 1)))
            return merge(left, right)
        }
    }

    private fun merge(firstArray: IntArray, secondArray: IntArray): IntArray {
        val merged = IntArray(firstArray.size + secondArray.size)
        var firstArrayIndex = 0
        var secondArrayIndex = 0
        for (i in merged.indices) {
            val firstArrayFinished = firstArray.size == firstArrayIndex
            val secondArrayFinished = secondArray.size == secondArrayIndex
            var insertedValueSource: InsertedValueSource
            if (!firstArrayFinished && (secondArrayFinished || firstArray[firstArrayIndex] <= secondArray[secondArrayIndex])) {
                merged[i] = firstArray[firstArrayIndex]
                firstArrayIndex++
                insertedValueSource = InsertedValueSource.FIRST_ARRAY
            } else {
                merged[i] = secondArray[secondArrayIndex]
                secondArrayIndex++
                insertedValueSource = InsertedValueSource.SECOND_ARRAY
            }

            callback.onMerge(
                insertedValueSource, i,
                firstArray, firstArrayIndex,
                secondArray, secondArrayIndex
            )
        }
        return merged
    }


    interface MergeCallback {
        fun onMerge(
            insertedValueSource: InsertedValueSource, insertedValueIndex: Int,
            firstArray: IntArray, firstArrayIndex: Int,
            secondArray: IntArray, secondArrayIndex: Int
        )
    }

    enum class InsertedValueSource {
        FIRST_ARRAY,
        SECOND_ARRAY,
    }

    class EmptyMergeCallback : MergeCallback {
        override fun onMerge(
            insertedValueSource: InsertedValueSource, insertedValueIndex: Int,
            firstArray: IntArray, firstArrayIndex: Int,
            secondArray: IntArray, secondArrayIndex: Int
        ) {
        }
    }
}
