package com.example.course_add_and_drop_manager_app.presentation.signUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.course_add_and_drop_manager_app.Course_add_and_drop_managerAppRoute
import com.example.course_add_and_drop_manager_app.R
import com.example.course_add_and_drop_manager_app.Screen
import com.example.course_add_and_drop_manager_app.presentation.components.HeadingTextComponent
import com.example.course_add_and_drop_manager_app.presentation.components.SystemBackButtonHandler
import com.example.course_add_and_drop_manager_app.ui.theme.colorGrayBackground
import java.time.format.TextStyle

@Composable
fun TermsAndConditionsScreen() {
    val onBack: () -> Unit = {
        Course_add_and_drop_managerAppRoute.navigateTo(Screen.SignUpScreen)
    }

    SystemBackButtonHandler {
        onBack()
    }

    Surface(
        color = colorGrayBackground,
        modifier = Modifier
            .fillMaxSize()
            .background(colorGrayBackground)
            .padding(20.dp)
    ) {
        Column {
            // Back Icon
            IconButton(onClick = { onBack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
            HeadingTextComponent(value = stringResource(id = R.string.terms_and_condition_header))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top=20.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                val termsList = listOf(
                    "1. Acceptance of Terms:\nBy using this app, you agree to these terms. If not, please do not use the app.",
                    "2. Eligibility:\nYou must be a registered student or authorized admin.",
                    "3. User Roles and Responsibilities:\nStudents can enroll/drop courses. Admins can manage course listings.",
                    "4. Authentication and Security:\nUse your credentials responsibly. Report unauthorized access immediately.",
                    "5. Authorization and Access:\nFeatures are role-based. Misuse may result in suspension.",
                    "6. Data Accuracy:\nEnsure all provided information is correct.",
                    "7. Course Enrollment Policies:\nFollow institutional policies for adding/dropping courses.",
                    "8. Changes to Courses:\nAdmins may change course details. Check regularly.",
                    "9. Account Suspension and Termination:\nMisuse may lead to account action.",
                    "10. Privacy and Data Use:\nYour data is used only for managing course enrollments securely.",
                    "11. Limitation of Liability:\nThe app is provided 'as is' without warranties.",
                    "12. Modifications to Terms:\nWe may update terms. Continued use means you accept the updates.",
                    "13. Support and Contact:\nReach your institution's IT support for help."
                )

                termsList.forEach { paragraph ->
                    Text(
                        text = paragraph,
                        style = androidx.compose.ui.text.TextStyle(fontSize = 16.sp),
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun TermsAndConditionsScreenPreview() {
    TermsAndConditionsScreen()
}
