package com.example.contacts.data

data class Contact(
    val id: Long = System.currentTimeMillis(),
    val name: String,
    val phone: String
)