package android.univ.fr.fizzupapp.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("data")
    val `data`: List<DataX>
)