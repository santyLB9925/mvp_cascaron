package com.example.mvp_practice.modelo;

import com.example.mvp_practice.Apis.Api;
import com.example.mvp_practice.Direcciones.Urls;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.json.JSONArray;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

public class AlumnoModelo {

    AsyncHttpClient client = new AsyncHttpClient();
    String token;

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
}
