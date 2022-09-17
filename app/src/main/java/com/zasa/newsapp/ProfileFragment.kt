package com.zasa.newsapp

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    lateinit var preferences : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        preferences = this.requireActivity().getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val username= preferences.getString("USERNAME", "")
        tvProfileName.text = username

//        btnProfileSignOut.setOnClickListener {
//            val editor : SharedPreferences.Editor? = preferences.edit()
//            editor?.commit()
//            editor?.apply()
//
//            val signInActivity = Intent(requireContext().applicationContext, SignInActivity::class.java)
//            startActivity(signInActivity)
//            activity?.finish()
//
//        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


}