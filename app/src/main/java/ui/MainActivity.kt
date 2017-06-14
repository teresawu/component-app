package ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import test.com.componentapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModelBtn.setOnClickListener({ v -> startActivity(Intent(MainActivity@ this, ViewModelActivity::class.java)) })
        liveDataBtn.setOnClickListener({ v -> startActivity(Intent(MainActivity@ this, LiveDataActivity::class.java)) })
        roomBtn.setOnClickListener({ v -> startActivity(Intent(MainActivity@ this, RoomActivity::class.java)) })
    }
}
