package com.isa.model;

import java.util.ArrayList;

public class Team {
   // private String teamName;
  //  private Employee[] employees = new Employee[5];

        private String teamName;
        private ArrayList<Employee> employess = new ArrayList<Employee>();

        public Team(String teamName) {
            this.teamName = teamName;
        }

        public void addMember(Employee employee) {
            employess.add(employee);
        }

        public void removeMember(Employee employee) {
            employess.remove(employee);
        }

        public ArrayList<Employee> getEmployess() {
            return employess;
        }
    }

