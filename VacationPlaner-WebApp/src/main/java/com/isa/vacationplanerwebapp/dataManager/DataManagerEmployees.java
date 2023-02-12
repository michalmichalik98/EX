package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.model.Address;
import com.isa.vacationplanerwebapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        employees.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee findEmployee(String pesel) {
        return employees.stream()
                .filter(employee -> employee.getPesel().equals(pesel))
                .findFirst().orElse(null);
    }

    private List<Employee> importEmployees() {

        List<Employee> employees = new ArrayList<>();

        Address address = new Address();
        address.setStreet("Polna");
        address.setCity("Gdańsk");
        address.setHouseNumber("2/5");
        address.setZipCode("80-809");

        employees.add(new Employee("Marcin", "Adamski", "872345601", "adamskim@gmail.com", address , "608753496"));
        employees.add(new Employee("Anna", "Nowak", "872613485", "anna.nowak@gmail.com", address , "603984672"));
        employees.add(new Employee("Jan", "Kowalski", "871425363", "jkowalski@o2.pl", address , "604236589"));
    /*    employees.add(new Employee("Agnieszka", "Wiśniewska", "873654287", "wiśniewska@wp.pl", "Lasowa 8/4", "604987563"));
        employees.add(new Employee("Tomasz", "Mazur", "877532648", "mazur.t@gmail.com", "Zielona 9/1", "605987236"));
        employees.add(new Employee("Marta", "Wójcik", "871523645", "martawojcik@o2.pl", "Polna 2/6", "608753421"));
        employees.add(new Employee("Katarzyna", "Jankowska", "874567312", "jankowska.k@gmail.com", "Słoneczna 7/3", "609765432"));
        employees.add(new Employee("Piotr", "Król", "875896321", "piotrkrol@wp.pl", "Zaciszna 4/5", "604372569"));
        employees.add(new Employee("Monika", "Woźniak", "876543298", "wozniakm@o2.pl", "Lipowa 6/1", "609874563"));
        employees.add(new Employee("Tomasz", "Kowalski", "748523169", "tomasz.kowalski@gmail.com", "Lipowa 7", "501236789"));
        employees.add(new Employee("Agnieszka", "Wiśniewska", "986237514", "agnieszka.wisniewska@gmail.com", "Kwiatowa 9", "604179832"));
        employees.add(new Employee("Jan", "Kowalczyk", "623987451", "jan.kowalczyk@gmail.com", "Topolowa 11", "507213698"));
        employees.add(new Employee("Monika", "Mazur", "981237564", "monika.mazur@gmail.com", "Parkowa 15", "605172398"));
        employees.add(new Employee("Krzysztof", "Jankowski", "623985147", "krzysztof.jankowski@gmail.com", "Dąbrowskiego 19", "506213987"));
        employees.add(new Employee("Ewa", "Wojciechowska", "981325764", "ewa.wojciechowska@gmail.com", "Piłsudskiego 21", "603172598"));
        employees.add(new Employee("Andrzej", "Kaczmarek", "623751849", "andrzej.kaczmarek@gmail.com", "Słoneczna 25", "507213489"));
        employees.add(new Employee("Marta", "Zielińska", "987152364", "marta.zielinska@gmail.com", "Kwiatowa 27", "603179528"));
        employees.add(new Employee("Marek", "Piotrowski", "623987541", "marek.piotrowski@gmail.com", "Parkowa 29", "507214689"));
        employees.add(new Employee("Małgorzata", "Nowakowska", "981247536", "malgorzata.nowakowska@gmail.com", "Dąbrowskiego 33", "605127498"));
        employees.add(new Employee("Janusz", "Wieczorek", "623985471", "janusz.wieczorek@gmail.com", "Piłsudskiego 35", "507213486"));
        employees.add(new Employee("Alicja", "Krupa", "981237546", "alicja.krupa@gmail.com", "Słoneczna 37", "603175892"));
        employees.add(new Employee("Piotr", "Jabłoński", "623985741", "piotr.jablonski@gmail.com", "Kwiatowa 39", "507213596"));
        employees.add(new Employee("Jan", "Kowalski", "123748965", "jan.kowalski@gmail.com", "Lipowa 7/3", "501236789"));
        employees.add(new Employee("Agnieszka", "Kowalczyk", "543216789", "agnieszka.kowalczyk@gmail.com", "Parkowa 15/5", "605172398"));
        employees.add(new Employee("Ewa", "Mazur", "753162948", "ewa.mazur@gmail.com", "Dąbrowskiego 19/6", "506213987"));
        employees.add(new Employee("Tomasz", "Wojciechowski", "632581749", "tomasz.wojciechowski@gmail.com", "Piłsudskiego 21/7", "603172598"));
        employees.add(new Employee("Monika", "Kaczmarek", "987532146", "monika.kaczmarek@gmail.com", "Słoneczna 25/8", "507213489"));
        employees.add(new Employee("Piotr", "Zieliński", "123865749", "piotr.zielinski@gmail.com", "Kwiatowa 27/9", "603179528"));
        employees.add(new Employee("Małgorzata", "Piotrowska", "987523461", "malgorzata.piotrowska@gmail.com", "Parkowa 29/10", "507214689"));
        employees.add(new Employee("Janusz", "Nowakowski", "987531246", "janusz.nowakowski@gmail.com", "Dąbrowskiego 33/11", "605127498"));
        employees.add(new Employee("Alicja", "Wieczorek", "987531624", "alicja.wieczorek@gmail.com", "Piłsudskiego 35/12", "507213486"));
        employees.add(new Employee("Marek", "Krupa", "987531462", "marek.krupa@gmail.com", "Słoneczna 37/13", "603175892"));
        employees.add(new Employee("Marta", "Jabłońska", "98753162", "marta.jabonska@gmail.com", "Kwiatowa 39/14", "507213596"));
        employees.add(new Employee("Marta", "Wiśniewska", "123498765", "marta.wisniewska@gmail.com", "Kwiatowa 9/1", "604179832"));
        employees.add(new Employee("Krzysztof", "Nowak", "987654321", "krzysztof.nowak@gmail.com", "Topolowa 11/4", "507213698"));
        employees.add(new Employee("Jan", "Kowalski", "234567890", "jan.kowalski@gmail.com", "Lipowa 7/3", "505236789"));
        employees.add(new Employee("Marta", "Wiśniewska", "098765432", "marta.wisniewska@gmail.com", "Kwiatowa 9/1", "604179832"));
        employees.add(new Employee("Krzysztof", "Nowak", "135790246", "krzysztof.nowak@gmail.com", "Topolowa 11/4", "507213698"));
        employees.add(new Employee("Agnieszka", "Kowalczyk", "246803571", "agnieszka.kowalczyk@gmail.com", "Parkowa 15/5", "605172398"));
        employees.add(new Employee("Ewa", "Mazur", "369258147", "ewa.mazur@gmail.com", "Dąbrowskiego 19/6", "506213987"));
        employees.add(new Employee("Tomasz", "Wojciechowski", "147258369", "tomasz.wojciechowski@gmail.com", "Piłsudskiego 21/7", "603172598"));
        employees.add(new Employee("Monika", "Kaczmarek", "258741036", "monika.kaczmarek@gmail.com", "Słoneczna 25/8", "507213489"));
        employees.add(new Employee("Piotr", "Zieliński", "125874369", "piotr.zielinski@gmail.com", "Kwiatowa 27/9", "603179528"));
        employees.add(new Employee("Małgorzata", "Piotrowska", "369258147", "malgorzata.piotrowska@gmail.com", "Parkowa 29/10", "507214689"));
        employees.add(new Employee("Janusz", "Nowakowski", "369258471", "janusz.nowakowski@gmail.com", "Dąbrowskiego 33/11", "605127498"));
        employees.add(new Employee("Alicja", "Wieczorek", "369245817", "alicja.wieczorek@gmail.com", "Piłsudskiego 35/12", "507213486"));
        employees.add(new Employee("Marek", "Krupa", "369254817", "marek.krupa@gmail.com", "Słoneczna 37/13", "603175892"));
        employees.add(new Employee("Marta", "Jabłońska", "369258471", "marta.jabonska@gmail.com", "Kwiatowa 39/*/;
        return employees;
    }
}
