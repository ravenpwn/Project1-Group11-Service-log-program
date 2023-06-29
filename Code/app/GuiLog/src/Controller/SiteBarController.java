package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class SiteBarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TreeView<String> treeView;
    

    @FXML
    void initialize() {
        TreeItem<String> rootItem = new TreeItem<>("Trang chủ");
        TreeItem<String> item1 = new TreeItem<>("apache");
        
        TreeItem<String> item2 = new TreeItem<>("modsecurity");
        TreeItem<String> item3 = new TreeItem<>("iptable");
        
        TreeItem<String> item4 = new TreeItem<>("table");
        TreeItem<String> item5 = new TreeItem<>("chart");
        item1.getChildren().add(item4);
        item1.getChildren().add(item5);
        item2.getChildren().add(item4);
        item2.getChildren().add(item5);
        item3.getChildren().add(item4);
        item3.getChildren().add(item5);
        

        // Thêm các mục con vào mục gốc
        rootItem.getChildren().add(item1);
        rootItem.getChildren().add(item2);
        rootItem.getChildren().add(item3);

        
        // Đặt mục gốc là gốc của TreeView
        treeView.setRoot(rootItem);
    }


}
