package com.github.ypconstante.assignment

import com.github.ypconstante.InversionCount
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.InputStreamReader

class Week2Assignment {
    @Test
    fun assignment() {
        val resource = Week2Assignment::class.java.getResourceAsStream("/Week2-input.txt")
        val reader = BufferedReader(InputStreamReader(resource))

        val values = ArrayList<Int>()
        reader.useLines { lines -> lines.forEach { values.add(Integer.parseInt(it)) } }

        val actual = InversionCount().count(values.toIntArray())
        val expected = 2407905288L

        assertEquals(expected, actual)
    }
}
