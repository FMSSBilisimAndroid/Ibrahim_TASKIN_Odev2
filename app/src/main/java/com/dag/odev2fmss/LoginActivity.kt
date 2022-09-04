package com.dag.odev2fmss

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dag.odev2fmss.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("UserInformation", MODE_PRIVATE)
        loginNewAccountClicked()
        loginBackClicked()
        loginClicked()
    }

    private fun loginNewAccountClicked() {
        binding.loginNewAccount.setOnClickListener {
            val intent = Intent(this@LoginActivity,SingUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginBackClicked() {
        binding.loginBackButton.setOnClickListener {
            val intent = Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginClicked() {
        binding.apply {

            loginButton.setOnClickListener {
                val username = loginUsernameText.text.toString()
                val password = loginPasswordText.text.toString()
                loginCheck(username, password)
                loginInformationCheck(username, password)
            }
        }
    }

    private fun loginCheck(username: String, password: String) {
        binding.apply {
            if (username.isEmpty()) loginUsernameLayout.error = " "
            else loginUsernameLayout.error = null

            if (password.isEmpty()) loginPasswordLayout.error = " "
            else loginPasswordLayout.error = null
        }
    }

    private fun loginInformationCheck(username: String, password: String) {
        val registeredUsername = preferences.getString("username","")
        val registeredPassword = preferences.getString("password","")
        if (username == registeredUsername && password == registeredPassword) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}