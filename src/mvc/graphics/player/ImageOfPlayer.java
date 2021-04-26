package mvc.graphics.player;

import mvc.graphics.addFrame.PlayerAddFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ImageOfPlayer extends JPanel {

    PlayerAddFrame addFrame;

    private JLabel etiquetaImagen;
    private String ruta;

        //Player
        public ImageOfPlayer() {
            FlowLayout fl = new FlowLayout();
            setLayout(fl);

            //addFrame = new PlayerAddFrame();
            //ruta = addFrame.getImagen();

            try {
                ImageIcon imagen = new ImageIcon(ruta);
                etiquetaImagen = new JLabel("");
                etiquetaImagen.setIcon(imagen);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


            add(etiquetaImagen);

        }
/*
    public  String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

 */


}
