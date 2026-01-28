package ru.netology

data class Likes (
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Post(
    val likes: Likes,
    val id: Int,
    val date: Int,
    val fromId: Int,
    val text: String,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean
)

object WallService {

    private var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }
}

fun main() {
    //val post = Post(0, 1, 25, 50, "text", "fast", 45, true)

}