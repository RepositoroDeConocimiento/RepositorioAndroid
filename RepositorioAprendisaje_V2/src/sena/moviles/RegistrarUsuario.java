package sena.moviles;

import sena.moviles.connection.RepositorioSQLiteHelper;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegistrarUsuario extends Activity {
	
	EditText cajaNombreUsuario;
	EditText cajaConstrasena1;
	EditText cajaConstrasena2;
	RadioButton radio_admin;
	RadioButton radio_basic;
	String perfil;
	String contrasena;
	String error;
	RepositorioSQLiteHelper usdbh;
	SQLiteDatabase  db;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_usuario);
		//Obtenemos la conexion
		// SQLiteDatabase db = new ConnectionSQLite().obtenerConexion();
        usdbh = new RepositorioSQLiteHelper(this, "DBRepositorioAprendizaje", null, 1);
        db= usdbh.getWritableDatabase();
        Toast.makeText(RegistrarUsuario.this, "valores en Categoria: "+Login.perfil+","+Login.usuario_cod, Toast.LENGTH_SHORT).show();
      
    }
	
	public void registrar(View view)
	{
			
        //Si hemos abierto correctamente la base de datos
        if(db != null)
        {
        	//usdbh.onUpgrade(db, 1, 2);
        	cajaNombreUsuario= (EditText) findViewById(R.id.campoNombreUsuario);
        	cajaConstrasena1= (EditText) findViewById(R.id.caja_password1);
        	cajaConstrasena2= (EditText) findViewById(R.id.caja_password2);
        	radio_admin= (RadioButton) findViewById(R.id.radio_admin);
        	radio_basic= (RadioButton) findViewById(R.id.radio_basico);
        	if (validaRegistro()) {
        		try {
            		db.execSQL("INSERT INTO Usuario (NomUsuario, Perfil,Password) " +
            	               "VALUES ('" + cajaNombreUsuario.getText().toString() + "', '" + perfil + "', '" + 
            				contrasena + "')");
    			} catch (Exception e) {
    				Toast.makeText(RegistrarUsuario.this, "No se pudo efectuar el registro.\n", Toast.LENGTH_SHORT).show();
    				Toast.makeText(RegistrarUsuario.this, e.getMessage(), Toast.LENGTH_SHORT).show();
    			}
			}
        	
        	
        	
         		    		 
    		 Toast.makeText(RegistrarUsuario.this, "despues del registro : codigoUsuario "+Login.usuario_cod, Toast.LENGTH_SHORT).show();
    		 //se cierra la BD
            
        }
        
	}
	
	private boolean validaRegistro() {
		boolean validadorContrasena=false;
		boolean validadorPerfil=false;
		if (cajaConstrasena1.getText().toString().equals(cajaConstrasena2.getText().toString())) {
			contrasena=cajaConstrasena1.getText().toString();
			validadorContrasena=true;
		}else{
			validadorContrasena=false;
			error="No se pudo registrar, Verifique la contraseña";
		}
		
		if (radio_admin.isChecked()==true || radio_basic.isChecked()==true) {
			validadorPerfil=true;
			if (radio_admin.isChecked()==true) {
				perfil="administrador";
			}else{
				perfil="basico";
			}
		}else{
			error="No se pudo registrar, Verifique que haya seleccionado un perfil";
		}
		
		if (validadorPerfil && validadorContrasena) {
			return true;
		}else{
			return false;
		}
		
	}

	public void cerrar(View view) {
    	finish();
    	db.close();
    }

}
