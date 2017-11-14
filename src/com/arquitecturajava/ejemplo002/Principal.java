package com.arquitecturajava.ejemplo002;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/curso";

		try (Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "123");
				Statement sentencia = conexion.createStatement();
				ResultSet rs = sentencia.executeQuery("select * from persona");
				) {
			while(rs.next()) {
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("apellidos"));
				System.out.println(rs.getInt("edad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
