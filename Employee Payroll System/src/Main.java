import java.util.ArrayList; 

abstract  class Employee{
    private String name;
    private int id;

   public Employee(String name,int id){
        this.name=name;
        this.id=id;
   }
    public abstract double calculateSalary();


    public String getname(){
        return name;
    }
    public int getid(){
        return id;
    }
}

class Fulltimeemployee extends Employee{
    //reusing code using polymorphism
    private double salary;


    public Fulltimeemployee(String name,int id , double salary){
        super(name, id);
        this.salary=salary;
    }
    @Override
    public double calculateSalary(){
        return salary;
    }
}

class Parttimeemployee extends Employee{
    private double wage;

    private int hoursworked;

    public Parttimeemployee(String name,int id ,double wage,int hoursworked){
        super(name, id);
        this.hoursworked=hoursworked;
        this.wage=wage;
    }
    public double calculateSalary(){
        return (hoursworked * wage);
    }
}

class Payrollsystem{
    ArrayList<Employee> employeelist;

    public Payrollsystem(){
        employeelist=new ArrayList<>();
    }

    public void addemployee(Employee employee){
        employeelist.add(employee);
    }

    public void removeemployee(int id){
        Employee employeeremove=null;
        for(Employee employee:employeelist){
            if(employee.getid()==id){
                employeeremove=employee;
                break;
            }
        }
        if (employeeremove!=null){
            employeelist.remove(employeeremove);
        }
    }

    public void displayemployees(){
            for (Employee employee : employeelist) {
                System.out.println("Employee : name = "+employee.getname()+" ID = "+employee.getid());
            }
    }
}




public class Main {
    public static void main(String[] args) {

        Payrollsystem payroll=new Payrollsystem();
        Fulltimeemployee emp1= new Fulltimeemployee("sayan", 1, 75000);
        Parttimeemployee emp2=new Parttimeemployee("david", 2, 100, 40);
        payroll.addemployee(emp2);
        payroll.addemployee(emp1);
        payroll.displayemployees();
    }
}