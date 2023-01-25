data class Geo(
val type: String,
val coordinates: String,
val place: Place
) {
    data class Place(
        val id: Int,
        val title: String,
        val latitude: Int,
        val longitude: Int,
        val created: Int,
        val icn: String,
        val country: String,
        val city: String
    )
}
