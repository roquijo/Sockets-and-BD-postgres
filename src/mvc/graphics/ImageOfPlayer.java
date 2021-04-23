package mvc.graphics;

import javax.swing.*;
import java.awt.*;

public class ImageOfPlayer extends JPanel {

    private JLabel etiquetaImagen;


        public ImageOfPlayer(String ruta)
        {

            FlowLayout fl = new FlowLayout();
            setLayout(fl);

            ImageIcon imagen = new ImageIcon(ruta);
            etiquetaImagen = new JLabel("");
            etiquetaImagen.setIcon(imagen);

        }


}
