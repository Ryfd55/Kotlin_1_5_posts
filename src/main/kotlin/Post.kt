data class Post(
    val id: Int=0,
    val ownerId: Int=0,
    val fromId: Int=0,
    val createdBy: Int=0,
    val date: Int=654,
    val text: String ="data class post",
    val replyOwnerId: Int=0,
    val replyPostId: Int=0,
    val friendsOnly: Boolean = false,
    val comments: Comments,
    val post_type: String ="asgafs data class post",
    val likes: Likes
)