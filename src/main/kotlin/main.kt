import attachment.VideoAttachments
import attachment.AudioAttachments
import attachment.PhotoAttachments
import attachment.GraffitiAttachments
import attachment.LinkAttachments

fun main() {
    val likes = Likes(234, true, true, true)
    val comments = Comment(1, canPost = true, groupsCanPost = true)

    var post1 = Post(
        1, 134, 56, 65, 1674149830, "bal-bla",
        111, 623, false,
        comments, "post", likes,
        reposts = Reposts(0, false), postSource = PostSource(Type.Vk, Platform.Android, "www"),
        null, 0,
        null, false, false, false, false, false, false
    )
    var post2 = Post(
        2, 14, 536, 657, 1674149530, "bal-bla-bla",
        6454, 6543, false,
        comments, "post", likes,
        reposts = Reposts(0, false), postSource = PostSource(Type.Widget, Platform.Iphone, "www"),
        null, 0,
        null, false, false, false, false, false, false
    )
}

