package mvc.graphics.team;

import javax.swing.*;
import java.awt.*;

public class ImageOfTeam extends JPanel{

    private JLabel etiquetaImagen;

    public ImageOfTeam(String ruta)
    {
        FlowLayout fl = new FlowLayout();
        setLayout(fl);

        ImageIcon imagen = new ImageIcon("src/mvc/images/equipos/laMafiaRusa.png");
        etiquetaImagen = new JLabel("");
        etiquetaImagen.setIcon(imagen);
        
         add(etiquetaImagen);


    }
}
