package com.example.course_add_and_drop_manager_app.presentation.dashboard

import ProfileImagePlaceholder
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.course_add_and_drop_manager_app.Course_add_and_drop_managerAppRoute
import com.example.course_add_and_drop_manager_app.R
import com.example.course_add_and_drop_manager_app.Screen
import com.example.course_add_and_drop_manager_app.presentation.components.ButtonComponent
import com.example.course_add_and_drop_manager_app.presentation.components.Footer
import com.example.course_add_and_drop_manager_app.presentation.components.NormalTextComponent
import com.example.course_add_and_drop_manager_app.presentation.components.SwitchableTableView
import com.example.course_add_and_drop_manager_app.presentation.components.SystemBackButtonHandler
import com.example.course_add_and_drop_manager_app.ui.theme.colorAccent
import com.example.course_add_and_drop_manager_app.ui.theme.colorGrayBackground

@Composable
fun UserDashboardScreen() {
    val onBack: () -> Unit = {
        Course_add_and_drop_managerAppRoute.navigateTo(Screen.LoginScreen)
    }

    SystemBackButtonHandler {
        onBack()
    }


    Surface(
        color = colorGrayBackground,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(colorAccent)
            ) {
                Column(modifier = Modifier.padding(top = 15.dp)) {
                    // Back Icon
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
                ProfileImagePlaceholder(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            // CONTENT should take space but not push Footer out
            Column(
                modifier = Modifier
                    .weight(1f) // <-- Important: take remaining space
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                SwitchableTableView()
            }

            // Footer at Bottom
            val currentScreen = Course_add_and_drop_managerAppRoute.currentScreen.value
            Footer(
                currentScreen = currentScreen,
                onItemSelected = { selectedScreen ->
                    Course_add_and_drop_managerAppRoute.navigateTo(selectedScreen)
                }
            )
        }
    }


}

@Preview
@Composable
fun UserDashboardScreenPreview() {
    UserDashboardScreen()
}
