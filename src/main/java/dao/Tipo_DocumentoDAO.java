package dao;

import model.Tipo_Documento;
import utils.SQL_Helps;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tipo_DocumentoDAO extends CatalogoDAO {

  public Tipo_DocumentoDAO() {
    super(new SQL_Helps().SQL_SELECT_ALL("tipo_documento"));
  }

  @Override
  protected Tipo_Documento crearEntidadDesdeResult(ResultSet rs) throws SQLException {
    int id = rs.getInt("tipo_documento_ID");
    String tipo_documento_nombre = rs.getString("tipo_documento").toUpperCase();
    return new Tipo_Documento(id, tipo_documento_nombre);
  }

}
