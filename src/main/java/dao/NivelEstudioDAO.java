package dao;

import model.Nivel_Estudio;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NivelEstudioDAO extends CatalogoDAO<Nivel_Estudio> {

  public NivelEstudioDAO(){
    super("SELECT nivel_estudio_ID, nivel_estudio FROM nivel_estudio");
  }

  @Override
  protected Nivel_Estudio crearEntidadDesdeResult(ResultSet rs) throws SQLException {
    int id = rs.getInt("nivel_estudio_ID");
    String nivel_nombre = rs.getString("nivel_estudio").toUpperCase();
    return new Nivel_Estudio(id, nivel_nombre);
  }
}

