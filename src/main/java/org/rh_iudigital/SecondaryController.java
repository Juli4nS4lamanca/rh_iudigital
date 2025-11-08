package org.rh_iudigital;

import dao.Estado_CivilDAO;
import dao.FuncionarioDAO;
import dao.SexoDAO;
import dao.Tipo_DocumentoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class SecondaryController implements Initializable {

  @FXML
  private ChoiceBox<Sexo> sexoChoiceBox;
  @FXML
  private ChoiceBox<Estado_Civil> estadoCivilChoiceBox;
  @FXML
  private ChoiceBox<Tipo_Documento> tipoDocumentoChoiceBox;
  @FXML
  private TextField no_identificacion;
  @FXML
  private TextField nombres;
  @FXML
  private TextField apellidos;
  @FXML
  private TextField direccion;
  @FXML
  private TextField telefono;
  @FXML
  private DatePicker fecha_nacimiento;

  private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
  private final SexoDAO sexoDAO = new SexoDAO();
  private final Estado_CivilDAO estadoCivilDAO = new Estado_CivilDAO();
  private final Tipo_DocumentoDAO tipoDocumentoDAO = new Tipo_DocumentoDAO();

  @Override
  public void initialize(URL location, ResourceBundle resourceBundle) {
    cargarDatosAChoiceBox(sexoDAO, sexoChoiceBox, "sexos");
    cargarDatosAChoiceBox(estadoCivilDAO, estadoCivilChoiceBox, "estados civiles");
    cargarDatosAChoiceBox(tipoDocumentoDAO, tipoDocumentoChoiceBox, "tipos de documentos");

    if (tipoDocumentoChoiceBox.getItems() != null && !tipoDocumentoChoiceBox.getItems().isEmpty()) {
      tipoDocumentoChoiceBox.getSelectionModel().selectFirst();
    }
  }

  @FXML
  private void atras() throws IOException {
    App.setRoot("primary");
  }

  @FXML
  private void guardarEmpleado() {
    int idSexo = obtenerIdSeleccionado(sexoChoiceBox);
    int idTipoDocumento = obtenerIdSeleccionado(tipoDocumentoChoiceBox);
    int idEstadoCivil = obtenerIdSeleccionado(estadoCivilChoiceBox);

    try {
      Funcionario nuevoFuncionario = new Funcionario();

      nuevoFuncionario.setTipo_documento_ID(idTipoDocumento);
      nuevoFuncionario.setNo_identificacion(no_identificacion.getText());
      nuevoFuncionario.setNombres(nombres.getText());
      nuevoFuncionario.setApellidos(apellidos.getText());
      nuevoFuncionario.setEstado_civil_ID(idEstadoCivil);
      nuevoFuncionario.setSexo_ID(idSexo);
      nuevoFuncionario.setDireccion(direccion.getText());
      nuevoFuncionario.setTelefono(telefono.getText());
      nuevoFuncionario.setFecha_nacimiento(fecha_nacimiento.getValue());

      funcionarioDAO.guardarFuncionario(nuevoFuncionario);
      mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Funcionario " + nuevoFuncionario.getNombres() + " " + nuevoFuncionario.getApellidos() + " guardado correctamente.");
      limpiarCampos();

    } catch (SQLException e) {
      mostrarAlerta(Alert.AlertType.ERROR, "Error de Base de Datos", "No se pudo guardar el funcionario: " + e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error inesperado " + e.getMessage());
      e.printStackTrace();
    }

  }

  private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
    Alert alert = new Alert(tipo);
    alert.setTitle(titulo);
    alert.setHeaderText(null);
    alert.setContentText(mensaje);
    alert.showAndWait();
  }

  private void limpiarCampos() {
    no_identificacion.setText("");
    nombres.setText("");
    apellidos.setText("");
    direccion.setText("");
    telefono.setText("");

    fecha_nacimiento.setValue(null);

    if (!tipoDocumentoChoiceBox.getItems().isEmpty()) {
      tipoDocumentoChoiceBox.getSelectionModel().selectFirst();
    }
    if (!estadoCivilChoiceBox.getItems().isEmpty()) {
      estadoCivilChoiceBox.getSelectionModel().clearSelection();
    }
    if (!sexoChoiceBox.getItems().isEmpty()) {
      sexoChoiceBox.getSelectionModel().clearSelection();
    }

    no_identificacion.requestFocus();
  }

  private <T> void cargarDatosAChoiceBox(dao.CatalogoDAO<T> dao, ChoiceBox<T> choiceBox, String nombreEntidad) {
    try {
      List<T> items = dao.seleccionarTodos();
      ObservableList<T> observableList = FXCollections.observableArrayList(items);
      choiceBox.setItems(observableList);

    } catch (SQLException e) {
      mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error inesperado " + e.getMessage());

    }
  }

  private <T extends ObtenerID> int obtenerIdSeleccionado(ChoiceBox<T> choiceBox) {
    T seleccionado = choiceBox.getSelectionModel().getSelectedItem();
    return (seleccionado != null) ? seleccionado.getId() : 0;
  }


}
