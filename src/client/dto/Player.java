package client.dto;

import java.io.Serializable;

public class Player implements Dto, Serializable {

    private static final long  serialVersionUID = 916479397570182364L;
    private  int idPlayer;
    private  String  name;
    private  String  position;
    private  int  age;
    private  String nameOfTeam;
    private  String imagePlayer;
    private Player root;

    public Player(int idPlayer, String name, String position, int age, String nameOfTeam, String imagePlayer) {

        this.idPlayer = idPlayer;
        this.name = name;
        this.position = position;
        this.age = age;
        this.nameOfTeam = nameOfTeam;
        this.imagePlayer = imagePlayer;

        System.out.println(name);
    }



    public Player(int identification) {

        this.idPlayer = identification;
    }

    public Player() {
    }

    @Override
    public String insert() {

        //INSERT INTO public.player(id_player, name, position, age, name_of_team, image_player) VALUES ('123','jorge','delantero','15','nacional','asdasd')
        String sql = "INSERT INTO public.player(id_player, name, position, age, name_of_team, image_player) VALUES ('"
                + idPlayer +"', '"
                + name + "','"
                + position + "','"
                + age + "','"
                + nameOfTeam+ "','"
                + imagePlayer+"');";
        return sql;
    }

    @Override
    public String update() {

        String sql = "UPDATE public.player SET name= '"+name
                +"', position='" + position
                +"', age='" + age +
                "' WHERE id_player = " + idPlayer;
        return sql;
    }

    @Override
    public String delete() {

        return "DELETE FROM player WHERE id_player = " + idPlayer;
    }

    @Override
    public String findById() {

        return "SELECT * FROM player WHERE id_player = " + idPlayer;
    }

    @Override
    public String read() {

        return "SELECT * FROM player";
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNameOfTeam() {
        return nameOfTeam;
    }

    public void setNameOfTeam(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
    }

    public String getImagePlayer() {
        return imagePlayer;
    }

    public void setImagePlayer(String imagePlayer) {
        this.imagePlayer = imagePlayer;
    }

    public Player getRoot() {
        return root;
    }

    public void setRoot(Player root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                "idPlayer=" + idPlayer +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", nameOfTeam='" + nameOfTeam + '\'' +
                ", imagePlayer='" + imagePlayer + '\'' +
                '}';
    }
}
