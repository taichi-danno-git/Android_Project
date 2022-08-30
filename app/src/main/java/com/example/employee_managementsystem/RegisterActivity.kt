package com.example.employee_managementsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)

        val main_button : Button = findViewById(R.id.main_button)

        main_button.setOnClickListener{
            finish()
        }
    }
}