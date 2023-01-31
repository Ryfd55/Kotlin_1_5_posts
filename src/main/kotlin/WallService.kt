object WallService {
    private var posts = emptyArray<Post>()
    private var nextIdPost: Int = 0
    private var comments = emptyArray<Comment>()
    private var complaints = emptyArray<Complaint>()

    fun clear() {
        posts = emptyArray()
        nextIdPost = 0
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++nextIdPost)
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
                    likes = targetPost.likes,
                    attachments = targetPost.attachments
                )
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, targetPost) in posts.withIndex()) {
            if (targetPost.id == postId) {
                comments += comment
                return comments.last()
            }
        }
        throw exception.PostNotFoundException("no post with id $postId")
    }

    fun createComplaint(postId: Int, complaint: Complaint): Complaint {
        for ((index, targetPost) in posts.withIndex()) {
            if (targetPost.id == postId) {
                if (complaint.reason in 0..8) {
                    complaints += complaint
                    return complaints.last()
                } else {
                    throw exception.ReasonNotFoundException("no reason with id ${complaint.reason}")
                }
            }
        }
        throw exception.PostNotFoundException("no post with id $postId")
    }
}