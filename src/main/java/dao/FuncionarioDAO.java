package dao;

import model.Funcionario;
import utils.ConexionDB;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
  private static final String SQL_SELECTED_ALL = "SELECT * FROM funcionarios";
  private static final String SQL_SELECT_BY_ID = "SELECT * FROM funcionarios WHERE funcionario_ID = ?";
  private static final String SQL_UPDATE_BY_ID = "UPDATE funcionarios SET " +
          "tipo_documento_ID = ?," +
          "no_identificacion = ?," +
          "nombres = ?," +
          "apellidos = ?," +
          "estado_civil_ID = ?," +
          "sexo_ID = ?," +
          "direccion = ?," +
          "telefono = ?," +
          "fecha_nacimiento = ?" +
          " WHERE funcionario_ID = ?";
  private static final String SQL_DELETE_BY_ID = "DELETE FROM funcionarios WHERE funcionario_ID = ?";
  private static final String SQL_SELECT_BY_ID_JOIN = "SELECT funcionarios.funcionario_ID, tipo_documento.tipo_documento, funcionarios.no_identificacion, funcionarios.nombres, funcionarios.apellidos, estado_civil.estado_civil, sexo.sexo,funcionarios.direccion, funcionarios.telefono, funcionarios.fecha_nacimiento " +
          "FROM (((funcionarios " +
          "INNER JOIN tipo_documento ON funcionarios.tipo_documento_ID = tipo_documento.tipo_documento_ID)" +
          "INNER JOIN estado_civil ON funcionarios.estado_civil_ID = estado_civil.estado_civil_ID)" +
          "INNER JOIN sexo ON funcionarios.sexo_ID = sexo.sexo_ID)" +
          "WHERE funcionario_ID = ?";

  public void guardarFuncionario (Funcionario funcionario) throws SQLException{
    try(Connection con = ConexionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(SQL_INSERT)){
        preparacionValoresStmt(funcionario, stmt);
        int funcionarioSubido = stmt.executeUpdate();
    }
  }

  public void  editarFuncionario (Funcionario funcionario) throws SQLException{
    try(Connection con = ConexionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(SQL_UPDATE_BY_ID)){
      preparacionValoresStmt(funcionario,stmt);
      stmt.setInt(10, funcionario.getFuncionario_ID());
      int funcionarioActualizado = stmt.executeUpdate();
    }
  }

  public void eliminarFuncionario (Funcionario funcionario) throws SQLException{
    try(Connection con = ConexionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(SQL_DELETE_BY_ID)){
      stmt.setInt(1, funcionario.getFuncionario_ID());
      int funcionarioEliminado = stmt.executeUpdate();
    }
  }

  public final List<Funcionario> seleccionarTodos() throws SQLException{
    List<Funcionario> listadoFuncionarios = new ArrayList<>();

    try(Connection con = ConexionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(SQL_SELECTED_ALL);
        ResultSet rs = stmt.executeQuery()){
      while (rs.next()){
        listadoFuncionarios.add(crearFuncionario(rs));
      }
    }
    return listadoFuncionarios;
  }

  public final List<String> seleccionarFuncionario(int id) throws SQLException{
    List<String> datosFuncionarios = new ArrayList<>();
    try(Connection con = ConexionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(SQL_SELECT_BY_ID_JOIN)){
        stmt.setInt(1,id);
        try(ResultSet rs = stmt.executeQuery()){
          if (rs.next()){
            datosFuncionarios.add(rs.getString("tipo_documento").toUpperCase());
            datosFuncionarios.add(rs.getString("no_identificacion"));
            datosFuncionarios.add(rs.getString("nombres"));
            datosFuncionarios.add(rs.getString("apellidos"));
            datosFuncionarios.add(rs.getString("estado_civil").toUpperCase());
            datosFuncionarios.add(rs.getString("sexo").toUpperCase());
            datosFuncionarios.add(rs.getString("telefono"));
            datosFuncionarios.add(rs.getString("direccion").toUpperCase());
            datosFuncionarios.add(rs.getObject("fecha_nacimiento", LocalDate.class).toString());
            datosFuncionarios.add(rs.getString("funcionario_ID"));
          }
        }
    }
    return datosFuncionarios;
  }


  public final Funcionario crearFuncionario(ResultSet rs) throws SQLException{
    int id= rs.getInt("funcionario_ID");
    String nombres = rs.getString("nombres");
    String apellidos = rs.getString("apellidos");
    String noIdentificacion = rs.getString("no_identificacion");
    int tipoIdentificacion = rs.getInt("tipo_documento_ID");
    int estadoCivil = rs.getInt("estado_civil_ID");
    int sexo = rs.getInt("sexo_ID");
    String telefono = rs.getString("telefono");
    String direccion = rs.getString("direccion");
    LocalDate fechaNacimiento = rs.getObject("fecha_nacimiento", LocalDate.class);
    Funcionario funcionario = new Funcionario(id,tipoIdentificacion,noIdentificacion,nombres,apellidos,estadoCivil,sexo,direccion,telefono,fechaNacimiento);

    return funcionario;
  }

  public final PreparedStatement preparacionValoresStmt(Funcionario funcionario, PreparedStatement stmt) throws SQLException{
    stmt.setInt(1, funcionario.getTipo_documento_ID());
    stmt.setString(2, funcionario.getNo_identificacion());
    stmt.setString(3, funcionario.getNombres());
    stmt.setString(4, funcionario.getApellidos());
    stmt.setInt(5, funcionario.getEstado_civil_ID());
    stmt.setInt(6, funcionario.getSexo_ID());
    stmt.setString(7, funcionario.getDireccion());
    stmt.setString(8, funcionario.getTelefono());
    stmt.setDate(9, Date.valueOf(funcionario.getFecha_nacimiento()));
    return stmt;
  }

}
