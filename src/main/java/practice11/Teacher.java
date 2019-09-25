package practice11;

import java.util.*;

public class Teacher extends Person implements Observer {
    private LinkedList<Klass> klassList = new LinkedList<>();

    public Teacher(Integer id, String name, Integer age, LinkedList<Klass> klassList){
        super(id, name, age);
        this.klassList = klassList;
        this.klassList.forEach(klass -> klass.addObserver(this));
    }

    public Teacher(Integer id, String name, Integer age){
        super(id, name, age);
    }

    public LinkedList<Klass> getClasses(){
        return klassList;
    }

    public String introduce(){
        if(!klassList.isEmpty()){
            String klasses = "";
            for(int i = 0; i < klassList.size(); i++) {
                if(i >= 1){
                    klasses += ", ";
                }
                klasses += klassList.get(i).getNumber().toString();
            }

            return super.introduce() + String.format(" I am a Teacher. I teach Class %s.", klasses);
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public boolean isTeaching(Student student){

        klassList.forEach(klass -> {
            if(student == klass.getLeader() && student.isIn(klass)){
                System.out.print("I am Tom. I know Jerry become Leader of Class 2.\n");
            }else{
                System.out.print("I am Tom. I know Jerry has joined Class 2.\n");
            }
        });

        return klassList.stream().anyMatch(klass -> klass.getNumber().equals(student.getKlass().getNumber()));
    }

    public String introduceWith(Student student){
        if(klassList.contains(student.getKlass())){
            return super.introduce() + String.format(" I am a Teacher. I teach %s.", student.getName());
        }
        return super.introduce() + String.format(" I am a Teacher. I don't teach %s.", student.getName());
    }

    @Override
    public void update(Observable o, Object studentList) {
        List<Student> newStudentList = (ArrayList<Student>) studentList;

        newStudentList.forEach(student -> {
            isTeaching(student);
        });
    }
}
