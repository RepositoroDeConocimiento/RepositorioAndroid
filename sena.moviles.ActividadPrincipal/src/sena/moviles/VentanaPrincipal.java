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
    }


    public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.menu_principal, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	
	public boolean onOptionsItemSelected(MenuItem item){
		
		switch (item.getItemId()) {
		case R.id.itemCategorias:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Categorias", Toast.LENGTH_SHORT).show();
			break;
		case R.id.itemTemas:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Temas", Toast.LENGTH_SHORT).show();
			break;
		case R.id.itemConsultar:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Consultar", Toast.LENGTH_SHORT).show();
			break;
		case R.id.subItemCrearCategoria:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Crear Categoria", Toast.LENGTH_SHORT).show();
			 Intent i = new Intent(this, RegistrarCategoria.class );
		     startActivity(i);
			break;
		case R.id.subItemGestionarCategoria:
			Toast.makeText(VentanaPrincipal.this, "Selecciono Gestionar Categoria", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
		
	}

}
