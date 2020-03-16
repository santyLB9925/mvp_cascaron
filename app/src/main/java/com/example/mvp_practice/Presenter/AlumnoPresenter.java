package com.example.mvp_practice.Presenter;

import com.example.mvp_practice.modelo.AlumnoModelo;

import java.util.ArrayList;

public class AlumnoPresenter {

    private AlumnoModelo alumnoModelo;
    private View view;

    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<String> nombres = new ArrayList<>();
    ArrayList<String> edades = new ArrayList<>();
    ArrayList<String> direcciones = new ArrayList<>();
    ArrayList<String> sexos = new ArrayList<>();
    ArrayList<String> apellidosP = new ArrayList<>();
    ArrayList<String> apellidosM = new ArrayList<>();
    ArrayList<String> carreras = new ArrayList<>();

    public AlumnoPresenter(View view) {
        this.view = view;
        this.alumnoModelo = new AlumnoModelo();
    }

    public void setDataToken(String Token){
        alumnoModelo.setToken(Token);
        view.sendDataToken(Token);
    }

    public interface View {
        void sendDataToken(String Token);
    }

    public void showDatas(){
        alumnoModelo.getData();
    }

    public ArrayList<Integer> getIds() {
        ids = alumnoModelo.getIds();
        return ids;
    }

    public ArrayList<String> getNombres() {
        nombres = alumnoModelo.getNames();
        return nombres;
    }

    public ArrayList<String> getEdades() {
        edades = alumnoModelo.getEdades();
        return edades;
    }

    public ArrayList<String> getDirecciones() {
        direcciones = alumnoModelo.getDirecciones();
        return direcciones;
    }

    public ArrayList<String> getSexos() {
        sexos = alumnoModelo.getSexos();
        return sexos;
    }

    public ArrayList<String> getApellidosP() {
        apellidosP = alumnoModelo.getApellidosP();
        return apellidosP;
    }

    public ArrayList<String> getApellidosM() {
        apellidosM = alumnoModelo.getApellidosM();
        return apellidosM;
    }

    public ArrayList<String> getCarreras() {
        carreras = alumnoModelo.getCarreras();
        return carreras;
    }
}