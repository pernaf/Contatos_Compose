package com.example.contacts.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.contacts.screens.AddContactScreen
import com.example.contacts.screens.ContactListScreen
import com.example.contacts.viewmodel.ContactViewModel

sealed class Screen(val route: String) {
    object ContactList : Screen("contact_list")
    object AddContact  : Screen("add_contact")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: ContactViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ContactList.route
    ) {
        composable(Screen.ContactList.route) {
            ContactListScreen(
                viewModel = viewModel,
                onNavigateToAdd = { navController.navigate(Screen.AddContact.route) }
            )
        }
        composable(Screen.AddContact.route) {
            AddContactScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}