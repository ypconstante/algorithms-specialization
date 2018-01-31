package com.github.ypconstante

import com.github.ypconstante.ClosestPair.Point
import com.github.ypconstante.ClosestPair.PointPair
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClosestPairTest {
    @Test
    fun twoPoints() {
        val p1 = Point(10.0, 20.0)
        val p2 = Point(20.0, 10.0)
        val expected = PointPair.createInstance(p1, p2)
        runTest(listOf(p1, p2), expected)
        runTest(listOf(p2, p1), expected)
    }

    @Test
    fun threePoints() {
        val p1 = Point(2.0, 2.0)
        val p2 = Point(10.0, 10.0)
        val p3 = Point(11.0, 11.0)
        runTest(
            listOf(p1, p2, p3),
            PointPair.createInstance(p2, p3)
        )
    }

    @Test
    fun fourPointsSameDistance() {
        val p1 = Point(10.0, 10.0)
        val p2 = Point(20.0, 20.0)
        val p3 = Point(30.0, 30.0)
        val p4 = Point(40.0, 40.0)
        runTest(
            listOf(p1, p2, p3, p4),
            PointPair.createInstance(p1, p2)
        )
    }

    @Test
    fun fourPointsSameX() {
        val p1 = Point(10.0, 10.0)
        val p2 = Point(10.0, 20.0)
        val p3 = Point(10.0, 32.0)
        val p4 = Point(10.0, 40.0)
        runTest(
            listOf(p1, p2, p3, p4),
            PointPair.createInstance(p3, p4)
        )
    }

    @Test
    fun fourPointsSameY() {
        val p1 = Point(10.0, 20.0)
        val p2 = Point(22.0, 20.0)
        val p3 = Point(30.0, 20.0)
        val p4 = Point(40.0, 20.0)
        runTest(
            listOf(p1, p2, p3, p4),
            PointPair.createInstance(p2, p3)
        )
    }

    @Test
    fun fourPointsClosestPointsLeft() {
        val p1 = Point(12.0, 20.0)
        val p2 = Point(20.0, 20.0)
        val p3 = Point(30.0, 20.0)
        val p4 = Point(40.0, 20.0)
        runTest(
            listOf(p1, p2, p3, p4),
            PointPair.createInstance(p1, p2)
        )
    }

    @Test
    fun fourPointsClosestPointsRight() {
        val p1 = Point(10.0, 20.0)
        val p2 = Point(20.0, 20.0)
        val p3 = Point(32.0, 20.0)
        val p4 = Point(40.0, 20.0)
        runTest(
            listOf(p1, p2, p3, p4),
            PointPair.createInstance(p3, p4)
        )
    }

    @Test
    fun fourPointsClosestPointsMiddle() {
        val p1 = Point(10.0, 20.0)
        val p2 = Point(22.0, 20.0)
        val p3 = Point(30.0, 20.0)
        val p4 = Point(40.0, 20.0)
        runTest(
            listOf(p1, p2, p3, p4),
            PointPair.createInstance(p2, p3)
        )
    }

    @Test
    fun sixPointsClosestPointsMiddleAllPointsInSplitRange() {
        val p1 = Point(1.0, 10.0)
        val p2 = Point(1.1, 110.0)
        val p3 = Point(1.2, 220.0)
        val p4 = Point(2.0, 50.0)
        val p5 = Point(2.2, 150.0)
        val p6 = Point(2.4, 300.0)
        runTest(
            listOf(p1, p2, p3, p4, p5, p6),
            PointPair.createInstance(p1, p4)
        )
    }

    @Test
    fun noPointsInSplitRange() {
        val p1 = Point(1.0, 10.0)
        val p2 = Point(1.0, 11.0)
        val p3 = Point(100.0, 100.0)
        val p4 = Point(200.0, 100.0)
        runTest(
            listOf(p1, p2, p3, p4),
            PointPair.createInstance(p1, p2)
        )
    }

    fun runTest(points: Collection<Point>, expected: PointPair) {
        val divideAndConquer = ClosestPair().closestPair(points.shuffled())
        val bruteForce = ClosestPair().bruteForce(points.shuffled())
        assertEquals(expected, divideAndConquer)
        assertEquals(bruteForce, divideAndConquer)

    }

    fun randomData(): Collection<Collection<Point>> {
        return IntRange(1, 100).map { _ -> randomDataItem() }
    }

    fun randomDataItem(): Collection<Point> {
        val size = Math.ceil((Math.random() * 100) + 1).toInt()
        return IntRange(1, size).map { _ ->
            Point(
                (Math.random() * 100) - 50,
                (Math.random() * 100) - 50
            )
        }
    }

    @ParameterizedTest
    @MethodSource("randomData")
    fun randomData(points: Collection<Point>) {
        val divideAndConquer = ClosestPair().closestPair(points)
        val bruteForce = ClosestPair().bruteForce(points)
        assertEquals(bruteForce, divideAndConquer)
    }
}
