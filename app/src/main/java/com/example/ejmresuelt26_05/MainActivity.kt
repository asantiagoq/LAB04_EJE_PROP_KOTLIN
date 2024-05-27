package com.example.ejmresuelt26_05

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    private lateinit var txtNombres: TextView
    private lateinit var txtApellidos: TextView
    private lateinit var txtUsuario: TextView
    private lateinit var txtContrasena: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtNombres = findViewById(R.id.txtNombres)
        txtApellidos = findViewById(R.id.txtApellidos)
        txtUsuario = findViewById(R.id.txtUsuario)
        txtContrasena = findViewById(R.id.txtContrasena)

        val blankFragment = BlankFragment.newInstance(response)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.frameLayout, blankFragment)
        }

    }

    val response: (UserData) -> Unit = { userData ->
        txtNombres.text = "Nombres: ${userData.nombres}"
        txtApellidos.text = "Apellidos: ${userData.apellidos}"
        txtUsuario.text = "Usuario: ${userData.usuario}"
        txtContrasena.text = "Contraseña: ${userData.contrasena}"
    }
}
