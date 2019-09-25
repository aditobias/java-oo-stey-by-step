package practice10;

import java.util.LinkedList;

public class Teacher extends Person{
    private LinkedList<practice10.Klass> linkedList = new LinkedList<>();

    public Teacher(Integer id, String name, Integer age, LinkedList<Klass> linkedList){
        super(id, name, age);
        this.linkedList = linkedList;
    }

    public Teacher(Integer id, String name, Integer age){
        super(id, name, age);
    }

    public LinkedList<Klass> getClasses(){
        return linkedList;
    }

    public String introduce(){
        if(!linkedList.isEmpty()){
            String klasses = "";
            for(int i = 0; i < linkedList.size(); i++) {
                if(i >= 1){
                    klasses += ", ";
                }
                klasses += linkedList.get(i).getNumber().toString();
            }

            return super.introduce() + String.format(" I am a Teacher. I teach Class %s.", klasses);
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public boolean isTeaching(Student student){
        if(linkedList.contains(student.getKlass()) && student.isIn()){
            return true;
        }
        return false;
    }

    public String introduceWith(Student student){
        if(linkedList.contains(student.getKlass())){
            return super.introduce() + String.format(" I am a Teacher. I teach %s.", student.getName());
        }
        return super.introduce() + String.format(" I am a Teacher. I don't teach %s.", student.getName());
    }
}
