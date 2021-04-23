package mvc.graphics.player;

import mvc.graphics.InterfaceTournament;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PlayerPanel extends JPanel {

    private ButtonPlayerPanel buttonPlayerPanel;
    private PlayerInfoPanel playerInfoPanel;
    private ImageOfTeam imageOfPlayer;
    private InterfaceTournament principal;

    public PlayerPanel( InterfaceTournament ventana ) {

        principal = ventana;
        setLayout( new GridLayout( 1, 3 ));
        setBorder( new TitledBorder("Jugadores"));
        



        playerInfoPanel = new PlayerInfoPanel();
        add(playerInfoPanel);

        imageOfPlayer = new ImageOfTeam();
        add(imageOfPlayer);

        buttonPlayerPanel = new ButtonPlayerPanel();
        add(buttonPlayerPanel);
    }
}
