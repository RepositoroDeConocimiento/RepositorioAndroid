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

public class RegistrarTema extends Activity {

	EditText cajaNom;
	EditText cajaProblema;
	EditText cajaSolucion;
	Spinner combo_SubCategorias;
	RepositorioSQLiteHelper usdbh;
	SQLiteDatabase  db;
	HashMap<String, String> subCategorias=new HashMap<String, String>();
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_tema);
        usdbh = new RepositorioSQLiteHelper(this, "DBRepositorioAprendizaje", null, 1);
        db= usdbh.getWritableDatabase();
       inicializaCombo();
    }
	
	private void inicializaCombo() {
		ArrayList<String> nombresSubCategoria=new ArrayList<String>();
		 Cursor c = db.rawQuery("SELECT idsubcategoria,nomsubcategoria FROM subcategoria ", null);
		 combo_SubCategorias = (Spinner) findViewById (R.id.comboSubCategorias);
	        String id=""; String nombre="";
	      //Nos aseguramos de que existe al menos un registro
	      if (c.moveToFirst()) {
	           //Recorremos el cursor hasta que no haya más registros
	           do {
	                 id = c.getString(0);
	                 nombre = c.getString(1);
	                 subCategorias.put(nombre, id);
	         		 nombresSubCategoria.add(nombre);
	           } while(c.moveToNext());
	      }

	        ArrayAdapter<String> combo = new ArrayAdapter<String>(
	                this, android.R.layout.simple_spinner_item, nombresSubCategoria);
	        combo_SubCategorias.setAdapter(combo);
    }
		
	public void registrar(View view)
	{
		String codigoSubCat=subCategorias.get(combo_SubCategorias.getSelectedItem().toString());
				
        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
        	//usdbh.onUpgrade(db, 1, 2);
        	cajaNom= (EditText) findViewById(R.id.campoNombreTema);
        	cajaProblema= (EditText) findViewById(R.id.areaProblema);
        	cajaSolucion= (EditText) findViewById(R.id.areaSolucionTema);
        	
        	try {
        		db.execSQL("INSERT INTO Tema (NomTema,DescTema,SoluTema,SubCategoria,Usuario) " +
        	               "VALUES ('" + cajaNom.getText().toString() + "', '" + cajaProblema.getText().toString() + "', '" +  
        				cajaSolucion.getText().toString() + "', '" + codigoSubCat + "', '" + Login.usuario_cod + "')");
        		
			} catch (Exception e) {
				Toast.makeText(RegistrarTema.this, "No se pudo efectuar el registro.", Toast.LENGTH_SHORT).show();
				Toast.makeText(RegistrarTema.this, e.getMessage(), Toast.LENGTH_LONG).show();
			}
        	
        	
         		    		 
    		 Toast.makeText(RegistrarTema.this, "despues del registro : "+combo_SubCategorias.getSelectedItem().toString()+", CodigoCat: "+codigoSubCat+" ,codigoUsuario "+Login.usuario_cod, Toast.LENGTH_LONG).show();
    		 //se cierra la BD
            
        }
        
	}
	
	public void cerrar(View view) {
    	finish();
    }
	
}
