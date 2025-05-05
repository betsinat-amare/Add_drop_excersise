package com.example.course_add_and_drop_manager_app.presentation.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.course_add_and_drop_manager_app.R
import com.example.course_add_and_drop_manager_app.ui.theme.colorAccent


import com.example.course_add_and_drop_manager_app.Course_add_and_drop_managerAppRoute
import com.example.course_add_and_drop_manager_app.Screen

@Composable
fun Footer(
    currentScreen: Screen,
    onItemSelected: (Screen) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        FooterItem(
            iconRes = R.drawable.home,
            label = "Home",
            isSelected = currentScreen == Screen.HomeScreen,
            onClick = { onItemSelected(Screen.HomeScreen) }
        )
        FooterItem(
            iconRes = R.drawable.add,
            label = "Add Course",
            isSelected = currentScreen == Screen.AddCourse,
            onClick = { onItemSelected(Screen.AddCourse) }
        )
        FooterItem(
            iconRes = R.drawable.remove,
            label = "Drop Course",
            isSelected = currentScreen == Screen.DropCourse,
            onClick = { onItemSelected(Screen.DropCourse) }
        )
        FooterItem(
            iconRes = R.drawable.dashboard,
            label = "Dashboard",
            isSelected = currentScreen == Screen.UserDashboardScreen,
            onClick = { onItemSelected(Screen.UserDashboardScreen) }
        )
    }
}

@Composable
fun FooterItem(
    iconRes: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(30.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = label,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) Color(0xFF655BEC) else Color(0xFF5D6677),
                textAlign = TextAlign.Center
            )
        )
    }
}



@Preview
@Composable
fun FooterPreview() {
    val currentScreen = Course_add_and_drop_managerAppRoute.currentScreen.value
    Footer(
        currentScreen = currentScreen,
        onItemSelected = { selectedScreen ->
            Course_add_and_drop_managerAppRoute.navigateTo(selectedScreen)})
}

