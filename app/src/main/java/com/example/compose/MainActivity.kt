package com.example.compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ShowTextInput()
            ShowTextField()

        }
    }
}

//Text Composable
@Composable
fun ShowText(name: String) {
    Text(
        "hello $name",
        fontSize = 22.sp
    )
}

//Button Composable
@Composable
fun ShowButton() {
    Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) {
        Text("Button")
    }
}

//Image Composable
@Composable
fun ShowImage() {
    Image(
        painter = painterResource(R.drawable.ic_heart),
        contentDescription = "Dummy Image",
        colorFilter = ColorFilter.tint(Color.Blue),
        contentScale = ContentScale.Fit
    )
}

//TextField
@Composable
fun ShowTextInput() {
    TextField(
        value = "Good Morning",
        onValueChange = {
            Log.d("TAG", it)
        },
        label = {
            Text(text = "Enter Message")
        },
    )

}

//Textfield with latest value
@Composable
fun ShowTextField() {
    val state = remember { mutableStateOf("") }
    TextField(value = state.value,
        onValueChange = {
            state.value = it
            Log.d("TAG", "ShowTextField: $it")
        },
        label = {
            Text(text = "Enter Message")
        })
}

@Composable
fun PositioningColumn() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.End
    ) {
        Text(text = "A")
        Text(text = "B")
    }
}

@Composable
fun PositioningRow(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "X", fontSize = 22.sp)
        Text(text = "Y", fontSize = 22.sp)

    }
}

@Composable
fun ShowBox(){
    Box(
        contentAlignment = Alignment.BottomEnd
    ){
        Text(text = "A")
        Text(text = "B")

    }
}

@Composable
fun ListViewItem(){
    Row {
        Image(
            painter = painterResource(R.drawable.ic_person),
            contentDescription = "")
    Column (){
        Text(
            text = "",
            fontWeight = FontWeight.Bold
        )

    }
}}


@Preview(showBackground = true)
@Composable
private fun ShowPreview() {
//    ShowText("Boy")
//    ShowButton()
//    ShowImage()
//    ShowTextInput()
//    PositioningColumn()
//    PositioningRow()
    ShowBox()

}

