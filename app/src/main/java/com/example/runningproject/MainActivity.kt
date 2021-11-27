package com.example.runningproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.runningproject.Compose.EachRow
import com.example.runningproject.Compose.GETData
import com.example.runningproject.network.data.MainViewModel
import com.example.runningproject.ui.theme.RunningProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
         val mainViewModel:MainViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContent {
            RunningProjectTheme {
                GETData(mainViewModel = mainViewModel )

            }
        }
    }
}
