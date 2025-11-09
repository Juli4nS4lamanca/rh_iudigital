package org.rh_iudigital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import dao.FormacionAcademicaDAO;
import dao.FuncionarioDAO;
import dao.NivelEstudioDAO;
import model.FormacionAcademica;
import model.Funcionario;
import model.Nivel_Estudio;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class FormFormacionController implements Initializable {

    @FXML private TextField txtUniversidad;
    @FXML private TextField txtTitulo;
    @FXML private ComboBox<Nivel_Estudio> cbNivelEstudio;
    @FXML private ComboBox<Funcionario> cbFuncionario;

    private final FormacionAcademicaDAO formacionDAO = new FormacionAcademicaDAO();
    private final NivelEstudioDAO nivelEstudioDAO = new NivelEstudioDAO();
    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarNivelesEstudio();
        cargarFuncionarios();
    }

    private void cargarNivelesEstudio() {
        try {
            List<Nivel_Estudio> niveles = nivelEstudioDAO.seleccionarTodos();
            ObservableList<Nivel_Estudio> observableList = FXCollections.observableArrayList(niveles);
            cbNivelEstudio.setItems(observableList);
        } catch (SQLException e) {
            mostrarAlerta("Error", "No se pudieron cargar los niveles de estudio: " + e.getMessage());
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

    /**
     * Método para asignar el funcionario al que se le agregará la formación
     */
    public void setFuncionarioId(int id) {
        try {
            List<Funcionario> funcionarios = funcionarioDAO.seleccionarTodos();
            for (Funcionario f : funcionarios) {
                if (f.getFuncionario_ID() == id) {
                    cbFuncionario.getSelectionModel().select(f);
                    break;
                }
            }
        } catch (SQLException e) {
            mostrarAlerta("Error", "No se pudo seleccionar el funcionario: " + e.getMessage());
        }
    }

    @FXML
    private void guardarFormacion(ActionEvent event) {
        try {
            // Validar campos
            if (txtUniversidad.getText().trim().isEmpty()) {
                mostrarAlerta("Error", "Debe ingresar la universidad.");
                return;
            }
            if (txtTitulo.getText().trim().isEmpty()) {
                mostrarAlerta("Error", "Debe ingresar el título.");
                return;
            }
            if (cbNivelEstudio.getSelectionModel().getSelectedItem() == null) {
                mostrarAlerta("Error", "Debe seleccionar un nivel de estudio.");
                return;
            }
            if (cbFuncionario.getSelectionModel().getSelectedItem() == null) {
                mostrarAlerta("Error", "Debe seleccionar un funcionario.");
                return;
            }

            FormacionAcademica f = new FormacionAcademica();
            f.setUniversidad(txtUniversidad.getText().trim());
            f.setTitulo(txtTitulo.getText().trim());
            f.setNivelEstudioId(cbNivelEstudio.getSelectionModel().getSelectedItem().getId());
            f.setFuncionarioId(cbFuncionario.getSelectionModel().getSelectedItem().getFuncionario_ID());

            // Insertar en la base de datos
            formacionDAO.insertar(f);

            mostrarAlerta("Éxito", "Formación guardada correctamente.");
            cerrarVentana();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo guardar la formación: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void cerrarFormulario(ActionEvent event) {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txtUniversidad.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
