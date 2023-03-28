package hw.homework.homework_2_6;

public class Employee {
    private String firstName;
    private String lastName;

    Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // Геттеры

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Стандартные методы


    @Override
    public int hashCode() {
        return firstName.hashCode() + lastName.hashCode();
    }

    public boolean equals(Employee obj) {
        if (this.hashCode() == obj.hashCode()) {
            return this.firstName.equals(obj.getFirstName()) && this.lastName.equals(obj.getLastName());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + " | Фамилия: " + lastName;
    }
}
