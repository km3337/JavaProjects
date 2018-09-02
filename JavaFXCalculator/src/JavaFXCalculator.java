import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXCalculator extends Application {
	TextField txtCharacter;
    TextField txtActor;
	public static void main(String[] args) {
	launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle("Calculator");
	GridPane primaryGrid= createGrid();
	
	Scene scene = new Scene(primaryGrid, 400, 400);
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	
	public GridPane createGrid() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
	    columnOneConstraints.setHalignment(HPos.RIGHT);
		
		final TextField input1= new TextField();
		input1.setPromptText("1st Num");
		
		final TextField input2= new TextField();
		input2.setPromptText("2nd Num");
		
		final TextField result= new TextField();
		result.setPromptText("result:");
		result.setEditable(false);
		
		HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");

	    Button add = new Button("+");
		Button subtract = new Button("-");
		Button multiply= new Button("*");
		Button divide= new Button ("/");
		
		add.setOnAction(e-> add(result,input1,input2));
		subtract.setOnAction(e-> subtract(result,input1,input2));
		multiply.setOnAction(e-> multiply(result,input1,input2));
		divide.setOnAction(e-> divide(result,input1,input2));
		
	    hbox.getChildren().addAll(add,subtract,multiply,divide);

		
		grid.add(input1,0, 1);
		grid.add(input2,0,2);
		grid.add(result, 3, 1);
		grid.add(hbox, 2, 1);
		return grid;
		
	}
	
	
	public static void add(TextField result, TextField num1, TextField num2) 
	{
		if(!(num1.getText().isEmpty()) && !(num2.getText().isEmpty()) ){
		 String conv1=num1.getText();
		 String conv2=num2.getText();
		 int answer= Integer.parseInt(conv1)+Integer.parseInt(conv2);
		 result.setText(Integer.toString(answer));
		}
		
	}
	
	public static void subtract(TextField result, TextField num1, TextField num2) 
	{
		if(!(num1.getText().isEmpty()) && !(num2.getText().isEmpty()) ){
			 String conv1=num1.getText();
			 String conv2=num2.getText();
			 int answer= Integer.parseInt(conv1)-Integer.parseInt(conv2);
			 result.setText(Integer.toString(answer));
			}
	}
	
	public static void multiply(TextField result, TextField num1, TextField num2) 
	{
		if(!(num1.getText().isEmpty()) && !(num2.getText().isEmpty()) ){
		 String conv1=num1.getText();
		 String conv2=num2.getText();
		 int answer= Integer.parseInt(conv1)*Integer.parseInt(conv2);
		 result.setText(Integer.toString(answer));
		}
		
	}
	
	public static void divide(TextField result, TextField num1, TextField num2) {
	if(!(num1.getText().isEmpty()) && !(num2.getText().isEmpty()) ){
		 String conv1=num1.getText();
		 String conv2=num2.getText();
		 int answer= Integer.parseInt(conv1) / Integer.parseInt(conv2);
		 result.setText(Integer.toString(answer));
		}
	}

}
