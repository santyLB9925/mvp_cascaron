package com.example.mvp_practice;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvp_practice.Presenter.AlumnoPresenter;

public class ShowMore extends AppCompatActivity implements AlumnoPresenter.View{
    private AlumnoPresenter alumnoPresentador;

    Button btnEnviar;
    EditText txtNombre;
    EditText txtApellidoPaterno;
    EditText txtApellidoMaterno;
    EditText txtCarrera;
    EditText txtEdad;
    EditText txtSexo;
    EditText txtDireccion;
    String token;
    int idStudent = 0;
    boolean desicion = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_more);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellidoPaterno = findViewById(R.id.txtApellidoPaterno);
        txtApellidoMaterno = findViewById(R.id.txtApellidoMaterno);
        txtCarrera = findViewById(R.id.txtCarrera);
        txtEdad = findViewById(R.id.txtEdad);
        txtSexo = findViewById(R.id.txtSexo);
        txtDireccion = findViewById(R.id.txtDireccion);
        btnEnviar = findViewById(R.id.btnEnviar);

        Bundle extra = getIntent().getExtras();
        token = (String) extra.get("token");
        idStudent = (int) extra.get("id");
        desicion = (boolean) extra.get("desicion");

        alumnoPresentador = new AlumnoPresenter(this);
        alumnoPresentador.setDataToken(token);

        btnEnviar.setOnClickListener(v -> {
            if (desicion == false){
                alumnoPresentador.Post();
                MostrarTabla();
            }else{
                alumnoPresentador.IdForUpdate(idStudent);
                MostrarTabla();
            }
        });

        txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                alumnoPresentador.setDataName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        txtApellidoPaterno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                alumnoPresentador.setDataApellidoPaterno(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        txtApellidoMaterno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                alumnoPresentador.setDataApellidoMaterno(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        txtCarrera.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                alumnoPresentador.setCarrera(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        txtEdad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                alumnoPresentador.setEdad(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        txtSexo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                alumnoPresentador.setSexo(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        txtDireccion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                alumnoPresentador.setDireccion(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    @Override
    public void sendDataToken(String Token) {}
    @Override
    public void sendDataName(String name) {}
    @Override
    public void sendDataApellidoPaterno(String apellidoPaterno) {}
    @Override
    public void sendDataApellidoMaterno(String apellidoMaterno) {}
    @Override
    public void sendDataCarrera(String carrera) {}
    @Override
    public void sendDataEdad(String edad) {
    }
    public void sendDataSexo(String sexo) {}
    @Override
    public void sendDataDireccion(String direccion) {}

    public void MostrarTabla(){
        Intent intent = new Intent(this, TablaFragment.class);
        startActivity(intent);
    }
}