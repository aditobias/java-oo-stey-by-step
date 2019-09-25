package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Klass extends Observable {
    private Integer number;
    private Student leader;
    private List<Student> studentList;

    public Klass(Integer number){
        this.number = number;
        studentList = new ArrayList<>();

    }

    public Integer getNumber() {
        return number;
    }

    public String getDisplayName(){
        return String.format("Class %d", number);
    }

    public void assignLeader(Student student){
        if(this.studentList.contains(student)){
            this.leader = student;
            setChanged();
            notifyObservers(studentList);
        }else{
            System.out.print("It is not one of us.\n");
        }
    }

    public void appendMember(Student student){
        student.getKlass().number = this.number;
        studentList.add(student);
        setChanged();
        notifyObservers(studentList);
    }


    public Student getLeader() {
        return this.leader;
    }
}
