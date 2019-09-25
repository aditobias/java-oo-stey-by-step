package practice08;

public class Person {
    private final String name;
    private final Integer age;
    private final Integer id;

    public Person(Integer id, String name, Integer age){
        this.id = id;
        this.name = name;
        this.age = age.hashCode();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String introduce(){
        return String.format("My name is %s. I am %d years old.", name, age);
    }

    @Override
    public int hashCode(){
        return this.id + this.name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person && (this.name == ((Person) obj).getName() && this.age == ((Person) obj).getAge());
    }
}