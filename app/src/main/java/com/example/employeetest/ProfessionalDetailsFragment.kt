package com.example.employeetest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.employeetest.data.ProfessionalData
import com.example.employeetest.data.ProfileData
import com.example.employeetest.restClient.RestClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log


class ProfessionalDetailsFragment : Fragment() {
    lateinit var company : EditText
    lateinit var designation : EditText
    lateinit var dateOfJoining: EditText
    lateinit var address : EditText
    lateinit var submit : Button

    private val args by navArgs<ProfessionalDetailsFragmentArgs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_professional_details, container, false)

        company = view.findViewById(R.id.editTextCompany)
        designation = view.findViewById(R.id.editTextTextPersonName2)
        dateOfJoining = view.findViewById(R.id.editTextDOJ)
        address = view.findViewById(R.id.editTextTextPersonName3)
        submit = view.findViewById(R.id.submit_button)

        val getData = args.profileArguments

        val profileData = ProfileData(getData.name,getData.date,getData.address)

        val company = company.text.toString()
        val designation = designation.text.toString()
        val dataOfJoining = dateOfJoining.text.toString()
        val address = address.text.toString()

        submit.setOnClickListener {
            val quotesApi = RestClient.getInstance().create(userDetailsApi::class.java)
            GlobalScope.launch {
                var result = quotesApi.getUserDetailsApi()
                if (result!= null){
                    Log.d("Brahmam",result.body().toString())
                    //Toast.makeText(context, result.body(), Toast.LENGTH_SHORT).show()
                }
            }

            val professionalData = ProfessionalData(company,designation,dataOfJoining,address,profileData)

            val action = ProfessionalDetailsFragmentDirections.actionProfessionalDetailsFragmentToOverAllDetailsFragment(professionalData)
            findNavController().navigate(action)



        }
        return view
    }


}