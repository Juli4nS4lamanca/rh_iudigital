package model;

public class Rol {
  private int rol_ID;
  private String rol_nombre;

  public Rol(int rol_ID, String rol_name) {
    this.rol_ID = rol_ID;
    this.rol_nombre = rol_nombre;
  }

  public Rol() {
  }

  public int getRol_ID() {
    return rol_ID;
  }

  public void setRol_ID(int rol_ID) {
    this.rol_ID = rol_ID;
  }

  public String getRol_name() {
    return rol_nombre;
  }

  public void setRol_name(String rol_nombre) {
    this.rol_nombre = rol_nombre;
  }
}
