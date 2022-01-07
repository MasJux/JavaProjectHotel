/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import org.mindrot.jbcrypt.BCrypt;


public class loginController implements Initializable {
    
   @FXML
    private AnchorPane login_win;
   @FXML
    private AnchorPane register_win;  
   @FXML
    private AnchorPane afterlog;
   @FXML
    private TextField login;
   @FXML
    private PasswordField pass;
   @FXML
    private TextField logreg;
   @FXML
    private PasswordField passreg;
   @FXML
    private TextField emailreg;
   @FXML
    private TextField name;
    @FXML
    private TextField number;
    @FXML
    private TextField address;

private DataBase polacz;
Connection conn = null;
private OraclePreparedStatement ps=null;
private OracleResultSet rs = null;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        polacz = new DataBase();
    }

    public void register(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("register.fxml"));
        login_win.getChildren().setAll(pane);
    }
 
    public void back(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
        register_win.getChildren().setAll(pane);
    }
//    public void userLogOut(ActionEvent event) throws IOException{
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("login.fxml"));
//        afterlog.getChildren().setAll(pane);
//    }

    //LOGOWANIE//
    public String current_user=null;
    public static int current_id;
    public void LoginIn(ActionEvent event) throws IOException, SQLException, ClassNotFoundException{
        
        Hotel m = new Hotel();
        conn = DataBase.ConnectDB();
        String orcl = "SELECT PASSWORD,GUEST_ID FROM GUEST WHERE LOGIN=?";
        ps = (OraclePreparedStatement)conn.prepareStatement(orcl);
        ps.setString(1, login.getText());
       try(final ResultSet nrs = ps.executeQuery()){
           if(nrs.next()){
                    final String hash = nrs.getString("PASSWORD");
                    current_user = nrs.getString("GUEST_ID");
                    final boolean valid = BCrypt.checkpw(pass.getText(), hash);
                           current_id = Integer.parseInt(String.valueOf(current_user));
                Alert user = new Alert(AlertType.INFORMATION);
                user.setTitle("ID");
                user.setHeaderText(null);
                user.setContentText("Oto twoje ID: "+current_id);
                user.showAndWait();  
                    
                if(valid == true){    
                    rs = (OracleResultSet) ps.executeQuery();
                    m.change("AfterLog.fxml");
                    
            }else{
            Alert logowanie = new Alert(AlertType.INFORMATION);
                logowanie.setTitle("Błąd");
                logowanie.setHeaderText(null);
                logowanie.setContentText("Nieprawidłowe hasło!");
                logowanie.showAndWait();  
                }
           }else{
            Alert logowanie = new Alert(AlertType.INFORMATION);
                logowanie.setTitle("Błąd");
                logowanie.setHeaderText(null);
                logowanie.setContentText("Nieprawidłowy login!");
                logowanie.showAndWait();    
           }
       
       if(login.getText().isEmpty() || pass.getText().isEmpty()){
        Alert logowanie = new Alert(AlertType.INFORMATION);
            logowanie.setTitle("Błąd");
            logowanie.setHeaderText(null);
            logowanie.setContentText("Uzupełnij dane logowania!");
            logowanie.showAndWait();
       }   
       }
       catch(SQLException e){
           Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, e);
       }                  
    } 
    
    public int getid(){
        return current_id;
    }
    public boolean validateEmail(){
    int container1 = 0;
    int container2 = 0;

    for(int i = 0; i < emailreg.getLength(); i++) {
            if(emailreg.getText().charAt(i) == '@') {
        container1 = container1 + 1;
            }
            else if(emailreg.getText().charAt(i) == '.') {
        container2 = container2 + 1;
            }
    }
        return !(container1 > 1 || container2 > 1);
    }

    //REJESTRACJA//
     public void RegIn(ActionEvent event) throws IOException, SQLException, ClassNotFoundException{
         conn = DataBase.ConnectDB();       
          
            if(number.getText().length()!=9){
        Alert rejka = new Alert(AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Zły nr telefonu!");
                rejka.showAndWait();
           }

            else if(logreg.getText().isEmpty()){
            Alert rejka = new Alert(AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij login!");
                rejka.showAndWait();
            }
           else if(passreg.getText().isEmpty()){
            Alert rejka = new Alert(AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij hasło!");
                rejka.showAndWait();
            }
           else if (emailreg.getText().isEmpty()){
            Alert rejka = new Alert(AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij email!");
                rejka.showAndWait();
           }                
           else if (name.getText().isEmpty()){
            Alert rejka = new Alert(AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij imie i nazwisko!");
                rejka.showAndWait();
           }                       
           else if (address.getText().isEmpty()){
            Alert rejka = new Alert(AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij adres!");
                rejka.showAndWait();
           }            
           else if (number.getText().isEmpty()){
            Alert rejka = new Alert(AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij numer!");
                rejka.showAndWait();           
           }
           else{    
                try{
                    if((!emailreg.getText().startsWith("@") && !emailreg.getText().startsWith(".")) && (!emailreg.getText().contains("@.")) && (emailreg.getText().contains("@")&& emailreg.getText().contains(".")) &&(validateEmail() == true)){
               
               String hashed = BCrypt.hashpw(passreg.getText(), BCrypt.gensalt());
               String orcl = "INSERT INTO GUEST (LOGIN, PASSWORD, EMAIL, NAME, ADDRESS, PHONE_NR) VALUES (?,?,?,?,?,?)";
                ps = (OraclePreparedStatement)conn.prepareStatement(orcl);
                ps.setString(1, logreg.getText());
                ps.setString(2, hashed);
                ps.setString(3, emailreg.getText());
                ps.setString(4, name.getText());
                ps.setString(5, address.getText());
                ps.setString(6, number.getText());
                rs = (OracleResultSet) ps.executeQuery();
                
                Alert rejka = new Alert(AlertType.INFORMATION);
                rejka.setTitle("Dodano");
                rejka.setHeaderText(null);
                rejka.setContentText("Dodano pomyślnie!");
                rejka.showAndWait();
                
                    }else{
                        Alert rejka = new Alert(AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Zły email!");
                rejka.showAndWait();
                        }

                    
       }catch(SQLException e){
        Alert rejka = new Alert(AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Dany rekord istnieje w bazie!");
                rejka.showAndWait();
        }
       }
     }
}
   



    
    

