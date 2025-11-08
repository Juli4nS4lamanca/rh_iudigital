package dao;

import model.Funcionario;
import utils.ConexionDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {

  private static final String SQL_INSERT = "INSERT INTO funcionarios " +
          "(tipo_documento_ID," +
          "no_identificacion," +
          "nombres," +
          "apellidos," +
          "estado_civil_ID," +
          "sexo_ID," +
          "direccion," +
          "telefono," +
          "fecha_nacimiento" +
          ") VALUES (?,?,?,?,?,?,?,?,?)";

  public void guardarFuncionario (Funcionario funcionario) throws SQLException{
    try(Connection con = ConexionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(SQL_INSERT)){
        stmt.setInt(1, funcionario.getTipo_documento_ID());
        stmt.setString(2, funcionario.getNo_identificacion());
        stmt.setString(3, funcionario.getNombres());
        stmt.setString(4, funcionario.getApellidos());
        stmt.setInt(5, funcionario.getEstado_civil_ID());
        stmt.setInt(6, funcionario.getSexo_ID());
        stmt.setString(7, funcionario.getDireccion());
        stmt.setString(8, funcionario.getTelefono());
        stmt.setDate(9, Date.valueOf(funcionario.getFecha_nacimiento()));

        int funcionarioSubido = stmt.executeUpdate();
    }
  }

}
