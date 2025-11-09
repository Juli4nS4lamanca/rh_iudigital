package org.rh_iudigital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import dao.FamiliarDAO;
import dao.FuncionarioDAO;
import dao.RolFamiliarDAO;
import model.Familiar;
import model.Funcionario;
import model.Rol;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class FormFamiliarController implements Initializable {

    @FXML private TextField txtNombres;
    @FXML private TextField txtApellidos;
    @FXML private ComboBox<Rol> cbRol;
    @FXML private ComboBox<Funcionario> cbFuncionario;

    private final FamiliarDAO familiarDAO = new FamiliarDAO();
    private final RolFamiliarDAO rolFamiliarDAO = new RolFamiliarDAO();
    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarRoles();
        cargarFuncionarios();
    }

    private void cargarRoles() {
        try {
            List<Rol> roles = rolFamiliarDAO.seleccionarTodos();
            ObservableList<Rol> observableList = FXCollections.observableArrayList(roles);
            cbRol.setItems(observableList);
        } catch (SQLException e) {
            mostrarAlerta("Error", "No se pudieron cargar los roles familiares: " + e.getMessage());
        }
    }

    private void cargarFuncionarios() {
        try {
            List<Funcionario> funcionarios = funcionarioDAO.seleccionarTodos();
            ObservableList<Funcionario> observableList = FXCollections.observableArrayList(funcionarios);
            cbFuncionario.setItems(observableList);
        } catch (SQLException e) {
            mostrarAlerta("Error", "No se pudieron cargar los funcionarios: " + e.getMessage());
        }
    }

    public void setFuncionarioId(int funcionarioId) {
        try {
            List<Funcionario> funcionarios = funcionarioDAO.seleccionarTodos();
            for (Funcionario f : funcionarios) {
                if (f.getFuncionario_ID() == funcionarioId) {
                    cbFuncionario.getSelectionModel().select(f);
                    break;
                }
            }
        } catch (SQLException e) {
            mostrarAlerta("Error", "No se pudo seleccionar el funcionario: " + e.getMessage());
        }
    }

    @FXML
    private void guardarFamiliar(ActionEvent event) {
        try {
            // Validar campos
            if (txtNombres.getText().trim().isEmpty()) {
                mostrarAlerta("Error", "Debe ingresar los nombres del familiar.");
                return;
            }
            if (txtApellidos.getText().trim().isEmpty()) {
                mostrarAlerta("Error", "Debe ingresar los apellidos del familiar.");
                return;
            }
            if (cbRol.getSelectionModel().getSelectedItem() == null) {
                mostrarAlerta("Error", "Debe seleccionar un rol familiar.");
                return;
            }
            if (cbFuncionario.getSelectionModel().getSelectedItem() == null) {
                mostrarAlerta("Error", "Debe seleccionar un funcionario.");
                return;
            }

            Familiar familiar = new Familiar();
            familiar.setNombres(txtNombres.getText().trim());
            familiar.setApellidos(txtApellidos.getText().trim());
            familiar.setRolFamiliarId(cbRol.getSelectionModel().getSelectedItem().getId());
            familiar.setFuncionarioId(cbFuncionario.getSelectionModel().getSelectedItem().getFuncionario_ID());

            familiarDAO.insertar(familiar);

            mostrarAlerta("Éxito", "Familiar guardado correctamente.");
            cerrarVentana();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo guardar el familiar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void cerrarFormulario(ActionEvent event) {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txtNombres.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
