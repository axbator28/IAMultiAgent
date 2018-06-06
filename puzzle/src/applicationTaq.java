import Metier.Agent;
import Metier.Grille;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class applicationTaq extends Application {
    private Grille g;
    private Rectangle[][] grillerect;


    public Grille getGrille(){
        return g;
    }

    public Rectangle[][] GetGrilleRect(){
        return grillerect;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        final int taille =4;
        g = new Grille(taille);
        //faire l'ajout des agents
        g.addAgent(new Agent(2,1,1,1,Color.BISQUE));
        g.addAgent(new Agent(3,2,1,2,Color.GREEN));
        System.out.println(g.getCases().get(1+taille*2).isOccupee());

        BorderPane border = new BorderPane();
        grillerect = new Rectangle[taille][taille];

        GridPane gPane = new GridPane();
        border.setCenter(gPane);
        int column;
        int row;

        int largeur= 50; //largeur des rectangles
        int hauteur = 50; //epaisseur des rectangles


        for (row=0; row < taille; row++) {
            for (column = 0; column < taille; column++) {
                Rectangle rect = new Rectangle();
                Text a = new Text();
                rect.setWidth(largeur);
                rect.setHeight(hauteur);
                if (g.getCases().get(row+column*taille).isOccupee()){
                    rect.setFill(g.getCases().get(row+column*taille).getA().getCouleur());
                    System.out.println(row +" "+ column);
                    a.setText(Integer.toString(g.getCases().get(row+column*taille).getA().getPosifinale().number(taille)));

                }
                else{
                    rect.setFill(Color.WHITE);
                }

                GridPane.setRowIndex(rect, row);
                GridPane.setColumnIndex(rect, column);
                gPane.getChildren().addAll(rect);
                GridPane.setRowIndex(a, row);
                GridPane.setColumnIndex(a, column);
                gPane.getChildren().addAll(a);
                grillerect[row][column] = rect;

            }
        }
        g.addObserver(new Observer() {

            @Override
            public void update(Observable o, Object arg) {
                for (int i=0; i < taille; i++){
                    for (int j = 0; j < taille; j++){
                        if (g.getCases().get(j+i*taille).isOccupee()) {
                            grillerect[i][j].setFill(g.getCases().get(j + i * taille).getA().getCouleur());
                        }else{
                            grillerect[i][j].setFill(Color.WHITE);
                        }
                    }
                }
            }
        });
        //startthread Thread(g).start();
        gPane.setGridLinesVisible(true);

        border.setCenter(gPane);
        Scene scene = new Scene(border, Color.WHITE);
        primaryStage.setTitle("Taquin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**

     * @param args the command line arguments

     */

    public static void main(String[] args) {
        launch(args);

    }
}
