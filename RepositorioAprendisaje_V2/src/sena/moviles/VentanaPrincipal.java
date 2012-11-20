package sena.moviles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class VentanaPrincipal extends Activity {
	
	TextView rol;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_principal);
        rol= (TextView) findViewById(R.id.rolIngresado);
        Bundle bundle= getIntent().getExtras();
        rol.setText(bundle.getString("VentanaPrincipal").toString());
        
        Toast.makeText(VentanaPrincipal.this, "valores: "+Login.perfil+","+Login.usuario_cod, Toast.LENGTH_SHORT).show();
    }

	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.menu_principal, menu);
		return super.onCreateOptionsMenu(menu);
	}
	

	
	public boolean onOptionsItemSelected(MenuItem item){
		
		switch (item.getItemId()) {
		case R.id.itemRegistrar:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Categorias", Toast.LENGTH_SHORT).show();
			break;
		case R.id.itemConsultar:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Consultar", Toast.LENGTH_SHORT).show();
			break;
		case R.id.itemRegistrarCategoria:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Crear Categoria", Toast.LENGTH_SHORT).show();
			 Intent l = new Intent(this, RegistrarCategoria.class );
		     startActivity(l);
			break;
		case R.id.itemRegistrarSubCategoria:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Gestionar Categoria", Toast.LENGTH_SHORT).show();
			 Intent i = new Intent(this, RegistrarSubCategoria.class );
		     startActivity(i);
			break;
		case R.id.itemRegistrarTema:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Crear Tema", Toast.LENGTH_SHORT).show();
			Intent k = new Intent(this, RegistrarTema.class );
		    startActivity(k);
			break;
		case R.id.itemRegistrarUsuario:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Crear Usuario", Toast.LENGTH_SHORT).show();
			Intent k1 = new Intent(this, RegistrarUsuario.class );
		    startActivity(k1);
			break;
		case R.id.itemConsultarCategoria:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Consultar Categoria", Toast.LENGTH_SHORT).show();
			Intent j = new Intent(this, ConsultarCategoria.class );
		    startActivity(j);
			break;
		case R.id.itemConsultarSubCategoria:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Consultar SubCategoria", Toast.LENGTH_SHORT).show();
			break;
		case R.id.itemConsultarTema:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Consultar Tema", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
		
	}

}
