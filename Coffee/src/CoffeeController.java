/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class CoffeeController implements Initializable {

    @FXML
    private TextField txtnama;
    @FXML
    private TextField txtnomor;
    @FXML
    private TextField txtnama1;
    @FXML
    private TextField txtnomor1;
    @FXML
    private Button btnSimpan;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDelete;
    @FXML
    private AnchorPane pane;
    @FXML
  TableView<Kopi> tablekopi;
    @FXML
     TableColumn<Kopi ,Integer> columkode;
    @FXML
     TableColumn<Kopi ,String> columnamabrg;
    @FXML
    TableColumn<Kopi, String> columnamapembeli;
    @FXML
     TableColumn<Kopi ,Integer> columjumlah;
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    Platform.runLater(() -> {
            txtnama.requestFocus();
        });
    
    // table property
        columkode.setCellValueFactory(new PropertyValueFactory<>("kode barang"));
        
        columnamabrg.setCellValueFactory(new PropertyValueFactory<>("nama barang"));
    
        columnamapembeli.setCellValueFactory(new PropertyValueFactory<>("nama pembeli"));

        columjumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah barang"));
    }    
    
    
    
     private String getNomorFromInput() throws IllegalArgumentException {
        String nomor = txtnomor.getText().trim();
        if (nomor.equals("")) throw new IllegalArgumentException("nomor tidak boleh kosong");
        return nomor;
    }
    
     private String getNamaFromInput() throws IllegalArgumentException {
        String nama = txtnama.getText().trim();
        if (nama.equals("")) throw new IllegalArgumentException("nama tidak boleh kosong");
        return nama;
    }
    
     private String getNamaFromInput1() throws IllegalArgumentException {
        String nama1 = txtnama1.getText().trim();
        if (nama1.equals("")) throw new IllegalArgumentException("nama tidak boleh kosong");
        return nama1;
    }

     private String getNomorFromInput1() throws IllegalArgumentException {
        String nomor1 = txtnomor1.getText().trim();
        if (nomor1.equals("")) throw new IllegalArgumentException("jumlah tidak boleh kosong");
        return nomor1;
    }
 public void onBtnClearClick(ActionEvent event){
     txtnama1.clear();
    txtnama.clear();
    txtnomor.clear();
    txtnomor1.clear();
    txtnama.requestFocus();
    messageBox("Message","Cleared");

    
    
 }

public void onBtnSimpanClick(ActionEvent event) {
        String namapembeli = "";
        try {
            namapembeli = getNamaFromInput();
        } catch (IllegalArgumentException e) {
            messageBox("Coffee Table View", e.getMessage()).showAndWait();
            txtnama.requestFocus();
        }
        Integer kode = 0;
        try {
            kode = Integer.valueOf(txtnomor.getText());
            if (kode < 0 || kode > 200) throw new IllegalArgumentException("Kode hanya boleh dari 0-200");
        } catch (NumberFormatException e) {
            messageBox("Coffee Tale View", "Kode hanya boleh angka").showAndWait();
            txtnomor.selectAll();
            txtnomor.requestFocus();
            return;
        } catch (IllegalArgumentException e) {
            messageBox("Coffee Table View", e.getMessage()).showAndWait();
            txtnomor.selectAll();
            txtnomor.requestFocus();
            txtnomor.selectAll();
            return;
        }
        String namabrg = "";
        try {
            namabrg = getNamaFromInput();
        } catch (IllegalArgumentException e) {
            messageBox("Coffee Table View", e.getMessage()).showAndWait();
            txtnama1.requestFocus();
        }
        Integer jumlah = 0;
        try {
            kode = Integer.valueOf(txtnomor.getText());
            if (jumlah < 0 || jumlah > 1000) throw new IllegalArgumentException("Kode hanya boleh dari 0-1000");
        } catch (NumberFormatException e) {
            messageBox("Coffee Tale View", "Kode hanya boleh angka").showAndWait();
            txtnomor1.selectAll();
            txtnomor1.requestFocus();
            return;
        } catch (IllegalArgumentException e) {
            messageBox("Coffee Table View", e.getMessage()).showAndWait();
            txtnomor1.selectAll();
            txtnomor1.requestFocus();
            txtnomor1.selectAll();
            return;
        }
        txtnama.clear();
        txtnomor.clear();
        txtnama1.clear();
        txtnomor.clear();

        tablekopi.getItems().add(new Kopi(namapembeli, kode ,namabrg,jumlah));

        txtnama.requestFocus();
    }

public void onBtnDeleteClick(ActionEvent event){
    int index = tablekopi.getSelectionModel().getSelectedIndex();
           if (index >= 0) {
               Kopi data = tablekopi.getItems().get(index);
               // tampilkan form konfirmasi
               if (confirm("Hapus", "Yakin hapus " + data + "?")
                       .orElse(ButtonType.CANCEL).equals(ButtonType.OK)) {
                   // hapus
                   deleteItem(index);
               }
           }
       }


 public void onTableViewKeyPressed(KeyEvent event) {
        // jika tombol DELETE/BACKSPACE hapus item
       if (event.getCode().equals(KeyCode.DELETE) || event.getCode().equals(KeyCode.BACK_SPACE)) {
           int index = tablekopi.getSelectionModel().getSelectedIndex();
           if (index >= 0) {
               Kopi data = tablekopi.getItems().get(index);
               // tampilkan form konfirmasi
               if (confirm("Hapus", "Yakin hapus " + data + "?")
                       .orElse(ButtonType.CANCEL).equals(ButtonType.OK)) {
                   // hapus
                   deleteItem(index);
               }
           }
       }
    }
// dialog box untuk menampilkan pesan konfirmasi (OK, CANCEL)
    private Optional<ButtonType> confirm(String title, String message) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle(title);
        confirm.setContentText(message);
        Optional<ButtonType> result = confirm.showAndWait();
        return result;
    }
 
    private void deleteItem(int index) {
        if (index >= 0 && index < tablekopi.getItems().size()) {
            tablekopi.getItems().remove(index);
        }
    }











private Alert messageBox(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        return alert;
    }


}
