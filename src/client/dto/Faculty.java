package client.dto;

import java.io.Serializable;

public class Faculty implements Dto, Serializable {

    private static final long       serialVersionUID = 916479397570182364L;
    private  int idFaculty;
    private  String name;
    private  String code;
    private  String imageFaculty;
    private Faculty root;
    private Faculty facultyDto;

    public Faculty(int idFaculty, String name, String code, String imageFaculty) {

        this.idFaculty = idFaculty;
        this.name = name;
        this.code = code;
        this.imageFaculty = imageFaculty;
    }

    public Faculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    public Faculty() {
    }

    @Override
    public String insert() {

        String sql = "INSERT INTO public.faculty(id_Faculty, name, code, image_faculty) VALUES ('"
                + idFaculty +"', '"
                + name + "','"
                + code + "','"
                + imageFaculty + "');";
        System.out.println(sql);
        return sql;
    }

    @Override
    public String read() {

        return "SELECT * FROM faculty";
    }

    @Override
    public String update() {

        String sql = "UPDATE public.faculty SET code= '"+ code
                 +
                "' WHERE id_faculty = '" + idFaculty + "'";
        System.out.println(sql);
        return sql;
    }

    @Override
    public String delete() {

        return "DELETE FROM faculty WHERE id_faculty = " + idFaculty;
    }

    @Override
    public String findById() {

        return "SELECT * FROM faculty WHERE id_faculty = " + idFaculty;
    }

    public int getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImageFaculty() {
        return imageFaculty;
    }

    public void setImageFaculty(String imageFaculty) {
        this.imageFaculty = imageFaculty;
    }

    public Faculty getRoot() {
        return root;
    }

    public void setRoot(Faculty root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "FacultyDto{" +
                "idFaculty=" + idFaculty +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", imageFaculty='" + imageFaculty + '\'' +
                '}';
    }
}
