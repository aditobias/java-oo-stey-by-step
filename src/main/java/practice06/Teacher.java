package practice06;

public class Teacher extends Person{

    private Integer klass;

    public Teacher(String name, Integer age, Integer klass){
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, Integer age){
        super(name, age);
    }

    public Integer getKlass() {
        return klass;
    }

    public String introduce(){
        if(klass != null){
            return super.introduce() + String.format(" I am a Teacher. I teach Class %d.", klass);
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }
}
