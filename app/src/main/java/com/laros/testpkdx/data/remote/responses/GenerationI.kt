package com.laros.testpkdx.data.remote.responses


import com.google.gson.annotations.SerializedName
import com.laros.testpkdx.data.remote.responses.RedBlue
import com.laros.testpkdx.data.remote.responses.Yellow

data class GenerationI(
    @SerializedName("red-blue")
    val redBlue: RedBlue,
    @SerializedName("yellow")
    val yellow: Yellow
)