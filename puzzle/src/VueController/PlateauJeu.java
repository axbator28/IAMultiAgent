package VueController;

import Metier.Case;
import Metier.Grille;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PlateauJeu extends Thread {
    Grille grille;

    PlateauJeu(){
        super();
    }


    @Override

    public void run(){

        BorderPane border = new BorderPane();

        GridPane gPane = new GridPane();

        border.setCenter(gPane);

        int column;

        int row;



        int largeur= 30; //largeur des rectangles

        int hauteur = 30; //epaisseur des rectangles

        //grille.chutePieceCourante();

        for (row=0; row < grille.getTaille(); row++){

            for (column = 0; column < grille.getTaille(); column++){

                Case c = grille.getCases().get(column+row*grille.getTaille());
                Rectangle rect = new Rectangle();

                rect.setWidth(largeur);

                rect.setHeight(hauteur);

                StackPane stack = null;
                if (c.isOccupee()){
                    rect.setFill((c.getA().getCouleur()));
                }

                else{

                    rect.setFill(Color.WHITE);
                    stack = new StackPane();
                    stack.getChildren().addAll(rect);
                }

                GridPane.setRowIndex(rect, row);

                GridPane.setColumnIndex(rect, column);
                gPane.getChildren().addAll(rect);
                //grillerect[row][column] = rect;
            }

            //grille.chutePieceCourante();

        }

    }
}
