package sena.moviles.connection;

import java.util.Iterator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
 
public class RepositorioSQLiteHelper extends SQLiteOpenHelper {
 
    public RepositorioSQLiteHelper(Context contexto, String nombre,
                               CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
 
    @SuppressWarnings("rawtypes")
    public void onCreate(SQLiteDatabase db) {
    	//verificar el llenado de las tablas
    	ConnectionSQLite constantes=new ConnectionSQLite();
    	Iterator iterator=constantes.sentencias.iterator();
    	
    	while (iterator.hasNext()) {
    		db.execSQL(iterator.next().toString());	
		}
    }
 
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.
 
        //Se elimina la versión anterior de la tabla
       // db.execSQL("DROP TABLE IF EXISTS categoria");
 
        //Se crea la nueva versión de la tabla
        //db.execSQL(sqlCreateCategoria);
    }
}
