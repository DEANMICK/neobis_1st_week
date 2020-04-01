import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;


public class Main {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Main runner = new Main();
        System.out.println("Добавление работников в Базу Данных...");
        runner.addEmployee("Sanya","Visockih","7554839344", "Osh", 2900000.0,35,"seller");
        runner.addEmployee( "Roman", "Guyvan", "0444444444", "Naryn", 2456700.0,24,"seller");
        runner.addEmployee( "Nurzhan", "Sharapov", "0000000000", "Bishkek", 2456700.0,24,"degustator");
        System.out.println("Лист работников");


        /**
         *   Лист работников
         */

        List employeeList = runner.listEmployee();
        for (Object employee: employeeList) {
            System.out.println(employee);
        }
        System.out.println("=======================================================================================");
        System.out.println();
        System.out.println("Обновление и Удаление работников...");
        System.out.println();


        /**
         * Обновление и Удаление работников
         */
        runner.updateEmployee(34, 50000);
        runner.removeEmployee(32);


        System.out.println("Действия завершены...");
        System.out.println();


        /**
         *   Лист работников
         */
        employeeList = runner.listEmployee();
        for (Object employee: employeeList) {
            System.out.println(employee);
        }
        System.out.println("===================================");

    }

    public void addEmployee( String name, String surname, String phone, String address, Double salary, Integer age, String position) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Employee employee = new Employee(name,surname, phone, address,salary,age,position);
        session.save(employee);
        transaction.commit();
        session.close();
    }

    public List listEmployee() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List developers = session.createQuery("FROM Employee").list();

        transaction.commit();
        session.close();
        return developers;
    }

    public void updateEmployee(int Id, double salary) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, Id);
        employee.setSalary(salary);
        session.update(employee);
        transaction.commit();
        session.close();
    }

    public void removeEmployee(int Id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class,Id);
        session.delete(employee);
        transaction.commit();
        session.close();
    }

}


