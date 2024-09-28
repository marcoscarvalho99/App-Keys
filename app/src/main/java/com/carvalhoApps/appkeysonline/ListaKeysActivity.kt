package com.carvalhoApps.appkeysonline

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.carvalhoApps.appkeysonline.Model.Datakey
import com.carvalhoApps.appkeysonline.databinding.ActivityListaKeysBinding

class ListaKeysActivity : AppCompatActivity() {

    lateinit var binding: ActivityListaKeysBinding
    private lateinit var adapter: ArrayAdapter<Datakey>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_lista_keys)

        val db = DBHelper(this)
       val listaKeys = db.keysListSelectAll()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaKeys)
        binding.listViewkeys.adapter = adapter


    }
}