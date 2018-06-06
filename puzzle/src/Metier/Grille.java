package Metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Grille extends Observable {
    private ArrayList<Agent> agents;
    private int taille;
    private StructureMess messages;
    private Map<Integer, Case> cases;

    public Grille(int n){
        taille =n;
        agents= new ArrayList<Agent>();
        cases = new HashMap();
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                cases.put(i*n+j, new Case(i,j));
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

    public void addAgent(Agent a){
        boolean posioufinok = true;
        for(Agent ag : agents){
            if(ag.getPosition().equals(a.getPosition())|| ag.getPosifinale().equals(a.getPosifinale())){
                posioufinok=false;
            }
        }
        if(posioufinok){
            agents.add(a);
            cases.get(a.getPosition().getY()+a.getPosition().getX()*taille).setA(a);
            cases.get(a.getPosition().getY()+a.getPosition().getX()*taille).setOccupee(true);
        }

    }
}
