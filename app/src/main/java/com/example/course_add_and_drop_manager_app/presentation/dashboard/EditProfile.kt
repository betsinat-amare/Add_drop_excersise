package com.example.course_add_and_drop_manager_app.presentation.dashboard


import ProfileEditPlaceholder
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.course_add_and_drop_manager_app.Course_add_and_drop_managerAppRoute
import com.example.course_add_and_drop_manager_app.R
import com.example.course_add_and_drop_manager_app.Screen
import com.example.course_add_and_drop_manager_app.presentation.components.ButtonComponent
import com.example.course_add_and_drop_manager_app.presentation.components.CheckboxComponent
import com.example.course_add_and_drop_manager_app.presentation.components.ClickableLoginTextComponent
import com.example.course_add_and_drop_manager_app.presentation.components.DropDownComponent
import com.example.course_add_and_drop_manager_app.presentation.components.Footer
import com.example.course_add_and_drop_manager_app.presentation.components.HeadingTextComponent
import com.example.course_add_and_drop_manager_app.presentation.components.NormalTextComponent
import com.example.course_add_and_drop_manager_app.presentation.components.PasswordTextFieldComponent
import com.example.course_add_and_drop_manager_app.presentation.components.SystemBackButtonHandler
import com.example.course_add_and_drop_manager_app.presentation.components.TextFieldComponent
import com.example.course_add_and_drop_manager_app.presentation.components.TextFieldPhotoComponent
import com.example.course_add_and_drop_manager_app.ui.theme.colorGrayBackground
import com.example.course_add_and_drop_manager_app.ui.theme.colorHeading

@Composable
fun EditProfile() {
    val onBack: () -> Unit = {
        Course_add_and_drop_managerAppRoute.navigateTo(Screen.UserDashboardScreen)
    }

    SystemBackButtonHandler {
        onBack()
    }


    Surface(
        color = colorGrayBackground,
        modifier = Modifier.fillMaxSize()
    ) {
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)  // ✅ Enable vertical scrolling
        ) {
            // -- Top AppBar Section --
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(top = 15.dp)) {
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
                        ProfileEditPlaceholder()
                    }
                }
            }

            // -- Form Content Section --
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
            ) {
                HeadingTextComponent(value = stringResource(id = R.string.edit))
                Spacer(modifier = Modifier.height(35.dp))

                TextFieldComponent(
                    labelValue = stringResource(id = R.string.placeName),
                    painterResource = painterResource(id = R.drawable.profile),
                    contentDescription = stringResource(id = R.string.profileImg)
                )
                TextFieldComponent(
                    labelValue = stringResource(id = R.string.Id),
                    painterResource = painterResource(id = R.drawable.id_image),
                    contentDescription = stringResource(id = R.string.IdImg)
                )
                PasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.password),
                    contentDescription = stringResource(id = R.string.passwordImg)
                )
                TextFieldPhotoComponent(
                    labelValue = stringResource(id = R.string.upload),
                    painterResource = painterResource(id = R.drawable.upload),
                    contentDescription = stringResource(id = R.string.uploadImg)
                )

                CheckboxComponent(
                    value = stringResource(id = R.string.terms_and_condition),
                    onTextSelected = {
                        Course_add_and_drop_managerAppRoute.navigateTo(Screen.TermsAndConditionsScreen)
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.save),
                    onClick = {}
                )
            }

            Spacer(modifier = Modifier.height(80.dp)) // Add spacing before footer
            // -- Footer Section --
            val currentScreen = Course_add_and_drop_managerAppRoute.currentScreen.value
            Footer(
                currentScreen = currentScreen,
                onItemSelected = { selectedScreen ->
                    Course_add_and_drop_managerAppRoute.navigateTo(selectedScreen)
                }
            )
        }




    }}
@Preview
@Composable
fun EditProfilePreview(){
    EditProfile()
}
