import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Gulshan {
	Stage stage;
	Scene scene;
	Admin d;
	String moviename=null;
	String showtime=null;
	String showdate=null;
	Gulshan g[]=new Gulshan[5];
	public Gulshan(String Movie, String time,String date,int i){
		this.moviename=Movie;
		this.showtime=time;
		this.showdate=date;
		stage=new Stage();
		stage.setTitle("Tickets");
		viewshow();
		stage.setScene(scene);
		stage.show();
	}
	public Gulshan(String Movie, String time,String date){
		this.moviename=Movie;
		this.showtime=time;
		this.showdate=date;
	}
	
	public String getMoviename(){
		return moviename;
	}
	public String getShowdate(){
		return showdate;
	}
	public String getShowtime(){
		return	showtime;
	}
	void viewshow(){
		Label tic=new Label("Ticket");
		tic.setFont(Font.font(20));
		Label m=new Label("Movie name");
		Label movie=new Label(moviename);
		Label t=new Label("Movie Time");
		Label time=new Label(showtime);
		Label da=new Label("Movie Date");
		Label Date=new Label(showdate);
		Label price=new Label("Price =500");
		HBox hb=new HBox();
		hb.setSpacing(10);
		hb.setAlignment(Pos.TOP_LEFT);
		hb.getChildren().addAll(m,movie);
		
		HBox hb1=new HBox();
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.TOP_LEFT);
		hb1.getChildren().addAll(t,time);
		
		HBox hb2=new HBox();
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.TOP_LEFT);
		hb2.getChildren().addAll(da,Date);
		
		VBox vb=new VBox();
		vb.setSpacing(20);
		vb.setAlignment(Pos.TOP_LEFT);
		vb.getChildren().addAll(tic,hb,hb1,hb2,price);
		scene =new Scene(vb, 500, 200);
	}
	
	

}
