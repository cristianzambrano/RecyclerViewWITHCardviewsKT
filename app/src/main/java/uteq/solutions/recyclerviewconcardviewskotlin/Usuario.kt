package uteq.solutions.recyclerviewconcardviewskotlin

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class Usuario(a: JSONObject) {
    var nombres: String
    var email: String
    var website: String
    var urlavatar: String

    companion object {
        @Throws(JSONException::class)
        fun JsonObjectsBuild(datos: JSONArray): ArrayList<Usuario> {
            val usuarios: ArrayList<Usuario> = ArrayList<Usuario>()
            var i = 0
            while (i < datos.length()) {
                usuarios.add(Usuario(datos.getJSONObject(i)))
                i++
            }
            return usuarios
        }
    }

    init {
        nombres = a.getString("first_name").toString() + " " + a.getString("last_name").toString()
        email = a.getString("email").toString()
        website = a.getString("avatar").toString()
        urlavatar = a.getString("avatar").toString()
    }
}