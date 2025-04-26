package com.devndiplomacy.spendwise.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devndiplomacy.spendwise.commonUi.SpendWiseBackground
import com.devndiplomacy.spendwise.getDataBase
import com.devndiplomacy.spendwise.screens.models.Expense
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@Composable
fun SpendWiseShowExpenseScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    var expenses by remember { mutableStateOf<List<Expense>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    // Fetch expenses when the screen is first displayed
    LaunchedEffect(Unit) {
        try {
            expenses = getDataBase().getExpenseDao().getAllExpenses().map {  it->
                val category = coroutineScope.async {

                   return@async getDataBase().getCategoryDao().getCategory(it.categoryId)
                }

                val c = category.await()
                Expense(
                    id = it.id,
                    amount = it.amount,
                    category = c.name
                )
            }
            println("expenses $expenses")
            isLoading = false
        } catch (e: Exception) {
            // Handle error
            isLoading = false
        }
    }

    SpendWiseBackground {
        Box(modifier = Modifier.fillMaxSize()) {
            // Show loading indicator while fetching expenses
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = spendwiseGreen
                )
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        IconButton(
                            onClick = {
                                onBackClick()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }

                        Text(
                            text = "Your Expenses",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    // Subtitle with total amount
                    val totalAmount = expenses.sumOf { it.amount }
                    Text(
                        text = "Total: $totalAmount",
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                    )

                    // Expense list
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp),
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(expenses) { expense ->
                            ExpenseCard(expense = expense)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ExpenseCard(expense: Expense) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        elevation = 4.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left section - Category and Date
            Column(modifier = Modifier.weight(1f)) {
                // Category with icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Category",
                        tint = spendwiseGreen,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = expense.category,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                }

                // Date with icon
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Date",
                        tint = Color.Gray,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "2025-03-15", // Placeholder date
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
            }

            // Right section - Amount
            Box(
                modifier = Modifier
                    .background(
                        color = spendwiseGreen.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = expense.amount.toString(),
                    color = spendwiseGreen,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}

