import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Admin {

	String username;
	String pasward;
	String Movie,Time,Date;
	Stage stage;
	Scene scene;
	Customer cus=new Customer(1);
	
	
	
	public Admin(){
		stage=new Stage();
		admin();
		stage.setScene(scene);
		stage.show();
		
	}
	private void admin(){
		Label lbl=new Label("Welcome to Cinema");
		lbl.setFont(Font.font(30));
		lbl.setTextFill(Color.RED);
		lbl.setAlignment(Pos.TOP_CENTER);
		Label ulbl=new Label("User name");
		ulbl.setTextFill(Color.WHITE);
		ulbl.setFont(Font.font(15));
		TextField uf=new TextField();
		Label plbl=new Label("Pasward");
		plbl.setTextFill(Color.WHITE);
		plbl.setFont(Font.font(15));
		PasswordField pf=new PasswordField();
		Button login=new Button("login");
		HBox hb=new HBox();
		hb.setAlignment(Pos.TOP_CENTER);
		hb.setSpacing(10);
		hb.getChildren().addAll(ulbl,uf);
		HBox hb1=new HBox();
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.TOP_CENTER);
		hb1.getChildren().addAll(plbl,pf);
		VBox vb=new VBox();
		vb.getChildren().addAll(lbl,hb,hb1,login);
		vb.setAlignment(Pos.TOP_CENTER);
		vb.setSpacing(30);
		Image im=new Image("images/5.jpg");
		ImageView view=new ImageView(im);
		Group root=new Group();
		root.getChildren().addAll(view,vb);
		
		
		scene=new Scene(root, 1000, 500);
		login.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				String name="shiwani";
				String pasward="42769";
			if(name.equals(uf.getText()) && pasward.equals(pf.getText()))
			{
				Admin a=new Admin(ulbl.getText(), plbl.getText());
				stage.hide();
				}
			
			else{
			
				Alert msg=new Alert(AlertType.ERROR);
				msg.setHeaderText("error");
				msg.setContentText("invalid user name or pasward");
				msg.show();
			}
			}
		});
		
	}
	public Admin (String name,String pasward ){
		this.username=name;
		this.pasward=pasward;
		stage=new Stage();
		stage.setTitle("Movies");
		addmovies();
		stage.setScene(scene);
		stage.show();
		
	}
	private void addmovies(){
		Label l=new Label("Welcome Sir");
		l.setFont(Font.font(20));
		Label movie=new Label("Enter Movies details");
		movie.setFont(Font.font(15));
		movie.setTextFill(Color.WHITE);
		Label m=new Label("Enter movie name");
		m.setTextFill(Color.WHITE);
		TextField mf=new TextField();
		
		HBox hb=new HBox();
		hb.setSpacing(10);
		hb.setAlignment(Pos.TOP_CENTER);
		hb.getChildren().addAll(m,mf);
		
		Label t=new Label("Enter time");
		t.setTextFill(Color.WHITE);
		TextField tf=new TextField();
	
		HBox hb1=new HBox();
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.TOP_CENTER);
		hb1.getChildren().addAll(t,tf);
		
		Label d=new Label("Enter date ");
		d.setTextFill(Color.WHITE);
		TextField df=new TextField();
		
		HBox hb2=new HBox();
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.TOP_CENTER);
		hb2.getChildren().addAll(d,df);
		TableView table=new TableView<>();
		TableColumn<String, Gulshan> cName=new TableColumn<>("Moviename");
		TableColumn<String,	Gulshan> cDate=new TableColumn<>("show date");
		TableColumn<String,	Gulshan> cTime=new TableColumn<>("show time");
		
		cName.setCellValueFactory(new PropertyValueFactory<>("Moviename"));
		cDate.setCellValueFactory(new PropertyValueFactory<>("Showdate"));
		cTime.setCellValueFactory(new PropertyValueFactory<>("Showtime"));
		
		table.getColumns().add(cName);
		table.getColumns().add(cDate);
		table.getColumns().add(cTime);
		
	
		
		Button done=new Button("done");
		VBox vb=new VBox();
		vb.getChildren().addAll(l,movie,hb,hb1,hb2,done);
		vb.setAlignment(Pos.TOP_CENTER);
		vb.setSpacing(20);
		
		GridPane gp=new GridPane();
		gp.add(vb, 0, 0);
		gp.setHgap(40);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.add(table, 2, 0);
		Image im=new Image("images/bkg-2.png");
		ImageView view =new ImageView(im);
		Group root=new Group();
		root.getChildren().addAll(view,gp);
	
		done.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				
				
				Gulshan gulshan=new Gulshan(mf.getText(), tf.getText(),df.getText());
				
				table.getItems().add(gulshan);
				cus.setTableData(gulshan);
				
			
			
		
				
				mf.setText(null);
				tf.setText(null);
				df.setText(null);
			
				Alert msg=new Alert(AlertType.INFORMATION);
				msg.setContentText("Movies Update");
				msg.show();}

			
		});scene =new Scene(root, 1000, 500);
	}
}
