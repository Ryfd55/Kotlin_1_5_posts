package attachment

class LinkAttachments (val link: Link) : Attachment() {
    override val type: String = "Link"
}

data class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
    val photo: Photo
)