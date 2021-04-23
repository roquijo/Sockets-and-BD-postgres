package mvc.graphics.banner;

import mvc.graphics.InterfaceTournament;

import javax.swing.*;
import java.awt.*;

public class PanelBanner extends JPanel {

    private JLabel etiquetaPanel;
    private String rutaBanner = "src/mvc/graphics/banner/Banner.jpg";
    private InterfaceTournament principal;

    public PanelBanner(InterfaceTournament ventana)
    {
        principal = ventana;
        FlowLayout fl = new FlowLayout();
        setLayout(fl);

        ImageIcon imagen = new ImageIcon(rutaBanner);
        etiquetaPanel = new JLabel("");
        etiquetaPanel.setIcon(imagen);
        add(etiquetaPanel);

    }


}
