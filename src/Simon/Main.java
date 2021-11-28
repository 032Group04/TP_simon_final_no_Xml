package Simon;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {



    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MyWindow myWindow = new MyWindow();
        MainMenu mainMenu = new MainMenu();
        myWindow.setContentPane(mainMenu);
        Menu menu = new Menu();
        //Sound sound = new Sound("resources/Trololo.wav");
        menu.mainMenu();
        myWindow.setJMenuBar(menu);
        myWindow.setVisible(true);
        myWindow.pack();

    /**
    * listeners menu déroulant partie
    */
        menu.getRollMenuSub1().addActionListener(new ActionListener() { /* menu facile */
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game("facile");
                play(game, myWindow, menu, mainMenu);
            }
        });

        menu.getRollMenuSub2().addActionListener(new ActionListener() { /* menu moyen */
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game("moyen");
                play(game, myWindow, menu, mainMenu);
            }
        });

        menu.getRollMenuSub3().addActionListener(new ActionListener() { /* menu difficile */
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game("difficile");
                play(game, myWindow, menu, mainMenu);
            }
        });
        /**
         * listeners du menu déroulant scores
         */

        menu.getFacileSubMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkScores("facile");
            }
        });
        menu.getMoyenSubMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkScores("moyen");
            }
        });
        menu.getDifficileSubMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkScores("difficile");
            }
        });



    }

    public static void play(Game game, MyWindow myWindow, Menu menu, MainMenu mainMenu) {
        myWindow.setContentPane(game.getMainPanel());
        game.startGame();
        menu.GameMenu();
        game.getPlayButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.gameTurn();
                game.getPlayButton().setVisible(false);
            }
        });
        menu.getRollMenuSub4().addActionListener(new ActionListener() { /* retour au menu principal */
            @Override
            public void actionPerformed(ActionEvent e) {
                game.gameStop();
//                System.out.println("retour menu game stopped");
                menu.mainMenu();
                myWindow.setContentPane(mainMenu);
                menu.getRollMenuSub4().removeActionListener(menu.getRollMenuSub4().getActionListeners()[0]);

            }
        });
    }

    public static void checkScores(String difficulty){
        try {
            HighScore highScore = new HighScore();
            JOptionPane.showMessageDialog(null,"High score "+ difficulty +" : "+highScore.readScore(difficulty));
        }catch(IOException e){

        }
    }


}
