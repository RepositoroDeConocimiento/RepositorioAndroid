package sena.moviles;

import java.util.ArrayList;
import java.util.HashMap;

import sena.moviles.connection.RepositorioSQLiteHelper;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrarSubCategoria extends Activity {
	
	EditText cajaNom;
	EditText cajaDescripcion;
	Spinner combo_Categorias;
	RepositorioSQLiteHelper usdbh;
	SQLiteDatabase  db;
	
    HashMap<String, String> categorias=new HashMap<String, String>();
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_categoria);
		//Obtenemos la conexion
		// SQLiteDatabase db = new ConnectionSQLite().obtenerConexion();
        usdbh = new RepositorioSQLiteHelper(this, "DBRepositorioAprendizaje", null, 1);
        db= usdbh.getWritableDatabase();
        Toast.makeText(RegistrarSubCategoria.this, "valores: "+Login.perfil+","+Login.usuario_cod, Toast.LENGTH_SHORT).show();
       inicializaCombo();
    }
	
	private void inicializaCombo() {

        ArrayList<String> nombresCategoria=new ArrayList<String>();
		combo_Categorias = (Spinner) findViewById (R.id.comboCategorias);
                
        Cursor c = db.rawQuery(" SELECT idcategoria,nomcategoria FROM categoria ", null);
        
        String id=""; String nombre="";
      //Nos aseguramos de que existe al menos un registro
      if (c.moveToFirst()) {
           //Recorremos el cursor hasta que no haya más registros
           do {
                 id = c.getString(0);
                 nombre = c.getString(1);
         		 categorias.put(nombre, id);
         		 nombresCategoria.add(nombre);
           } while(c.moveToNext());
      }

        ArrayAdapter<String> combo = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, nombresCategoria);
        combo_Categorias.setAdapter(combo);
	}

	public void registrar(View view)
	{
		String codigoCat=categorias.get(combo_Categorias.getSelectedItem().toString());
		
		
        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
        	//usdbh.onUpgrade(db, 1, 2);
        	cajaNom= (EditText) findViewById(R.id.campoNombre);
        	cajaDescripcion= (EditText) findViewById(R.id.areaDescripcion);
        	try {
        		db.execSQL("INSERT INTO SubCategoria (NomSubCategoria, Descripcion,Categoria,Usuario) " +
        	               "VALUES ('" + cajaNom.getText().toString() + "', '" + cajaDescripcion.getText().toString() + "', '" + 
        	               codigoCat + "', '" + Login.usuario_cod + "')");
			} catch (Exception e) {
				Toast.makeText(RegistrarSubCategoria.this, "No se pudo efectuar el registro.\n verifique que la categoria no exista", Toast.LENGTH_SHORT).show();
				Toast.makeText(RegistrarSubCategoria.this, e.getMessage(), Toast.LENGTH_SHORT).show();
			}
        	
        	
         		    		 
    		 Toast.makeText(RegistrarSubCategoria.this, "despues del registro : "+combo_Categorias.getSelectedItem().toString()+", CodigoCat: "+codigoCat+" ,codigoUsuario "+Login.usuario_cod, Toast.LENGTH_SHORT).show();
    		 //se cierra la BD
            
        }
        
	}
	
	public void cerrar(View view) {
    	finish();
    	db.close();
    }

}
