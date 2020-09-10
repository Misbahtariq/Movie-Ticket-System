import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
	Stage stage;
	Scene scene;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage=stage;
		stage.setTitle("Cinema");
		
		component();
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	
	private void component(){
		
	
		Image ima=new Image("images/1.jpg");
		ImageView imview=new ImageView(ima);
		Button admin =new Button("Login as admin");
		Button Customer =new Button("Enter as Customer");
		HBox hb=new HBox();
		hb.setSpacing(20);
		hb.getChildren().addAll(admin,Customer);
		Group root=new Group();
		root.getChildren().addAll(imview,hb);
		
		scene=new Scene(root, 1300,500,Color.DARKBLUE);
		
		admin.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				Admin m =new Admin();
				
				
			}
		});
		Customer.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Customer c=new Customer();
				stage.hide();
			}
		});
	}
	
	
	
	
}
