package Simon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar {

    private JMenu rollMenu;
    private JMenuItem rollMenuSub1;
    private JMenuItem rollMenuSub2;
    private JMenuItem rollMenuSub3;
    private JMenuItem rollMenuSub4;

    private JMenu highScoresMenu;
    private JMenuItem facileSubMenu;
    private JMenuItem moyenSubMenu;
    private JMenuItem difficileSubMenu;
    private JMenu soundsMenu;
    private JMenuItem sounds;
    public Menu() {
        super();

        /*
        menu déroulant partie
         */
        rollMenu = new JMenu("partie");

        rollMenuSub1 = new JMenuItem("facile");
        rollMenuSub2 = new JMenuItem("moyen");
        rollMenuSub3 = new JMenuItem("difficile");
        rollMenuSub4 = new JMenuItem("menu principal");
        rollMenu.setOpaque(true);

        /*
        menu déroulant high scores
         */
        highScoresMenu = new JMenu("high scores");

        facileSubMenu = new JMenuItem("facile");
        moyenSubMenu = new JMenuItem("moyen");
        difficileSubMenu = new JMenuItem("difficile");
        soundsMenu = new JMenu("options");
        sounds = new JMenuItem("désactiver les sons");

        this.add(rollMenu);
        this.add(soundsMenu);
        soundsMenu.add(sounds);
        sounds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Game.isSoundsEnabled()){
                    Game.setSoundsEnabled(false);
                    sounds.setText("activer les sons");
                }
                else{
                    Game.setSoundsEnabled(true);
                    sounds.setText("désactiver les sons");
                }
            }
        });




    }

/* barre de menus hors jeu*/

    public void mainMenu(){
        rollMenu.add(rollMenuSub1);
        rollMenu.add(rollMenuSub2);
        rollMenu.add(rollMenuSub3);
        rollMenu.remove(rollMenuSub4);
        highScoresMenu.add(facileSubMenu);
        highScoresMenu.add(moyenSubMenu);
        highScoresMenu.add(difficileSubMenu);
        this.add(highScoresMenu);
        rollMenu.updateUI();

    }
/* barre de menus in-game*/

    public void GameMenu(){
        rollMenu.remove(rollMenuSub1);
        rollMenu.remove(rollMenuSub2);
        rollMenu.remove(rollMenuSub3);
        this.remove(highScoresMenu);
        rollMenu.updateUI();
        rollMenu.add(rollMenuSub4);
    }


    public JMenuItem getFacileSubMenu() {
        return facileSubMenu;
    }

    public JMenuItem getMoyenSubMenu() {
        return moyenSubMenu;
    }

    public JMenuItem getDifficileSubMenu() {
        return difficileSubMenu;
    }

    public JMenuItem getRollMenuSub1() {
        return rollMenuSub1;
    }

    public JMenuItem getRollMenuSub2() {
        return rollMenuSub2;
    }

    public JMenuItem getRollMenuSub3() {
        return rollMenuSub3;
    }

    public JMenuItem getRollMenuSub4() {
        return rollMenuSub4;
    }


}
