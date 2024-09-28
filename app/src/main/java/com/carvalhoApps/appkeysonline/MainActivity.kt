package com.carvalhoApps.appkeysonline
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.carvalhoApps.appkeysonline.Repository.UsuarioRepository
import com.carvalhoApps.appkeysonline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.buttonConfirme.setOnClickListener{
           var senha = binding.editTextTextSenha.text.toString()

            if(senha.toString().equals("seguro") ){

                val intent = Intent(this, KeysActivity::class.java)
                startActivityForResult(intent,1)
                Toast.makeText(this, "permissão concedida",Toast.LENGTH_LONG).show()
            }
            Toast.makeText(this, "Você está em um sistema protegido",Toast.LENGTH_LONG).show()

        }

    }
}