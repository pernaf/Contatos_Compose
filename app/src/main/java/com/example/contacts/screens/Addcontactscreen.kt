package com.example.contacts.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.contacts.viewmodel.ContactViewModel

// Máscara: (XX) X XXXX-XXXX  →  11 dígitos
private fun formatPhone(digits: String): String {
    val d = digits.take(11)
    return buildString {
        d.forEachIndexed { i, c ->
            when (i) {
                0    -> append("($c")
                1    -> append("$c) ")
                2    -> append(c)
                3    -> append(" $c")
                7    -> append("-$c")
                else -> append(c)
            }
        }
    }
}

private object PhoneMaskTransformation : VisualTransformation {
    // Mapa: posição no texto original → posição no texto exibido
    // Original (digits): 0123456789A  (A = índice 10)
    // Exibido:  (XX) X XXXX-XXXX
    //            0123456789...
    private val originalToMasked = intArrayOf(
        1, 2, 5, 7, 8, 9, 10, 11, 13, 14, 15
    )

    override fun filter(text: AnnotatedString): TransformedText {
        val formatted = formatPhone(text.text)
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int =
                if (offset <= 0) 0
                else if (offset <= originalToMasked.size) originalToMasked[offset - 1] + 1
                else formatted.length

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 0) return 0
                // Conta quantos dígitos existem até a posição `offset` no texto formatado
                return formatted.take(offset).count { it.isDigit() }
            }
        }
        return TransformedText(AnnotatedString(formatted), offsetMapping)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreen(
    viewModel: ContactViewModel,
    onNavigateBack: () -> Unit
) {
    var name       by remember { mutableStateOf("") }
    var phoneRaw   by remember { mutableStateOf("") }   // só dígitos
    var nameError  by remember { mutableStateOf(false) }
    var phoneError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Novo Contato") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Preencha os dados do contato",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )

            // ── Campo Nome: aceita apenas letras e espaços ──────────────────
            OutlinedTextField(
                value = name,
                onValueChange = { input ->
                    // Filtra qualquer caractere que não seja letra ou espaço
                    val filtered = input.filter { it.isLetter() || it == ' ' }
                    name = filtered
                    nameError = false
                },
                label = { Text("Nome") },
                placeholder = { Text("Ex: João Silva") },
                isError = nameError,
                supportingText = if (nameError) {
                    { Text("Por favor, insira o nome") }
                } else null,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    capitalization = KeyboardCapitalization.Words
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            // ── Campo Telefone: máscara (DDD) 9 XXXX-XXXX ──────────────────
            OutlinedTextField(
                value = phoneRaw,
                onValueChange = { input ->
                    // Extrai só dígitos e limita a 11
                    val digits = input.filter { it.isDigit() }.take(11)
                    phoneRaw = digits
                    phoneError = false
                },
                label = { Text("Telefone") },
                placeholder = { Text("(79) 9 9999-9999") },
                isError = phoneError,
                supportingText = if (phoneError) {
                    { Text("Por favor, insira o telefone completo") }
                } else null,
                visualTransformation = PhoneMaskTransformation,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Salvar
            Button(
                onClick = {
                    nameError  = name.isBlank()
                    phoneError = phoneRaw.length < 11   // exige os 11 dígitos completos

                    if (!nameError && !phoneError) {
                        // Salva o número formatado no ViewModel
                        viewModel.addContact(name, formatPhone(phoneRaw))
                        onNavigateBack()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = "Salvar Contato",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            // Cancelar
            OutlinedButton(
                onClick = onNavigateBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = "Cancelar",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}