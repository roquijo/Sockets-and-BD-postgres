package mvc.graphics.player;

import mvc.graphics.InterfaceTournament;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    private ButtonTeamPanel buttonPlayerPanel;
    private TeamInfoPanel playerInfoPanel;
    private ImageOfTeam imageOfPlayer;
    private InterfaceTournament principal;

    public PlayerPanel( InterfaceTournament ventana ) {

        principal = ventana;
        setLayout( new GridLayout( 1, 3 ));

        playerInfoPanel = new TeamInfoPanel();
        add(playerInfoPanel);

        imageOfPlayer = new ImageOfTeam();
        add(imageOfPlayer);

        buttonPlayerPanel = new ButtonTeamPanel();
        add(buttonPlayerPanel);
    }
}
