import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

/**
 * The Cleint Class For Robowars 2
 * origional program by Kevin Hertzberg
 * This similar game by William
 *
 */
public class RoboWar2 extends Application implements Observer {
    private Arena arena;
    private ArenaControler arenaControler;
    private GraphicsContext graphicsContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        arena = new Arena();
        for (int i = 0; i < 10; i ++){

        }
        arena.addObserver(this);

        arenaControler = new ArenaControler(arena);
        System.out.println("Setting Up Gui and Arena");


        BorderPane pane = new BorderPane();

        Canvas canvas = new Canvas(Arena.WIDTH, Arena.HEIGHT);
        graphicsContext = canvas.getGraphicsContext2D();

        pane.setTop(canvas);

        BorderPane bottom = new BorderPane();

        Button onOff = new Button("On/Off");
        onOff.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        arenaControler.turnOnOff();
                    }
                });

        Button step = new Button("step");
        step.setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        arenaControler.step();
                    }
                });

        bottom.setRight(step);
        bottom.setLeft(onOff);

        pane.setBottom(bottom);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();



    }

    @Override
    public void update(Observable o, Object arg) {
        javafx.application.Platform.runLater( () ->
                updateGuiLater(o, arg)
        );
    }

    private void updateGuiLater(Observable o, Object arg){
        if (o instanceof Arena){
            graphicsContext.setFill(Color.GREEN);
            for (ArenaItem item:((Arena) o).getItems()){
                int r = item.getRadius();
                graphicsContext.fillOval(item.getxLocation() - r, item.getyLocation() - r, 2 * r, 2 * r);
            }
        }

    }
}
