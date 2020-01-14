package com.hyum9.myapplication.Vistas.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hyum9.myapplication.Presentador.GestionarJsonUsuario;
import com.hyum9.myapplication.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText nombreUsuario, passwordUsuario;
    Button btnIngresar;
    ProgressDialog progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        nombreUsuario = findViewById(R.id.idNombre);
        passwordUsuario = findViewById(R.id.idPassword);
        btnIngresar=findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btnIngresar:

                GestionarJsonUsuario _jsonUsuario =  new GestionarJsonUsuario(this,progreso);
                _jsonUsuario.IniciarSesion(nombreUsuario,passwordUsuario);
                break;
        }

    }
}
