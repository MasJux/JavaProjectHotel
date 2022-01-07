/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MACIEK
 */
public class Hotel extends Application {
    
    private static Stage st;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       st = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene scene = new Scene(root);
        primaryStage.setWidth(400);
        primaryStage.setHeight(500);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public void change(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));       
        st.setWidth(1280);
        st.setHeight(620);
        st.centerOnScreen();
        st.getScene().setRoot(pane);
        st.setResizable(false);
    }
    public void Logout(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));       
        st.setWidth(400);
        st.setHeight(500);
        st.centerOnScreen();
        st.getScene().setRoot(pane);
        st.setResizable(false);
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
