package Metier;

public class Coordonnee {
    private int x;
    private int y;

    public Coordonnee(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getDistance(Coordonnee coord2){
        return Math.sqrt((coord2.getX()-x)*(coord2.getX()-x) + (coord2.getY()-y)*(coord2.getY()-y));
    }

    public boolean equals(Coordonnee coord2){
        return coord2.getX()==x && coord2.getY()==y;
    }
}
