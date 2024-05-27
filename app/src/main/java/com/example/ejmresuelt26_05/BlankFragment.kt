package com.example.ejmresuelt26_05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

data class UserData(val nombres: String, val apellidos: String, val usuario: String, val contrasena: String)

class BlankFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)

        val edtNombres = view.findViewById<EditText>(R.id.edtNombres)
        val edtApellidos = view.findViewById<EditText>(R.id.edtApellidos)
        val edtUsuario = view.findViewById<EditText>(R.id.edtUsuario)
        val edtContrasena = view.findViewById<EditText>(R.id.edtContraseña)
        val btnEnviarDatos = view.findViewById<Button>(R.id.btnEnviarDatos)

        btnEnviarDatos.setOnClickListener {
            val nombres = edtNombres.text.toString()
            val apellidos = edtApellidos.text.toString()
            val usuario = edtUsuario.text.toString()
            val contrasena = edtContrasena.text.toString()
            val userData = UserData(nombres, apellidos, usuario, contrasena)
            clickBtnEnviarDatos(userData)
        }
        return view
    }

    companion object {
        private lateinit var clickBtnEnviarDatos: (UserData) -> Unit

        @JvmStatic
        fun newInstance(clickBtnEnviarDatos: (UserData) -> Unit): BlankFragment {
            val blankFragment = BlankFragment()
            this.clickBtnEnviarDatos = clickBtnEnviarDatos
            return blankFragment
        }
    }
}
