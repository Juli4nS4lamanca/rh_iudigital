package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

  private static final String URL = "jdbc:mysql://localhost:3306/rh_iudigital";
  private static final String USUARIO = "rh_user_root";
  private static final String CONTRASENA = "rh_root123";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
  }
}
