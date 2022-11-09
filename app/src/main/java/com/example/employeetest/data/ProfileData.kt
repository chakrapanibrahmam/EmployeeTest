package com.example.employeetest.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileData(
    var name : String,
    var date : String,
    var address : String
) : Parcelable
