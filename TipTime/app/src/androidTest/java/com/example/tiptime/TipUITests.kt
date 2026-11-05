package com.example.tiptime

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
import com.example.tiptime.ui.theme.TipTimeTheme

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }

        // Вводим сумму счёта
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        // Вводим процент чаевых
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")

        // Проверяем, что отобразилась правильная сумма
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertIsDisplayed()
    }
}