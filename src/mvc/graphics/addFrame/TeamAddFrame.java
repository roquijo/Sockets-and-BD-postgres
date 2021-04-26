package mvc.graphics.addFrame;

import client.dto.Team;
import mvc.controller.ControllerForTeam;
import mvc.graphics.team.TeamInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamAddFrame extends JFrame implements ActionListener {

   private static final String ADD = "Agregar";
   private static final String CANCEL = "Cancelar";

    static Team teamDto;

   private JLabel jlblNombre;
   private JLabel jlblCapitan;
   private JLabel jlblIdentificador;
   private JLabel jlblImagen;
   private JLabel jlblTitle;

   private JTextField txtNombre;
   private JTextField txtCapitan;
   private JTextField txtIdentificador;
   private JTextField txtImagen;

   private JButton btnAgregar;
   private JButton btnCancelar;

   private JPanel infoPanel;
   private JPanel btnPanel;

   public TeamAddFrame(){

           setTitle("Agregar Equipo");
           setLayout(new BorderLayout());
           setSize( 350, 250 );
           setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
           setLocationRelativeTo(null);
           setResizable(false);

           Font font = new Font("Arial", 2, 16);
           Font fontTxt = new Font("Arial", 2, 16);

           //Titulo
           jlblTitle = new JLabel("AGREGAR EQUIPO", SwingConstants.CENTER);
           jlblTitle.setFont(new Font("Arial", 2, 22));
           add(jlblTitle, BorderLayout.NORTH);

           //JPanel FLowLayout
           infoPanel = new JPanel();
           infoPanel.setLayout(new FlowLayout());

           add(infoPanel, BorderLayout.CENTER);

           //Info

            jlblNombre = new JLabel("Nombre        ");
            jlblNombre.setFont(font);

            jlblCapitan = new JLabel("Capitan         ");
            jlblCapitan.setFont(font);

            jlblIdentificador = new JLabel("Identificador ");
            jlblIdentificador.setFont(font);

            jlblImagen = new JLabel("Ruta Imagen");
            jlblImagen.setFont(font);

            txtNombre = new JTextField();
            txtNombre.setPreferredSize(new Dimension( 200, 30 ));
            txtNombre.setFont(fontTxt);
            txtNombre.setEditable(true);

            txtCapitan = new JTextField();
            txtCapitan.setPreferredSize(new Dimension( 200, 30 ));
            txtCapitan.setFont(fontTxt);
            txtCapitan.setEditable(true);

            txtIdentificador = new JTextField();
            txtIdentificador.setPreferredSize(new Dimension( 200, 30 ));
            txtIdentificador.setFont(fontTxt);
            txtIdentificador.setEditable(true);

            txtImagen = new JTextField();
            txtImagen.setFont(fontTxt);
            txtImagen.setPreferredSize(new Dimension( 200, 30 ) );
            txtImagen.setEditable(true);

            infoPanel.add(jlblNombre);
            infoPanel.add(txtNombre);

            infoPanel.add(jlblCapitan);
            infoPanel.add( txtCapitan);

            infoPanel.add(jlblIdentificador);
            infoPanel.add(txtIdentificador);

            infoPanel.add(jlblImagen);
            infoPanel.add(txtImagen);

            //JPanel FLowLayout
            btnPanel = new JPanel();
            btnPanel.setLayout(new GridLayout(1,2));

            add(btnPanel, BorderLayout.SOUTH);

            //Botones
            btnAgregar = new JButton( "Agregar" );
            btnAgregar.setActionCommand(ADD);
            btnAgregar.addActionListener( this );

            btnCancelar = new JButton( "Cancelar" );
            btnCancelar.setActionCommand(CANCEL);
            btnCancelar.addActionListener( this );

            btnPanel.add(btnAgregar);
            btnPanel.add(btnCancelar);
   }

     public static Team getTeamDto() {
        return teamDto;
    }

    public void setTeamDto(Team teamDto) {
        this.teamDto = teamDto;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

    String comando = evento.getActionCommand();

             if(ADD.equals(comando))
             {
                 teamDto = new Team(txtNombre.getText(),txtCapitan.getText(), txtImagen.getText(),Integer.parseInt(txtIdentificador.getText()));
                 TeamInfoPanel.limpiar();
                 TeamInfoPanel.actualizarLista(teamDto);
                 TeamInfoPanel.llenarCombobox();
                 ControllerForTeam.ControllerForAddTeam(teamDto);
                 JOptionPane.showMessageDialog(null,"El Equipo Ha Sido Agregado");
                 dispose();
                }
             else if( CANCEL.equals( comando ) )
             {
                 JOptionPane.showMessageDialog(null,"Cancelado");
                 dispose();
             }

    }
}
