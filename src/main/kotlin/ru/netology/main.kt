package ru.netology

data class Likes (
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Post(
    val likes: Likes,
    var id: Int,
    val date: Int?,
    val fromId: Int,
    val text: String?,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    )

object WallService {

    private var posts = emptyArray<Post>()
    private var prId: Int = 1

    fun clear() {
        posts = emptyArray()
        prId = 1
    }

    fun add(post: Post): Post {
        posts += post.copy(id = prId++)
        return posts.last()
    }

    fun update(post1: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post1.id == post.id) {
                posts[index] = post1.copy()
                return true
            }
        }
        return false
    }
}

