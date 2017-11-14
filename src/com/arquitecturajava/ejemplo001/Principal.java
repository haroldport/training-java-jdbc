package com.arquitecturajava.ejemplo001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		
		try {
			//registra el driver de mysql
			//podriamos tener mas drivers instalados
			Class.forName("com.mysql.jdbc.Driver");
			String cadenaConexion = "jdbc:mysql://localhost:3306/curso";
			Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "123");
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("insert into persona (nombre, apellidos, edad) "
					+ "values ('Harold', 'Portocarrero', 25)");
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
