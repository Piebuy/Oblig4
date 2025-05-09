package com.example.oblig3.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable

//TODO Legge til blant annet imageUrl og imageThumbUrl for bilder i henhold til json databasen?
@Serializable
data class Photo(
    /** Unik ID til bildet **/
    val id: Long,
    val title: String = "",
    @DrawableRes
    val imageResId: Int,
    val artistId: Long,
    val category: Category,
    val price: Float = 0.0f
)
@Serializable
data class Artist(
    val id: Long,
    val name: String = "",
    val familyName: String = ""
)
@Serializable
data class SelectedPhoto(
    val photoId: Long,
    val frameType: FrameType,
    val frameWidth: Int,
    val photoSize: PhotoSize,
    val photoPrice: Float = 0.0f,
)
@Serializable
enum class Category {
    NATURE(),
    FOOD(),
    SPORT()
}
@Serializable
enum class FrameType(val extraPrice: Float, val color: Color = Color.Yellow) {
    WOOD(0f, color = Color.Yellow),
    METAL(100f, color = Color.Blue),
    PLASTIC(30f, color = Color.Green)
}
@Serializable
enum class PhotoSize(val extraPrice: Float, val size: Int = 170) {
    SMALL(0f, size=170),
    MEDIUM(130f, size=200),
    LARGE(230f, size=250)
}
@Serializable
enum class FrameSize(val extraPrice: Float, val size: Int = 170) {
    SMALL(0f, size=10),
    MEDIUM(130f, size=15),
    LARGE(230f, size=20)
}