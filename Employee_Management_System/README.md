# MSE-2 Question 2: Employee Management System (Spring Boot REST API)

## 📌 Problem Overview
- **Scenario:** Employee Management System using Spring Boot REST APIs.
- **Attributes:** `id`, `name`, `department`, `salary`.
- **Marks:** 10 Marks (CO5).
- **Operations:**
  - **(a)** Employee model class (fields, constructors, getters/setters) [2 Marks]
  - **(b)** `@PostMapping` + `@RequestBody` to add new employee [2 Marks]
  - **(c)** `@GetMapping` for all employees and by ID [2 Marks]
  - **(d)** `@PutMapping` to update employee details [2 Marks]
  - **(e)** `@DeleteMapping` to delete employee by ID with HTTP status responses [2 Marks]

---

## 📁 Project Structure

```text
Employee_Management_System/
│
├── pom.xml                                      # Maven configuration
├── README.md                                    # Documentation & Postman guide
└── src/
    └── main/
        ├── java/com/example/employeemanagement/
        │   ├── EmployeeManagementApplication.java # Spring Boot Main Class
        │   ├── model/
        │   │   └── Employee.java                 # Question 2(a) Model Class
        │   ├── service/
        │   │   └── EmployeeService.java          # In-memory Business Logic
        │   └── controller/
        │       └── EmployeeController.java       # Question 2(b, c, d, e) REST Controller
        └── resources/
            ├── application.properties           # Server port 8080 configuration
            └── static/
                └── index.html                   # Clean, student-style Chrome Frontend
```

---

## 🚀 How to Run in IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Click **File ➔ Open...** and select the folder:
   `C:\Users\Bhavna Panwar\OneDrive\Desktop\Employee_Management_System`
3. IntelliJ will automatically detect `pom.xml` and import dependencies.
4. Open [`EmployeeManagementApplication.java`](src/main/java/com/example/employeemanagement/EmployeeManagementApplication.java).
5. Click the **Green Run (▶️)** button next to `main()`.
6. Once started, access:
   - **Chrome Frontend:** `http://localhost:8081/index.html`
   - **REST API Base URL:** `http://localhost:8081/api/employees`

---

## 📮 Postman Complete Testing Guide

Set `Headers` in Postman for POST and PUT requests:
- **Key:** `Content-Type`
- **Value:** `application/json`

---

### 1️⃣ (b) Add New Employee (POST) — 2 Marks
* **Method:** `POST`
* **URL:** `http://localhost:8081/api/employees`
* **Body ➔ raw ➔ JSON:**
```json
{
  "id": 104,
  "name": "Karan Mehra",
  "department": "Marketing",
  "salary": 52000.0
}
```
* **Expected Response (Status: 201 Created):**
```json
{
  "id": 104,
  "name": "Karan Mehra",
  "department": "Marketing",
  "salary": 52000.0
}
```

---

### 2️⃣ (c) Retrieve All Employees (GET) — 1 Mark
* **Method:** `GET`
* **URL:** `http://localhost:8081/api/employees`
* **Body:** None
* **Expected Response (Status: 200 OK):**
```json
[
  {
    "id": 101,
    "name": "Amit Sharma",
    "department": "Engineering",
    "salary": 75000.0
  },
  {
    "id": 102,
    "name": "Priya Patel",
    "department": "Human Resources",
    "salary": 60000.0
  },
  {
    "id": 103,
    "name": "Rahul Verma",
    "department": "Finance",
    "salary": 68000.0
  },
  {
    "id": 104,
    "name": "Karan Mehra",
    "department": "Marketing",
    "salary": 52000.0
  }
]
```

---

### 3️⃣ (c) Retrieve Specific Employee by ID (GET) — 1 Mark
* **Method:** `GET`
* **URL:** `http://localhost:8081/api/employees/101`
* **Body:** None
* **Expected Response (Status: 200 OK):**
```json
{
  "id": 101,
  "name": "Amit Sharma",
  "department": "Engineering",
  "salary": 75000.0
}
```
* **Case when ID does not exist (`/api/employees/999`):**
  - **Status:** `404 Not Found`
  - **Response:** `"Error: Employee not found with ID: 999"`

---

### 4️⃣ (d) Update Employee Details (PUT) — 2 Marks
* **Method:** `PUT`
* **URL:** `http://localhost:8081/api/employees/101`
* **Body ➔ raw ➔ JSON:**
```json
{
  "name": "Amit Sharma (Senior)",
  "department": "Engineering & DevOps",
  "salary": 90000.0
}
```
* **Expected Response (Status: 200 OK):**
```json
{
  "id": 101,
  "name": "Amit Sharma (Senior)",
  "department": "Engineering & DevOps",
  "salary": 90000.0
}
```
* **Case when ID does not exist (`/api/employees/999`):**
  - **Status:** `404 Not Found`
  - **Response:** `"Error: Cannot update. Employee not found with ID: 999"`

---

### 5️⃣ (e) Delete Employee by ID (DELETE) — 2 Marks
* **Method:** `DELETE`
* **URL:** `http://localhost:8081/api/employees/104`
* **Body:** None
* **Expected Response (Status: 200 OK):**
```text
Success: Employee with ID 104 was deleted successfully.
```
* **Case when ID does not exist (`/api/employees/999`):**
  - **Status:** `404 Not Found`
  - **Response:** `"Error: Cannot delete. Employee not found with ID: 999"`

---

## 🌐 Chrome Frontend (Basic & Clean)

Once the application is running:
- Open Chrome and navigate to: **`http://localhost:8081/index.html`** (or `http://localhost:8081/`)
- It provides:
  - Simple form to Add new employees (`POST`)
  - Table displaying all active employees (`GET`)
  - Search by ID box (`GET by ID`)
  - "Edit" button to modify details (`PUT`)
  - "Delete" button to remove employees (`DELETE`)
  - Live status box showing HTTP Status code and API responses.
