fun main() {
    val posts = emptyArray<Post>()
    val likes = Likes(234, true, true, true)
    val comments = Comments(1, canPost = true, groupsCanPost = true)

    val post = Post(
        1, 134, 56, 65, 1674149830, "bal-bla",
        111, 623, false, comments, "post", likes
    )
    val post1 = Post(
        13, 14, 536, 657, 1674149530, "bal-bla-bla",
        6454, 6543, false, comments, "post", likes
    )
}
