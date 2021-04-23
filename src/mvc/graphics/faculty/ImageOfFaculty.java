package mvc.graphics.faculty;

import javax.swing.*;
import java.awt.*;

public class ImageOfFaculty extends JPanel{

    private JLabel etiquetaImagen;
    private String ruta;

    public ImageOfFaculty()
    {
        FlowLayout fl = new FlowLayout();
        setLayout(fl);

        ImageIcon imagen = new ImageIcon(ruta);
        etiquetaImagen = new JLabel("" );
        etiquetaImagen.setIcon(imagen);

    }
}
