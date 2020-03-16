package com.example.mvp_practice;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mvp_practice.Presenter.AlumnoPresenter;
import com.loopj.android.http.AsyncHttpClient;
import java.util.ArrayList;

public class TablaFragment extends AppCompatActivity implements AlumnoPresenter.View{

    private AlumnoPresenter alumnoPresenter;
    AsyncHttpClient client = new AsyncHttpClient();

    String token;
    TableLayout table;
    TextView textName;
    EditText txtName;
    TextView textPrecio;
    TextView textdescripcion;
    Button btnShow;

    ArrayList<Integer> Ids = new ArrayList<>();
    ArrayList<String> Names = new ArrayList<>();
    ArrayList<String> Edades = new ArrayList<>();
    ArrayList<String> Direcciones = new ArrayList<>();
    ArrayList<String> Sexos = new ArrayList<>();
    ArrayList<String> ApellidosP = new ArrayList<>();
    ArrayList<String> ApellidosM = new ArrayList<>();
    ArrayList<String> Carreras = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);

        table =  findViewById(R.id.tablelayout);
        txtName = findViewById(R.id.txtName);
        btnShow = findViewById(R.id.btnShow);

        Bundle extra = getIntent().getExtras();
        token = (String) extra.get("token");

        alumnoPresenter = new AlumnoPresenter(this);
        alumnoPresenter.setDataToken(token);
        alumnoPresenter.showDatas();
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Show();
            }
        });
    }


    @Override
    public void sendDataToken(String Token) {
    }

    public void Show()
    {
        Ids = alumnoPresenter.getIds();
        Names = alumnoPresenter.getNombres();
        Edades = alumnoPresenter.getEdades();
        Direcciones = alumnoPresenter.getDirecciones();
        Sexos = alumnoPresenter.getSexos();
        ApellidosP = alumnoPresenter.getApellidosP();
        ApellidosM = alumnoPresenter.getApellidosM();
        Carreras = alumnoPresenter.getCarreras();
        User();
    }




    public void User()
    {
        if (token.equals("89d2b0e10197c11f22db4d7156270efc3a4a454d")){
            recorrerDatos();
        }else{
            if (token.equals("c31ad0dc4c16efa62eca34307c51bfc13cf93f0b")){
                recorrerDatos2();
            }
        }
    }


    public void recorrerDatos()
    {
        int NUM_COLS= 1;
        int NUM_ROWS= Names.size();

        for(int i = 0; i<NUM_ROWS; i++){
            TableRow tableRow = new TableRow(getBaseContext());
            table.addView(tableRow);

            for(int j= 0; j<NUM_COLS; j++){

                textName = new TextView(getBaseContext());
                textName.setGravity(Gravity.CENTER_VERTICAL);
                textName.setPadding(60, 40, 60, 25);
                textName.setTextColor(Color.WHITE);

                textPrecio  = new TextView(getBaseContext());
                textPrecio.setPadding(60, 40, 60, 25);
                textPrecio.setTextColor(Color.WHITE);


                textName.setText(Names.get(i));
                textPrecio.setText(Edades.get(i));

                tableRow.addView(textName);
                tableRow.addView(textPrecio);
            }
        }
    }

    public void recorrerDatos2(){
        int NUM_COLS= 1;
        int NUM_ROWS= Names.size();

        for(int i = 0; i<NUM_ROWS; i++){
            TableRow tableRow = new TableRow(getBaseContext());
            table.addView(tableRow);

            for(int j= 0; j<NUM_COLS; j++){
                final int idDa = i;

                textName = new TextView(getBaseContext());
                textName.setGravity(Gravity.CENTER_VERTICAL);
                textName.setPadding(40, 35, 40, 25);
                textName.setBackgroundResource(R.color.colorPrimaryDark);
                textName.setTextColor(Color.WHITE);

                textPrecio  = new TextView(getBaseContext());
                textPrecio.setPadding(40, 35, 40, 25);
                textPrecio.setBackgroundResource(R.color.colorPrimaryDark);
                textPrecio.setTextColor(Color.WHITE);

                textdescripcion  = new TextView(getBaseContext());
                textdescripcion.setPadding(40, 35, 40, 25);
                textdescripcion.setBackgroundResource(R.color.colorPrimaryDark);
                textdescripcion.setTextColor(Color.WHITE);


                textName.setText(Names.get(i));
                textPrecio.setText(Edades.get(i));
                textdescripcion.setText(Direcciones.get(i));


                tableRow.addView(textName);
                tableRow.addView(textPrecio);
                tableRow.addView(textdescripcion);
            }
        }
    }

}
