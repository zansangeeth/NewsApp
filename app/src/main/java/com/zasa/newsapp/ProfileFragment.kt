package com.zasa.newsapp
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        sharedPreferences = activity?.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)!!

        val username = sharedPreferences.getString("USERNAME", "")
//        tvProfileName.text = username


//        btnProfileSignOut.setOnClickListener {
//            val editor : SharedPreferences.Editor? = sharedPreferences.edit()
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