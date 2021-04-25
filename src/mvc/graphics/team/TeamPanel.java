package mvc.graphics.team;

import mvc.graphics.InterfaceTournament;
import mvc.graphics.player.ButtonPlayerPanel;
import mvc.graphics.player.ImageOfTeam;
import mvc.graphics.player.PlayerInfoPanel;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TeamPanel extends JPanel {

    private ButtonPlayerPanel buttonTeamPanel;
    private PlayerInfoPanel playerInfoPanel;
    private ImageOfTeam imageOfTeam;
    private InterfaceTournament principal;

    public TeamPanel( InterfaceTournament ventana ) {

        principal = ventana;
        setLayout( new GridLayout( 1, 3 ));
        setBorder( new CompoundBorder( new EmptyBorder(0 , 0, 0, 0 ), new TitledBorder( "Equipos" ) ) );

        playerInfoPanel = new PlayerInfoPanel();
        add(playerInfoPanel);

        imageOfTeam = new ImageOfTeam();
        add(imageOfTeam);

        buttonTeamPanel = new ButtonPlayerPanel();
        add(buttonTeamPanel);
    }
}