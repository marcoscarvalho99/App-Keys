package com.carvalhoApps.appkeysonline

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.carvalhoApps.appkeysonline.databinding.ActivityCreateBinding
import android.view.View
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog;
import android.graphics.Color;
import android.text.Editable
import android.text.TextWatcher

class CreateActivity : AppCompatActivity() {

    lateinit var binding: ActivityCreateBinding
    private fun setNegativeButton(s: String, onClickListener: DialogInterface.OnClickListener) {
        TODO("Not yet implemented")
    }
    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            android.R.string.no, Toast.LENGTH_SHORT).show()
    }

    fun Alert(){

        SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText("Registro adicionado com sucesso!")
            .setConfirmText("OK")
            .setConfirmClickListener {
                finish()
            }
            .show();
    }
    fun verificarCampos() {
        if (binding.DescricaoeditText.text.isNullOrEmpty() || binding.senhaeditText.text.isNullOrEmpty()) {
            binding.buttoncadastrar.isEnabled = false // Esconde o botão
        } else {
            binding.buttoncadastrar.isEnabled = true // Mostra o botão
        }
    }
    fun verificacaoCamposDescricaoAndPassowrdIsEmpty(){
        binding.DescricaoeditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                verificarCampos()
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.senhaeditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                verificarCampos()
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create)


        binding.buttoncadastrar.isEnabled = false // Esconde o botão inicialmente

        binding.buttoncadastrar.setOnClickListener {
            val vm = MainViewModel(this.application)
            vm.cadastrar(
                binding.DescricaoeditText.text.toString(),
                binding.senhaeditText.text.toString(),
                this
            )
            this.Alert()
        }

        verificacaoCamposDescricaoAndPassowrdIsEmpty()

    }
    override fun onBackPressed() {

        super.onBackPressed()

    }
}