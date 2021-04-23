package mvc.graphics;

import mvc.controller.BuilderObject;
import mvc.graphics.faculty.FacultyPanel;
import mvc.graphics.player.PlayerPanel;
import mvc.graphics.player.TeamInfoPanel;
import mvc.graphics.team.TeamPanel;

import javax.swing.*;
import java.awt.*;

//Interface Main
public class InterfaceTournament extends  JFrame{

    private  BuilderObject builderObject;
    private FacultyPanel facultyPanel;
    private TeamPanel teamPanel;
    private PlayerPanel playerPanel;

    public InterfaceTournament() {

        //builderObject = object;

        setLayout( new GridLayout( 3, 1 ));
        setSize( 800, 600 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setResizable(false);

        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.fill = GridBagConstraints.BOTH;

        facultyPanel = new FacultyPanel( this );
        add(facultyPanel, gbc );

        teamPanel = new TeamPanel( this );
        add(teamPanel, gbc );

        playerPanel = new PlayerPanel( this );
        add(playerPanel, gbc );

    }
/*
    JComboBox comboFacultad = new JComboBox();

    NodeList<FacultyDto> facultyList = new NodeList<>();
    FacultyDao faculty = new FacultyDao();
    FacultyDto facultyDto = new FacultyDto();
    facultyList = faculty.read(facultyDto);
        for (int i = 0; i < facultyList.getSize(); i++) {
        comboFacultad.addItem(facultyList.pop(i).getName());
    }


        comboFacultad.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    });*/
/*
    public static void main(String[] args) {
        InterfaceTournament gui = new InterfaceTournament();
        JFrame frame = new JFrame("Torneo Futbol Universidad De Ibagué");
        frame.setContentPane((gui.panelPrincipal));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
 */
    public static void main( String[] args )
    {/*
        BuilderObject builderObject = null;

        try
        {
            builderObject = new BuilderObject( "./data/Equipos.txt" );
        }
        catch( PersistenciaException e )
        {
            e.printStackTrace( );
            System.exit( 1 );
        }
        */
        InterfaceTournament id = new InterfaceTournament( );
        id.setVisible( true );
    }
}
