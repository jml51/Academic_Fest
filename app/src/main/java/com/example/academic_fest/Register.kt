package com.example.academic_fest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.academic_fest.dataBase.User
import com.example.academic_fest.databinding.RegisterBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    private lateinit var binding  : RegisterBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bt2.setOnClickListener {

            val firstName = binding.Editnome.text.toString()
            val email     = binding.Editemail.text.toString()
            val password  = binding.Editpassword.text.toString()

            database = FirebaseDatabase.getInstance().getReference("User")
            val user = User(firstName,email,password)
            database.child(firstName).setValue(user).addOnSuccessListener {

                binding.Editnome.text.clear()
                binding.Editemail.text.clear()
                binding.Editpassword.text.clear()


                Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{

                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


            }
        }
    }
}