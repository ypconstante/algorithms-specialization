package com.github.ypconstante

class MergeSortWithCallback<T : Comparable<T>>(
    private val callback: MergeCallback<T> = EmptyMergeCallback()
) {

    fun sort(array: List<T>): List<T> {
        if (array.size <= 1) {
            return array
        } else {
            val left = sort(array.subList(0, array.size / 2))
            val right = sort(array.subList(array.size / 2, array.size))
            return merge(left, right)
        }
    }

    private fun merge(firstArray: List<T>, secondArray: List<T>): List<T> {
        val mergedArraySize = firstArray.size + secondArray.size
        val merged = ArrayList<T>(mergedArraySize)
        var firstArrayIndex = 0
        var secondArrayIndex = 0
        for (i in 0..(mergedArraySize - 1)) {
            val firstArrayFinished = firstArray.size == firstArrayIndex
            val secondArrayFinished = secondArray.size == secondArrayIndex
            var insertedValueSource: InsertedValueSource
            if (!firstArrayFinished && (secondArrayFinished || firstArray[firstArrayIndex] <= secondArray[secondArrayIndex])) {
                merged.add(i, firstArray[firstArrayIndex])
                firstArrayIndex++
                insertedValueSource = InsertedValueSource.FIRST_ARRAY
            } else {
                merged.add(i, secondArray[secondArrayIndex])
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


    interface MergeCallback<in T> {
        fun onMerge(
            insertedValueSource: InsertedValueSource, insertedValueIndex: Int,
            firstArray: List<T>, firstArrayIndex: Int,
            secondArray: List<T>, secondArrayIndex: Int
        )
    }

    enum class InsertedValueSource {
        FIRST_ARRAY,
        SECOND_ARRAY,
    }

    class EmptyMergeCallback<T> : MergeCallback<T> {
        override fun onMerge(
            insertedValueSource: InsertedValueSource, insertedValueIndex: Int,
            firstArray: List<T>, firstArrayIndex: Int,
            secondArray: List<T>, secondArrayIndex: Int
        ) {
        }
    }
}
