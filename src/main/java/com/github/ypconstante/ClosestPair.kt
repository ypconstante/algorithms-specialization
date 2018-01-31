package com.github.ypconstante

import java.util.*

class ClosestPair {

    fun closestPair(points: Collection<Point>): PointPair {
        return closestPair(
            points.sortedWith(Point.comparatorXY),
            points.sortedWith(Point.comparatorYX)
        )
    }

    private fun closestPair(pointsOrderedByX: Collection<Point>, pointsOrderedByY: Collection<Point>): PointPair {
        val size = pointsOrderedByX.size
        if (size <= 3) {
            return bruteForce(pointsOrderedByX)
        }

        val splitPointIndex = Math.ceil(size / 2.0).toInt()
        val (leftPointsOrderedByX, rightPointsOrderedByX) = pointsOrderedByX.chunked(splitPointIndex)
        val (leftPointsOrderedByY, rightPointsOrderedByY) = pointsOrderedByY.partition(leftPointsOrderedByX::contains)
        val lastLeftPointX = leftPointsOrderedByX.last()
        val firstRightPointX = rightPointsOrderedByX.first()

        val closestPairLeft = closestPair(leftPointsOrderedByX, leftPointsOrderedByY)
        val closestPairRight = closestPair(rightPointsOrderedByX, rightPointsOrderedByY)
        val closestPair = if (closestPairLeft.distance <= closestPairRight.distance) closestPairLeft else closestPairRight
        val closestSplitPair = closestSplitPair(pointsOrderedByY, lastLeftPointX, firstRightPointX, closestPair)
        return if (closestPair.distance < closestSplitPair.distance) closestPair else closestSplitPair
    }

    private fun closestSplitPair(
        pointsOrderedByY: Collection<Point>,
        lastLeftPointX: Point, firstRightPointX: Point,
        closestPair: PointPair)
        : PointPair {
        val xRangeBegin = firstRightPointX.x - closestPair.distance
        val xRangeEnd = lastLeftPointX.x + closestPair.distance
        if (xRangeBegin > xRangeEnd) {
            return closestPair
        }

        val xRange = xRangeBegin..xRangeEnd
        val pointsOnSplitRange = pointsOrderedByY.filter { p -> p.x in xRange }

        var closestSplitPair = closestPair
        for (i in IntRange(0, pointsOnSplitRange.size - 2)) {
            for (j in IntRange(i + 1, pointsOnSplitRange.size - 1)) {
                val p1 = pointsOnSplitRange[i]
                val p2 = pointsOnSplitRange[j]

                if (p2.y > p1.y + closestSplitPair.distance)
                    break

                if (Point.distance(p1, p2) < closestSplitPair.distance)
                    closestSplitPair = PointPair.createInstance(p1, p2)
            }
        }
        return closestSplitPair
    }

    fun bruteForce(points: Collection<Point>): PointPair {
        if (points.size <= 1) {
            throw RuntimeException("points size must be >= 2")
        }
        if (points.size == 2) {
            return PointPair.createInstance(points.first(), points.last())
        }
        val list = points.sortedWith(Point.comparatorXY)
        var smallestDistance = PointPair.createInstance(list[0], list[1])
        IntRange(0, list.size - 2).forEach { i ->
            IntRange(i + 1, list.size - 1).forEach { j ->
                val p1 = list[i]
                val p2 = list[j]
                val pointsDistance = Point.distance(p1, p2)
                if (pointsDistance < smallestDistance.distance) {
                    smallestDistance = PointPair.createInstance(p1, p2)
                }
            }
        }
        return smallestDistance
    }

    data class PointPair(val p1: Point, val p2: Point, val distance: Double) {
        private constructor(p1: Point, p2: Point) : this(p1, p2, Point.distance(p1, p2))

        companion object {
            fun createInstance(p1: Point, p2: Point): PointPair {

                return if (Point.comparatorXY.compare(p1, p2) < 0)
                    PointPair(p1, p2)
                else
                    PointPair(p2, p1)
            }

        }
    }

    data class Point(val x: Double, val y: Double) {
        companion object {

            val comparatorXY: Comparator<Point> = Comparator.comparing(Point::x).thenComparing(Point::y)!!
            val comparatorYX: Comparator<Point> = Comparator.comparing(Point::y).thenComparing(Point::x)!!

            fun distance(p1: Point, p2: Point): Double {
                return Math.sqrt(
                    Math.pow(p1.x - p2.x, 2.0) + Math.pow(p1.y - p2.y, 2.0)
                )
            }
        }
    }
}
