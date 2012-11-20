package sena.moviles;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
/**
 * Clase encargada de mostrar la información global del proyecto
 * @author Diego
 *
 */
public class AcercaDe extends Activity {

	
	 /**
	  * metodo que crea la actividad
	  */
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.acerca_de);
	        inicializaTexto();
	    }
	 
	 private void inicializaTexto() {
		 TextView cadena= (TextView) findViewById(R.id.areaIntroduccion);
		 String texto="El repositorio de Conocimiento es un sistema que permite " +
		 		"almacenar informaci�n sobre posibles errores o falencias en " +
		 		"torno a un �rea o categor�a en especifico, desde la cual se " +
		 		"puede consultar las soluciones o pasos a seguir comunes para " +
		 		"diferentes usuarios con el fin de contrarrestar dichos " +
		 		"inconvenientes. ";
		 texto+="El repositorio de Conocimiento es un sistema que permite " +
			 		"almacenar informaci�n sobre posibles errores o falencias en " +
			 		"torno a un �rea o categor�a en especifico, desde la cual se " +
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
 /**
  * Metodo encargado de finalizar el proyecto
  * @param view
  */
	public void cerrar(View view) {
	    	finish();
	    }
}
