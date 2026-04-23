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

| Tela Inicial | Novo Contato | Lista de Contatos adicionados/excluir contato |
|:---:|:---:|:---:|
| <img width="702" height="1600" alt="Tela inicial" src="https://github.com/user-attachments/assets/71aefa12-5b62-4aec-8ed3-eb5aa7e6e991" /> | <img width="702" height="1600" alt="Tela adicionar contato" src="https://github.com/user-attachments/assets/c3d40e83-b41b-4843-a723-8f83f467c52a" /> | <img width="702" height="1600" alt="Tela com contatos adicionados" src="https://github.com/user-attachments/assets/a3c3b940-9e17-4b4a-9aa2-21f27b3b896b" />> |

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

## License
```
The MIT License (MIT)

Copyright (c) 2024 Gabriel de Oliveira Carvalho

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

----

<div align="center">

Feito com Jetpack Compose

</div>
