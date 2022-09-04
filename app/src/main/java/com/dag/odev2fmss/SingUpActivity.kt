package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dag.odev2fmss.databinding.ActivitySingUpBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SingUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backClicked()
        singUpClicked()
    }

    private fun backClicked() {
        binding.singUpBackButton.setOnClickListener {
            val intent = Intent(this@SingUpActivity,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun singUpClicked() {
        binding.apply {

            singUpButton.setOnClickListener {
                val email = enterEmailText.text.toString()
                val username = createUsernameText.text.toString()
                val password = createPasswordText.text.toString()
                singUpCheck(email, username, password)
                if (email.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                    userRegister(email, username, password)
                    showAlertDialog(email, username, password)
                    clear()
                    Toast.makeText(applicationContext,"Register Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext,"Register Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun singUpCheck(email: String, username: String, password: String) {
        binding.apply {
            if (email.isEmpty()) enterEmailLayout.error = " "
            else enterEmailLayout.error = null

            if (username.isEmpty()) createUsernameLayout.error = " "
            else createUsernameLayout.error = null

            if (password.isEmpty()) createPasswordLayout.error = " "
            else createPasswordLayout.error = null

        }
    }

    private fun userRegister(email: String, username: String, password: String) {
        val sharedPreferences = this.getSharedPreferences("UserInformation", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("email",email).apply()
        editor.putString("username",username).apply()
        editor.putString("password", password).apply()
    }

    private fun showAlertDialog(email: String, username: String, password: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("User Information")
            .setMessage("Email : $email\nUsername : $username\nPassword : $password")
            .show()
    }

    private fun clear() {
        binding.apply {
            enterEmailText.text?.clear()
            createUsernameText.text?.clear()
            createPasswordText.text?.clear()
        }
    }
}