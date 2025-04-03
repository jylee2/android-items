package com.androiditems.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.androiditems.security.ICryptoManager
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

@Composable
fun LoginScreen(cryptoManager: ICryptoManager) {
    var messageToEncrypt by remember {
        mutableStateOf("")
    }
    var messageToDecrypt by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val path = context.filesDir

    fun onClickEncrypt() {
        val bytes = messageToEncrypt.encodeToByteArray()
        val file = File(path, "secret.txt")
        if (!file.exists()) {
            file.createNewFile()
        }
        val fileOutputStream = FileOutputStream(file)

        messageToDecrypt = cryptoManager.encrypt(
            bytes = bytes,
            outputStream = fileOutputStream
        ).decodeToString()
    }

    fun onClickDecrypt() {
        val file = File(path, "secret.txt")
        messageToEncrypt = cryptoManager.decrypt(
            inputStream = FileInputStream(file)
        ).decodeToString()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        TextField(
            value = messageToEncrypt,
            onValueChange = { messageToEncrypt = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter password...") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Button(onClick = { onClickEncrypt() }) {
                Text("Encrypt")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onClickDecrypt() }) {
                Text("Decrypt")
            }
        }
        Text(text = messageToDecrypt)
    }
}