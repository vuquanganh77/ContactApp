package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactapp.adapter.ContactAdapter
import com.example.contactapp.databinding.ActivityMainBinding
import com.example.contactapp.model.Contact

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var contactList = listOf<Contact>(
            Contact("Ja Morant", "555-555-5555", "Betty@gmail.com", 1),
            Contact("Justin Bieber", "123-456-7890", "grace@example.com", 2),
            Contact("Adam Levine", "987-654-3210", "ada@example.com", 3),
            Contact("ASAP Rocky", "111-222-3333", "alan@example.com", 4),
            Contact("Nicky James", "999-888-7777", "tim@example.com", 5),
            Contact("Lebron James", "444-333-2222", "margaret@example.com", 6),
            Contact("Steph Curry", "777-666-5555", "john@example.com", 7),
            Contact("Kanye West", "333-444-5555", "linus@example.com", 8),
            Contact("Donald Trump", "666-555-4444", "donald@example.com", 9),
            Contact("Cristiano Ronaldo", "222-333-4444", "grace.murray@example.com", 10)
        )

        binding.recyclerView.adapter = ContactAdapter(contactList)
        binding.recyclerView.setHasFixedSize(true)
    }
}