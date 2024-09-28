package com.carvalhoApps.appkeysonline

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carvalhoApps.appkeysonline.Model.Datakey
import com.carvalhoApps.appkeysonline.Repository.UsuarioRepository

class MainViewModel  (application: Application) : AndroidViewModel(application){

//    private val repository = UsuarioRepository(application.applicationContext)

//    private val usuarioModel = MutableLiveData<UsuarioModel>()
//    val usuario: LiveData<UsuarioModel> = usuarioModel
//    private var changes = MutableLiveData<Long>()
//    var newChanges: LiveData<Long> =changes
//    fun get(id:Int){
//
//    }
//    fun insert(password:String){
//        val usuarioNovo = UsuarioModel()
//        usuarioNovo.password = password
//       changes.value = repository.insert(usuarioNovo    )
//    }

    fun cadastrar(descricao: String, password: String, context: Context){
        val keyNew = Datakey()
        keyNew.password = password
        keyNew.descricao = descricao

        val db = DBHelper(context)
        val listaKeys = db.keysInsert(descricao,password)
        db.close()
    }


}