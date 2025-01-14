# LoginAndRegister Project

A simple web application for user registration and login functionality built using **Spring MVC**, **Hibernate**, and **MySQL**.

---

## Features

1. **User Registration:**
   - Collects user details (name, email, password, etc.) and stores them in the database.

2. **User Login:**
   - Verifies credentials and redirects users to the appropriate page (admin or user profile).

3. **Admin Access:**
   - Admin can log in with predefined credentials.

4. **Database Integration:**
   - User details are persisted using Hibernate ORM with MySQL as the database.

---

## Tech Stack

### Backend:
- **Spring MVC 6.1.3**
- **Hibernate ORM**
- **Java 21**

### Frontend:
- JSP (Java Server Pages)

### Database:
- **MySQL**

---

## Prerequisites

1. **Java 21**
2. **Eclipse IDE**
3. **Maven**
4. **Tomcat 9.0**
5. **MySQL Server**
6. **MySQL Workbench** (Optional)

---

## Setup Instructions

### Step 1: Clone the Repository
```bash
git clone https://github.com/your-username/LoginAndRegister.git
cd LoginAndRegister
```

### Step 2: Import the Project in Eclipse
1. Open Eclipse IDE.
2. Go to `File` > `Import` > `Maven` > `Existing Maven Projects`.
3. Browse to the cloned project directory and click `Finish`.

### Step 3: Configure MySQL Database
1. Create a database named `login_register`:
   ```sql
   CREATE DATABASE login_register;
   ```
2. Update `hibernate.cfg.xml` with your MySQL credentials:
   ```xml
   <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/login_register</property>
   <property name="hibernate.connection.username">your-username</property>
   <property name="hibernate.connection.password">your-password</property>
   ```

### Step 4: Build and Deploy
1. Run the following Maven command to build the project:
   ```bash
   mvn clean install
   ```
2. Deploy the generated `.war` file to **Tomcat 9.0**.
3. Start the Tomcat server.

### Step 5: Access the Application
- Visit `http://localhost:8080/LoginAndRegister/` in your browser.

---

## Folder Structure

```
LoginAndRegister/
|
|-- src/main/java
|   |--config/           #configuration files
|   |-- controller/      # Spring MVC Controllers
|   |-- dao/             # DAO Layer
|   |-- entity/          # Hibernate Entities
|-- src/main/webapp
|   |-- WEB-INF/
|       |-- web.xml       # Servlet Configuration
|   |-- views/           # JSP Views
|-- pom.xml              # Maven Configuration
```

---

## Key Endpoints

1. `/register`: Displays the registration page.
2. `/registerDetails`: Saves user details to the database.
3. `/loginHere`: Displays the login page.
4. `/login`: Authenticates the user and redirects to the appropriate page.

---

## Author
[Rahul tripathi](https://github.com/rahultripathioo41)

---
