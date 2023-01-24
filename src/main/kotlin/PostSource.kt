data class PostSource(
    val type: Type,
    val platform: Platform,
    val data : String,
    val url : String
)

enum class Type{
    Vk, Widget, Api, Rss, Sms
}

enum class Platform{
    Android,Iphone, Wphone
}