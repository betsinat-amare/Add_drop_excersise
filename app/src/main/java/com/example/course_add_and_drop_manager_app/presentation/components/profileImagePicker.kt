import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.course_add_and_drop_manager_app.Course_add_and_drop_managerAppRoute
import com.example.course_add_and_drop_manager_app.R
import com.example.course_add_and_drop_manager_app.Screen
import com.example.course_add_and_drop_manager_app.presentation.components.DropDownComponent
import com.example.course_add_and_drop_manager_app.presentation.components.DropDownEditComponent
import com.example.course_add_and_drop_manager_app.presentation.components.NormalTextComponent
import com.example.course_add_and_drop_manager_app.presentation.dashboard.SelectAddOrDrop

@Composable
fun ProfileImagePlaceholder(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {
        Course_add_and_drop_managerAppRoute.navigateTo(Screen.EditProfile)
    }
) {
    Column(
        modifier = modifier,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .clickable { onClick() }
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Default Profile Icon",
                tint = Color.White,
                modifier = Modifier.size(60.dp)

            )
        }
        Spacer(modifier=Modifier.height(8.dp))

        NormalTextComponent(
            value = stringResource(id = R.string.welcomef),

        )
    }
}
@Composable
fun ProfileImgPlaceholder(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {
        Course_add_and_drop_managerAppRoute.navigateTo(Screen.EditProfile)
    }
) {
    Box(
            modifier = Modifier
                .padding(end=25.dp, top=10.dp)
                .clickable { onClick() }
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentAlignment = Alignment.TopEnd
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Default Profile Icon",
                tint = Color.White,
                modifier = Modifier.size(60.dp)

            )


    }
}

@Composable
fun ProfileEditPlaceholder(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 25.dp, top = 10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.align(Alignment.TopEnd)
                .clickable { onClick() }
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Default Profile Icon",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            var selected by remember { mutableStateOf("") }
            val items= listOf("Edit","Logout")

            DropDownEditComponent(
                label = if (selected.isEmpty()) "Edit/Logout" else selected,
                options = items,
                selectedValue = selected,
                onValueSelected = { selected = it }
            )
        }
    }
}
@Preview
@Composable
fun ProfileEditPlaceholderPreview(){
    ProfileEditPlaceholder()
}