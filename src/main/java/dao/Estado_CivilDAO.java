package dao;

import model.Estado_Civil;
import utils.SQL_Helps;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Estado_CivilDAO extends CatalogoDAO {

  public Estado_CivilDAO(){
    super(new SQL_Helps().SQL_SELECT_ALL("estado_civil"));
  }

  @Override
  protected Object crearEntidadDesdeResult(ResultSet rs) throws SQLException {
    int id= rs.getInt("estado_civil_ID");
    String estado_civil_nombre = rs.getString("estado_civil").toUpperCase();
    return new Estado_Civil(id,estado_civil_nombre);
  }
}
