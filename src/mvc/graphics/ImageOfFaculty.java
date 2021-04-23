package mvc.graphics;

import javax.swing.*;
import java.awt.*;

public class ImageOfFaculty extends JPanel{

    private JLabel etiquetaImagen;

    public ImageOfFaculty(String ruta)
    {
        FlowLayout fl = new FlowLayout();
        setLayout(fl);

        ImageIcon imagen = new ImageIcon(ruta);
        etiquetaImagen = new JLabel("" );
        etiquetaImagen.setIcon(imagen);

    }
}
