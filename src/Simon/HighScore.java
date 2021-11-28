package Simon;

import javax.swing.*;
import java.io.*;

public class HighScore {
    private File scoreFile;
    private RandomAccessFile accessFile;
    private int topScore;
    private long position;

    public HighScore() throws IOException{
        topScore = 0;
        try {
            scoreFile = new File("score.txt");

            /*vérification de la présence d'un fichier de sauvegarde des scores*/
            if(scoreFile.isFile()){
                System.out.println("file exists");
                accessFile = new RandomAccessFile(scoreFile,"r");

                topScore = accessFile.readInt();

                accessFile.seek(0);

            }
            /*création du fichier de sauvegarde des scores*/
            else{
                System.out.println("file created");
                accessFile= new RandomAccessFile(scoreFile,"rw");
//                System.out.println("fichier créé");

                accessFile.writeInt(0);
                accessFile.writeChar('|');
                accessFile.writeInt(0);
                accessFile.writeChar('|');
                accessFile.writeInt(0);
                accessFile.seek(0);



//                System.out.println("fichier après creation: "+ accessFile.readLine());
//                accessFile.seek(0);
                accessFile.close();
            }

        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }

    }

    /*
    * fonction test: vérification architecture du fichier de sauvegarde bit par bit


//    public void seekScore() throws IOException{
//        accessFile= new RandomAccessFile(scoreFile,"r");
//        for(int i = 0; i< accessFile.length();i++){
//            System.out.println(accessFile.read());
//            System.out.println("i= "+ i);
//        }
//        //while(accessFile.readChar() != '|')
//    }

     */

     /* fonction de lecture du score */
    public int readScore (String difficulty) throws IOException{
        accessFile= new RandomAccessFile(scoreFile,"r");

        if(difficulty == "facile"){
            position = 0;
            accessFile.seek(position);
            topScore = accessFile.readInt();
            System.out.println("score facile "+ topScore);
        }
        else if(difficulty == "moyen"){
            position = 6;
            accessFile.seek(position);
            topScore = accessFile.readInt();
            System.out.println("score moyen "+ topScore);
        }
        else if (difficulty == "difficile"){
            position = 12;
            accessFile.seek(position);
            topScore = accessFile.readInt();
            System.out.println("score difficile "+ topScore);
        }
        accessFile.close();
        return topScore;
    }

    /*
    * mise a jour du high score
    */

    public void setScore(int _topScore, String _diffculty) throws IOException{
        readScore(_diffculty);
        accessFile= new RandomAccessFile(scoreFile,"rw");

        if(_topScore > topScore){
            System.out.println("nouveau topscore");
            accessFile.seek(position);
            accessFile.writeInt(_topScore);
            JOptionPane.showMessageDialog(null,"nouveau meilleur Score en mode "+ _diffculty+
                    " : " + _topScore);
        }
        accessFile.close();
    }
}
