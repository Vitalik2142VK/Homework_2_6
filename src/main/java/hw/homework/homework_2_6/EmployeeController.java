package hw.homework.homework_2_6;

import hw.homework.homework_2_6.exeptions.EmployeeAlreadyAddedException;
import hw.homework.homework_2_6.exeptions.EmployeeNotFoundException;
import hw.homework.homework_2_6.exeptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public String firstMessage() {
        return "Введите Имя и Фамилию сотрудника.";
    }

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam ("firstName")String firstName, @RequestParam ("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "remove")
    public String removeEmployee(@RequestParam ("firstName")String firstName, @RequestParam ("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "find")
    public String findEmployee(@RequestParam ("firstName")String firstName, @RequestParam ("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "getAll")
    public String getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}
