package com.zasa.newsapp.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zasa.newsapp.R
import kotlinx.android.synthetic.main.activity_sign_in.*

private const val TAG = "SignInActivity"

class SignInActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        sharedPreferences = this.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        isRemembered = sharedPreferences.getBoolean("CHECK_BOX", false)

        if (isRemembered) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnSignIn.setOnClickListener {

            val username: String = etUsername.text.toString()
            val password: String = etPassword.text.toString()
            val checkBox: Boolean = cbCheckBox.isChecked

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("USERNAME", username)
            editor.putString("PASSWORD", password)
            editor.putBoolean("CHECKBOX", checkBox)
            editor.commit()
            editor.apply()
        }
        Toast.makeText(applicationContext, "information saved!", Toast.LENGTH_SHORT).show()
        val loginIntent = Intent(this, MainActivity::class.java)
        startActivity(loginIntent)
        finish()

    }
}
