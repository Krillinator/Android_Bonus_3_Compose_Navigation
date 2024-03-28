package com.krillinator.bonus_3_compose_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animate
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.krillinator.bonus_3_compose_navigation.destinations.SignUpPageDestination
import com.krillinator.bonus_3_compose_navigation.ui.theme.Bonus_3_Compose_NavigationTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.spec.DestinationStyle

class MainActivity : ComponentActivity() {

    /* TODO - Compose Destinations
    *   --> PDF --> Compose Destinations
    *   --> Gradle setup --> Latest versions
    *   --> SKIP old version
    * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bonus_3_Compose_NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                     //DestinationsNavHost(navGraph = NavGraphs.root)

                            DestinationsNavHost(
                                navGraph = NavGraphs.root,
                            )




                }
            }
        }
    }
}

@RootNavGraph(start = true)
@Destination(style = ProfileTransitions::class)
@Composable
fun Home(navigator: DestinationsNavigator) {
    Column {
    Text(text = "HOME")
        Button(onClick = {
            navigator.navigate(
                SignUpPageDestination(
                    username = "Benny",
                    password = "123"
                )
            )
        }) {
            Text(text = "Navigate")
        }
    }
}

@Destination(style = ProfileTransitions::class)
@Composable
fun SignUpPage(username: String, password: String) {

    // Sending Data to --> LoginPage
    val user = User(username, password)

    Column {
        Text(text = "SignUpPage")
        Text(text = "$user")
        Button(onClick = { }) {
            Text(text = "Navigate -> loginPage ")
        }
    }
}

@Destination(style = ProfileTransitions::class)
@Composable
fun LoginPage() {

    Column {
        Text(text = "LoginPage")
        Text(text = "User data: ")
        Button(onClick = { }) {

        }
    }
    
}

@Destination(style = ProfileTransitions::class)
@Composable
fun ThemePage(navController: NavController) {
    Column {
        Text(text = "ThemePage")
        Button(onClick = { /*TODO*/ }) {

        }
    }
}

@Destination
@Composable
fun AboutPage(navController: NavController) {
    Column {
        Text(text = "AboutPage")
        Button(onClick = { /*TODO*/ }) {
        }
    }
}
