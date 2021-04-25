package server.dto;

import java.io.Serializable;

public class TeamDto implements Dto, Serializable {

    private static final long       serialVersionUID = 916479397570182364L;
    private  String  name;
    private  String  captain;
    private  String imageTeam;
    private  int idFaculty;
    private TeamDto root;

    public TeamDto(String name, String captain, String imageTeam, int idOfFaculty) {

        this.name = name;
        this.captain = captain;
        this.imageTeam = imageTeam;
        this.idFaculty = idOfFaculty;
    }

    public TeamDto(String name) {
        this.name = name;
    }

    public TeamDto() {
    }

    @Override
    public String insert() {
        String sql = "INSERT INTO public.team(name, captain, image_team, id_faculty) VALUES ("+"'"
                + name + "','"
                + captain + "','"
                + imageTeam+ "',"
                + idFaculty + ")"
                ;
        System.out.println(sql);
        return sql;
    }

    @Override
    public String update() {

        String sql = "UPDATE public.team SET name= '"+name
                +"', captain='" + captain
                +"', image_team= '"+ imageTeam +
                "' WHERE id_of_faculty = " + idFaculty;
        System.out.println(sql);
        return sql;
    }

    @Override
    public String delete() {

        return "DELETE FROM team WHERE name = " + name;
    }

    @Override
    public String findById() {

        return "SELECT * FROM team WHERE name = " + name;
    }

    @Override
    public String read() {

        return "SELECT * FROM team";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getImageTeam() {
        return imageTeam;
    }

    public void setImageTeam(String imageTeam) {
        this.imageTeam = imageTeam;
    }

    public int getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    public TeamDto getRoot() {
        return root;
    }

    public void setRoot(TeamDto root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "TeamDto{" +
                "name='" + name + '\'' +
                ", captain='" + captain + '\'' +
                ", imageTeam='" + imageTeam + '\'' +
                ", idFaculty=" + idFaculty +
                "}";
    }
}
