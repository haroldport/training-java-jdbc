package com.arquitecturajava.ejemplo003;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/curso";

		try (Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "123");
				PreparedStatement sentencia = generarConsultaParametrizada("select * from persona where nombre = ?", 
						"Harold", conexion);
				ResultSet rs = sentencia.executeQuery();
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
	
	private static PreparedStatement generarConsultaParametrizada(String sql, String nombre, Connection conexion) 
			throws SQLException {
		PreparedStatement consultaParametrizada = conexion.prepareStatement(sql);
		consultaParametrizada.setString(1, nombre);
		return consultaParametrizada;
	}

}
