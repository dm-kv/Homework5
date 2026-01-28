package ru.netology

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WallServiceTest {
    @Test
    fun add() {
        val likes = 0
        val result = add(likes = likes, id = id, date = date, fromId = 0, text: String = "text", postType = "fast", )

        assertEquals(1, result)


    }

    @Test
    fun update_1() {
    }



    @Test
    fun update_2() {
    }

}