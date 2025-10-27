package com.example.scribo_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val textValue = remember { mutableStateOf("") }

            Scaffold { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .background(Color(0xFF73FF81))
                        )

                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .background(Color(0xFFCE73FF))
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.scribo_logo),
                        contentDescription = "Scribo logo",
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxWidth()
                    )

                    TextField(
                        value = textValue.value,
                        onValueChange = { textValue.value = it },
                        placeholder = {Text("Zadajte definíciu výrazu")},
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f),
                        shape = RoundedCornerShape(50.dp),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    }
}