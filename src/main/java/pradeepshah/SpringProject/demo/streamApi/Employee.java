package pradeepshah.SpringProject.demo.streamApi;

public class Employee {
    int id;
    String name;
    Department dept;

    long salary;

    public Employee(int id, String name, Department dept,long salary){
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", salary=" + salary + '}';
    }

}
