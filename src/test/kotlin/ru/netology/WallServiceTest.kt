package ru.netology

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WallServiceTest {

    @BeforeEach
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val post = Post(
            likes = Likes(
                count = 1,
                userLikes = true,
                canLike = true,
                canPublish = true
            ),
            id = 0,
            date = 2,
            fromId = 3,
            text = "text",
            postType = "new",
            signerId = 123,
            canPin = true
        )
        val result = WallService.add(post)
        assertEquals(1, result.id)
    }

    @Test
    fun update_1() {
        val post = Post(
            likes = Likes(
                count = 1,
                userLikes = true,
                canLike = true,
                canPublish = true
            ),
            id = 1,
            date = 2,
            fromId = 3,
            text = "text",
            postType = "new",
            signerId = 123,
            canPin = true
        )
        val post1 = Post(
            likes = Likes(
                count = 100,
                userLikes = true,
                canLike = true,
                canPublish = true
            ),
            id = 1,
            date = 20,
            fromId = 30,
            text = "text text",
            postType = "new",
            signerId = 123,
            canPin = true
        )
        WallService.add(post)
        val result = WallService.update(post1)
        assertEquals(true, result)
    }

    @Test
    fun update_2() {
        val post = Post(
            likes = Likes(
                count = 1,
                userLikes = true,
                canLike = true,
                canPublish = true
            ),
            id = 1,
            date = 2,
            fromId = 3,
            text = "text",
            postType = "new",
            signerId = 123,
            canPin = true
        )
        val post1 = Post(
            likes = Likes(
                count = 10,
                userLikes = true,
                canLike = true,
                canPublish = true
            ),
            id = 7,
            date = 20,
            fromId = 30,
            text = "text text",
            postType = "new",
            signerId = 123,
            canPin = true
        )
        WallService.add(post)
        val result = WallService.update(post1)
        assertEquals(false, result)
    }
}