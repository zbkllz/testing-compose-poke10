package com.laros.testpkdx.data.remote.responses


import com.google.gson.annotations.SerializedName
import com.laros.testpkdx.data.remote.responses.Version

data class GameIndice(
    @SerializedName("game_index")
    val gameIndex: Int,
    @SerializedName("version")
    val version: Version
)