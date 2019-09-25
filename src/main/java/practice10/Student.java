package practice10;

public class Student extends Person{
    private Klass klass;

    public Student(Integer id, String name, Integer age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce() {
        if(klass.getLeader() != null){
            return super.introduce() + String.format(" I am a Student. I am Leader of Class %d.",
                    klass.getNumber());
        }
        return super.introduce() + String.format(" I am a Student. I am at Class %d.",
                klass.getNumber());
    }

    public boolean isIn(){
        return klass.getNumber() != null;
    }
}
