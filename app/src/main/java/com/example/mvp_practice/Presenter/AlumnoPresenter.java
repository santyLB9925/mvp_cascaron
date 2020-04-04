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
    public void setDataName(String name){
        alumnoModelo.setNombre(name);
        view.sendDataName(name);
    }

    public void setDataApellidoPaterno(String apellidoP){
        alumnoModelo.setApellidoPaterno(apellidoP);
        view.sendDataApellidoPaterno(apellidoP);
    }

    public void setDataApellidoMaterno(String apellidoM){
        alumnoModelo.setApellidoMaterno(apellidoM);
        view.sendDataApellidoMaterno(apellidoM);
    }

    public void setCarrera(String carrera){
        alumnoModelo.setCarrera(carrera);
        view.sendDataCarrera(carrera);
    }

    public void setEdad(String edad){
        alumnoModelo.setEdad(edad);
        view.sendDataEdad(edad);
    }

    public void setSexo(String sexo){
        alumnoModelo.setSexo(sexo);
        view.sendDataSexo(sexo);
    }

    public void setDireccion(String direccion){
        alumnoModelo.setDireccion(direccion);
        view.sendDataDireccion(direccion);
    }

    public interface View {
        void sendDataToken(String Token);
        void sendDataName(String Name);
        void sendDataApellidoPaterno(String apellidoPaterno);
        void sendDataApellidoMaterno(String apellidoMaterno);
        void sendDataCarrera(String carrera);
        void sendDataEdad(String edad);
        void sendDataSexo(String sexo);
        void sendDataDireccion(String direccion);
    }

    public void showDatas(){
        alumnoModelo.getData();
    }
    public void Post(){alumnoModelo.Post(); }
    public void IdForDelete(int idStudent){ alumnoModelo.Delete(idStudent);}
    public void IdForUpdate(int idUpdateStudent){alumnoModelo.Update(idUpdateStudent); }

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