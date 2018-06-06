package Metier;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Agent extends Thread implements Observer {
    //connaissances
    private Coordonnee position;
    private Coordonnee posifinale;
    private Color couleur;
    static Grille grille; //Il va falloir gérer les accès concurrents


    public Agent(int Xini, int Yini, int Xfin, int Yfin, Color c){
        super();
        position = new Coordonnee(Xini, Yini);
        posifinale = new Coordonnee(Xfin, Yfin);
        couleur = c;
    }
    //comportements
    public void run(){
        while(!grille.fin()){
            Boolean hasmoved=false;

            //On commence par vérifier quelles sont les positions voisines dans la grille


            if(!isPosFin()){
                ArrayList<Coordonnee> posipossibles = new ArrayList();
                Coordonnee deplacement = position;
                double distance = position.getDistance(posifinale);
                if(position.getX()+1<grille.getTaille()){
                    posipossibles.add(new Coordonnee(position.getX()+1,position.getY()));
                }
                if(position.getX()-1>=0){
                    posipossibles.add(new Coordonnee(position.getX()-1,position.getY()));
                }
                if(position.getY()+1<grille.getTaille()){
                    posipossibles.add(new Coordonnee(position.getX(),position.getY()+1));
                }
                if(position.getY()-1>=0){
                    posipossibles.add(new Coordonnee(position.getX(),position.getY()-1));
                }
                for(Coordonnee posi: posipossibles){
                    if(!grille.getCases().get(posi.getX()*7+posi.getY()).isOccupee()
                            && posi.getDistance(posifinale)<distance){
                        hasmoved = true;
                        distance = posi.getDistance(posifinale);
                        deplacement = posi;
                    }
                }
                if(!deplacement.equals(position)){
                    move(position.getDirection(deplacement));
                }else{

                }


            }

        }
    }

    //tant que le puzzle n'est oas reconstitué
        //chercher à satisfaire son but
        //traiter les messages()

    public boolean isPosFin(){
        return position.equals(posifinale);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public void move(char commande){
        Case actualCase = grille.getCases().get(position.getY()+position.getX()*grille.getTaille());
        switch(commande){
            case 'h':
                actualCase.setA(null);
                actualCase.setOccupee(false);
                position.setY(position.getY()+1);
                grille.getCases().get(position.getY()+position.getX()*grille.getTaille()).setA(this);
                grille.getCases().get(position.getY()+position.getX()*grille.getTaille()).setOccupee(true);
                break;
            case 'b':
                actualCase.setA(null);
                actualCase.setOccupee(false);
                position.setY(position.getY()-1);
                grille.getCases().get(position.getY()+position.getX()*grille.getTaille()).setA(this);
                grille.getCases().get(position.getY()+position.getX()*grille.getTaille()).setOccupee(true);
                break;
            case 'g':
                actualCase.setA(null);
                actualCase.setOccupee(false);
                position.setX(position.getX()-1);
                grille.getCases().get(position.getY()+position.getX()*grille.getTaille()).setA(this);
                grille.getCases().get(position.getY()+position.getX()*grille.getTaille()).setOccupee(true);
                break;
            case 'd':
                actualCase.setA(null);
                actualCase.setOccupee(false);
                position.setX(position.getX()+1);
                grille.getCases().get(position.getY()+position.getX()*grille.getTaille()).setA(this);
                grille.getCases().get(position.getY()+position.getX()*grille.getTaille()).setOccupee(true);
                break;
        }
        //faire l'update grapgique
    }


    public Coordonnee getPosition() {
        return position;
    }

    public void setPosition(Coordonnee position) {
        this.position = position;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Coordonnee getPosifinale(){
        return posifinale;
    }
}
