package dao;

import utils.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class CatalogoDAO<T> {

  protected final String SQL_SELECTED_ALL;

  public CatalogoDAO(String sqlSelectAll){
    this.SQL_SELECTED_ALL = sqlSelectAll;
  }

  public final List<T> seleccionarTodos() throws SQLException{
    List<T> listadoObjetos = new ArrayList<>();

    try(Connection con = ConexionDB.getConnection();
        PreparedStatement stmt = con.prepareStatement(SQL_SELECTED_ALL);
        ResultSet rs = stmt.executeQuery()){
      while (rs.next()){
        T entidad = crearEntidadDesdeResult(rs);
        listadoObjetos.add(entidad);
      }
    }
    return listadoObjetos;
  }

  protected abstract T crearEntidadDesdeResult(ResultSet rs) throws SQLException;
}
