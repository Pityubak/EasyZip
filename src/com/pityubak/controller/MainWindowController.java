package com.pityubak.controller;

import com.pityubak.service.CompressionService;
import com.pityubak.model.CompressionType;
import com.pityubak.service.CompressionTypeConverter;
import com.pityubak.service.State;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.Scene;
import javafx.stage.Window;

/**
 *
 * @author Pityubak
 */
public class MainWindowController implements Initializable {

    @FXML
    private Text targetText;
    @FXML
    private ChoiceBox optionsCb;


    private CompressionService compressionService;
    private ObservableList optionsList;
    private final static String MESSAGE = "Drag and drop files here";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.compressionService = new CompressionService();
        this.optionsList = FXCollections.observableArrayList();
        optionsList.addAll(CompressionType.COMPRESS, CompressionType.DECOMPRESS, new Separator(),
                CompressionType.COMPRESS_AS, CompressionType.DECOMPRESS_AS);
        optionsCb.setConverter(new CompressionTypeConverter());
        optionsCb.setItems(optionsList);
        optionsCb.setValue(optionsList.get(0));

    }

    @FXML
    public void executeBtnAction(MouseEvent event) {
        CompressionType type = (CompressionType) optionsCb.getValue();
        String path = targetText.getText();
        State state = type.getState();
        if (type.getName().contains("as")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle(type.getName());
            Stage stage = new Stage();
            File dest = fileChooser.showSaveDialog(stage);
            if (dest != null) {
                state.setDestination(dest.getAbsolutePath());
            }
        }
        state.setSourcePath(path);
        compressionService.setCompressionType(type);
        compressionService.execute();
        targetText.setText(MESSAGE);
    }

    @FXML
    public void handleDragOver(DragEvent event) {
        Dragboard dg = event.getDragboard();
        if (dg.hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    public void handleDrop(DragEvent event) {
        Dragboard dg = event.getDragboard();
        List<File> files = dg.getFiles();
        File targetFile = files.get(0);
        String targetName = targetFile.getName();
        String source = targetFile.getAbsolutePath();
        if (targetName.endsWith(".zip")) {
            optionsCb.setValue(optionsList.get(1));
        } else {
            optionsCb.setValue(optionsList.get(0));
        }
        targetText.setText(source);

    }

    @FXML
    public void clearBtnAction(MouseEvent e) {
        targetText.setText(MESSAGE);
    }

    @FXML
    public void exitBtnAction(MouseEvent e) {
        Scene scene=targetText.getScene();
        Window window=scene.getWindow();
        window.hide();
    }
}
