package sena.moviles;

import sena.moviles.connection.RepositorioSQLiteHelper;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarCategoria extends Activity {
	
	EditText cajaNom;
	EditText cajaDescripcion;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_categoria);
       
    }
	
	public void registrar(View view)
	{
		 //Abrimos la base de datos 'DBUsuarios' en modo escritura
        RepositorioSQLiteHelper usdbh =
	            new RepositorioSQLiteHelper(this, "DBRepositorioAprendizaje", null, 1);
 
        SQLiteDatabase db = usdbh.getWritableDatabase();
        //almacenarRegistros(db,);
 
        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
        	//usdbh.onUpgrade(db, 1, 2);
        	cajaNom= (EditText) findViewById(R.id.campoNombre);
        	cajaDescripcion= (EditText) findViewById(R.id.areaDescripcion);
        	int documento=0;
        	        	
        	documento=Integer.parseInt("23");
        	db.execSQL("INSERT INTO categoria (nombre, descripcion) " +
               "VALUES ('" + cajaNom.getText().toString() + "', '" + 
        			cajaDescripcion.getText().toString() + "')");
        	
         		    		 
    		 Toast.makeText(RegistrarCategoria.this, "despues del registro", Toast.LENGTH_SHORT).show();
    		 //se cierra la BD
            db.close();
        }
        
	}
	
	public void cerrar(View view) {
    	finish();
    }

}
