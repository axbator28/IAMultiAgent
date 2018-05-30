package Metier;

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
            if(!isPosFin()){

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
}
