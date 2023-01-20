/**
 * @Simon
 * @description Main program, this is like tester class as well, we execute this file and this file will call/link with other file
 * @date 2023-01-19
 */

/**
 * this program is designed at IDEA platform, and it will not work at replit or geany( I don't know why, but I tried)
 */
package com.gec.work2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Screen { //this is the tester/main class
    /**
     * The table and its position the first one is the table and the second one is the position
     */
    private static Employees[][] table;
    /**
     * This array list holds an array of 16 companies
     */
    private static ArrayList<Company> companies;

    public static void main(String[] args) {
        System.out.println("Hi, welcome to the party planner!");
        System.out.println("This function will help you to arrange the seating chart of employees from differnet company");
        System.out.println("Here are the rules:");
        System.out.println("Each table could hold 10 people max, and one employee from each company only");
        System.out.println("There are 16 company total and each company could have 10 employee max");
        System.out.println("There is an employee list containing 90 people, you can add employee by put their name and company ID, them you could rearrange the seating chart");
        System.out.println("That's it! Hope you have fun!");
        // Initialization variable
        companies = new ArrayList<>();
        table = new Employees[10][10];
        // Read company information
        try {
            File myObj = new File("companies.txt"); //scan the file
            Scanner myReader = new Scanner(myObj);
            File partyguests = new File("partyguests.txt");
            Scanner partyguestsReader = new Scanner(partyguests);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();//check if there still have next line
                // Empty lines are skipped
                if (data.equals("")) {
                    continue;
                }
                String[] splitData = data.split(",");//split the data with ","
                companies.add(new Company(Integer.parseInt(splitData[0]), splitData[1]));
            }
            while (partyguestsReader.hasNextLine()) {
                String data = partyguestsReader.nextLine();
                String[] splitData = data.split(",");
                // Iterate through the array of companies
                for (Company company : companies) {
                    // Determine the company the employee works for
                    if (company.getId().equals(Integer.parseInt(splitData[3]))) {
                        // Adds employees to the company array without initializing their location
                        company.addEmployees(new Employees(Integer.parseInt(splitData[3]), splitData[1]));
                        company.addEmployees(new Employees(Integer.parseInt(splitData[3]), splitData[2]));
                    }
                }
            }
            myReader.close();
            partyguestsReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        while (true) {
            System.out.println("Please select");//list the options that give user to choose
            System.out.println("1. Create an employee");
            System.out.println("2. Check the number of users");
            System.out.println("3. Print the roster by table");
            System.out.println("4. Print the roster by company");
            System.out.println("5. Find the user's desk");
            System.out.println("6. Randomly assigned position");
            Scanner scanner = new Scanner(System.in);
            int select = scanner.nextInt();
            switch (select) { //same with the if statement
                case 1: //if user choose 1 then call the function createEmployees()
                    createEmployees();
                    break;
                case 2: //if user choose 2 then call the function checkTable()
                    checkTable();
                    break;
                case 3: //same with the example above
                    printTable();
                    break;
                case 4:
                    printEmployessOfCompany();
                    break;
                case 5:
                    findEmployees();
                case 6:
                    allocationPosition();
                    break;
                default: //if user put other function, then warning invalid
                    System.out.println("Invalid input!");
            }

        }
    }

    /**
     * Print out desk staff information
     */
    public static void printTable() {
        // Traversal table
        for (int i = 0; i < table.length; i++) {
            System.out.print("table id: " + i);
            // Walk through the table from 0 to 9 by serial number
            for (int j = 0; j < table.length; j++) {
                Employees employees = table[i][j];
                if (employees != null) {
                    System.out.print(employees.getName() + " Company ID:" + employees.getCompanyId() + "    ");
                } else {
                    System.out.print(" Empty!    ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Check the maximum number of people at the table and the number of people to export each table
     */
    public static void checkTable() {
        int total = 0;
        for (int i = 0; i < table.length; i++) {
            int row = 0;
            for (int j = 0; j < table.length; j++) {
                Employees employees = table[i][j];
                if (employees != null) {
                    row++;
                }
            }
            total += row;
            System.out.println("table ID:" + i + "  The number is  " + row);
        }
        System.out.println("The total number is " + total);
    }

    /**
     * Print employee information by company
     */
    public static void printEmployessOfCompany() {
        System.out.println("Enter the company ID for which you want to print employee information(1-16)");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        for (Company company : companies) {
            if (company.getId() == id) {
                company.getNumberEmployees()
                        .forEach(employees -> System.out.println("Name of employee:" + employees.getName()
                                + " Table ID:" + employees.getTable() + " Position number:" + employees.getPosition()
                                + " Company ID:" + employees.getCompanyId()));
            }
        }
    }

    /**
     * Randomly generate n lists of different numbers
     */
    public static List getRandomNumList(int nums, int start, int end) { //nums: random numbers to generate, start: the start of random numbers, end: the end of the random numbers
        List list = new ArrayList();
        Random r = new Random();
        // If the random number does not exist in the set, the random number will be put
        // into the set; if it does exist,
        // the random number will be discarded without any operation,
        // and the next cycle will be carried out until the set length is equal to nums
        while (list.size() != nums) {
            int num = r.nextInt(end - start) + start;
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        return list;
    }

    /**
     * Create employees
     */
    public static void createEmployees() {
        System.out.println("Please enter the employee name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Please enter the company ID(1-16)");
        int id = scanner.nextInt();
        Employees employees = new Employees(id, name);
        // I'm going to add to the company, I'm going to subtract one from the index and
        // the array is going to start at zero
        companies.get(--id).addEmployees(employees);

    }

    /**
     * Locate employees and their desks
     */
    public static void findEmployees() {
        System.out.println("Please enter the employee name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        // Traversal to find employee location
        for (Company company : companies) {
            for (Employees employees : company.getNumberEmployees()) {
                String employeesName = employees.getName();
                if (name.equals(employeesName)) {
                    System.out.println("name:" + employeesName + " table id:" + employees.getTable()
                            + " seat 6position(Start with 0):" + employees.getPosition());
                    break;
                }
            }
        }
    }

    public static void allocationPosition() {
      //reinitialize employee's information
      for (Company company:companies) {
    company.getNumberEmployees().forEach(k->{
        k.setArrange(false);
        k.setPosition(-1);
        k.setTable(-1);
    });
}
      
      for (int i = 0; i < table.length; i++) {
            // Get 10 different random numbers between 0 and 16 as the company id to be
            // assigned, ensuring that only one company can have employees on a table
            List<Integer> randomNumList = getRandomNumList(10, 0, 16);
            // Assign staff positions at the JTH table
            for (int j = 0; j < table.length; j++) {
                // Employee acquisition
                Integer randomNum = randomNumList.get(j);
                List<Employees> numberEmployees = companies.get(randomNum).getNumberEmployees();
                Random random = new Random();
                // No employee is not assigned a place
                if (numberEmployees.size() != 0) {
                    // Retrieves employees randomly from an array
                    int randomEmp = random.nextInt(numberEmployees.size());
                    Employees employees = numberEmployees.get(randomEmp);
                    // Determine if a location is assigned
                    if (!employees.isArrange()) {
                        employees.setPosition(j);
                        employees.setTable(i);
                        employees.setArrange(true);
                        // Store it on the table
                        table[i][j] = employees;
                    }
                }
            }
        }
    }
}
