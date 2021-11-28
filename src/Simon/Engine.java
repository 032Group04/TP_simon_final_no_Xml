package Simon;


import java.util.ArrayList;

public class Engine {

    private enum color{blue,green,red,yellow}
    private ArrayList gameSequence = new ArrayList();
    private ArrayList userSequence = new ArrayList();
    private boolean good;

    public Engine(){
        good= true;

    }



    public void addGameSequence(){
        gameSequence.add(color.values()[randomChoice()]);

    }


    /*
    * générateur de nombre aléatoire, renvoie entre 0 et 3
    */
    public int randomChoice(){
        double resultDouble = Math.random() * 4;
        if(resultDouble < 1){
            return 0;
        }
        else if(resultDouble > 1 && resultDouble < 2){
            return 1;
        }
        else if(resultDouble > 2 && resultDouble < 3){
            return 2;
        }
        else{
            return 3;
        }

    }
    /*
    * fonction d'ajout et de vérification de la touche saisie par l'utilisateur
    */
    public boolean addUserSequence(String userColor, int index) {
        userSequence.add(color.valueOf(userColor));
        if(userSequence.get(index)==gameSequence.get(index)){
            return true;
        }
        else return false;
    }

    public ArrayList getUserSequence() {
        return userSequence;
    }



    public ArrayList getGameSequence() {
        return gameSequence;
    }
    /*
    * effacer les séquences
    */
    public void resetSequences(){
        gameSequence.clear();
        userSequence.clear();
    }
}
