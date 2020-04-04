package com.example.mvp_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.example.mvp_practice.Presenter.AlumnoPresenter;


import java.util.ArrayList;

public class TablaFragment extends AppCompatActivity implements AlumnoPresenter.View{

    private AlumnoPresenter alumnoPresentador;

    TableLayout table;
    TextView textName;
    EditText txtName;
    TextView textApellido;

    Button btnShow;
    Button btnPost;

    String token;
    int idStudent = 0;
    boolean desicion = false;

    ArrayList<Integer> Ids = new ArrayList<>();
    ArrayList<String> Names = new ArrayList<>();
    ArrayList<String> apellidosPaterno = new ArrayList<>();
    ArrayList<String> apellidosMaterno = new ArrayList<>();
    ArrayList<String> carrera = new ArrayList<>();
    ArrayList<String> edad = new ArrayList<>();
    ArrayList<String> sexo = new ArrayList<>();
    ArrayList<String> direcccion = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);

        table =  findViewById(R.id.tablelayout);
        txtName = findViewById(R.id.txtName);
        btnShow = findViewById(R.id.btnShow);
        btnPost = findViewById(R.id.btnPost);

        Bundle extra = getIntent().getExtras();
        token = (String) extra.get("token");

        alumnoPresentador = new AlumnoPresenter(this);
        alumnoPresentador.setDataToken(token);
        alumnoPresentador.showDatas();

        btnShow.setOnClickListener(v -> Show());

        btnPost.setOnClickListener(v -> MovetoShowmore());
    }


    @Override
    public void sendDataToken(String Token) {}
    @Override
    public void sendDataName(String Name) {}
    @Override
    public void sendDataApellidoPaterno(String apellidoPaterno) {}
    @Override
    public void sendDataApellidoMaterno(String Descripcion) {}
    @Override
    public void sendDataCarrera(String TProducto) {}

    @Override
    public void sendDataEdad(String edad) {

    }
    @Override
    public void sendDataSexo(String sexo) {}
    @Override
    public void sendDataDireccion(String direccion){}

    public void Show()
    {
        Ids = alumnoPresentador.getIds();
        Names = alumnoPresentador.getNombres();
        apellidosPaterno = alumnoPresentador.getApellidosP();
        apellidosMaterno = alumnoPresentador.getApellidosM();
        carrera = alumnoPresentador.getCarreras();
        edad = alumnoPresentador.getEdades();
        sexo = alumnoPresentador.getSexos();
        direcccion = alumnoPresentador.getDirecciones();
        recorrerDatos();
    }

    public void recorrerDatos()
    {
        int NUM_COLS= 1;
        int NUM_ROWS= Names.size();

        for(int i = 0; i<NUM_ROWS; i++){
            TableRow tableRow = new TableRow(getBaseContext());
            table.addView(tableRow);
            table.setBackgroundColor(Color.WHITE);

            for(int j= 0; j<NUM_COLS; j++){
                final Button btnDel = new Button(getBaseContext());
                btnDel.setId(i);
                btnDel.setText("Delete");

                final Button btnEdit = new Button(getBaseContext());
                btnEdit.setId(i);
                btnEdit.setText("Update");

                textName = new TextView(getBaseContext());
                textName.setGravity(Gravity.CENTER_VERTICAL);
                textName.setPadding(60, 40, 60, 25);
                textName.setBackgroundColor(Color.WHITE);
                textName.setTextColor(Color.BLACK);

                textApellido  = new TextView(getBaseContext());
                textApellido.setPadding(60, 40, 60, 25);
                textApellido.setBackgroundColor(Color.WHITE);
                textApellido.setTextColor(Color.BLACK);

                textName.setText(Names.get(i));
                textApellido.setText(apellidosPaterno.get(i));

                tableRow.addView(textName);
                tableRow.addView(textApellido);

                tableRow.addView(btnEdit);
                tableRow.addView(btnDel);


                btnEdit.setOnClickListener(v -> {
                    idStudent = Ids.get(btnEdit.getId());
                    desicion = true;
                    MovetoShowmore();
                });

                btnDel.setOnClickListener(v -> {
                    idStudent = Ids.get(btnDel.getId());
                    DeleteStudent(idStudent);
                    Intent intent = new Intent(this, TablaFragment.class);
                    intent.putExtra("token", token);
                    intent.putExtra("id", idStudent);
                    intent.putExtra("desicion", desicion);
                    startActivity(intent);
                    onDestroy();


                });

            }
        }
    }

    public void MovetoShowmore(){
        Intent intent = new Intent(this, ShowMore.class);
        intent.putExtra("token", token);
        intent.putExtra("id", idStudent);
        intent.putExtra("desicion", desicion);
        startActivity(intent);
    }

    public void DeleteStudent(int idProduct){
        alumnoPresentador.IdForDelete(idProduct);
    }
}