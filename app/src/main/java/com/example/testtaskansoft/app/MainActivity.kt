package com.example.testtaskansoft.app

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.testtaskansoft.R
import com.example.testtaskansoft.databinding.ActivityMainBinding
import com.example.testtaskansoft.feature.domain.model.Delivery
import com.example.testtaskansoft.feature.presentation.complete.ItemDeliveryCard

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ItemDeliveryCard(
                delivery = Delivery(
                    "Ивановского 6",
                    6,
                    "",
                    "",
                    "+7-999-999-99-99",
                    "Завтоа",
                    false
                )
            )
        }

/*        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val navController =
            (supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment)
                .navController

        binding.bottomNavigate.setupWithNavController(navController)*/
    }
}