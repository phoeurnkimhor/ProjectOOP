**Create a Database for our web app.**
```Sql
CREATE DATABASE oopdb;

USE oopdb;

CREATE TABLE employee(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255),
dateOfhiring DATE,
department VARCHAR(255),
job_title VARCHAR(255),
status VARCHAR(200)
);

-- Add Data to the Table
INSERT INTO employee (name, dateOfhiring, department, job_title, status)
VALUES
("John Doe", "2024-05-15", "Finance", "Financial Analyst", "Normal"),
("Jane Smith", "2023-12-10", "Marketing", "Marketing Specialist", "Blacklist"),
("Michael Johnson", "2025-02-28", "HR", "HR Manager", "Normal"),
("Emily White", "2024-07-20", "IT", "Software Developer", "Normal"),
("Chris Brown", "2025-09-15", "Finance", "Accountant", "Normal"),
("Emma Davis", "2025-04-05", "Marketing", "Content Writer", "Normal"),
("Andrew Miller", "2024-11-12", "HR", "Recruiter", "Normal"),
("Olivia Taylor", "2025-01-08", "IT", "System Analyst", "Blacklist"),
("William Robinson", "2024-03-22", "Finance", "Financial Planner", "Normal")
```

- Click [Here](https://drive.google.com/file/d/15TfPLyt9FiCRdImCn3rWt51lIlYp0RSL/view?usp=drive_link) to see our Slide Presentation
