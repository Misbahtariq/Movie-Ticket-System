import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
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

public class Customer {
	Stage stage;
	Scene scene;
	String email,name,contactno;
	VBox vb=new VBox();	Label lbl=new Label("Welcome to Cinema");Label sea=new Label("Your movie ");

	static TableView table =new TableView<>();
	Customer (int i){
		
	}
	public Customer()
	{
		stage=new Stage();
		Customer1();
		stage.setScene(scene);
		stage.show();
	}
	public Customer(String name ,String cno,String email){
		stage = new Stage();
		this.name=name;
		this.email=email;
		this.contactno=cno;
		showmovies();
		stage.setScene(scene);
		stage.show();
	}
	private void Customer1(){
		
	
		lbl.setFont(Font.font(30));
		lbl.setTextFill(Color.RED);
		lbl.setAlignment(Pos.TOP_CENTER);
		Label ulbl=new Label("Name");
		TextField uf=new TextField();
		Label plbl=new Label("Contact number");
		TextField pf=new TextField();
		Label albl=new Label("Email address");
		TextField af=new TextField();
		Button login=new Button("login");
		GridPane gp=new GridPane();
		gp.add(lbl, 0, 0);
		gp.add(ulbl, 0, 1);
		gp.add(uf, 1, 1);
		gp.add(plbl, 0, 2);
		gp.add(pf, 1, 2);
		gp.add(albl, 0, 3);
		gp.add(af, 1, 3);
	
		gp.add(login, 1, 5);
		gp.setAlignment(Pos.TOP_CENTER);
		gp.setVgap(30);
		gp.setHgap(10);
		Image im=new Image("images/2.jpg");
		ImageView view=new ImageView(im);
		Group root=new Group();
		root.getChildren().addAll(view,gp);
		scene=new Scene(root,900, 680);
		login.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				Customer c=new Customer(uf.getText(), pf.getText(), af.getText());
				stage.hide();
			}
		});
		
	}
	void showmovies(){
		Gulshan Gmovies[]=new Gulshan[5];
		
	
		Label n=new Label("your name :");
		n.setTextFill(Color.WHITE);
		n.setFont(Font.font(15));
		Label gn=new Label(name);
		gn.setFont(Font.font(15));
		gn.setTextFill(Color.WHITE);
		
		Label c=new Label("Contact number ");
		c.setTextFill(Color.WHITE);
		c.setFont(Font.font(15));
		
		Label gc=new Label(contactno);
		gc.setFont(Font.font(15));
		gc.setTextFill(Color.WHITE);
		
		Label e=new Label("Email :");
		e.setFont(Font.font(15));
		e.setTextFill(Color.WHITE);
		
		Label ge=new Label(email);
		ge.setFont(Font.font(15));
		ge.setTextFill(Color.WHITE);
		
		//Label sea=new Label("Your movie ");
		sea.setFont(Font.font(15));
		sea.setTextFill(Color.WHITE);
		
		
		Button done=new Button("ticket generate ");
		
		Label movies=new Label("Movie detail");
		movies.setFont(Font.font(15));
		movies.setTextFill(Color.WHITE);
		
		ComboBox<String > cb=new ComboBox<>();
	
		
		TableColumn<String , Gulshan> cname=new TableColumn<>("Movie name");
		TableColumn<String, Gulshan> ctime=new TableColumn<>("Show time");
		TableColumn<String, Gulshan> cdate=new TableColumn<>("Show date");
		
		cname.setCellValueFactory(new PropertyValueFactory<>("Moviename"));
		ctime.setCellValueFactory(new PropertyValueFactory<>("Showtime"));
		cdate.setCellValueFactory(new PropertyValueFactory<>("Showdate"));
		table.getColumns().add(cname);
		table.getColumns().add(ctime);
		table.getColumns().add(cdate);
		Gulshan g = new Gulshan("iron man", "dsa", "ds");
		Gulshan g1 = new Gulshan("ant man", "dsa", "ds");
		Gulshan g2 = new Gulshan("hulk", "dsa", "ds");
		cb.getItems().addAll(g.moviename,g1.moviename,g2.moviename);
		setTableData(g);
	
			
		
		
		done.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				for(Gulshan show:Gmovies){
					
				if(show.moviename.equalsIgnoreCase(cb.getValue())) {
					Gulshan sh=new Gulshan(show.moviename, show.showtime, show.showdate, 1);
					stage.hide();
				}
				}
			}
		});
		
		
		
		HBox hb=new HBox();
		hb.setSpacing(10);
		hb.setAlignment(Pos.TOP_CENTER);
		hb.getChildren().addAll(n,gn);
		
		HBox hb1=new HBox();
		hb1.setSpacing(10);
		hb1.setAlignment(Pos.TOP_CENTER);
		hb1.getChildren().addAll(c,gc);
		
		HBox hb2=new HBox();
		hb2.setSpacing(10);
		hb2.setAlignment(Pos.TOP_CENTER);
		hb2.getChildren().addAll(e,ge);
		

		HBox hb4=new HBox();
		hb4.setSpacing(10);
		hb4.setAlignment(Pos.TOP_CENTER);
		hb4.getChildren().addAll(sea,cb); 
		
		HBox hb5=new HBox();
		hb5.setSpacing(10);
		hb5.setAlignment(Pos.TOP_CENTER);
		hb5.getChildren().addAll(hb4,table);
		
	
		vb.setSpacing(20);
		vb.setAlignment(Pos.TOP_CENTER);
		vb.getChildren().addAll(hb,hb1,hb2,movies,hb5,done);
		
		
		Image im=new Image("images/4.jpg");
		ImageView view =new ImageView(im);
		
		Group root=new Group();
		root.getChildren().addAll(view,vb);
		
		scene =new Scene(root, 900, 630);
	}
	
	
	
	void setTableData(Gulshan g)
	{
	System.out.println("Worked");
		table.getItems().add(g);
	}
}
