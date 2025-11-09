package org.rh_iudigital;

import dao.FuncionarioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import model.Funcionario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class verFuncionariosController {

  @FXML
  private TableView<Funcionario> tablaFuncionarios;
  @FXML
  private TableColumn<Funcionario, Integer> colID;
  @FXML
  private  TableColumn<Funcionario, String> colIdentificacion;
  @FXML
  private TableColumn<Funcionario, String> colNombreCompleto;
  @FXML
  private TableColumn<Funcionario, String> colTelefono;
  @FXML
  private TableColumn<Funcionario, Void> colAcciones;

  private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

  @FXML
  public void initialize(){

    colID.setCellValueFactory(new PropertyValueFactory<>("funcionario_ID"));
    colIdentificacion.setCellValueFactory(new PropertyValueFactory<>("no_identificacion"));
    colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

    colNombreCompleto.setCellValueFactory(data -> {
      Funcionario funcionario = data.getValue();

      String nombreCompleto = funcionario.getNombres() + " " + funcionario.getApellidos();
      return new javafx.beans.property.SimpleStringProperty(nombreCompleto);
    });

    Callback<TableColumn<Funcionario, Void>, TableCell<Funcionario, Void>> cellFactory = new Callback<>(){
      @Override
      public TableCell<Funcionario, Void> call(final TableColumn<Funcionario, Void> param){
        final TableCell<Funcionario, Void> cell = new TableCell<>(){
          private final Button btnVerMas = new Button("Ver más");
          private final Button btnEditar = new Button("Editar");
          private final Button btnEliminar = new Button("Borrar");

          private final HBox pane = new HBox(5, btnVerMas, btnEditar, btnEliminar);

          {
            btnVerMas.setOnAction(event -> {
              Funcionario funcionario = getTableView().getItems().get(getIndex());
              List<String> datos = null;
              try {
                datos = funcionarioDAO.seleccionarFuncionario(funcionario.getFuncionario_ID());
              } catch (SQLException e) {
                throw new RuntimeException(e);
              }
              try {
                verMasFuncionario(datos);
              } catch (IOException e) {
                throw new RuntimeException(e);
              }
            });

            btnEditar.setOnAction(event -> {
              Funcionario funcionario = getTableView().getItems().get(getIndex());
              try {
                formularioEditarFuncionario(funcionario);
              } catch (IOException e) {
                throw new RuntimeException(e);
              }
            });

            btnEliminar.setOnAction(event -> {
              Funcionario funcionario = getTableView().getItems().get(getIndex());
              boolean confirmado = confirmarEliminar(funcionario);
              if (confirmado){
                try {
                  funcionarioDAO.eliminarFuncionario(funcionario);
                  cargarFuncionarios();
                } catch (SQLException e) {
                  throw new RuntimeException(e);
                }
              }
            });
          }

          @Override
          public void updateItem(Void item, boolean empty){
            super.updateItem(item, empty);
            if(empty){
              setGraphic(null);
            }else {
              setGraphic(pane);
            }
          }
        };
        return  cell;
      }
    };

    colAcciones.setCellFactory(cellFactory);
    cargarFuncionarios();
  }

  private void cargarFuncionarios(){
    try {
      List<Funcionario> funcionarioList = funcionarioDAO.seleccionarTodos();
      ObservableList<Funcionario> data = FXCollections.observableArrayList(funcionarioList);
      tablaFuncionarios.setItems(data);
    } catch (SQLException e){
      e.printStackTrace();
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error en base de datos");
      alert.setHeaderText("No se pudieron cargar los funcionarios");
      alert.setContentText("Ocurrio un error al acceder a la base de datos");
      alert.showAndWait();
    }
  }

  private boolean confirmarEliminar(Funcionario funcionario){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmar Eliminación");
    alert.setHeaderText("Eliminar funcionario");
    alert.setContentText("Esta seguro de eliminar a "+funcionario.getNombres()+" "+funcionario.getApellidos()+"?");

    Optional<ButtonType> result = alert.showAndWait();
    return result.isPresent() && result.get() == ButtonType.OK;
  }

  private void formularioEditarFuncionario(Funcionario funcionario) throws IOException {
    try {
      FXMLLoader loader = App.setRoot("secondary");
      SecondaryController controller = loader.getController();
      controller.setFuncionario(funcionario);
      cargarFuncionarios();
    }catch (IOException e){
      e.printStackTrace();
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error de Carga");
      alert.setHeaderText("No se pudo cargar el formulario de edición.");
      alert.setContentText("Verifica la ruta del archivo FXML.");
      alert.showAndWait();
    }

  }

  private void verMasFuncionario(List<String> funcionario) throws IOException{
    try {
      FXMLLoader loader = App.setRoot("verMasFuncionario");
      verMasFuncionarioController controller = loader.getController();
      controller.setFuncionario(funcionario);
    }catch (IOException e){
      e.printStackTrace();
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error de Carga");
      alert.setHeaderText("No se pudo cargar el formulario de edición.");
      alert.setContentText("Verifica la ruta del archivo FXML.");
      alert.showAndWait();
    }
  }


  @FXML
  private void atras() throws IOException {
    App.setRoot("primary");
  }

}
