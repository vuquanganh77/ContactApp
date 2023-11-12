package com.example.contactapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)


        val name = intent.getStringExtra("detail_name")

        findViewById<TextView>(R.id.detail_name).text = name
        findViewById<TextView>(R.id.detail_phone_number).text = intent.getStringExtra("detail_phone_number")
        findViewById<TextView>(R.id.detail_email).text = intent.getStringExtra("detail_mail")
    }

}