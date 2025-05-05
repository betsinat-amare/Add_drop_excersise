package com.example.course_add_and_drop_manager_app.presentation.signUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.course_add_and_drop_manager_app.Course_add_and_drop_managerAppRoute
import com.example.course_add_and_drop_manager_app.R
import com.example.course_add_and_drop_manager_app.Screen
import com.example.course_add_and_drop_manager_app.presentation.components.ButtonComponent
import com.example.course_add_and_drop_manager_app.presentation.components.CheckboxComponent
import com.example.course_add_and_drop_manager_app.presentation.components.ClickableLoginTextComponent
import com.example.course_add_and_drop_manager_app.presentation.components.HeadingTextComponent
import com.example.course_add_and_drop_manager_app.presentation.components.NormalTextComponent
import com.example.course_add_and_drop_manager_app.presentation.components.PasswordTextFieldComponent
import com.example.course_add_and_drop_manager_app.presentation.components.TextFieldComponent
import com.example.course_add_and_drop_manager_app.presentation.components.TextFieldPhotoComponent
import com.example.course_add_and_drop_manager_app.ui.theme.colorGrayBackground

@Composable
fun SignUpScreen(){
    Surface(
        color= colorGrayBackground,
        modifier=Modifier.fillMaxSize()
            .background(Color(0xFFE0E7FF))
            .padding(top=140.dp)
           ,

    ){
        Column (modifier=Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())){
            HeadingTextComponent(value= stringResource(id= R.string.Start))
            Spacer(modifier=Modifier.height(10.dp))
            NormalTextComponent(value= stringResource(id=R.string.Hello))
            Spacer(modifier=Modifier.height(35.dp))
            TextFieldComponent(labelValue = stringResource(id=R.string.placeName),
                painterResource =(painterResource(id=R.drawable.profile)),
                contentDescription= stringResource(id=R.string.profileImg)

            )
            TextFieldComponent(labelValue = stringResource(id=R.string.email),
                painterResource =(painterResource(id=R.drawable.email)),
                contentDescription= stringResource(id=R.string.IdImg)

            )

            TextFieldComponent(labelValue = stringResource(id=R.string.Id),
                painterResource =(painterResource(id=R.drawable.id_image)),
                contentDescription= stringResource(id=R.string.IdImg)

            )

            PasswordTextFieldComponent(labelValue = stringResource(id=R.string.password),
                painterResource =(painterResource(id=R.drawable.password)),
                contentDescription= stringResource(id=R.string.passwordImg)

            )
            TextFieldPhotoComponent(labelValue = stringResource(id=R.string.upload),
                painterResource =(painterResource(id=R.drawable.upload)),
                contentDescription= stringResource(id=R.string.uploadImg)

            )
            CheckboxComponent(value= stringResource(id=R.string.terms_and_condition),
                onTextSelected = {
                    Course_add_and_drop_managerAppRoute.navigateTo(Screen.TermsAndConditionsScreen)

                })
            Spacer(modifier=Modifier.height(20.dp).padding(bottom=20.dp))
            ButtonComponent(value= stringResource(id=R.string.signUp),
                onClick = {})
            Spacer(modifier=Modifier.height(10.dp))
            NormalTextComponent(value= stringResource(id=R.string.Already_have_accountL))
            ClickableLoginTextComponent(onTextSelected = {
                Course_add_and_drop_managerAppRoute.navigateTo(Screen.LoginScreen)
            })
            Spacer(modifier = Modifier.height(30.dp))


        }






    }
}
@Preview
@Composable
fun DefaultPreviewOfSignUpScree(){
    SignUpScreen()

}