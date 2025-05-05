package com.example.course_add_and_drop_manager_app.presentation.dropcourse

import ProfileImgPlaceholder
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.course_add_and_drop_manager_app.Course_add_and_drop_managerAppRoute
import com.example.course_add_and_drop_manager_app.Screen
import com.example.course_add_and_drop_manager_app.presentation.components.DropCard
import com.example.course_add_and_drop_manager_app.presentation.components.DropCard
import com.example.course_add_and_drop_manager_app.presentation.components.Footer
import com.example.course_add_and_drop_manager_app.presentation.components.SearchBar
import com.example.course_add_and_drop_manager_app.presentation.components.SystemBackButtonHandler
import com.example.course_add_and_drop_manager_app.ui.theme.colorGrayBackground

@Composable
fun DropCourse(){
    val onBack: () -> Unit = {
        Course_add_and_drop_managerAppRoute.navigateTo(Screen.SelectAcademicYear)
    }

    SystemBackButtonHandler {
        onBack()
    }

    Surface(
        color = colorGrayBackground,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // <--- Make it scrollable
                .padding(horizontal = 16.dp) // optional: horizontal padding
        ) {
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { onBack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Text(
                    text = "Drop Course",
                    modifier = Modifier.padding(top = 17.dp),
                    style = TextStyle(fontSize = 18.sp)
                )
                ProfileImgPlaceholder()
            }

            Spacer(modifier = Modifier.height(20.dp))

            var query by remember { mutableStateOf("") }
            SearchBar(
                query = query,
                onQueryChange = { query = it }
            )

            Spacer(modifier = Modifier.height(40.dp))

            repeat(10) { // example: 10 cards
                DropCard(
                    onClick = {},
                    header = "Python Starter",
                    text1 = "Learn Python basics",
                    text2 = "Duration: 6 weeks"
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
            Column(modifier=Modifier.padding(bottom = 10.dp),
                verticalArrangement = Arrangement.Bottom) {
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
}

@Preview
@Composable
fun DropCoursePreview(){
    DropCourse()
}