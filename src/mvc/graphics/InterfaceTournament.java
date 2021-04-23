package mvc.graphics;

import mvc.controller.BuilderObject;

import javax.swing.*;
import java.awt.*;

public class InterfaceTournament extends  JFrame{

    private  BuilderObject builderObject;
    private  ButtonFacultyPanel buttonFacultyPanel;
    private  ButtonTeamPanel buttonTeamPanel;
    private  ButtonPlayerPanel buttonPlayerPanel;
    private  FacultyInfoPanel facultyInfoPanel;
    private  TeamInfoPanel teamInfoPanel;
    private  PlayerInfoPanel playerInfoPanel;

    public InterfaceTournament() {

        //builderObject = object;

        setLayout( new GridBagLayout( ) );
        setSize( 800, 600 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setResizable(false);

        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;

        buttonFacultyPanel = new ButtonFacultyPanel( this );
        gbc.gridy = 3;
        add( buttonFacultyPanel, gbc );

        buttonTeamPanel = new ButtonTeamPanel( this );
        gbc.gridy = 4;
        add( buttonTeamPanel, gbc );

        buttonPlayerPanel = new ButtonPlayerPanel( this );
        gbc.gridy = 5;
        add( buttonPlayerPanel, gbc );

        facultyInfoPanel = new FacultyInfoPanel( this );
        gbc.gridy = 5;
        add( facultyInfoPanel, gbc );

        teamInfoPanel = new TeamInfoPanel( this );
        gbc.gridy = 5;
        add( teamInfoPanel, gbc );

        playerInfoPanel = new PlayerInfoPanel( this );
        gbc.gridy = 5;
        add( playerInfoPanel, gbc );
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
