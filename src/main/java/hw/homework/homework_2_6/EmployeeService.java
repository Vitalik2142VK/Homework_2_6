package hw.homework.homework_2_6;

import hw.homework.homework_2_6.exeptions.EmployeeAlreadyAddedException;
import hw.homework.homework_2_6.exeptions.EmployeeNotFoundException;
import hw.homework.homework_2_6.exeptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employee = new ArrayList<>();

    public String addEmployee(String firstName, String lastName) {
        try {
            int maxEmployee = 10;
            if (employee.size() >= maxEmployee) {
                throw new EmployeeStorageIsFullException();
            }
            Employee newEmployee = new Employee(firstName, lastName);
            for (Employee value : employee) {
                if (newEmployee.equals(value)) {
                    throw new EmployeeAlreadyAddedException();
                }
            }
            employee.add(newEmployee);
            return "Сотрудник " + newEmployee + " добавлен.";
        } catch (EmployeeStorageIsFullException e) {
            return "Данные переполнены, сотрудника добавить не возможно.";
        } catch (EmployeeAlreadyAddedException e) {
            return "Такой сотрудник уже есть в списке.";
        }
    }

    public String removeEmployee(String firstName, String lastName) {
        try {
            Employee delEmployee = new Employee(firstName, lastName);
            for (int i = 0; i < employee.size(); i++) {
                if (delEmployee.equals(employee.get(i))) {
                    employee.remove(i);
                    return "Сотрудник " + delEmployee + " удален.";
                }
            }
            throw new EmployeeNotFoundException();
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден";
        }

    }

    public String findEmployee(String firstName, String lastName) {
        try {
            Employee fEmployee = new Employee(firstName, lastName);
            for (Employee value : employee) {
                if (fEmployee.equals(value)) {
                    return "Сотрудник " + fEmployee + " найден.";
                }
            }
            throw new EmployeeNotFoundException();
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден.";
        }
    }

    public String getAllEmployee() {
        String allEmployee = "";
        for (var value : employee) {
            allEmployee += value + "<br>";
        }
        if (allEmployee.isEmpty())
            return "Сотрудников нет.";
        return "Список всех сотрудников:<br>" + allEmployee;
    }
}
