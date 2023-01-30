import exception.PostNotFoundException
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import kotlin.test.assertTrue

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val result = WallService.add(
            Post(
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
        )
        assertEquals(1, result.id)
    }

    @Test
    fun updateExistingId() {
        WallService.add(
            Post(
                3,
                140,
                200,
                300,
                167414980,
                "test text 1",
                100,
                200,
                false,
                Comments(15, canPost = true, groupsCanPost = true),
                "copy",
                Likes(120, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(0, false), postSource = PostSource(Type.Widget, Platform.Iphone, "www"),
                null, 0,
                null, false, false, false, false, false, false
            )
        )
        WallService.add(
            Post(
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
        )
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
        WallService.add(
            Post(
                33,
                140,
                200,
                300,
                167414980,
                "test text 1",
                100,
                200,
                false,
                Comments(15, canPost = true, groupsCanPost = true),
                "copy",
                Likes(120, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(0, false), postSource = PostSource(Type.Widget, Platform.Iphone, "www"),
                null, 0,
                null, false, false, false, false, false, false
            )
        )
        WallService.add(
            Post(
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
        )
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
        WallService.add(
            Post(
                33,
                140,
                200,
                300,
                167414980,
                "test text 1",
                100,
                200,
                false,
                Comments(15, canPost = true, groupsCanPost = true),
                "copy",
                Likes(120, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(0, false), postSource = PostSource(Type.Widget, Platform.Iphone, "www"),
                null, 0,
                null, false, false, false, false, false, false
            )
        )
        WallService.add(
            Post(
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
        )
        val result =  WallService.createComment(
            2, Comment(2, 3,3, "eg", 45,5)
        )
        println(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.clear()
        WallService.add(
            Post(
                33,
                140,
                200,
                300,
                167414980,
                "test text 1",
                100,
                200,
                false,
                Comments(15, canPost = true, groupsCanPost = true),
                "copy",
                Likes(120, userLikes = true, canLike = true, canPublish = true),
                reposts = Reposts(0, false), postSource = PostSource(Type.Widget, Platform.Iphone, "www"),
                null, 0,
                null, false, false, false, false, false, false
            )
        )
        WallService.add(
            Post(
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
        )
        WallService.createComment(
            3, Comment(15, 3,3, "eg", 45,5)
        )
    }
}