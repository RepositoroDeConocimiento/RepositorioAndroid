package sena.moviles;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class ActividadPrincipal extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
    }

    
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actividad_principal, menu);
        return true;
    }
    
    public void lanzar(View view) {
        Intent i = new Intent(this, AcercaDe.class );
        startActivity(i);
  }
    
    public void iniciarSesion(View view){
    	Intent i = new Intent(this, Login.class );
        startActivity(i);
    }
    
}
