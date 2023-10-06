package app.k9mail.core.ui.compose.designsystem.atom.textfield

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import app.k9mail.core.ui.compose.designsystem.R
import app.k9mail.core.ui.compose.testing.ComposeTest
import assertk.assertThat
import assertk.assertions.isTrue
import org.junit.Test

private const val PASSWORD = "Password input"

class TextFieldOutlinedPasswordKtTest : ComposeTest() {

    @Test
    fun `should not display password by default`() = runComposeTest {
        setContent {
            TextFieldOutlinedPassword(
                value = PASSWORD,
                onValueChange = {},
            )
        }

        onNodeWithText(PASSWORD).assertDoesNotExist()
    }

    @Test
    fun `should display password when show password is clicked`() = runComposeTest {
        setContent {
            TextFieldOutlinedPassword(
                value = PASSWORD,
                onValueChange = {},
            )
        }

        onShowPasswordNode().performClick()

        onNodeWithText(PASSWORD).assertIsDisplayed()
    }

    @Test
    fun `should not display password when hide password is clicked`() = runComposeTest {
        setContent {
            TextFieldOutlinedPassword(
                value = PASSWORD,
                onValueChange = {},
            )
        }
        onShowPasswordNode().performClick()

        onHidePasswordNode().performClick()

        onNodeWithText(PASSWORD).assertDoesNotExist()
    }

    @Test
    fun `should display hide password icon when show password is clicked`() = runComposeTest {
        setContent {
            TextFieldOutlinedPassword(
                value = PASSWORD,
                onValueChange = {},
            )
        }

        onShowPasswordNode().performClick()

        onHidePasswordNode().assertIsDisplayed()
    }

    @Test
    fun `should display show password icon when hide password icon is clicked`() = runComposeTest {
        setContent {
            TextFieldOutlinedPassword(
                value = PASSWORD,
                onValueChange = {},
            )
        }
        onShowPasswordNode().performClick()

        onHidePasswordNode().performClick()

        onShowPasswordNode().assertIsDisplayed()
    }

    @Test
    fun `should call callback when password visibility toggle icon is clicked`() = runComposeTest {
        var clicked = false
        setContent {
            TextFieldOutlinedPassword(
                value = PASSWORD,
                onValueChange = {},
                isPasswordVisible = false,
                onPasswordVisibilityToggleClicked = { clicked = true },
            )
        }

        onShowPasswordNode().performClick()

        assertThat(clicked).isTrue()
    }

    @Test
    fun `should display password when isPasswordVisible = true`() = runComposeTest {
        setContent {
            TextFieldOutlinedPassword(
                value = PASSWORD,
                onValueChange = {},
                isPasswordVisible = true,
                onPasswordVisibilityToggleClicked = {},
            )
        }

        onNodeWithText(PASSWORD).assertIsDisplayed()
    }

    @Test
    fun `should not display password when isPasswordVisible = false`() = runComposeTest {
        setContent {
            TextFieldOutlinedPassword(
                value = PASSWORD,
                onValueChange = {},
                isPasswordVisible = false,
                onPasswordVisibilityToggleClicked = {},
            )
        }

        onNodeWithText(PASSWORD).assertDoesNotExist()
    }

    private fun SemanticsNodeInteractionsProvider.onShowPasswordNode(): SemanticsNodeInteraction {
        return onNodeWithContentDescription(
            getString(R.string.designsystem_atom_password_textfield_show_password),
        )
    }

    private fun SemanticsNodeInteractionsProvider.onHidePasswordNode(): SemanticsNodeInteraction {
        return onNodeWithContentDescription(
            getString(R.string.designsystem_atom_password_textfield_hide_password),
        )
    }
}
