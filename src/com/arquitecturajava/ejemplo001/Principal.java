package com.arquitecturajava.ejemplo001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/curso";

		try (Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "123");
				Statement sentencia = conexion.createStatement();) {
			sentencia.executeUpdate("insert into persona (nombre, apellidos, edad) " + "values ('Pedro', 'Oyola', 25)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
