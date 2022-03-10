package com.example.jlcardonagamecenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jlcardonagamecenter.Login.DataBase.DBHelper;
import com.example.jlcardonagamecenter.Login.Principal.PrincipalMenu;
import com.example.jlcardonagamecenter.Login.RegistroData.RegistroData;

public class MainActivity extends AppCompatActivity {

    //Variables

    EditText et1, et2;

    private Cursor fila;

    String Title = "Inicio de Sesión";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pinta el titulo de la actividad
        this.setTitle(Title);
        //Habilita para que se pueda visualizar el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Indica donde esta la imagen para el action bar
        getSupportActionBar().setIcon(R.drawable.ic_action_name);
        //Empereja las variable con el xml editText usuario y password
        et1 = (EditText) findViewById(R.id.etusuario);
        et2 = (EditText) findViewById(R.id.edtclave);
    }

    public void InicioSesion(View v) {
        /*Creamos un objeto de la clase DBHelper e
        instanciamos el constructor y damos el nonbre de
         la base de datos y la version*/
        DBHelper admin = new DBHelper(this);
        /*Abrimos la base de datos como escritura*/
        SQLiteDatabase db = admin.getWritableDatabase();
        /*Creamos dos variables string y capturamos los datos
         ingresado por el usuario y lo convertimos a string*/
        String usuario = et1.getText().toString();
        String contrasena = et2.getText().toString();
        /*inicializamos al cursor y llamamos al objeto de la base
        de datos para realizar un sentencia query where donde
         pasamos las dos variables nombre de usuario y password*/
        fila = db.rawQuery("select username,clave_user from userstable where username='" +
                usuario + "' and clave_user='" + contrasena + "'", null);
        /*Realizamos un try catch para captura de errores*/
        try {
            /*Condicional if preguntamos si cursor tiene algun dato*/
            if (fila.moveToFirst()) {
//capturamos los valores del cursos y lo almacenamos en variable
                String usua = fila.getString(0);
                String pass = fila.getString(1);
                //preguntamos si los datos ingresados son iguales
                if (usuario.equals(usua) && contrasena.equals(pass)) {
                    //si son iguales entonces vamos a otra ventana
                    //Menu es una nueva actividad empty
                    Intent ven = new Intent(this, PrincipalMenu.class);
                    //lanzamos la actividad
                    startActivity(ven);
                    //limpiamos las las cajas de texto
                    et1.setText("");
                    et2.setText("");
                }
            }//si la primera condicion no cumple entonces que envie un mensaje toast
            else {
                Toast toast = Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG);
                //mostramos el toast
                toast.show();
            }

        } catch (Exception e) {//capturamos los errores que ubieran
            Toast toast = Toast.makeText(this, "Error" + e.getMessage(), Toast.LENGTH_LONG);
            //mostramos el mensaje
            toast.show();
        }
    }

    //metodo que nos envia a otra ventana
    public void RegistroData(View v) {
        //creamos una variables e instanciamos al intent para que me muestra la clase
        Intent rdata = new Intent(this, RegistroData.class);
        //lanzamos la actividad
        startActivity(rdata);
    }
}