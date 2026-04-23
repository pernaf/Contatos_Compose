package com.example.contacts.viewmodel

import androidx.lifecycle.ViewModel
import com.example.contacts.data.Contact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContactViewModel : ViewModel() {

    private val _contacts = MutableStateFlow<List<Contact>>(emptyList())
    val contacts: StateFlow<List<Contact>> = _contacts.asStateFlow()

    fun addContact(name: String, phone: String) {
        if (name.isBlank() || phone.isBlank()) return
        val newContact = Contact(name = name.trim(), phone = phone.trim())
        _contacts.value = _contacts.value + newContact
    }

    fun removeContact(contact: Contact) {
        _contacts.value = _contacts.value.filter { it.id != contact.id }
    }
}