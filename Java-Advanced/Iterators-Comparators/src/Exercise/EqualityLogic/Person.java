package Exercise.EqualityLogic;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this){
            return  true;
        }
        if(!(o instanceof Person)){
            return false;
        }
        Person other = (Person) o;
        boolean nameEquals = (this.name == null && other.name == null)
                || (this.name != null && this.name.equals(other.name));
        return this.age == other.age && nameEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if(name != null){
            result = 31 * result + name.hashCode();
        }
         if(age != 0){
             result = 31 * result * age;
         }
         return result;
    }

    @Override
    public int compareTo(Person other) {
        if(this.getName().compareTo(other.getName()) == 0){
            return Integer.compare(this.age, other.age);
        }

        return this.getName().compareTo(other.getName());
    }
}
