package attachment

class AudioAttachments(val audio: Audio) : Attachment() {
    override val type: String = "Audio"
}

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int
)