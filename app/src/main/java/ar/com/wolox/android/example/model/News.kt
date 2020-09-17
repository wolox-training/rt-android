package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("id") var id: Int,
    @SerializedName("userId") var userId: Int,
    @SerializedName("createdAt") var createdAt: String,
    @SerializedName("title") var title: String,
    @SerializedName("picture") var picture: String,
    @SerializedName("text") var text: String,
    @SerializedName("likes") var likes: List<Int>
)
