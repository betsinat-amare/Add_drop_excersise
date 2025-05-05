package com.example.course_add_and_drop_manager_app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen(){
    object HomeScreen:Screen()
    object SignUpScreen:Screen()
    object TermsAndConditionsScreen:Screen()
    object  LoginScreen:Screen()
    object ForgetPasswordScreen:Screen()
    object UserDashboardScreen:Screen()
    object SelectAcademicYear:Screen()
    object AddCourse:Screen()
    object DropCourse:Screen()
    object EditProfile:Screen()

}
object Course_add_and_drop_managerAppRoute {
    val currentScreen: MutableState<Screen> = mutableStateOf(Screen.HomeScreen)
    fun navigateTo(destination:Screen){
        currentScreen.value=destination
    }
}