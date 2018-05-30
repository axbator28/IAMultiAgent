package Metier;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Agent extends Thread implements Observer {
    //connaissances
    private Coordonnee position;
    private Coordonnee posifinale;
    private String avatar;
    static Grille grille; //Il va falloir gérer les accès concurrents


    public Agent(int Xini, int Yini, int Xfin, int Yfin, String ava){
        super();
        position = new Coordonnee(Xini, Yini);
        posifinale = new Coordonnee(Xfin, Yfin);
        avatar = ava;
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
        switch(commande){
            case 'h':
                position.setY(position.getY()+1);
                break;
            case 'b':
                position.setY(position.getY()-1);
                break;
            case 'g':
                position.setX(position.getX()-1);
                break;
            case 'd':
                position.setX(position.getX()+1);
                break;
        }
    }


    public Coordonnee getPosition() {
        return position;
    }

    public void setPosition(Coordonnee position) {
        this.position = position;
    }
}
