import java.util.ArrayList;
import java.util.List;

public class Persona {
    public String name;
    public Gender gender;
    public Persona mother;
    public Persona father;
    public Persona partner;
    List<Persona> childList = new ArrayList<>();

    public Persona(String nameString, Gender genderGender, Persona motherPersona,Persona fatherPersona) {
        this.name = nameString;
        this.gender = genderGender;
        this.mother = motherPersona;
        this.father = fatherPersona;
    }


    public void addChild(Persona p) {
        childList.add(p);
    }

    public ArrayList<Persona> getChildList(){
        return (ArrayList<Persona>) childList;
    }

}

