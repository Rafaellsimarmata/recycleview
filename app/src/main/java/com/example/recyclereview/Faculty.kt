package com.example.recyclereview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Faculty(
    var name: String,
    var description: String,
    var photo: Int,
    var dean: String
):Parcelable