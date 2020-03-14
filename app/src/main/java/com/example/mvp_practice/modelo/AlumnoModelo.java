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
    ArrayList<String> precios = new ArrayList<>();
    ArrayList<String> descripciones = new ArrayList<>();
    ArrayList<String> tipoProductos = new ArrayList<>();
    ArrayList<String> proveedores = new ArrayList<>();
    ArrayList<Integer> statuses = new ArrayList<>();
    ArrayList<String> folios = new ArrayList<>();

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList<Integer> getIds() {
        return ids;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<String> getPrecios() {
        return precios;
    }

    public ArrayList<String> getDescripciones() {
        return descripciones;
    }

    public ArrayList<String> getTipoProductos() {
        return tipoProductos;
    }

    public ArrayList<String> getProveedores() {
        return proveedores;
    }

    public ArrayList<Integer> getStatuses() {
        return statuses;
    }

    public ArrayList<String> getFolios() {
        return folios;
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
                        precios.add(jsonArray.getJSONObject(i).getString("precio"));

                        descripciones.add(jsonArray.getJSONObject(i).getString("descripcion"));
                        tipoProductos.add(jsonArray.getJSONObject(i).getString("tipoProducto"));
                        proveedores.add(jsonArray.getJSONObject(i).getString("proveedor"));
                        statuses.add(Integer.parseInt(jsonArray.getJSONObject(i).getString("status")));
                        folios.add(jsonArray.getJSONObject(i).getString("folio"));
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
