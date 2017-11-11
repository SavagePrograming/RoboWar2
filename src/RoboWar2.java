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
    private Canvas canvas;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        arena = new BouncingArena();
        for (int i = 0; i < 100; i ++){
            arena.add(new Robot(arena, arena.getMASS_DEFAULT(), (int)(Math.random() * arena.getRADIUS_DEFAULT() + 1),
                    (int)(Math.random() * arena.getWidth() + 1),  (int)(Math.random() * arena.getHeight() + 1),
                    (int)(Math.random() * 11 - 5),  (int)(Math.random() * 11 - 5)));
        }


        arenaControler = new ArenaControler(arena);
        arenaControler.setSpeed(5);
        System.out.println("Setting Up Gui and Arena");


        BorderPane pane = new BorderPane();

        canvas = new Canvas(arena.getWidth(), arena.getHeight());
//        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

//        graphicsContext.fillOval(10, 60, 30, 30);
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


        arena.addObserver(this);
        arenaControler.start();


    }

    @Override
    public void update(Observable o, Object arg) {
//        System.out.println("Update Recived");
        javafx.application.Platform.runLater( () ->
                updateGuiLater(o, arg)
        );
    }

    private void updateGuiLater(Observable o, Object arg){
//        System.out.println("Update Recived");
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0,0,arena.getWidth(), arena.getHeight());
        if (o instanceof Arena){
            graphicsContext.setFill(Color.GREEN);
//            graphicsContext.fillOval(10, 60, 30, 30);
            for (ArenaItem item:((Arena) o).getItems()){
                int r = item.getRadius();
                graphicsContext.fillOval(item.getxLocation() - r, item.getyLocation() - r, 2 * r , 2 * r );
            }
        }

    }

    @Override
    public void stop() throws Exception {
        arenaControler.exit();
        super.stop();
    }
}
