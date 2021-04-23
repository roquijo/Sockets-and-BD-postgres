package mvc.graphics.player;

import mvc.graphics.InterfaceTournament;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PlayerPanel extends JPanel {

    private ButtonTeamPanel buttonPlayerPanel;
    private TeamInfoPanel playerInfoPanel;
    private ImageOfTeam imageOfPlayer;
    private InterfaceTournament principal;

    public PlayerPanel( InterfaceTournament ventana ) {

        principal = ventana;
        setLayout( new GridLayout( 1, 3 ));
        setBorder( new CompoundBorder( new EmptyBorder(0 , 0, 0, 0 ), new TitledBorder( "Jugadores" ) ) );


        playerInfoPanel = new TeamInfoPanel();
        add(playerInfoPanel);

        imageOfPlayer = new ImageOfTeam();
        add(imageOfPlayer);

        buttonPlayerPanel = new ButtonTeamPanel();
        add(buttonPlayerPanel);
    }
}
