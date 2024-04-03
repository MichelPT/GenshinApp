package com.example.genshinapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.genshinapp.ui.ValorantApp
import com.example.genshinapp.ui.theme.GenshinAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var broadcastReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GenshinAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ValorantApp()
                }
            }
        }
    }
    private fun registerBroadCastReceiver() {
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                when (intent.action) {
                    Intent.ACTION_POWER_CONNECTED -> {
                        Log.d("Power status", getString(R.string.power_connected))
                    }
                    Intent.ACTION_POWER_DISCONNECTED -> {
                        Log.d("Power status", getString(R.string.power_disconnected))
                    }
                }
            }
        }
        val intentFilter = IntentFilter()
        intentFilter.apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        registerReceiver(broadcastReceiver, intentFilter)
    }

    override fun onStart() {
        super.onStart()
        registerBroadCastReceiver()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GenshinAppTheme {
        Greeting("Android")
    }
}