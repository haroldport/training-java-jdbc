package com.arquitecturajava.ejemplo005;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/curso";

		try (Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "123");
				Statement sentencia = conexion.createStatement();) {
			conexion.setAutoCommit(false);
			//a partir de ahora se ejecuta de forma transaccional
			sentencia.executeUpdate("insert into persona (nombre, apellidos, edad) " + "values ('Lorena', 'Oyola', 25)");
			sentencia.executeUpdate("insert into persona (nombre, apellidos, edad) " + "values ('Carlos', 'Loyola', 29)");
			sentencia.executeUpdate("insert into persona (nombre, apellidos, edad) " + "values ('Pablo', 'Caicedo', 32)");
			sentencia.executeUpdate("insert into persona (nombre, apellidos, edad) " + "values ('Fernando', 'Portocarrero', 31)");
			conexion.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
