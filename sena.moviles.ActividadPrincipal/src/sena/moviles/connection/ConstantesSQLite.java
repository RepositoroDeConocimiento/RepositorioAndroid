package sena.moviles.connection;

import java.util.ArrayList;

public class ConstantesSQLite {
	

	ArrayList<String> sentencias= new ArrayList<String>();
	

	String trig_insertCatUsu="CREATE TRIGGER InsertarCatUser BEFORE INSERT ON Categoria " +
			"BEGIN SELECT CASE WHEN ((SELECT Usuario.IdUsuario FROM Usuario WHERE Usuario.IdUsuario = NEW.Usuario ) ISNULL) " +
			"THEN RAISE(ABORT, 'Usuario Inexistente') END; END;";
	
	String trig_actuCatUsua="CREATE TRIGGER ActualizarCatUser BEFORE UPDATE ON Categoria " +
			"FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT Usuario.IdUsuario FROM Usuario WHERE Usuario.IdUsuario = NEW.Usuario ) " +
			"ISNULL) THEN RAISE(ABORT, 'Usuario Inexistente') END; END;";
	

	String trig_insertSubCatUse= "CREATE TRIGGER InsertarSubCatUser BEFORE INSERT ON SubCategoria BEGIN SELECT CASE WHEN " +
			"((SELECT Usuario.IdUsuario FROM Usuario WHERE Usuario.IdUsuario = NEW.Usuario ) ISNULL) THEN RAISE(ABORT," +
			" 'Usuario Inexistente') END; END;";

	String trig_actuSubCatUse="CREATE TRIGGER ActualizarSubCatUser BEFORE UPDATE ON SubCategoria FOR EACH ROW BEGIN SELECT " +
			"CASE WHEN ((SELECT Usuario.IdUsuario FROM Usuario WHERE Usuario.IdUsuario = NEW.Usuario ) ISNULL) " +
			"THEN RAISE(ABORT, 'Usuario Inexistente') END; END;";

	String trig_insertSubCatCat= "CREATE TRIGGER InsertarSubCatCat BEFORE INSERT ON SubCategoria BEGIN SELECT CASE WHEN " +
			"((SELECT Categoria.IdCategoria FROM Usuario WHERE Categoria.IdCategoria = NEW.Categoria) ISNULL) THEN RAISE(ABORT," +
			" 'Usuario Inexistente') END; END;";

	String trig_actuSubCatCat= "CREATE TRIGGER ActualizarSubCatCat BEFORE UPDATE ON SubCategoria FOR EACH ROW BEGIN SELECT CASE" +
			" WHEN ((SELECT Categoria.IdCategoria FROM Categoria WHERE Categoria.IdCategoria = NEW.Categoria) ISNULL)" +
			" THEN RAISE(ABORT, 'Categoria Inexistente') END; END;";

	String trig_insertTemaUser= "CREATE TRIGGER InsertarTemaUser BEFORE INSERT ON Tema BEGIN SELECT CASE WHEN ((SELECT " +
			"Usuario.IdUsuario FROM Usuario WHERE Usuario.IdUsuario = NEW.Usuario ) ISNULL) THEN RAISE(ABORT, " +
			"'Usuario Inexistente') END; END;";

	String trig_actTemaUser= "CREATE TRIGGER ActualizarTemaUser BEFORE UPDATE ON Tema FOR EACH ROW BEGIN SELECT CASE" +
			" WHEN ((SELECT Usuario.IdUsuario FROM Usuario WHERE Usuario.IdUsuario = NEW.Usuario ) ISNULL) THEN RAISE(ABORT," +
			" 'Usuario Inexistente') END; END;";

	String trig_insertTemaSubc= "CREATE TRIGGER InsertarTemaSubC BEFORE INSERT ON Tema BEGIN SELECT CASE WHEN ((SELECT" +
			" SubCategoria.IdSubCategoria FROM SubCategoria WHERE SubCategoria.IdSubCategoria = NEW.SubCategoria ) ISNULL)" +
			" THEN RAISE(ABORT, 'SubCategoria Inexistente') END; END;";

	String trig_actTemaSubc= "CREATE TRIGGER ActualizarTemaSubC BEFORE UPDATE ON Tema FOR EACH ROW BEGIN SELECT CASE WHEN" +
			" ((SELECT SubCategoria.IdSubCategoria FROM SubCategoria WHERE SubCategoria.IdSubCategoria = NEW.SubCategoria )" +
			" ISNULL) THEN RAISE(ABORT, 'SubCategoria Inexistente') END; END;"; 
	

String tCategoria= "CREATE TABLE Categoria (IdCategoria INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , NomCategoria CHAR NOT NULL , DesCategoria VARCHAR NOT NULL , Usuario INTEGER NOT NULL )";


String tSubCategoria="CREATE TABLE SubCategoria (IdSubCategoria INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , NomSubCategoria CHAR NOT NULL  UNIQUE , Descripcion VARCHAR NOT NULL  UNIQUE , Categoria INTEGER NOT NULL  UNIQUE , Usuario INTEGER NOT NULL  UNIQUE )";

String tTema= "CREATE TABLE Tema (IdTema INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , NomTema CHAR NOT NULL , DescTema VARCHAR NOT NULL , SoluTema VARCHAR NOT NULL , SubCategoria INTEGER NOT NULL , Usuario INTEGER NOT NULL )";

String tUsuario= "CREATE TABLE Usuario (IdUsuario INTEGER PRIMARY KEY  NOT NULL ,NomUsuario VARCHAR NOT NULL ,Perfil CHAR NOT NULL ,Password CHAR NOT NULL )";

String insertAdmin="INSERT INTO Usuario (NomUsuario,Perfil,Password) values ('Manager','administrador','admin')";

String insertBasico="INSERT INTO Usuario (NomUsuario,Perfil,Password) values ('Cristian','basico','123456')";

	public ConstantesSQLite() {
		sentencias.add(tCategoria);
		sentencias.add(tTema);
		sentencias.add(tUsuario);
		sentencias.add(tSubCategoria);
		sentencias.add(trig_actTemaSubc);
		sentencias.add(trig_actTemaUser);
		sentencias.add(trig_actuCatUsua);
		sentencias.add(trig_actuSubCatCat);
		sentencias.add(trig_actuSubCatUse);
		sentencias.add(trig_insertCatUsu);
		sentencias.add(trig_insertSubCatCat);
		sentencias.add(trig_insertSubCatUse);
		sentencias.add(trig_insertTemaSubc);
		sentencias.add(trig_insertTemaUser);
		sentencias.add(insertAdmin);
		sentencias.add(insertBasico);
		
	}
}
