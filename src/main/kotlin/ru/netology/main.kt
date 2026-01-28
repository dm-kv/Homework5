package ru.netology

data class Likes (
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Post(
    val likes: Int,
    var id: Int,
    val date: Int,
    val fromId: Int,
    val text: String,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    var prId: Int = 0
)

object WallService {
    private var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        post.id = post.prId
        posts += post
        post.prId += 1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, post1) in posts.withIndex()) {
            if (post1.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }
}

fun main() {
    val post = Post(0, 25, 50,66, "text", "fast", 45, true)
    val likes = Likes(0, true, true, true)
}


