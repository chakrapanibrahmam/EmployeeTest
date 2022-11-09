package com.example.employeetest.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfessionalData(
    var company: String,
    var designation: String,
    var dateOfJoining: String,
    var address: String,
    var profile: ProfileData
) : Parcelable
