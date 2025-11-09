package dao;

import model.Rol;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolFamiliarDAO extends CatalogoDAO<Rol> {

  public RolFamiliarDAO(){
    super("SELECT rol_familiar_ID, rol_familiar FROM rol_familiar");
  }

  @Override
  protected Rol crearEntidadDesdeResult(ResultSet rs) throws SQLException {
    int id = rs.getInt("rol_familiar_ID");
    String rol_nombre = rs.getString("rol_familiar").toUpperCase();
    return new Rol(id, rol_nombre);
  }
}

