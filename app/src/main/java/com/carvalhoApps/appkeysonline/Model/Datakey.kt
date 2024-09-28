package com.carvalhoApps.appkeysonline.Model

class Datakey(val id: Int = 0, var descricao : String = "", var password: String = "") {

    override fun toString(): String {

//        "Datakey (id=$id, descricao='$descricao', password='$password')"
        return "$descricao, Senha:$password)"
    }
}