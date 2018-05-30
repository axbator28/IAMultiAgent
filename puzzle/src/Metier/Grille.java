package Metier;

import java.util.ArrayList;

public class Grille{
    private ArrayList<Agent> agents;
    private int taille;
    private StructureMess messages;

    public boolean fin(){
        boolean rep = true;
        for(Agent agent: agents){
            if(!agent.isPosFin()){
                rep = false;
            }
        }
        return rep;
    }



}
