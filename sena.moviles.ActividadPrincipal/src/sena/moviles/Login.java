package sena.moviles;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
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
		if (comboRoles.getSelectedItemPosition()!=0) {
			if (comboRoles.getSelectedItemPosition()==1) {
				if (cajaPass.getText().toString().equals("admin")) {
					intent.putExtra("VentanaPrincipal", "Administrador");
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

}
