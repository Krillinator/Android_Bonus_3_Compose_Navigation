package com.krillinator.bonus_3_compose_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.krillinator.bonus_3_compose_navigation.ui.theme.Bonus_3_Compose_NavigationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bonus_3_Compose_NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    // TODO - NavGraph + Multiple Destinations

    NavHost(navController = navController, startDestination = "signUpPage") {
        composable("themePage") { ThemePage(navController) }
        composable("signUpPage") { SignUpPage(navController) }
        composable("aboutPage") { AboutPage(navController) }
        composable(
            "loginPage/{username}/{password}",
            arguments = listOf(
                navArgument("username") {type = NavType.StringType},
                navArgument("password") {type = NavType.StringType}
            )) { navBackStackEntry ->
            val username = navBackStackEntry.arguments?.getString("username")
            val password = navBackStackEntry.arguments?.getString("password")
            LoginPage(navController = navController, username = username, password = password)
        }
    }
    
}

@Composable
fun SignUpPage(navController: NavController) {

    // Sending Data to --> LoginPage
    val user = User("Benny", "123")

    Column {
        Text(text = "SignUpPage")
        Button(onClick = { navController.navigate("loginPage/${user.name}/${user.password}") }) {
            Text(text = "Navigate -> loginPage ")
        }
    }
}

@Composable
fun LoginPage(navController: NavController, username: String?, password: String?) {

    Column {
        Text(text = "LoginPage")
        Text(text = "User data: $username, $password")
        Button(onClick = { navController.navigate("signInPage") }) {

        }
    }
    
}

@Composable
fun ThemePage(navController: NavController) {
    Column {
        Text(text = "ThemePage")
        Button(onClick = { /*TODO*/ }) {

        }
    }
}

@Composable
fun AboutPage(navController: NavController) {
    Column {
        Text(text = "AboutPage")
        Button(onClick = { /*TODO*/ }) {
        }
    }
}
