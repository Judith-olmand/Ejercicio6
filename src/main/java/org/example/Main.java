package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()); Statement statement = conn.createStatement()){
            System.out.println("Conexión establecida con Oracle.");
            String sql = "DELETE FROM empleado WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 10);
            int filasEliminadas = ps.executeUpdate();
            System.out.println("Empleado eliminado con éxito" + filasEliminadas);

        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}