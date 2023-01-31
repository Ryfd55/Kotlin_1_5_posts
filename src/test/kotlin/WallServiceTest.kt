import exception.PostNotFoundException
import exception.ReasonNotFoundException
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import kotlin.test.assertTrue

class WallServiceTest {
    private val post1 = Post(
        3,
        14,
        20,
        30,
        1674149855,
        "test text",
        10,
        20,
        false,
        Comments(15, canPost = true, groupsCanPost = true),
        "copy",
        Likes(120, userLikes = true, canLike = true, canPublish = true),
        reposts = Reposts(0, false), postSource = PostSource(Type.Widget, Platform.Iphone, "www"),
        null, 0,
        null, false, false, false, false, false, false
    )
    private val post2 = Post(
        11,
        141,
        201,
        301,
        1674149851,
        "test text 2",
        101,
        201,
        false,
        Comments(15, canPost = true, groupsCanPost = true),
        "copy",
        Likes(120, userLikes = true, canLike = true, canPublish = true),
        reposts = Reposts(0, false), postSource = PostSource(Type.Widget, Platform.Iphone, "www"),
        null, 0,
        null, false, false, false, false, false, false
    )
    private val comment1 = Comment(
        2, 3, 3, "eg", 45, 5,
        complaint = Complaint(1, 1, 1)
    )

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val result = WallService.add(
            post1
        )
        assertEquals(1, result.id)
    }

    @Test
    fun updateExistingId() {
        WallService.add(post1)
        WallService.add(post2)
        assertTrue(
            WallService.update(
                Post(
                    2,
                    14,
                    20,
                    30,
                    1674149855,
                    "test text",
                    10,
                    20,
                    false,
                    Comments(15, canPost = true, groupsCanPost = true),
                    "copy",
                    Likes(120, userLikes = true, canLike = true, canPublish = true),
                    reposts = Reposts(0, false), postSource = PostSource(Type.Widget, Platform.Iphone, "www"),
                    null, 0,
                    null, false, false, false, false, false, false
                )
            )
        )
    }

    @Test
    fun updateNotExistingId() {
        WallService.clear()
        WallService.add(post1)
        WallService.add(post2)
        assertFalse(
            WallService.update(
                Post(
                    7,
                    14,
                    20,
                    30,
                    1674149855,
                    "test text",
                    10,
                    20,
                    false,
                    Comments(15, canPost = true, groupsCanPost = true),
                    "copy",
                    Likes(120, userLikes = true, canLike = true, canPublish = true),
                    reposts = Reposts(0, false), postSource = PostSource(Type.Widget, Platform.Iphone, "www"),
                    null, 0,
                    null, false, false, false, false, false, false
                )
            )
        )
    }

    @Test
    fun createCommentTrue() {
        WallService.clear()
        WallService.add(post1)
        WallService.add(post2)
        val result = WallService.createComment(
            2, Comment(
                2, 3, 3, "eg", 45, 5,
                complaint = Complaint(1, 1, 1)
            )
        )
        println(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.clear()
        WallService.add(post1)
        WallService.add(post2)
        WallService.createComment(
            3, Comment(
                15, 3, 3, "eg", 45, 5,
                complaint = Complaint(1, 1, 1)
            )
        )
    }

    @Test // проверка на наличие поста с заданным id
    fun createComplaintTrue() {
        WallService.clear()
        WallService.add(post1)
        WallService.add(post2)
        WallService.createComment(2, comment1)
        WallService.createComplaint(
            2, Complaint(1, 1, 8)
        )
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowNoPostEx() {
        WallService.clear()
        WallService.add(post1)
        WallService.add(post2)
        WallService.createComment(2, comment1)
        WallService.createComplaint(
            5, Complaint(1, 1, 8)
        )
    }

    @Test(expected = ReasonNotFoundException::class)
    fun shouldThrowReasonEx() {
        WallService.clear()
        WallService.add(post1)
        WallService.add(post2)
        WallService.createComment(2, comment1)
        WallService.createComplaint(
            2, Complaint(1, 1, 18)
        )
    }
}