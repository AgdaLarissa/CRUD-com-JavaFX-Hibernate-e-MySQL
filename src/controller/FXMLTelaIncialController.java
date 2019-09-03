/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.UsuariosModel;
import entity.Usuarios;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * FXML Controller class
 *
 * @author agda_larissa
 */
public class FXMLTelaIncialController implements Initializable {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button bntAlterar;

    @FXML
    private Button bntExcluir;

    @FXML
    private TableView<Usuarios> tabela;

    @FXML
    private TableColumn<Usuarios, String> colunaId;

    @FXML
    private TableColumn<Usuarios, String> colunaNome;

    @FXML
    private TableColumn<Usuarios, String> colunaLogin;

    @FXML
    private TableColumn<Usuarios, String> colunaSenha;

    @FXML
    private TextField txtBuscar;

    UsuariosModel usuario = new UsuariosModel();
    ObservableList lista = FXCollections.observableArrayList();
    String key = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar();
        selecionarLinha();
        buscar();
        salvar();
        alterar();
        excluir();
    }

    public void listar() {
        tabela.getItems().clear();
        List<Usuarios> ls = usuario.listar();
        for (Usuarios l : ls) {
            lista.add(l);
        }
        colunaId.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        colunaSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        tabela.setItems(lista);
    }

    public void buscar() {
        txtBuscar.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                tabela.getItems().clear();
                List<Usuarios> ls = usuario.buscarPorNome(txtBuscar.getText());
                for (Usuarios l : ls) {
                    lista.add(l);
                }
                colunaId.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
                colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
                colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
                colunaSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
                tabela.setItems(lista);
            }

        });

    }

    public void selecionarLinha() {
        tabela.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                int i = tabela.getSelectionModel().getSelectedIndex();
                key = String.valueOf(colunaId.getCellData(i));
                txtNome.setText(colunaNome.getCellData(i));
                txtLogin.setText(colunaLogin.getCellData(i));
                txtSenha.setText(colunaSenha.getCellData(i));
            }
        });

    }

    public void limpar() {
        key = null;
        txtNome.clear();
        txtLogin.clear();
        txtSenha.clear();
    }

    public void salvar() {
        btnSalvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                Usuarios u = new Usuarios();
                u.setNome(txtNome.getText());
                u.setLogin(txtLogin.getText());
                u.setSenha(txtSenha.getText());
                usuario.inserir(u);
                limpar();
                listar();
            }

        });
    }

    public void alterar() {
        bntAlterar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                Usuarios u = new Usuarios();
                u.setIdUsuario(Integer.parseInt(key));
                u.setNome(txtNome.getText());
                u.setLogin(txtLogin.getText());
                u.setSenha(txtSenha.getText());
                usuario.atualizar(u);
                limpar();
                listar();
            }

        });
    }

    public void excluir() {
        bntExcluir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                Usuarios u = new Usuarios();
                u.setIdUsuario(Integer.parseInt(key));
                u.setNome(txtNome.getText());
                u.setLogin(txtLogin.getText());
                u.setSenha(txtSenha.getText());
                usuario.deletar(u);
                limpar();
                listar();
            }

        });
    }

}
