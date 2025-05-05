package com.example.course_add_and_drop_manager_app.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import com.example.course_add_and_drop_manager_app.ui.theme.colorGrayBackground
import com.example.course_add_and_drop_manager_app.ui.theme.colorPrimary
import com.example.course_add_and_drop_manager_app.ui.theme.colorTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownComponent(
    label: String,
    options: List<String>,
    selectedValue: String,
    onValueSelected: (String) -> Unit,
    textFieldBgColor: Color = Color.White,
    focusedDropdownBg: Color = Color(0xFFB1E7DA) // light cyan when touched
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    Column(
        modifier = Modifier
            .padding(horizontal = 50.dp),

    ) {
        // OutlinedTextField with background and border
        OutlinedTextField(

            value = selectedValue,
            onValueChange = { onValueSelected(it) },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },

            label = { Text(text = label) },

            trailingIcon = {
                Icon(
                    icon,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            expanded = !expanded
                        }
                )
            },
            readOnly = true,
            shape = RoundedCornerShape(12.dp),
//            color= colorPrimary,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = colorPrimary,
                unfocusedIndicatorColor = colorTextField,
                focusedLabelColor = colorPrimary,
                cursorColor = colorPrimary,
                focusedContainerColor = colorTextField,
                unfocusedContainerColor = colorTextField
            ),
        )

        // Dropdown menu for options
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },


            modifier = Modifier

                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .background(if (expanded) focusedDropdownBg else Color.White),


        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        onValueSelected(item)
                        expanded = false
                    },
                    modifier=Modifier.background(colorPrimary)

                )
            }
        }
    }
}

@Composable
fun DropDownCenteredRowComponent(
    label: String,
    options: List<String>,
    selectedValue: String,
    onValueSelected: (String) -> Unit,
    focusedDropdownBg: Color = (colorGrayBackground)
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    Column(modifier = Modifier.padding(horizontal = 90.dp)) {

        // Custom Box acting like a text field
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .border(
                    width = 1.dp,
                    color = colorPrimary,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(colorPrimary, RoundedCornerShape(12.dp))
                .clickable { expanded = !expanded }
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = label,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                .background(if (expanded) focusedDropdownBg else Color.White)
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        onValueSelected(item)
                        expanded = false
                    },
                    modifier = Modifier.background(colorTextField)
                )
            }
        }
    }
}
@Composable
fun DropDownEditComponent(
    label: String,
    options: List<String>,
    selectedValue: String,
    onValueSelected: (String) -> Unit,
    focusedDropdownBg: Color = colorGrayBackground
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    // Outer Row to push the dropdown to the right
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize(Alignment.TopEnd) // align dropdown to button
        ) {
            // Button-like Box
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(100.dp)
                    .border(
                        width = 1.dp,
                        color = colorTextField,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(colorTextField, RoundedCornerShape(12.dp))
                    .clickable { expanded = !expanded }
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                contentAlignment = Alignment.CenterEnd
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                ) {
                    Text(
                        text = selectedValue.ifEmpty { label },
                        textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // DropdownMenu aligned below and to the right of the button
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                    .align(Alignment.TopEnd)
                    .background(if (expanded) focusedDropdownBg else Color.White)
            ) {
                options.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            onValueSelected(item)
                            expanded = false
                        },
                        modifier = Modifier.background(colorPrimary)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun DropDownCenteredRowPreview() {
    var selected by remember { mutableStateOf("") }
    val items = listOf("Option A", "Option B", "Option C")

    DropDownEditComponent(
        label = if (selected.isEmpty()) "Pick One" else selected,
        options = items,
        selectedValue = selected,
        onValueSelected = { selected = it }
    )
}

