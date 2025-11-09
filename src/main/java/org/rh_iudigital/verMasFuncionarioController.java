package org.rh_iudigital;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Funcionario;


import java.io.IOException;
import java.util.List;

public class verMasFuncionarioController {

  @FXML
  private Label sexo;
  @FXML
  private Label estadoCivil;
  @FXML
  private Label tipoDocumento;
  @FXML
  private Label no_identificacion;
  @FXML
  private Label nombres;
  @FXML
  private Label apellidos;
  @FXML
  private Label direccion;
  @FXML
  private Label telefono;
  @FXML
  private Label fecha_nacimiento;
  @FXML
  private Label titulo;

  private List<String> funcionarioActual;

  @FXML
  private void atras() throws IOException {
    App.setRoot("verFuncionarios");
  }

  public void setFuncionario (List<String> funcionario){
    this.funcionarioActual = funcionario;
    no_identificacion.setText(funcionario.get(1));
    nombres.setText(funcionario.get(2));
    apellidos.setText(funcionario.get(3));
    direccion.setText(funcionario.get(7));
    telefono.setText(funcionario.get(6));
    fecha_nacimiento.setText(funcionario.get(8));
    sexo.setText(funcionario.get(5));
    estadoCivil.setText(funcionario.get(4));
    tipoDocumento.setText(funcionario.get(0));
    titulo.setText("Información funcionario ID "+funcionario.get(9));
  }
}
