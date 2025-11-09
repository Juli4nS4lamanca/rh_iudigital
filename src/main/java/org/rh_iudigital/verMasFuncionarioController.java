package org.rh_iudigital;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
  private int funcionarioId;

  @FXML
  private void onAgregarFamiliar() throws IOException {
    try {
      FXMLLoader loader = new FXMLLoader(App.class.getResource("/org/rh_iudigital/FormFamiliar.fxml"));
      Parent root = loader.load();
      
      FormFamiliarController controller = loader.getController();
      controller.setFuncionarioId(funcionarioId);
      
      Stage stage = new Stage();
      stage.setTitle("Agregar Familiar");
      stage.setScene(new Scene(root));
      stage.initModality(Modality.WINDOW_MODAL);
      stage.initOwner(titulo.getScene().getWindow());
      stage.showAndWait();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void onAgregarFormacion() throws IOException {
    try {
      FXMLLoader loader = new FXMLLoader(App.class.getResource("/org/rh_iudigital/formFormacion.fxml"));
      Parent root = loader.load();
      
      FormFormacionController controller = loader.getController();
      controller.setFuncionarioId(funcionarioId);
      
      Stage stage = new Stage();
      stage.setTitle("Agregar Formación Académica");
      stage.setScene(new Scene(root));
      stage.initModality(Modality.WINDOW_MODAL);
      stage.initOwner(titulo.getScene().getWindow());
      stage.showAndWait();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

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
    funcionarioId = Integer.parseInt(funcionario.get(9));
    titulo.setText("Información funcionario ID "+funcionarioId);
  }
}
