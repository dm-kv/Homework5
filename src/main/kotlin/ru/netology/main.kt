package ru.netology

abstract class Attachment() {
}

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
    val attachments: Array<Attachment> = emptyArray()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false
        if (date != other.date) return false
        if (fromId != other.fromId) return false
        if (signerId != other.signerId) return false
        if (canPin != other.canPin) return false
        if (likes != other.likes) return false
        if (text != other.text) return false
        if (postType != other.postType) return false
        if (!attachments.contentEquals(other.attachments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (date ?: 0)
        result = 31 * result + fromId
        result = 31 * result + signerId
        result = 31 * result + canPin.hashCode()
        result = 31 * result + likes.hashCode()
        result = 31 * result + (text?.hashCode() ?: 0)
        result = 31 * result + postType.hashCode()
        result = 31 * result + attachments.contentHashCode()
        return result
    }
}

class Photo(
    val id: Int,
    val albumId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
)
class PhotoAttachment(val photo: Photo) : Attachment()

class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
)
class AudioAttachment(val audio: Audio) : Attachment()

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
)
class VideoAttachment(val video: Video) : Attachment()


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