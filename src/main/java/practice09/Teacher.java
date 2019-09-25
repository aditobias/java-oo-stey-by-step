package practice09;

public class Teacher extends Person{
    private Klass klass;

    public Teacher(Integer id, String name, Integer age, Klass klass){
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(Integer id, String name, Integer age){
        super(id, name, age);
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce(){
        if(klass != null){
            return super.introduce() + String.format(" I am a Teacher. I teach Class %d.", klass.getNumber());
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public String introduceWith(Student student){
        if(klass.getNumber().equals(student.getKlass().getNumber())){
            return super.introduce() + String.format(" I am a Teacher. I teach %s.", student.getName());
        }
        return super.introduce() + String.format(" I am a Teacher. I don't teach %s.", student.getName());
    }
}