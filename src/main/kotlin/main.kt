fun main() {
    val likes = Likes(234, true, true, true)
    val comments = Comments(1, canPost = true, groupsCanPost = true)

    var post1 = Post(
        1, 134, 56, 65, 1674149830, "bal-bla",
        111, 623, false,
        comments,
        "post",
        likes
    )
    var post2 = Post(
        2, 14, 536, 657, 1674149530, "bal-bla-bla",
        6454, 6543, false,
        comments,
        "post",
        likes
    )
}

