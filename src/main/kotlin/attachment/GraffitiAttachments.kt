package attachment

class GraffitiAttachments(val graffiti: Graffiti) : Attachment() {
    override val type: String = "Graffiti"
}

data class Graffiti(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
)