package hw.homework.homework_2_6.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class EmployeeNotFoundException extends RuntimeException{

}
