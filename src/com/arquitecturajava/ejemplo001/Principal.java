package com.arquitecturajava.ejemplo001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		
		Connection conexion = null;
		Statement sentencia = null;
		
		try {
			//registra el driver de mysql
			//podriamos tener mas drivers instalados
			Class.forName("com.mysql.jdbc.Driver");
			String cadenaConexion = "jdbc:mysql://localhost:3306/curso";
			conexion = DriverManager.getConnection(cadenaConexion, "root", "123");
			sentencia = conexion.createStatement();
			sentencia.executeUpdate("insert into persona (nombre, apellidos, edad) "
					+ "values ('Harold', 'Portocarrero', 25)");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(sentencia != null) {
					sentencia.close();
				}
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
