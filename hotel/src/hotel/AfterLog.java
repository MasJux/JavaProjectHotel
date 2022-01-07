
package hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import java.sql.Date;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

public class AfterLog {
    
private DataBase polacz;
Connection conn = null;
private OraclePreparedStatement ps=null;
private OracleResultSet rs = null;

@FXML
    private Pane war;
@FXML
    public TextField ID;
@FXML
    private TextField ile;
@FXML
    private TextField kiedy;
@FXML
    private TextField ID_rez;
@FXML
    private TextField ID2;
@FXML
    private TextField ile2;
@FXML
    private TextField kiedy2;
@FXML
    private TextField ID_rez2;
@FXML
    private TextField ID3;
@FXML
    private TextField ile3;
@FXML
    private TextField kiedy3;
@FXML
    private TextField ID_rez3;
@FXML
    private Label lID_A;
@FXML
    private Label lnr_r;
@FXML
    private Label lfloor;
@FXML
    private Label lown;
@FXML
    private Label lbeds;
@FXML
    private Label lprice;
@FXML
    private Label lrate_w;
@FXML
    private Label lsmoke;
@FXML
    private Label lpet;
@FXML
    private Label lava;
@FXML
    private Label lcity;
@FXML
    private Label lID_A2;
@FXML
    private Label lnr_r2;
@FXML
    private Label lfloor2;
@FXML
    private Label lown2;
@FXML
    private Label lbeds2;
@FXML
    private Label lprice2;
@FXML
    private Label lrate_w2;
@FXML
    private Label lsmoke2;
@FXML
    private Label lpet2;
@FXML
    private Label lava2;
@FXML
    private Label lcity2;
@FXML
    private Label lID_A3;
@FXML
    private Label lnr_r3;
@FXML
    private Label lfloor3;
@FXML
    private Label lown3;
@FXML
    private Label lbeds3;
@FXML
    private Label lprice3;
@FXML
    private Label lrate_w3;
@FXML
    private Label lsmoke3;
@FXML
    private Label lpet3;
@FXML
    private Label lava3;
@FXML
    private Label lcity3;
    


    public void initialize(URL url, ResourceBundle rb) {
        polacz = new DataBase();
    }

    public void userLogOut(ActionEvent event) throws IOException, Exception {
        Hotel m = new Hotel();
        m.Logout("login.fxml");
            Alert logowanie = new Alert(Alert.AlertType.INFORMATION);
                logowanie.setTitle("Wylogowano");
                logowanie.setHeaderText(null);
                logowanie.setContentText("Wylogowano pomyślnie.");
                logowanie.showAndWait();
    }
    //zmiana okien
     public void warszawa (ActionEvent event) throws IOException  {
         Hotel m = new Hotel();
        m.change("Warszawa.fxml");
}
     public void gdansk (ActionEvent event) throws IOException  {
         Hotel m = new Hotel();
        m.change("Gdansk.fxml");
}
     public void krakow (ActionEvent event) throws IOException  {
         Hotel m = new Hotel();
        m.change("Krakow.fxml");
}
    //powrót do afterloga
     public void backa (ActionEvent event) throws IOException  {
         Hotel m = new Hotel();
        m.change("AfterLog.fxml");
}
     public void back2 (ActionEvent event) throws IOException  {
         Hotel m = new Hotel();
        m.change("AfterLog.fxml");
}
     public void back3 (ActionEvent event) throws IOException  {
         Hotel m = new Hotel();
        m.change("AfterLog.fxml");
}
     public void back4 (ActionEvent event) throws IOException  {
         Hotel m = new Hotel();
        m.change("AfterLog.fxml");
}
     //Warszawa
         public void ap_waw(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
         conn = DataBase.ConnectDB();
         
         try{
         String ora = "INSERT INTO RESERVATION (GUEST_ID, RESERVATION_DATE, APARTAMENT_ID, PRICE, RENT_DAYS) VALUES (?,?,?,?,?)";

                ps = (OraclePreparedStatement)conn.prepareStatement(ora);
                ps.setString(1, ID.getText());
                ps.setString(2, kiedy.getText());
                ps.setString(3, "1");
                ps.setInt(4, Integer.parseInt(ile.getText())*100);
                ps.setString(5, ile.getText());

                rs = (OracleResultSet) ps.executeQuery();
                
                if(rs.next())
       {                                 
        Alert rezerwacja = new Alert(Alert.AlertType.INFORMATION);
            rezerwacja.setTitle("ZAREZERWOWANO!");
            rezerwacja.setHeaderText(null);
            rezerwacja.setContentText("Zarezerwowano pomyślnie!");
            rezerwacja.showAndWait();   
       }   
         } catch(SQLException e){
           if(ID.getText().isEmpty()){
            Alert rejka = new Alert(Alert.AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij swoje ID!");
                rejka.showAndWait();
            }
           else if(kiedy.getText().isEmpty()){
            Alert rejka = new Alert(Alert.AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij datę rezerwacji!");
                rejka.showAndWait();
            }
           else if(ile.getText().isEmpty()){
            Alert rejka = new Alert(Alert.AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij na ile dni chcesz wynająć!");
                rejka.showAndWait();
            }
         }        
    }
        
         public void waw_info(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
        conn = DataBase.ConnectDB();
        String orcl = "SELECT * FROM APARTAMENT WHERE APARTAMENT_ID = 1";
        PreparedStatement wps = conn.prepareStatement(orcl);
        ResultSet wrs = wps.executeQuery();
        if(wrs.next()){
        String ID_A=wrs.getString("APARTAMENT_ID");
        String nr_r=wrs.getString("ROOM_NR");
        String floor=wrs.getString("FLOOR");
        String own=wrs.getString("OWNERS");
        String beds=wrs.getString("BEDS");
        String price=wrs.getString("PRICE");
        String rate_w=wrs.getString("RATE_ROOM");
        String smoke=wrs.getString("SMOKING");
        String pet=wrs.getString("PET_FRIENDLY");
        String ava=wrs.getString("AVAILABILITY");
        String city=wrs.getString("CITY");
            
            lID_A.setText("ID apartamtentu: "+ID_A);
            lnr_r.setText("Numer pokoju: "+nr_r);
            lfloor.setText("Piętro: "+floor);
            lown.setText("Ilość gości: "+own);
            lbeds.setText("Łóżka: "+beds);
            lprice.setText("Cena: "+price);
            lrate_w.setText("Ocena: "+rate_w);
            lsmoke.setText("Możliwość palenia: "+smoke);
            lpet.setText("Zwierzęta: "+pet);
            lava.setText("Dostępność: "+ava);
            lcity.setText("Miasto: "+city);
            
            loginController lc = new loginController();
            System.out.println(lc.getid());
         }
         }
         public void ukryj_w(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
         
            lID_A.setText("");
            lnr_r.setText("");
            lfloor.setText("");
            lown.setText("");
            lbeds.setText("");
            lprice.setText("");
            lrate_w.setText("");
            lsmoke.setText("");
            lpet.setText("");
            lava.setText("");
            lcity.setText("");
         }
     //Gdansk
        public void ap_waw2(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
         conn = DataBase.ConnectDB();
         
         try{
         String ora = "INSERT INTO RESERVATION (GUEST_ID, RESERVATION_DATE, APARTAMENT_ID, PRICE, RENT_DAYS) VALUES (?,?,?,?,?)";

                ps = (OraclePreparedStatement)conn.prepareStatement(ora);
                ps.setString(1, ID2.getText());
                ps.setString(2, kiedy2.getText());
                ps.setString(3, "2");
                ps.setInt(4, Integer.parseInt(ile2.getText())*250);
                ps.setString(5, ile2.getText());

                rs = (OracleResultSet) ps.executeQuery();
                
                if(rs.next())
       {                                 
        Alert rezerwacja = new Alert(Alert.AlertType.INFORMATION);
            rezerwacja.setTitle("ZAREZERWOWANO!");
            rezerwacja.setHeaderText(null);
            rezerwacja.setContentText("Zarezerwowano pomyślnie!");
            rezerwacja.showAndWait();   
       }   
         } catch(SQLException e){
           if(ID.getText().isEmpty()){
            Alert rejka = new Alert(Alert.AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij swoje ID!");
                rejka.showAndWait();
            }
           else if(kiedy.getText().isEmpty()){
            Alert rejka = new Alert(Alert.AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij datę rezerwacji!");
                rejka.showAndWait();
            }
           else if(ile.getText().isEmpty()){
            Alert rejka = new Alert(Alert.AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij na ile dni chcesz wynająć!");
                rejka.showAndWait();
            }
         }        
    }
        
         public void waw_info2(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
        conn = DataBase.ConnectDB();
        String orcl = "SELECT * FROM APARTAMENT WHERE APARTAMENT_ID = 2";
        PreparedStatement wps2 = conn.prepareStatement(orcl);
        ResultSet wrs2 = wps2.executeQuery();
        if(wrs2.next()){
        String ID_A2=wrs2.getString("APARTAMENT_ID");
        String nr_r2=wrs2.getString("ROOM_NR");
        String floor2=wrs2.getString("FLOOR");
        String own2=wrs2.getString("OWNERS");
        String beds2=wrs2.getString("BEDS");
        String price2=wrs2.getString("PRICE");
        String rate_w2=wrs2.getString("RATE_ROOM");
        String smoke2=wrs2.getString("SMOKING");
        String pet2=wrs2.getString("PET_FRIENDLY");
        String ava2=wrs2.getString("AVAILABILITY");
        String city2=wrs2.getString("CITY");
            
            lID_A2.setText("ID apartamtentu: "+ID_A2);
            lnr_r2.setText("Numer pokoju: "+nr_r2);
            lfloor2.setText("Piętro: "+floor2);
            lown2.setText("Ilość gości: "+own2);
            lbeds2.setText("Łóżka: "+beds2);
            lprice2.setText("Cena: "+price2);
            lrate_w2.setText("Ocena: "+rate_w2);
            lsmoke2.setText("Możliwość palenia: "+smoke2);
            lpet2.setText("Zwierzęta: "+pet2);
            lava2.setText("Dostępność: "+ava2);
            lcity2.setText("Miasto: "+city2);
            
            loginController lc = new loginController();
            System.out.println(lc.getid());
         }
         }
         public void ukryj_w2(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
         
            lID_A2.setText("");
            lnr_r2.setText("");
            lfloor2.setText("");
            lown2.setText("");
            lbeds2.setText("");
            lprice2.setText("");
            lrate_w2.setText("");
            lsmoke2.setText("");
            lpet2.setText("");
            lava2.setText("");
            lcity2.setText("");
         }
      //Krakow
            public void ap_waw3(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
         conn = DataBase.ConnectDB();
         
         try{
         String ora = "INSERT INTO RESERVATION (GUEST_ID, RESERVATION_DATE, APARTAMENT_ID, PRICE, RENT_DAYS) VALUES (?,?,?,?,?)";

                ps = (OraclePreparedStatement)conn.prepareStatement(ora);
                ps.setString(1, ID3.getText());
                ps.setString(2, kiedy3.getText());
                ps.setString(3, "1");
                ps.setInt(4,  Integer.parseInt(ile3.getText())*150);
                ps.setString(5, ile3.getText());

                rs = (OracleResultSet) ps.executeQuery();
                
                if(rs.next())
       {                                 
        Alert rezerwacja = new Alert(Alert.AlertType.INFORMATION);
            rezerwacja.setTitle("ZAREZERWOWANO!");
            rezerwacja.setHeaderText(null);
            rezerwacja.setContentText("Zarezerwowano pomyślnie!");
            rezerwacja.showAndWait();   
       }   
         } catch(SQLException e){
           if(ID.getText().isEmpty()){
            Alert rejka = new Alert(Alert.AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij swoje ID!");
                rejka.showAndWait();
            }
           else if(kiedy.getText().isEmpty()){
            Alert rejka = new Alert(Alert.AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij datę rezerwacji!");
                rejka.showAndWait();
            }
           else if(ile.getText().isEmpty()){
            Alert rejka = new Alert(Alert.AlertType.INFORMATION);
                rejka.setTitle("Błąd");
                rejka.setHeaderText(null);
                rejka.setContentText("Uzupełnij na ile dni chcesz wynająć!");
                rejka.showAndWait();
            }
         }        
    }
        
         public void waw_info3(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
        conn = DataBase.ConnectDB();
        String orcl = "SELECT * FROM APARTAMENT WHERE APARTAMENT_ID = 3";
        PreparedStatement wps = conn.prepareStatement(orcl);
        ResultSet wrs = wps.executeQuery();
        if(wrs.next()){
        String ID_A=wrs.getString("APARTAMENT_ID");
        String nr_r=wrs.getString("ROOM_NR");
        String floor=wrs.getString("FLOOR");
        String own=wrs.getString("OWNERS");
        String beds=wrs.getString("BEDS");
        String price=wrs.getString("PRICE");
        String rate_w=wrs.getString("RATE_ROOM");
        String smoke=wrs.getString("SMOKING");
        String pet=wrs.getString("PET_FRIENDLY");
        String ava=wrs.getString("AVAILABILITY");
        String city=wrs.getString("CITY");
            
            lID_A3.setText("ID apartamtentu: "+ID_A);
            lnr_r3.setText("Numer pokoju: "+nr_r);
            lfloor3.setText("Piętro: "+floor);
            lown3.setText("Ilość gości: "+own);
            lbeds3.setText("Łóżka: "+beds);
            lprice3.setText("Cena: "+price);
            lrate_w3.setText("Ocena: "+rate_w);
            lsmoke3.setText("Możliwość palenia: "+smoke);
            lpet3.setText("Zwierzęta: "+pet);
            lava3.setText("Dostępność: "+ava);
            lcity3.setText("Miasto: "+city);
            
            loginController lc = new loginController();
            System.out.println(lc.getid());
         }
         }
         public void ukryj_w3(ActionEvent event) throws IOException, SQLException, ClassNotFoundException  {
         
            lID_A3.setText("");
            lnr_r3.setText("");
            lfloor3.setText("");
            lown3.setText("");
            lbeds3.setText("");
            lprice3.setText("");
            lrate_w3.setText("");
            lsmoke3.setText("");
            lpet3.setText("");
            lava3.setText("");
            lcity3.setText("");
         }
}


 
