package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.exception.EmployeeNotFoundException;
import com.isa.vacationplanerwebapp.model.Address;
import com.isa.vacationplanerwebapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DataManagerEmployees {

    private final List<Employee> employees;


    public DataManagerEmployees() {
        this.employees = importEmployees();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employee.setEmployeeId(UUID.randomUUID().toString());
        employee.setTeam("UnAssignedTeam");
        employees.add(employee);
    }

    public void deleteEmployee(String id) {
        employees.remove(getEmployeeById(id));
    }

    public Employee getEmployeeById(String id) {
        return employees.stream().
                filter(employee -> employee.getEmployeeId().equals(id))
                .findAny().orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID"));
    }

    public void modifyEmployee(Employee employee) {
        employees.replaceAll(employee1 -> {
            if (employee1.getEmployeeId().equals(employee.getEmployeeId())) {
                employee1.setName(employee.getName());
                employee1.setSurname(employee.getSurname());
                employee1.setPhoneNumber(employee.getPhoneNumber());
                employee1.setEmail(employee.getEmail());
                employee1.setAddress(employee.getAddress());
                employee1.setPesel(employee.getPesel());
            }
            return employee1;
        });
    }

    public List<Employee> getEmployeesByTeam(String name) {
        return employees.stream()
                .filter(employee -> employee.getTeam().equals(name))
                .toList();
    }

    public void removeAllEmployeesFromTeam(String teamName) {
        getEmployeesByTeam(teamName).forEach(Employee::unAssignedTeam);
    }

    public void setTeamToUnassigned(String id) {
        getEmployeeById(id).setTeam(Employee.UNASSIGNED_TEAM);
    }

    public void addEmployeeToTeam(String id, String teamName) {
        Employee employee = getEmployeeById(id);
        employee.setTeam(teamName);
    }

    public void changeTeamName(String oldTeamName, String newTeamName) {
        employees.replaceAll(employee -> {
            if (employee.getTeam().equals(oldTeamName)) {
                employee.setTeam(newTeamName);
            }
            return employee;
        });
    }

    public Map<String, List<String>> groupEmployeesByTeam() {

        Map<String, List<Employee>> employeesGrouped = employees.stream().collect(Collectors.groupingBy(Employee::getTeam));

        return employeesGrouped.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .map(Employee::getEmployeeId)
                                .collect(Collectors.toList())));

    }

    private List<Employee> importEmployees() {

        List<Employee> employees = new ArrayList<>();

        Address address = new Address();
        address.setStreet("Polna");
        address.setCity("Gdańsk");
        address.setHouseNumber("2/5");
        address.setZipCode("80-809");

        employees.add(new Employee("Marcin", "Adamski", "872345601", "adamskim@gmail.com", address, "608753496", "Czarni", "f0ba16ce-c1b1-4d1d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Anna", "Nowak", "872613485", "anna.nowak@gmail.com", address, "603984672", "Czarni", "f0ba16ce-c1b1-4d0d-68b9-0756681e4ae4"));
        employees.add(new Employee("Jan", "Kowalski", "871425363", "jkowalski@o2.pl", address, "604236589", "Czarni", "f0ba16ce-ceb1-1d0d-a869-0756681e4ae4"));
        employees.add(new Employee("Agnieszka", "Wiśniewska", "873654287", "wiśniewska@wp.pl", address, "604987563", "Czarni", "f1ba16ce-ce61-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Tomasz", "Mazur", "877532648", "mazur.t@gmail.com", address, "605987236", "Niebiescy", "f0ba1fce-ceb1-4d7d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Marta", "Wójcik", "871523645", "martawojcik@o2.pl", address, "608753421", "Niebiescy", "f0ba1sce-ceb1-4djd-a8b9-0756681e4ae4"));
        employees.add(new Employee("Katarzyna", "Jankowska", "874567312", "jankowska.k@gmail.com", address, "609765432", "Niebiescy", "fsba26ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Piotr", "Król", "875896321", "piotrkrol@wp.pl", address, "604372569", "Niebiescy", "f0ba16ce-ces1-4d0d-38b9-0756681e4ae4"));
        employees.add(new Employee("Monika", "Woźniak", "876543298", "wozniakm@o2.pl", address, "609874563", "Zieloni", "f0ba16ce-cfb1-4d0d-U8b9-0756681e4ae4"));
        employees.add(new Employee("Tomasz", "Kowalski", "748523169", "tomasz.kowalski@gmail.com", address, "501236789", "Zieloni", "f0ia16Se-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Agnieszka", "Wiśniewska", "986237514", "agnieszka.wisniewska@gmail.com", address, "604179832", "Zieloni", "faba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Jan", "Kowalczyk", "623987451", "jan.kowalczyk@gmail.com", address, "507213698", "Zieloni", "f0ba16ce-ceM1-4dsd-a8b9-0756681e4ae4"));
        employees.add(new Employee("Monika", "Mazur", "981237564", "monika.mazur@gmail.com", address, "605172398", "Zieloni", "f0ba16ce-cebs-4ddd-a8b9-0756681e4ae4"));
        employees.add(new Employee("Krzysztof", "Jankowski", "623985147", "krzysztof.jankowski@gmail.com", address, "506213987", "Czerwoni", "fgba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Ewa", "Wojciechowska", "981325764", "ewa.wojciechowska@gmail.com", address, "603172598", "Niebiescy", "f0bn1hce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Andrzej", "Kaczmarek", "623751849", "andrzej.kaczmarek@gmail.com", address, "507213489", "Czerwoni", "f0da16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Marta", "Zielińska", "987152364", "marta.zielinska@gmail.com", address, "603179528", "Czarni", "f0ba16fe-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Marek", "Piotrowski", "623987541", "marek.piotrowski@gmail.com", address, "507214689", "Czerwoni", "f0bag6ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Małgorzata", "Nowakowska", "981247536", "malgorzata.nowakowska@gmail.com", address, "605127498", "Żółci", "j0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Janusz", "Wieczorek", "623985471", "janusz.wieczorek@gmail.com", address, "507213486", "Niebiescy", "r0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Alicja", "Krupa", "981237546", "alicja.krupa@gmail.com", address, "603175892", "Żółci", "k0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Piotr", "Jabłoński", "623985741", "piotr.jablonski@gmail.com", address, "507213596", "Żółci", "h0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Jan", "Kowalski", "123748965", "jan.kowalski@gmail.com", address, "501236789", "Żółci", "f0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Agnieszka", "Kowalczyk", "543216789", "agnieszka.kowalczyk@gmail.com", address, "605172398", "Żółci", "12ba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Ewa", "Mazur", "753162948", "ewa.mazur@gmail.com", address, "506213987", "Żółci", "f0ba16ce-ceb1-4d02-a8b9-0756681e4ae4"));
        employees.add(new Employee("Tomasz", "Wojciechowski", "632581749", "tomasz.wojciechowski@gmail.com", address, "603172598", "Czerwoni", "f0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Monika", "Kaczmarek", "987532146", "monika.kaczmarek@gmail.com", address, "507213489", "f0ba16ce-ceb1-4d0d-a8b9-0756681e1ae4"));
        employees.add(new Employee("Piotr", "Zieliński", "123865749", "piotr.zielinski@gmail.com", address, "603179528", "Niebiscy", "f0ba16ce-ceb1-4d0d-a8b9-0756681e4a24"));
        employees.add(new Employee("Małgorzata", "Piotrowska", "987523461", "malgorzata.piotrowska@gmail.com", address, "507214689", "f0ba16ce-ceb1-4d0d-a8b3-0756681e4ae4"));
        employees.add(new Employee("Janusz", "Nowakowski", "987531246", "janusz.nowakowski@gmail.com", address, "605127498", "f0ba16he-ceb1-4d0d-a8b9-0756682e4ae4"));
        employees.add(new Employee("Alicja", "Wieczorek", "987531624", "alicja.wieczorek@gmail.com", address, "507213486", "f0ba16ce-ceb1-4d0d-a8b9-0756681e5ae4"));
        employees.add(new Employee("Marek", "Krupa", "987531462", "marek.krupa@gmail.com", address, "603175892", "f0ba16ce-ceb1-4d0d-a8b9-0756681e41e4"));
        employees.add(new Employee("Marta", "Jabłońska", "98753162", "marta.jabonska@gmail.com", address, "507213596", "f0ba16ce-ceb1-4d0d-a8b9-0754681e4ae4"));
        employees.add(new Employee("Marta", "Wiśniewska", "123498765", "marta.wisniewska@gmail.com", address, "604179832", "f0ba16ce-ceb1-4d0d-a8b9-4756681e4ae4"));
        employees.add(new Employee("Krzysztof", "Nowak", "987654321", "krzysztof.nowak@gmail.com", address, "507213698", "f0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Jan", "Kowalski", "234567890", "jan.kowalski@gmail.com", address, "505236789", "f0ba16ce-ceb1-4d0d-a8b9-0756681e6ae4"));
        employees.add(new Employee("Marta", "Wiśniewska", "098765432", "marta.wisniewska@gmail.com", address, "604179832", "f0ba16ce-ceb1-4d0d-a8b9-2756681e4ae4"));
        employees.add(new Employee("Krzysztof", "Nowak", "135790246", "krzysztof.nowak@gmail.com", address, "507213698", "f0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Agnieszka", "Kowalczyk", "246803571", "agnieszka.kowalczyk@gmail.com", address, "605172398", "f0ba16ce-ceb1-4d3d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Ewa", "Mazur", "369258147", "ewa.mazur@gmail.com", address, "506213987", "f0ba16ce-ceb1-4d0d-a8b9-0756681e45e4"));
        employees.add(new Employee("Tomasz", "Wojciechowski", "147258369", "tomasz.wojciechowski@gmail.com", address, "603172598", "Niebiescy","f0ba16ce-ce11-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Monika", "Kaczmarek", "258741036", "monika.kaczmarek@gmail.com", address, "507213489", "f0ba16ce-ceb1-4d0d-x8b9-0756681e4ae4"));
        employees.add(new Employee("Piotr", "Zieliński", "125874369", "piotr.zielinski@gmail.com", address, "603179528", "Czarni", "f0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Małgorzata", "Piotrowska", "369258147", "malgorzata.piotrowska@gmail.com", address, "507214689", "f0ba16ce-cbb1-4d0d-a8b9-0756681e4ae4"));
        employees.add(new Employee("Alicja", "Wieczorek", "369245817", "alicja.wieczorek@gmail.com", address, "507213486", "f0ba16ce-ceb1-4d0d-a8t9-0756681e4ae4"));
        employees.add(new Employee("Marek", "Krupa", "369254817", "marek.krupa@gmail.com", address, "603175892", "f0ba16ce-ceb1-4d0d-a8b9-075668664ae4"));

        return employees;
    }
}
