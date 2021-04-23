package mvc.graphics.team;

import mvc.graphics.InterfaceTournament;
import mvc.graphics.player.ButtonTeamPanel;
import mvc.graphics.player.ImageOfTeam;
import mvc.graphics.player.TeamInfoPanel;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TeamPanel extends JPanel {

    private ButtonTeamPanel buttonTeamPanel;
    private TeamInfoPanel teamInfoPanel;
    private ImageOfTeam imageOfTeam;
    private InterfaceTournament principal;

    public TeamPanel( InterfaceTournament ventana ) {

        principal = ventana;
        setLayout( new GridLayout( 1, 3 ));
        setBorder( new CompoundBorder( new EmptyBorder(0 , 0, 0, 0 ), new TitledBorder( "Equipos" ) ) );

        teamInfoPanel = new TeamInfoPanel();
        add(teamInfoPanel);

        imageOfTeam = new ImageOfTeam();
        add(imageOfTeam);

        buttonTeamPanel = new ButtonTeamPanel();
        add(buttonTeamPanel);
    }
}
