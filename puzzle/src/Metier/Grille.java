package Metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Grille{
    private ArrayList<Agent> agents;
    private int taille;
    private StructureMess messages;
    private Map<Integer, Case> cases;

    public Grille(int n){
        taille =n;
        cases = new HashMap();
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                cases.put(i*7+j, new Case(i,j));
            }
        }
    }

    public boolean fin(){
        boolean rep = true;
        for(Agent agent: agents){
            if(!agent.isPosFin()){
                rep = false;
            }
        }
        return rep;
    }

    public void setCasesBools(){
        for(int i=0; i<taille*taille; i++){
            cases.get(i).setOccupee(false);
        }
        for(Agent agent: agents){
            cases.get(agent.getPosition().getX()*7+agent.getPosition().getY()).setOccupee(true);
        }
    }




    public int getTaille() {
        return taille;
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public StructureMess getMessages() {
        return messages;
    }

    public Map<Integer, Case> getCases() {
        return cases;
    }
}
