import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import kotlin.test.assertTrue

class WallServiceTest {

//    private var testPost = Post(
//        3,
//        14,
//        20,
//        30,
//        1674149855,
//        "test text",
//        10,
//        20,
//        false,
//        Comments(15, canPost = true, groupsCanPost = true),
//        "copy",
//        Likes(120, userLikes = true, canLike = true, canPublish = true)
//    )
//    private var testPost1 = Post(
//        3,
//        140,
//        200,
//        300,
//        167414980,
//        "test text 1",
//        100,
//        200,
//        false,
//        Comments(15, canPost = true, groupsCanPost = true),
//        "copy",
//        Likes(120, userLikes = true, canLike = true, canPublish = true)
//    )
//    private var testPost2 = Post(
//        11,
//        141,
//        201,
//        301,
//        1674149851,
//        "test text 2",
//        101,
//        201,
//        false,
//        Comments(15, canPost = true, groupsCanPost = true),
//        "copy",
//        Likes(120, userLikes = true, canLike = true, canPublish = true)
//    )
//    private var testPost3 = Post(
//        33,
//        140,
//        200,
//        300,
//        167414980,
//        "test text 1",
//        100,
//        200,
//        false,
//        Comments(15, canPost = true, groupsCanPost = true),
//        "copy",
//        Likes(120, userLikes = true, canLike = true, canPublish = true)
//    )

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
                Likes(120, userLikes = true, canLike = true, canPublish = true)
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
                Likes(120, userLikes = true, canLike = true, canPublish = true)
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
                Likes(120, userLikes = true, canLike = true, canPublish = true)
            )
        )
        assertTrue(
            WallService.update(
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
                    Likes(120, userLikes = true, canLike = true, canPublish = true)
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
                Likes(120, userLikes = true, canLike = true, canPublish = true)
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
                Likes(120, userLikes = true, canLike = true, canPublish = true)
            )
        )
        assertFalse(
            WallService.update(
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
                    Likes(120, userLikes = true, canLike = true, canPublish = true)
                )
            )
        )
    }
}