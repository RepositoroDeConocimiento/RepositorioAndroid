package sena.moviles;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class RegistrarCategoria extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_categoria);
       
    }
	
	public void cerrar(View view) {
    	finish();
    }

}
