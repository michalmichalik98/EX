package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.model.Employee;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;

public class DataManager2 implements Resource {

    Employee employee1 = new Employee("Marcin", "Adamski", "872345601", "adamskim@gmail.com", "Parkowa 3/2", "608753496");
    Employee employee2 = new Employee("Anna", "Nowak", "872613485", "anna.nowak@gmail.com", "Kwiatowa 5/2", "603984672");
    Employee employee3 = new Employee("Jan", "Kowalski", "871425363", "jkowalski@o2.pl", "Parkowa 1/3", "604236589");
    Employee employee4 = new Employee("Agnieszka", "Wiśniewska", "873654287", "wiśniewska@wp.pl", "Lasowa 8/4", "604987563");
    Employee employe5 = new Employee("Tomasz", "Mazur", "877532648", "mazur.t@gmail.com", "Zielona 9/1", "605987236");
    Employee employee6 = new Employee("Marta", "Wójcik", "871523645", "martawojcik@o2.pl", "Polna 2/6", "608753421");
    Employee employee7 = new Employee("Katarzyna", "Jankowska", "874567312", "jankowska.k@gmail.com", "Słoneczna 7/3", "609765432");
    Employee employee8 = new Employee("Piotr", "Król", "875896321", "piotrkrol@wp.pl", "Zaciszna 4/5", "604372569");
    Employee employee9= new Employee("Monika", "Woźniak", "876543298", "wozniakm@o2.pl", "Lipowa 6/1", "609874563");

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public boolean isReadable() {
        return Resource.super.isReadable();
    }

    @Override
    public boolean isOpen() {
        return Resource.super.isOpen();
    }

    @Override
    public boolean isFile() {
        return Resource.super.isFile();
    }

    @Override
    public URL getURL() throws IOException {
        return null;
    }

    @Override
    public URI getURI() throws IOException {
        return null;
    }

    @Override
    public File getFile() throws IOException {
        return null;
    }

    @Override
    public ReadableByteChannel readableChannel() throws IOException {
        return Resource.super.readableChannel();
    }

    @Override
    public long contentLength() throws IOException {
        return 0;
    }

    @Override
    public long lastModified() throws IOException {
        return 0;
    }

    @Override
    public Resource createRelative(String relativePath) throws IOException {
        return null;
    }

    @Override
    public String getFilename() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }
}
