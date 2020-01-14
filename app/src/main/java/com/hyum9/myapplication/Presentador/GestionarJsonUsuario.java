package com.hyum9.myapplication.Presentador;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.EditText;

import com.hyum9.myapplication.Modelo.UsuarioJsonModel;

public class GestionarJsonUsuario {
    public Context context;
    public ProgressDialog progreso;
    private UsuarioJsonModel _usuarioJsonModel;

    public GestionarJsonUsuario(Context context, ProgressDialog progreso)
    {
        this.context = context;
        this.progreso  = progreso;
        _usuarioJsonModel = new UsuarioJsonModel(context, progreso);
    }

    public void IniciarSesion(final EditText nombreUsuario, final EditText passwordUsuario)
    {
        try
        {
            _usuarioJsonModel.IniciarSesion(nombreUsuario, passwordUsuario);
        }
        catch(Exception ex)
        {
            throw ex;
        }

    }
}
