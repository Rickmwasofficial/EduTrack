package com.example.edutrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.edutrack.app.about.presentation.AboutScreen
import com.example.edutrack.app.contact.presentation.ContactScreen
import com.example.edutrack.app.home.presentation.HomeScreen
import com.example.edutrack.ui.theme.EduTrackTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

// Type Safe Navigation
@Serializable
object Home
@Serializable
object Contact
@Serializable
object About

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EduTrackTheme {
                val navHostController = rememberNavController()

                // helps control the drawer
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                // help identify current screen
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                // Navigation Drawer

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("EduTrack", modifier = Modifier)
                                IconButton(
                                    onClick = {
                                        scope.launch {
                                            drawerState.apply {
                                                if (isClosed) open() else close()
                                            }
                                        }
                                    },
                                    modifier = Modifier.size(32.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.menu_open),
                                        contentDescription = "Close Navigation Drawer",
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                            }
                            HorizontalDivider()
                            Spacer(Modifier.height(20.dp))
                            NavigationDrawerItem(
                                label = { Text("Home") },
                                selected = currentRoute?.contains("Home") == true,
                                onClick = {
                                    goToRoute(
                                        navHostController,
                                        scope,
                                        drawerState,
                                        Home
                                    )
                                },
                                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(1.dp))
                            )
                            NavigationDrawerItem(
                                label = { Text("About") },
                                selected = currentRoute?.contains("About") == true,
                                onClick = {
                                    goToRoute(
                                        navHostController,
                                        scope,
                                        drawerState,
                                        About
                                    )
                                },
                                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(1.dp))
                            )
                            NavigationDrawerItem(
                                label = { Text("Contact") },
                                selected = currentRoute?.contains("Contact") == true,
                                onClick = {
                                    goToRoute(
                                        navHostController,
                                        scope,
                                        drawerState,
                                        Contact
                                    )
                                },
                                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(1.dp))
                            )
                        }
                    }
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize()
                    ) { innerPadding ->
                        AppNavHost(
                            navHostController,
                            {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            },
                            Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

fun goToRoute(navHostController: NavHostController, scope: CoroutineScope, drawerState: DrawerState, route: Any) {
    navHostController.navigate(route)
    scope.launch {
        drawerState.apply {
            if (isClosed) open() else close()
        }
    }
}

// App Navigation
@Composable
fun AppNavHost(navHostController: NavHostController, openDrawer: () -> Unit, modifier: Modifier = Modifier) {
    NavHost(
        navController = navHostController,
        startDestination = Home,
        modifier = modifier
    ) {
        composable<Home> {
            HomeScreen(
                openDrawer = {
                    openDrawer()
                }
            )
        }
        composable<About> {
            AboutScreen(
                openDrawer = {
                    openDrawer()
                }
            )
        }
        composable<Contact> {
            ContactScreen(
                openDrawer = {
                    openDrawer()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    EduTrackTheme {

    }
}