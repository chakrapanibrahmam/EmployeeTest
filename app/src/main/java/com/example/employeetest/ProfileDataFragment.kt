package com.example.employeetest

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.employeetest.data.ProfileData
import java.net.Inet4Address


class ProfileDataFragment : Fragment() {

    lateinit var etName : EditText
    lateinit var etData : EditText
    lateinit var etAddress: EditText
    lateinit var nextBT : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile_data, container, false)

        etName = view.findViewById(R.id.editTextName)
        etData = view.findViewById(R.id.editTextDate)
        etAddress = view.findViewById(R.id.editTextAddress)
        nextBT = view.findViewById(R.id.next_button)

        val name = etName.text.toString()
        val date = etData.text.toString()
        val address = etAddress.text.toString()

        nextBT.setOnClickListener {
            val profileData = ProfileData(name,date,address)
            val action = ProfileDataFragmentDirections.actionProfileDataFragment2ToProfessionalDetailsFragment(profileData)
            findNavController().navigate(action)
        }
        return view
    }

}