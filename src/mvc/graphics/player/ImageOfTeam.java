package mvc.graphics.player;

import javax.swing.*;
import java.awt.*;

public class ImageOfTeam extends JPanel {

    private JLabel etiquetaImagen;
    private String ruta;

        //Player
        public ImageOfTeam()
        {

            FlowLayout fl = new FlowLayout();
            setLayout(fl);

            ImageIcon imagen = new ImageIcon("src/mvc/images/jugadores/camisetaLaMafiaRusa.png");
            etiquetaImagen = new JLabel("");
            etiquetaImagen.setIcon(imagen);

            add(etiquetaImagen);

        }


}
