package com.example.course_add_and_drop_manager_app.presentation.dashboard

import ProfileImagePlaceholder
import ProfileImgPlaceholder
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.course_add_and_drop_manager_app.Course_add_and_drop_managerAppRoute
import com.example.course_add_and_drop_manager_app.R
import com.example.course_add_and_drop_manager_app.Screen
import com.example.course_add_and_drop_manager_app.presentation.components.DropDownCenteredRowComponent
import com.example.course_add_and_drop_manager_app.presentation.components.DropDownComponent
import com.example.course_add_and_drop_manager_app.presentation.components.Footer
import com.example.course_add_and_drop_manager_app.presentation.components.NormalTextComponent
import com.example.course_add_and_drop_manager_app.presentation.components.SystemBackButtonHandler
import com.example.course_add_and_drop_manager_app.ui.theme.colorAccent
import com.example.course_add_and_drop_manager_app.ui.theme.colorGrayBackground
import com.example.course_add_and_drop_manager_app.ui.theme.colorHeading

@Composable
fun SelectAcademicYear(){
    val onBack: () -> Unit = {
        Course_add_and_drop_managerAppRoute.navigateTo(Screen.UserDashboardScreen)
    }

    SystemBackButtonHandler {
        onBack()
    }


    Surface(
        color = colorGrayBackground,
        modifier = Modifier.fillMaxSize()
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
//
            ) {

                Column(modifier=Modifier.padding(top=15.dp)) {
                    Row (modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        IconButton(onClick = { onBack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                        ProfileImgPlaceholder()
                    }
                    Spacer(modifier=Modifier.height(120.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text= stringResource(id=R.string.SelectAcademic),
                            style= TextStyle(
                                fontSize = 18.sp,
                                color = colorHeading,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                    Spacer(modifier=Modifier.height(20.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        var selected by remember { mutableStateOf("") }
                        val year = listOf("2022/2023", "2023/2024", "2024/2025","2025/2026")
                        DropDownComponent(
                            label = "Select Year",
                            options = year,
                            selectedValue = selected,
                            onValueSelected = { selected = it },
                            textFieldBgColor = Color(0xFFEADDDD),
                            // Deep Purple
                            focusedDropdownBg = Color(0xFFEDE7F6) // Light Purple when open
                        )


                    }
                    Spacer(modifier=Modifier.height(25.dp))
                    Box(modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center) {
                        var selected by remember { mutableStateOf("") }
                        val semester = listOf("One", "Two", "Three")
                        DropDownComponent(
                            label = "Select semester",
                            options = semester,
                            selectedValue = selected,
                            onValueSelected = { selected = it },
                            textFieldBgColor = Color(0xFFEADDDD),
                            // Deep Purple
                            focusedDropdownBg = Color(0xFFEDE7F6) // Light Purple when open
                        )

                    }
                    Spacer(modifier=Modifier.height(80.dp))
                    SelectAddOrDrop()


                }





            }

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

}}
@Composable
fun SelectAddOrDrop() {
    var selected by remember { mutableStateOf("") }
    val items = listOf("Add", "Drop")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            DropDownCenteredRowComponent(
                label = if (selected.isEmpty()) "Add/Drop" else selected,
                options = items,
                selectedValue = selected,
                onValueSelected = {
                    selected = it
                    when (it) {
                        "Add" -> Course_add_and_drop_managerAppRoute.navigateTo(Screen.AddCourse)
                        "Drop" -> Course_add_and_drop_managerAppRoute.navigateTo(Screen.DropCourse)
                    }
                }
            )
        }
    }
}


@Preview
@Composable
fun SelectAcademicYearPreview(){
    SelectAcademicYear()
}