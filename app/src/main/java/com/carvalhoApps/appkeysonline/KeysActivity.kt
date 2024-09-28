package com.carvalhoApps.appkeysonline

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.carvalhoApps.appkeysonline.databinding.ActivityKeysBinding

class KeysActivity : AppCompatActivity() {

    lateinit var binding: ActivityKeysBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_keys)

        binding.ButtonSalvar.setOnClickListener{
            val intent = Intent(this, CreateActivity::class.java)
            startActivityForResult(intent,1)
        }

        binding.ButtonSalvos.setOnClickListener{
            val intent = Intent(this, ListaKeysActivity::class.java)
            startActivityForResult(intent,2)
        }
        binding.buttonVoltar.setOnClickListener{
            setResult(RESULT_CANCELED)
            finish()
        }

    }
}