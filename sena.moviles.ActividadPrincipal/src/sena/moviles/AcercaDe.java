package sena.moviles;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AcercaDe extends Activity {

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.acerca_de);
	        inicializaTexto();
	    }
	 
	 private void inicializaTexto() {
		 TextView cadena= (TextView) findViewById(R.id.areaIntroduccion);
		 String texto="El repositorio de Conocimiento es un sistema que permite " +
		 		"almacenar información sobre posibles errores o falencias en " +
		 		"torno a un área o categoría en especifico, desde la cual se " +
		 		"puede consultar las soluciones o pasos a seguir comunes para " +
		 		"diferentes usuarios con el fin de contrarrestar dichos " +
		 		"inconvenientes. ";
		 texto+="El repositorio de Conocimiento es un sistema que permite " +
			 		"almacenar información sobre posibles errores o falencias en " +
			 		"torno a un área o categoría en especifico, desde la cual se " +
			 		"puede consultar las soluciones o pasos a seguir comunes para " +
			 		"diferentes usuarios con el fin de contrarrestar dichos " +
			 		"inconvenientes.\n \n";
		 
		 texto+="Aqui podemos ver mas texto Aqui podemos ver mas texto " +
		 		"Aqui podemos ver mas texto Aqui podemos ver mas texto " +
		 		"Aqui podemos ver mas texto Aqui podemos ver mas texto " +
		 		"Aqui podemos ver mas texto Aqui podemos ver mas texto " +
		 		"Aqui podemos ver mas texto Aqui podemos ver mas texto  ";
		 
	     cadena.setText(texto);
	}

	public void cerrar(View view) {
	    	finish();
	    }
}
