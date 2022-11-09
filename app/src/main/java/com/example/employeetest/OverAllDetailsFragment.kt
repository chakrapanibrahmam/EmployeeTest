package com.example.employeetest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs


class OverAllDetailsFragment : Fragment() {

    private lateinit var nameTV : TextView
    private lateinit var dateTV : TextView
    private lateinit var addressTV : TextView
    private lateinit var company : TextView
    private lateinit var designation : TextView

    private val args by navArgs<OverAllDetailsFragmentArgs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_over_all_details, container, false)
        nameTV = view.findViewById(R.id.nameText)
        dateTV = view.findViewById(R.id.dateText)
        addressTV = view.findViewById(R.id.address)
        company = view.findViewById(R.id.companyText)
        designation = view.findViewById(R.id.designationText)

        var getArgsData = args.professionalData

        addressTV.setText(getArgsData.address)
        company.setText(getArgsData.company)
        designation.setText(getArgsData.designation)
        nameTV.setText(getArgsData.profile.name)
        dateTV.setText(getArgsData.profile.date)

        return view
    }

}