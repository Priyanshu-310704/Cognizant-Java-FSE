public class EmployeeArrayManager {
    private final Employee[] employees;
    private int size;

    public EmployeeArrayManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (size == employees.length) {
            return false;
        }

        employees[size] = employee;
        size++;
        return true;
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                employees[size - 1] = null;
                size--;
                return true;
            }
        }

        return false;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        EmployeeArrayManager manager = new EmployeeArrayManager(5);

        manager.addEmployee(new Employee(301, "Anita", "Developer", 55000.0));
        manager.addEmployee(new Employee(302, "Rahul", "Tester", 42000.0));
        manager.addEmployee(new Employee(303, "Meera", "Manager", 78000.0));

        System.out.println("All employees:");
        manager.traverseEmployees();

        System.out.println("\nSearch employee 302:");
        System.out.println(manager.searchEmployee(302));

        manager.deleteEmployee(301);
        System.out.println("\nAfter deleting employee 301:");
        manager.traverseEmployees();
    }
}
