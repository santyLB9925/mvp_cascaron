package com.example.mvp_practice.modelo;

import android.widget.Toast;

import com.example.mvp_practice.Apis.Api;
import com.example.mvp_practice.Direcciones.Urls;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.JsonHttpResponseHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class AlumnoModelo {

    AsyncHttpClient client = new AsyncHttpClient();


    String token;

    String nombre;
    String apellidoP;
    String apellidoM;
    String carrera;
    String edad;
    String sexo;
    String direccion;

    ArrayList<Integer> ids = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> edades = new ArrayList<>();
    ArrayList<String> direcciones = new ArrayList<>();
    ArrayList<String> sexos = new ArrayList<>();
    ArrayList<String> apellidosP = new ArrayList<>();
    ArrayList<String> apellidosM = new ArrayList<>();
    ArrayList<String> carreras = new ArrayList<>();

    public void setToken(String token) {
        this.token = token;
    }
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellidoPaterno(String apellidoP) {this.apellidoP = apellidoP; }
    public void setApellidoMaterno(String apellidoM) {this.apellidoM = apellidoM;}
    public void setCarrera(String carrera) {this.carrera = carrera;}
    public void setEdad(String edad) {this.edad = edad;}
    public void setSexo(String sexo) { this.sexo = sexo; }
    public void setDireccion(String direccion) {this.direccion = direccion;}

    public ArrayList<Integer> getIds() {
        return ids;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<String> getEdades() {
        return edades;
    }

    public ArrayList<String> getDirecciones() {
        return direcciones;
    }

    public ArrayList<String> getSexos() {
        return sexos;
    }

    public ArrayList<String> getApellidosP() {
        return apellidosP;
    }

    public ArrayList<String> getApellidosM() {
        return apellidosM;
    }

    public ArrayList<String> getCarreras() {
        return carreras;
    }

    public void getData() {

        String head = "Token " + token;
        client.addHeader("Content-Type", "application/x-www-form-urlencoded");
        client.addHeader("Authorization", head);

        client.get(Urls.URL + Api.GetStudent, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                try {
                    JSONArray jsonArray = new JSONArray(new String(responseBody));
                    for (int i = 0; i < jsonArray.length(); i++) {

                        ids.add(Integer.parseInt(jsonArray.getJSONObject(i).getString("id")));
                        names.add(jsonArray.getJSONObject(i).getString("nombre"));
                        edades.add(jsonArray.getJSONObject(i).getString("edad"));

                        direcciones.add(jsonArray.getJSONObject(i).getString("direccion"));
                        sexos.add(jsonArray.getJSONObject(i).getString("sexo"));
                        apellidosP.add(jsonArray.getJSONObject(i).getString("apellidoPaterno"));
                        apellidosM.add((jsonArray.getJSONObject(i).getString("apellidoMaterno")));
                        carreras.add(jsonArray.getJSONObject(i).getString("carrera"));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
    }
    public void Delete(int idSelected){
        String head = "Token " + token;
        client.addHeader("Content-Type", "application/x-www-form-urlencoded");
        client.addHeader("Authorization", head);

        client.delete(Urls.URL + Api.DeleteStudent + idSelected + "/", new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
            }
        });
    }
    public void Post(){
        String head = "Token " + token;
        client.addHeader("Content-Type", "application/x-www-form-urlencoded");
        client.addHeader("Authorization", head);
        RequestParams params =  new  RequestParams ();
        params.put("nombre", nombre);
        params.put("edad", edad);
        params.put("direccion", direccion);
        params.put("sexo", sexo);
        params.put("apellidoPaterno", apellidosP);
        params.put("apellidoMaterno", apellidosM);
        params.put("carrera", carrera);


        client.post(Urls.URL + Api.PostStudent, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                getData();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
            }
        });
    }
    public void Update(int idSelected){
        String head = "Token " + token;
        client.addHeader("Content-Type", "application/x-www-form-urlencoded");
        client.addHeader("Authorization", head);
        RequestParams params =  new  RequestParams ();
        params.put("nombre", nombre);
        params.put("edad", edad);
        params.put("direccion", direccion);
        params.put("sexo", sexo);
        params.put("apellidoPaterno", apellidosP);
        params.put("apellidoMaterno", apellidosM);
        params.put("carrera", carrera);

        client.put(Urls.URL + Api.UpdateStudent + idSelected + "/", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                getData();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
            }
        });
    }
}
