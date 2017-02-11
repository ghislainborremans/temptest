/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserver;

import java.net.URL;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ghisl
 */
public class UDPServer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
    
    String sceneFile = Paths.get("UDPServer.fxml").toString();
    
        Parent root = null;
        URL    url  = null;
 
        url  = getClass().getResource( sceneFile );
        root = FXMLLoader.load(url);    //.load( url );
        System.out.println( "  fxmlResource = " + sceneFile );
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
