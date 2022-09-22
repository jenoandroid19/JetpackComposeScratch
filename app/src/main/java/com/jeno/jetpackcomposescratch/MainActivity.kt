package com.jeno.jetpackcomposescratch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeno.jetpackcomposescratch.ui.theme.JetpackComposeScratchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user1 = User("Jeno","Chennai")
        val user2 = User("Moien","Dubai")
        var userList = listOf(user1,user2)
        setContent {
            JetpackComposeScratchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowList(userList)
                }
            }
        }
    }
}

data class User(var name:String,var address:String)

@Composable
fun ShowList(userList : List<User>){
    LazyColumn{
        items(userList){user ->
            Greeting(user = user)
        }
    }
}

@Composable
fun Greeting(user: User) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(
                    width = 1.5.dp,
                    MaterialTheme.colors.primaryVariant, CircleShape
                )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = user.name,
                color = MaterialTheme.colors.secondaryVariant
            )
            Spacer(modifier = Modifier.height(2.dp))
            Surface(shape = MaterialTheme.shapes.large, elevation = 2.dp) {
                Text(
                    text = user.address,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
    

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeScratchTheme {
        Greeting(User("Jeno","Chennai"))
    }
}