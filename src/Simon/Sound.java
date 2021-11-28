package Simon;

import javax.sound.sampled.*;
import javax.swing.*;

import java.io.File;
import java.io.IOException;

public class Sound {
    private Clip clip;
    private String path;
    private File file;

    /*
    * classe générant les sons.
    *
    * Le constructeur déclenche la lecture
    */

    public Sound(String _path){

        path = _path;
        file = new File(path);
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.start();
        }catch (UnsupportedAudioFileException auE){
            JOptionPane.showMessageDialog(null,auE.toString());
        }catch (IOException ioE){
            JOptionPane.showMessageDialog(null,ioE.toString());
        }catch (LineUnavailableException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }



    }


}
