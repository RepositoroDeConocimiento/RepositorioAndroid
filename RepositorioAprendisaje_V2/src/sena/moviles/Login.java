package sena.moviles;

import sena.moviles.connection.RepositorioSQLiteHelper;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Login extends Activity {

	Spinner comboRoles;
	EditText cajaPass;
	public static String perfil;
	public static Integer usuario_cod;
	
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	        cajaPass= (EditText) findViewById(R.id.cajaPassword);
	        inicializaCombo();
			
	    }
	 
	private void inicializaCombo() {
		 comboRoles= (Spinner) findViewById(R.id.comboLogin);
		 comboRoles.setOnItemSelectedListener(new OnItemSelectedListener() 
	        {
				//@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					//Toast.makeText(Login.this, comboRoles.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
					if (comboRoles.getSelectedItemPosition()==1) {
						Toast.makeText(Login.this, comboRoles.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
						cajaPass.setVisibility(View.VISIBLE);
					}else{
						cajaPass.setVisibility(View.INVISIBLE);
					}

					//
				}

				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
	        	
			}
	        );
	}

	public void cancelar(View view) {
	    	finish();
	    }
	
	public void iniciar(View view){
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(this, VentanaPrincipal.class));
		obtienePerfil(cajaPass.getText().toString()); 
		if (comboRoles.getSelectedItemPosition()!=0) {
			if (comboRoles.getSelectedItemPosition()==1) {
				if (cajaPass.getText().toString().equals("admin")) {
					intent.putExtra("VentanaPrincipal", perfil);
					startActivity(intent);
				}else{
					Toast.makeText(Login.this, "Debe Ingresar Una Contraseña Valida", Toast.LENGTH_SHORT).show();
				}
			}else{
				
				intent.putExtra("VentanaPrincipal", "Usuario");
				startActivity(intent);
			}
			
		}else{
			Toast.makeText(Login.this, "Debe Seleccionar un Tipo de Usuario", Toast.LENGTH_SHORT).show();
		}
				
	}

	 @SuppressWarnings("unused")
	private void obtienePerfil(String contrsena) {
		 String pass="";
		if (contrsena!=null && !contrsena.equals("")) {
			
		 	 	System.out.println("Antes");
		        RepositorioSQLiteHelper usdbh =
			            new RepositorioSQLiteHelper(this, "DBRepositorioAprendizaje", null, 1);
		        SQLiteDatabase  db= usdbh.getWritableDatabase();
	        System.out.println("Despues");
	        String[] args = new String[] {contrsena};
	        Cursor c = db.rawQuery(" SELECT NomUsuario,Password,idUsuario FROM Usuario WHERE Password= ? ", args);
	        String usuario="";
	        String contr="";
	        String codigo="";
	      //Nos aseguramos de que existe al menos un registro
	      if (c.moveToFirst()) {
	           //Recorremos el cursor hasta que no haya más registros
	           do {
	        	     usuario = c.getString(0);
	                 contr = c.getString(1);
	                 codigo=c.getString(2); 
	           } while(c.moveToNext());
	      }
	      Toast.makeText(Login.this, "Usuario y contraseña obtenidos: "+usuario+" "+contr, Toast.LENGTH_SHORT).show();
	        perfil=usuario;
	        usuario_cod=Integer.parseInt(codigo);
	        db.close();
		}
		else{
			perfil="Basico";
	        usuario_cod=0;
		}
	}

}
