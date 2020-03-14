package com.example.mvp_practice.Presenter;

import com.example.mvp_practice.modelo.LoginModelo;

public class LoginPresenter {

    LoginModelo loginModelo;
    private View view;
    boolean conectedSucces;

    public LoginPresenter(View view){
        this.view = view;
        this.loginModelo = new LoginModelo();
    }

    public void setDataName(String Name){
        loginModelo.setName(Name);
        view.sendDataLogin(Name);
    }


    public void setDataPassword(String Password){
        loginModelo.setPassword(Password);
        view.sendDataLoginPassword(Password);
    }

    public interface View {
        void sendDataLogin(String Name);
        void sendDataLoginPassword(String Password);
    }

    public void iniciarSesion() {
        loginModelo.Login();
    }

    public String getTokenUser(){
        return loginModelo.getToken();
    }
    //public String getBASE_URL(){return loginModelo.getBaseUrl();}

    public boolean isConectedSucces() {
        conectedSucces = loginModelo.isConectedSucces();
        return conectedSucces;
    }
}
