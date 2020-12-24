//bsc-13-18
//importing from interfaces class

import javafx .application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

//feedcal class obtains access to use methods from application

public class FeedCal extends Application {

//defining the variables to be used
  private   double maizestr;
  private   double soyastr;
  private   double groundnutstr;
  private   double saltstr;
  private   double feedInKgstr;

// creating object constructors

        TextField maize = new TextField();
        TextField soya = new TextField();
        TextField groundnuts = new TextField();
        TextField salt = new TextField();


       Text maizeUsed = new Text();
       Text soyaUsed = new Text();
       Text groundnutsUsed = new Text();
       Text saltUsed = new Text();
       Text youWillMake = new Text();

//get already defined method add use it in the Feedcal class

     @Override
     public void start(Stage primaryStage){
//creating object grid pane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5,14.5));
//setting gaps between the Horizontal and vertical sections
        grid.setHgap(5);
        grid.setVgap(5);

//adding display text to pane
        grid.add(new Text("Enter ingredients amount in kilograms (kgs)"),0,0);


//adding textField to pane
        grid.add(new Label("Maize"),0,1);
        grid.add(maize,1, 1);
        grid.add(new Label("Soya"),0,2);
        grid.add(soya,1,2);
        grid.add(new Label("Groundnuts"),0,3);
        grid.add(groundnuts,1,3);
        grid.add(new Label("Salt"),0, 4);
        grid.add(salt,1,4);

//defining and adding button calculate to the pane

        Button cal = new Button("Calculate");
        grid.add(cal, 1, 5);

//registering button handlers and creating event handler class

        HandlerClass handler1 = new HandlerClass();
        cal.setOnAction(handler1);

//drawing line demarcation

        Line line1 = new Line(0, 0, 240, 0);
        grid.add(line1, 0, 6);

        Line line2 = new Line(0, 0, 200, 0);
        grid.add(line2, 1, 6);

//add  display text to pane

        grid.add(new Text ("you will use (kg)"),0,8);

        grid.add(new Text ("Maize:"),0,9);

        grid.add(maizeUsed,1,9);

        grid.add(new Text("Soya:"),0,10);

        grid.add(soyaUsed,1,10);

        grid.add(new Text("Groundnuts:"),0,11);

        grid.add(groundnutsUsed,1,11);

        grid.add(new Text("Salt:"),0,12);

        grid.add(saltUsed,1,12);

        grid.add(youWillMake, 0, 13);


        Scene scene = new Scene(grid);
        primaryStage.setTitle("CalculatorFeed");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void Convection() {


        String maizeInput = maize.getText();
        String soyaInput = soya.getText();
        String groundnutsInput = groundnuts.getText();
        String saltInput = salt.getText();
//conveting String values to  numbers with data type
        
        maizestr = Integer.parseInt(maizeInput);
        soyastr = Integer.parseInt(soyaInput);
        groundnutstr = Integer.parseInt(groundnutsInput);
        saltstr = Integer.parseInt(saltInput);

    }

    class HandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Convection();

            
            for(int i = 1;
                maizestr >= 60 && soyastr >= 20
                        && groundnutstr >= 15
                        && saltstr >= 5; i++) {

                feedInKgstr = 100 * i;                
                maizestr = maizestr - 60;
                maizeUsed.setText("" + i * 60);

                soyastr = soyastr - 20;
                soyaUsed.setText("" + i * 20);

                groundnutstr = groundnutstr - 15;
                groundnutsUsed.setText("" + i * 15);

                saltstr= saltstr - 5;
                saltUsed.setText("" + i * 5);

            }
            youWillMake.setText("You will make " + feedInKgstr + "kgs of feed");
        }
    }

}