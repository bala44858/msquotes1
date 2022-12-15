package com.example.msquotes1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.msquotes1.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var db:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



//            Navigation to QUotes page
            binding.textView.setOnClickListener {
                Handler(Looper.getMainLooper()).postDelayed({
                    if(binding.userName.text.toString()!=""){
                        var move = Intent(this,trackingQuote::class.java)
                        move.putExtra("userName", binding.userName.text.toString())
                        startActivity(move)
//                        setContentView(R.layout.activity_tracking_quote)

                    }else{
                        Toast.makeText(applicationContext,"please enter the user-name",Toast.LENGTH_SHORT).show()
                    }

                }, 10)

            }




        db=FirebaseDatabase.getInstance().getReference("quotes")
        binding.sendbutton.setOnClickListener {
                if (binding.userName.text.toString() !=""){
                    if (binding.quotes.text.toString()!="") {
                        val simpleDate = SimpleDateFormat("dd-M-yyyy")
                        val username: String = binding.userName.text.toString().trim()

                        val currentDate = simpleDate.format(Date())
                        var t = binding.quotes.text.toString()
                        db.child(currentDate).child(username).child(t).setValue(t)
                            .addOnSuccessListener {

                                binding.quotes.text.clear()
                                Toast.makeText(
                                    applicationContext,
                                    "Added successfully ..",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }.addOnFailureListener {
                                Toast.makeText(applicationContext,"erro-try again ",Toast.LENGTH_SHORT).show()

                            }
                    }else{Toast.makeText(applicationContext,"please enter the quotes.",Toast.LENGTH_SHORT).show()}
                }else{
                    Toast.makeText(applicationContext,"please enter the user-name",Toast.LENGTH_SHORT).show()
                }
            }
//                    Toast.makeText(applicationContext, "done cclicking ", Toast.LENGTH_SHORT).show()
//                if(binding.userName.text.toString() !=""){
//                    checking here user name is there or not
//                    if ( t!="") {

//                        db.child(t).setValue(t).addOnSuccessListener {
//                            binding.quotes.text.clear()
//                            Toast.makeText(
//                                applicationContext,
//                                "successfully Added in Database..",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }.addOnFailureListener {
//                            Toast.makeText(
//                                applicationContext,
//                                "Error Data not stored ",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }

//                    }else{ Toast.makeText(applicationContext,"please enter the quotes",Toast.LENGTH_SHORT)}
//                    }else{
////                        user name is not available then give the tost
//                        Toast.makeText(applicationContext,"Enter a User name ",Toast.LENGTH_SHORT)
//                    }




        }

//        setContentView(R.layout.activity_main)
    }


