package sena.moviles.connection;

import java.util.Iterator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
 
public class RepositorioSQLiteHelper extends SQLiteOpenHelper {
 
    //Sentencia SQL para crear la tabla de Usuarios
	String sqlCreateUsuarios = "CREATE TABLE usuario (id_usuario INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, password TEXT)";
	String sqlCreateCategoria = "CREATE TABLE categoria (id_categoria INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT)";
	String insertAdmin="INSERT INTO usuario (nombre,password) values ('Administrador','admin')";
    public RepositorioSQLiteHelper(Context contexto, String nombre,
                               CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
    	//db.execSQL(sqlCreateUsuarios);
    	//db.execSQL(sqlCreateCategoria);
    	//db.execSQL(insertAdmin);
    	//verificar el llenado de las tablas
    	ConstantesSQLite constantes=new ConstantesSQLite();
    	
    	Iterator iterator=constantes.sentencias.iterator();
    	
    	while (iterator.hasNext()) {
    		db.execSQL(iterator.next().toString());	
		}
    	
    }
 
    @Override
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
