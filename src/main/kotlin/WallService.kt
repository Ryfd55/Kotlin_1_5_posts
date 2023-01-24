object WallService {
    private var posts = emptyArray<Post>()
    private var nextIdPost: Int = 0

    fun clear() {
        posts = emptyArray()
        nextIdPost = 0
    }

    fun add(post: Post): Post {

        posts += post.copy(id = ++nextIdPost)
//        nextIdPost++
//        posts += post.copy(id = nextIdPost)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, targetPost) in posts.withIndex()) {
            if (targetPost.id == post.id) {
                posts[index] = post.copy(
                    fromId = targetPost.fromId,
                    createdBy = targetPost.createdBy,
                    text = targetPost.text,
                    replyOwnerId = targetPost.replyOwnerId,
                    replyPostId = targetPost.replyPostId,
                    friendsOnly = targetPost.friendsOnly,
                    comments = targetPost.comments,
                    postType = targetPost.postType,
                    likes = targetPost.likes
                )
                return true
            }
        }
        return false
    }
}