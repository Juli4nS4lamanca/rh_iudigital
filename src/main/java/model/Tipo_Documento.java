package model;

public class Tipo_Documento implements ObtenerID {
  private int tipo_Documento_ID;
  private String tipo_Documento;

  public Tipo_Documento(int tipo_Documento_ID, String tipo_Documento) {
    this.tipo_Documento_ID = tipo_Documento_ID;
    this.tipo_Documento = tipo_Documento;
  }

  public Tipo_Documento() {
  }

  public int getTipo_Documento_ID() {
    return tipo_Documento_ID;
  }

  public void setTipo_Documento_ID(int tipo_Documento_ID) {
    this.tipo_Documento_ID = tipo_Documento_ID;
  }

  public String getTipo_Documento() {
    return tipo_Documento;
  }

  public void setTipo_Documento(String tipo_Documento) {
    this.tipo_Documento = tipo_Documento;
  }

  @Override
  public String toString(){
    return tipo_Documento;
  }

  @Override
  public int getId() {
    return tipo_Documento_ID;
  }

}
