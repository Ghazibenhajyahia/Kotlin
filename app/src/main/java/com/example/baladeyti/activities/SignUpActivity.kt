package com.example.baladeyti.activities

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.baladeyti.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener,
    View.OnKeyListener {

    lateinit var mSharedPref: SharedPreferences

    private lateinit var mBinding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        mSharedPref = getSharedPreferences("UserPref", Context.MODE_PRIVATE)

        mBinding = ActivitySignUpBinding.inflate(LayoutInflater.from(this))

        setContentView(mBinding.root)
        supportActionBar?.hide()


    }


    private fun validatePassword(): Boolean {
        var error: String? = null
        val value: String = mBinding.password.text.toString()
        if (value.isEmpty()) {
            error = "Password is required"
        } else if (value.length < 6) {
            error = "Password must be 6 characters long"
        }

        return error == null
    }

    private fun validateConfirmPassword(): Boolean {
        var error: String? = null
        val value: String = mBinding.confirmPassword.text.toString()
        if (value.isEmpty()) {
            error = "Confirm Password is required"
        } else if (value.length < 6) {
            error = "Confirm Password must be 6 characters long"
        }

        return error == null
    }

    private fun validateEmail(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.username.text.toString()
        if (value.isEmpty()) {
            errorMessage = "Email is required"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            errorMessage = "Username name must be a valid Email"
        }

        if (errorMessage != null) {
            mBinding.username.apply {

                error = errorMessage
            }
        }


        return errorMessage == null
    }

    private fun validatePasswordAndConfirmPassword(): Boolean {
        var error: String? = null
        val password = mBinding.password.text.toString()
        val confimPassword = mBinding.confirmPassword.text.toString()
        if (password != confimPassword) {
            error = "Confirm password doesn't match with password"
        }
        return error == null
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

//    override fun onFocusChange(view: View?, hasFocus: Boolean) {
//        if (view != null) {
//            when (view.id) {
//                R.id.username -> {
//                    if (hasFocus) {
//                        if (mBinding.username.isCounterEnabled)
//                    } else {
//                        validateEmail()
//                    }
//                }
//                R.id.password -> {
//                    if (hasFocus) {
//
//                    } else {
//                        validatePassword()
//                    }
//                }
//                R.id.confirmPassword -> {
//                    if (hasFocus) {
//
//                    } else {
//                        validateConfirmPassword()
//                    }
//                }
//            }
//        }
//    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onFocusChange(p0: View?, p1: Boolean) {
        TODO("Not yet implemented")
    }
}