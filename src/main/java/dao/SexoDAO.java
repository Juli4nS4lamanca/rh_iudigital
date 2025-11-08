package dao;

import model.Sexo;
import utils.SQL_Helps;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SexoDAO extends CatalogoDAO {

  public SexoDAO(){
    super(new SQL_Helps().SQL_SELECT_ALL("sexo"));
  }

  @Override
  protected Sexo crearEntidadDesdeResult(ResultSet rs) throws SQLException {
    int id= rs.getInt("sexo_ID");
    String tipo_sexo = rs.getString("sexo").toUpperCase();
    return new Sexo(id, tipo_sexo);
  }

}
