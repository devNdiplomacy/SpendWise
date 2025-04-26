package com.devndiplomacy.spendwise.add_expense.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.devndiplomacy.spendwise.core.SPEND_WISE_COLOR
import com.devndiplomacy.spendwise.core.ui.SpendWiseBackground
import com.devndiplomacy.spendwise.core.ui.SpendWiseOutlineTextField
import com.devndiplomacy.spendwise.core.ui.SpendWiseText

@Composable
fun AddExpenseScreen(
    onBack: () -> Unit,
    onSave: (String, String,String) -> Unit
) {

    SpendWiseBackground(greenPortion = 0.5f) {

        AddExpenseScreenContent(onBack = onBack, onSave = onSave)
    }
}

@Composable
fun AddExpenseScreenContent(
    onBack: () -> Unit,
    onSave: (String, String, String) -> Unit
) {
    var amount by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val categories = listOf("Food", "Transport", "Shopping", "Entertainment", "Bills", "Healthcare", "Others")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp)
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    SpendWiseText(
                        text = "Add New Expense",
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                SpendWiseText(
                    text = "Amount",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Medium,
                )

                Spacer(modifier = Modifier.height(8.dp))

                SpendWiseOutlineTextField(
                    value = amount,
                    onValueChange = { newValue -> amount = newValue },
                    label = "",
                    placeHolder = "Enter amount",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Money",
                            tint = MaterialTheme.colors.primary
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )

                Spacer(modifier = Modifier.height(16.dp))

                SpendWiseText(
                    text = "Category",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Category dropdown
                Box {

                    SpendWiseOutlineTextField(
                        value = category,
                        onValueChange = { newValue -> category = newValue },
                        label = "",
                        placeHolder = "Select category",
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowUp,
                                contentDescription = "Category",
                                tint = MaterialTheme.colors.primary
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { expanded = !expanded }) {
                                Icon(
                                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Dropdown"
                                )
                            }
                        },
                        readOnly = true,
                        onClick = { expanded = true }
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        categories.forEach { option ->
                            DropdownMenuItem(
                                onClick = {
                                    category = option
                                    expanded = false
                                }
                            ) {
                                Text(text = option)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                SpendWiseText(
                    text = "Description",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))

                SpendWiseOutlineTextField(
                    value = description,
                    onValueChange = { newValue -> description = newValue },
                    label = "",
                    placeHolder = "Add optional description",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Description",
                            tint = MaterialTheme.colors.primary
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(
                        onClick = onBack,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    ) {
                        Text("Cancel", color = Color(SPEND_WISE_COLOR))
                    }

                    Button(
                        onClick = { onSave(amount, category, description) },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(SPEND_WISE_COLOR),
                            contentColor = Color.White
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Save",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Save")
                    }
                }
            }
        }
    }
}