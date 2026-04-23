<div align="center">

# 📱 Contacts App

**Aplicativo de Registro de Contatos desenvolvido com Jetpack Compose**

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)

</div>

---

## 📸 Telas

<div align="center">

| Tela Inicial | Lista de Contatos | Adicionar Contato |
|:---:|:---:|:---:|
| <img src="screenshots/tela_inicial.jpeg" width="200"/> | <img src="screenshots/tela_contatos.jpeg" width="200"/> | <img src="screenshots/tela_adicionar.jpeg" width="200"/> |

</div>

---

## 📋 Sobre

App Android simples para gerenciar contatos pessoais, desenvolvido com **Jetpack Compose** e arquitetura **MVVM**.

---

## ✨ Funcionalidades

- 📄 Listagem de contatos em cards com nome e telefone
- ➕ Adicionar contatos via formulário com validação
- 🗑️ Remover contatos diretamente da lista
- 🔤 Campo Nome restrito a letras — números e símbolos são bloqueados
- 📞 Campo Telefone com máscara automática `(DDD) 9 XXXX-XXXX`
- 🧭 Navegação entre telas com Navigation Compose

---

## 🗂️ Estrutura do Projeto

```
com.example.contacts/
├── data/               # Model (Contact.kt)
├── viewmodel/          # ContactViewModel (StateFlow)
├── navigation/         # NavGraph (rotas)
├── ui/screens/         # ContactListScreen, AddContactScreen
├── ui/components/      # ContactCard
└── MainActivity.kt
```

---

## 🛠️ Tecnologias

| Tecnologia | Uso |
|---|---|
| Kotlin | Linguagem principal |
| Jetpack Compose BOM 2024.02 | UI declarativa |
| Material 3 | Design System |
| Navigation Compose 2.7.7 | Navegação entre telas |
| ViewModel + StateFlow | Gerenciamento de estado |

---

## 🚀 Como Executar

```bash
git clone https://github.com/seu-usuario/contacts-app.git
```

1. Abra no **Android Studio Hedgehog** ou superior
2. Aguarde a sincronização do Gradle
3. Execute em emulador ou dispositivo físico (`minSdk 24`)

---

<div align="center">

Feito com ❤️ e Jetpack Compose

</div>
