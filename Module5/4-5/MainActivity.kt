package com.example.otpverify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.otpverify.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    lateinit var verificationid:String
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()


        binding.btnotp.setOnClickListener {

            var num1 = binding.edtnum.text.toString()
            sendVerificationCode(num1)




        }
        binding.btnotp2.setOnClickListener {

            var num2 = binding.edtotp.text.toString()

            verifycode(num2)


        }
    }

    private fun verifycode(num2: String)
    {

            var credential = PhoneAuthProvider.getCredential(verificationid,num2)
            signinwithcredential(credential)


    }

    private fun signinwithcredential(credential: PhoneAuthCredential)
    {

            auth.signInWithCredential(credential).addOnCompleteListener {

                if(it.isSuccessful)
                {
                    var i = Intent(this,MainActivity2::class.java)
                    startActivity(i)




                }

            }
                .addOnFailureListener()
                {
                        Toast.makeText(applicationContext,"Code is Wrong",Toast.LENGTH_LONG).show()
                }


    }

    var mycallback:PhoneAuthProvider.OnVerificationStateChangedCallbacks = object:PhoneAuthProvider.OnVerificationStateChangedCallbacks()
    {
        override fun onVerificationCompleted(p0: PhoneAuthCredential)
        {
            var  code = p0.getSmsCode()
            if(code!=null)
            {
                binding.edtotp.setText(code)
            }
        }

        override fun onVerificationFailed(p0: FirebaseException)
        {
            Toast.makeText(applicationContext,"Error  ", Toast.LENGTH_LONG).show();
        }

        override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken)
        {
            //super.onCodeSent(p0, p1)
            verificationid =p0
        }

    }

    private fun sendVerificationCode(num1: String)
    {

            PhoneAuthProvider.getInstance().verifyPhoneNumber(num1,60,TimeUnit.SECONDS,this,mycallback)

    }
}