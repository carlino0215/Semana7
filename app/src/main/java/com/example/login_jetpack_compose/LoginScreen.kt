package com.example.login_jetpack_compose

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login_jetpack_compose.main.MainScreen
import com.example.login_jetpack_compose.main.MonedaViewModel


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen() {



    val context = LocalContext.current

    var usuario by remember { mutableStateOf("") }
    var isValidUsuario by remember { mutableStateOf(false) }

    var contrasena by remember { mutableStateOf("") }
    var isValidPassword by remember { mutableStateOf(false) }

    var passwordVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFb5e48c))) {
        Column(
            Modifier
                .align(Alignment.Center)
                .padding(10.dp)
                .fillMaxWidth()) {
            Card(Modifier.padding(15.dp),
                shape = RoundedCornerShape(5.dp),
                elevation = 40.dp
            ) {
                Column(Modifier.padding(10.dp)) {
                    RowImage()
                    RowEmail(
                        email = usuario,
                        emailChange = {
                            usuario = it
                            isValidUsuario = Patterns.EMAIL_ADDRESS.matcher(usuario).matches()
                        },
                        isValidUsuario
                    )
                    RowPassword(
                        contrasena = contrasena,
                        passwordChange = {
                            contrasena = it
                            isValidPassword = contrasena.length >= 4
                        },
                        passwordVisible = passwordVisible,
                        passwordVisibleChange = { passwordVisible = !passwordVisible },
                        isValidPassword = isValidPassword
                    )
                    RowButtonLogin(
                        context = context,
                        isValidEmail = isValidUsuario,
                        isValidPassword = isValidPassword
                    )
                }
            }
        }
    }
}

@Composable
fun RowButtonLogin(
    context: Context,
    isValidEmail: Boolean,
    isValidPassword: Boolean
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
    horizontalArrangement = Arrangement.Center) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { login(context) },
            enabled = isValidEmail && isValidPassword
        ) {
            Text(text = "Inciar Sesión")
        }
    }
}


fun login(context: Context) {
    Toast.makeText(context, "Bievenido!!", Toast.LENGTH_LONG).show()
    ///////
}



@Composable
fun RowPassword(
    contrasena: String,
    passwordChange: (String)->Unit,
    passwordVisible: Boolean,
    passwordVisibleChange: ()->Unit,
    isValidPassword: Boolean
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center) {
        OutlinedTextField(
            value = contrasena,
            onValueChange = passwordChange,
            maxLines = 1,
            singleLine = true,
            label = { Text(text = "Contraseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if(passwordVisible) {
                    Icons.Filled.VisibilityOff
                } else {
                    Icons.Filled.Visibility
                }
                IconButton(
                    onClick = passwordVisibleChange
                ) {
                    Icon(
                        imageVector = image,
                        contentDescription = "Ver contraseña")
                }
            },
            visualTransformation = if(passwordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            colors = if(isValidPassword) {
                TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray
                )
            } else {
                TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray
                )
            }

        )
    }
}

@Composable
fun RowEmail(
    email: String,
    emailChange: (String)->Unit,
    isValid: Boolean
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = emailChange,
            label = { Text(text = "Email usuario") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            maxLines = 1,
            singleLine = true,
            colors = if(isValid) {
                TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray
                )
            } else {
                TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Color.LightGray,
                    focusedBorderColor = Color.LightGray
                )
            }
        )
    }
}

@Composable
fun RowImage() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
    horizontalArrangement = Arrangement.Center) {
        Image(
            modifier = Modifier.width(100.dp),
            painter = painterResource(id = R.drawable.bitco),
            contentDescription = "Imagen")
    }
}