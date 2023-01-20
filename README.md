# PartyPlanner-Simon-He
This is an AP CS A Project
* Project Name: Party Planner
* Author: Simon He
***
* Project Introduction:
  * This project simulates the company, the employees and the arrangement of the tables. The total number of employees cannot exceed 100; there are 16 companies, each with no more than 10 employees; there are 10 tables, each with only 10 people and no two employees from the same company are allowed to be at one table.
  * This project calculates the three variables (mentioned above) and gives the seat chart that satisfy the conditions above.
  * Also, this project have other functions:
    *  Check the number of users (10/tablemax, maximum total 100)
    *  Show employee list by table
    *  Show employee list by company
    *  Properly place the user at the table
    *  Find the employee's name and report which table they are at
    *  Register or enroll a person, and can continue to arrange the seating chart, print the "roster", and find the location
* Project Logic:
  * First of all, I analyze the company part, in which the company has employees, a number, and a company name, so I think it as a class based on these requirements. The employees are stored in a list, because a company can have more than one employee. In addition, when adding employees, a capacity judgment is made on them, because each company cannot have more than ten people. Next, the employees are analyzed, they belongs to a company, and they have a company ID, and then they have a name of them own. I found that I could consider ten tables of ten people into a two-dimensional array, where one element of each array is an employee, so I needed two numbers to store where the employee was located, and another variable to store whether it had already been placed. I used a list of data to store multiple companies, and then a two-dimensional array to use as a location information.
  * The difficulty lies in how we determine the randomness of the project (how to determine each table a company can only have one person), I want to randomly generate ten different random numbers, and then the ten random numbers as the company id, and then randomly go from there to get the staff arranged to the position, so that you can ensure that the ten tables are different employees.
* PS: all the javadoc file and txt file are in the com folder
