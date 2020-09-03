package ar.com.wolox.android.example.model

data class News(
    val id: Int,
    val userId: Int,
    val createdAt: String,
    val title: String,
    val picture: String,
    val text: String,
    val likes: IntArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as News

        if (id != other.id) return false
        if (userId != other.userId) return false
        if (createdAt != other.createdAt) return false
        if (title != other.title) return false
        if (picture != other.picture) return false
        if (text != other.text) return false
        if (!likes.contentEquals(other.likes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + userId
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + picture.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + likes.contentHashCode()
        return result
    }
}
