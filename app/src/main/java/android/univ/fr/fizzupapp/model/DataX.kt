package android.univ.fr.fizzupapp.model
import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("name")
    val name: String
)