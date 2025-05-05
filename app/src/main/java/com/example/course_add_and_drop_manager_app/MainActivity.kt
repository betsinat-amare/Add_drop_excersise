package com.example.course_add_and_drop_manager_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.course_add_and_drop_manager_app.presentation.addCourse.AddCourse

import com.example.course_add_and_drop_manager_app.presentation.dashboard.SelectAcademicYear
import com.example.course_add_and_drop_manager_app.presentation.dashboard.UserDashboardScreen
import com.example.course_add_and_drop_manager_app.presentation.dropcourse.DropCourse
import com.example.course_add_and_drop_manager_app.presentation.home.HomeScreen
import com.example.course_add_and_drop_manager_app.presentation.signUp.SignUpScreen
import com.example.course_add_and_drop_manager_app.presentation.signUp.TermsAndConditionsScreen
import com.example.course_add_and_drop_manager_app.presentation.singIn.ForgetPasswordScreen
import com.example.course_add_and_drop_manager_app.presentation.singIn.LoginScreen
import com.example.course_add_and_drop_manager_app.ui.theme.Course_add_and_drop_manager_appTheme
import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.meta.When

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Crossfade(targetState= Course_add_and_drop_managerAppRoute.currentScreen) { currentState->
                when (currentState.value) {
                    is Screen.HomeScreen-> {
                        HomeScreen()
                    }
                    is Screen.SignUpScreen ->{
                        SignUpScreen()
                    }
                    is Screen.TermsAndConditionsScreen -> {
                        TermsAndConditionsScreen()
                    }
                    is Screen. LoginScreen ->{
                        LoginScreen()
                    }
                    is Screen.ForgetPasswordScreen ->{
                        ForgetPasswordScreen()
                    }
                    is Screen.UserDashboardScreen ->{
                        UserDashboardScreen()
                    }
                    is Screen.SelectAcademicYear ->{
                        SelectAcademicYear()
                    }
                    is Screen.AddCourse ->{
                        AddCourse()
                    }
                    is Screen.DropCourse ->{
                        DropCourse()
                    }
                    is Screen.EditProfile ->{
                        Screen.EditProfile()
                    }
                }

            }
        }
    }
}
