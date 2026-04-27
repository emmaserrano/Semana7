package ni.edu.uam.navegacionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ni.edu.uam.navegacionapp.navigation.NavManager
import ni.edu.uam.navegacionapp.ui.theme.NavegacionAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavegacionAppTheme {
                NavManager()
            }
        }
    }
}