package Metier;

public class Case {
    private Coordonnee coord;
    private boolean occupee;
    private Agent a;

    public Case(int x, int y){
        coord = new Coordonnee(x,y);
    }

    public Coordonnee getCoord() {
        return coord;
    }

    public void setCoord(Coordonnee coord) {
        this.coord = coord;
    }

    public boolean isOccupee() {
        return occupee;
    }

    public void setOccupee(boolean occupee) {
        this.occupee = occupee;
    }

    public Agent getA() {
        return a;
    }

    public void setA(Agent a) {
        if(!isOccupee()) {
            this.a = a;
        }
    }

}
