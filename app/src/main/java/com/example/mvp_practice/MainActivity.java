package com.example.mvp_practice;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mvp_practice.Presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginPresenter.View {
    private LoginPresenter loginPresenter;

    EditText password;
    EditText txtName;
    Button btnEntrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = findViewById(R.id.password);
        txtName = findViewById(R.id.txtName);
        btnEntrar = findViewById(R.id.btnEntrar);


        loginPresenter = new LoginPresenter(this);
        btnEntrar.setOnClickListener(v -> Login());


        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginPresenter.setDataName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginPresenter.setDataPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public void sendDataLogin(String Name) {
    }

    @Override
    public void sendDataLoginPassword(String Password) {
    }

    public void Login(){
        loginPresenter.iniciarSesion();
        if (loginPresenter.isConectedSucces() == true){
            Intent intent = new Intent(this, TablaFragment.class);
            intent.putExtra("token", loginPresenter.getTokenUser());

            startActivity(intent);
        }
    }
}