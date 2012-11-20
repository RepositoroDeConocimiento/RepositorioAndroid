package sena.moviles;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ConsultarCategoria extends Activity {
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultar_categoria);
       
    }
	
    
	public void cerrar(View view) {
    	finish();
    }

}
