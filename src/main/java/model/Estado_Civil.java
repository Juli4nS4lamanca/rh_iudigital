package model;

public class Estado_Civil implements ObtenerID {
  private int estado_Civil_ID;
  private String estado_Civil;

  public Estado_Civil(int estado_Civil_ID, String estado_Civil) {
    this.estado_Civil_ID = estado_Civil_ID;
    this.estado_Civil = estado_Civil;
  }

  public Estado_Civil() {
  }

  public int getEstado_Civil_ID() {
    return estado_Civil_ID;
  }

  public void setEstado_Civil_ID(int estado_Civil_ID) {
    this.estado_Civil_ID = estado_Civil_ID;
  }

  public String getEstado_Civil() {
    return estado_Civil;
  }

  public void setEstado_Civil(String estado_Civil) {
    this.estado_Civil = estado_Civil;
  }

  @Override
  public String toString(){
    return estado_Civil;
  }

  @Override
  public int getId(){
    return estado_Civil_ID;
  }
}
