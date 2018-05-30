public class Agent extends Thread {
    //connaissances
    private Coordonnee posiInitiale;
    private Coordonnee posifinale;
    static Grille grille; //Il va falloir grer les accès concurrents


    public Agent(int Xini, int Yini, int Xfin, int Yfin){
        super();
        posiInitiale = new Coordonnee(Xini, Yini);
        posifinale = new Coordonnee(Xfin, Yfin);
    }
    //comportements
    public void run(){
        while(!grille.fin()){

        }
    }

    //tant que le puzzle n'est oas reconstitué
        //chercher à satisfaire son but
        //traiter les messages()

    public boolean isPosFin(){
        return posiInitiale.equals(posifinale);
    }

}
