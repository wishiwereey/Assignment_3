public class Student{
    private String name;
    private int age;
    public Student(String name,int age){this.name=name;this.age=age;}
    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(!(obj instanceof Student))return false;
        Student other=(Student)obj;
        return age==other.age&&name.equals(other.name);
    }
    @Override
    public String toString(){return name+" "+age;}
}