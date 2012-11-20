package sena.moviles;

import java.util.HashMap;

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
	RepositorioSQLiteHelper usdbh;
	SQLiteDatabase  db;
	
    HashMap<String, String> categorias=new HashMap<String, String>();
	
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_categoria_ppal);
		//Obtenemos la conexion
		// SQLiteDatabase db = new ConnectionSQLite().obtenerConexion();
        usdbh = new RepositorioSQLiteHelper(this, "DBRepositorioAprendizaje", null, 1);
        db= usdbh.getWritableDatabase();
        Toast.makeText(RegistrarCategoria.this, "valores en Categoria: "+Login.perfil+","+Login.usuario_cod, Toast.LENGTH_SHORT).show();
      
    }
	
	public void registrar(View view)
	{
			
        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
        	//usdbh.onUpgrade(db, 1, 2);
        	cajaNom= (EditText) findViewById(R.id.campoNombreCategoria);
        	cajaDescripcion= (EditText) findViewById(R.id.areaDescripcionCategoria);
        	try {
        		db.execSQL("INSERT INTO Categoria (NomCategoria, DesCategoria,Usuario) " +
        	               "VALUES ('" + cajaNom.getText().toString() + "', '" + cajaDescripcion.getText().toString() + "', '" + 
        				Login.usuario_cod + "')");
			} catch (Exception e) {
				Toast.makeText(RegistrarCategoria.this, "No se pudo efectuar el registro.\n", Toast.LENGTH_SHORT).show();
				Toast.makeText(RegistrarCategoria.this, e.getMessage(), Toast.LENGTH_SHORT).show();
			}
        	
        	
         		    		 
    		 Toast.makeText(RegistrarCategoria.this, "despues del registro : codigoUsuario "+Login.usuario_cod, Toast.LENGTH_SHORT).show();
    		 //se cierra la BD
            
        }
        
	}
	
	public void cerrar(View view) {
    	finish();
    	db.close();
    }

}
