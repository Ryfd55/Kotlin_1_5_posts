data class PostSource(
    val type: Type = Type.Vk,
    val platform: Platform = Platform.Android,
    val data: String = "rdg",
    val url: String = ""
)

enum class Type {
    Vk, Widget, Api, Rss, Sms
}

enum class Platform {
    Android, Iphone, Wphone
}