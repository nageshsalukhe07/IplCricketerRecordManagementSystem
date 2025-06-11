# 🏏 Cricket Player Management System

A full-stack Spring Boot based web application for managing cricketers, countries, teams, and users. Provides CRUD operations and filtering APIs to retrieve and manage cricket-related data efficiently.

---

## 📦 Project Structure

cricket-player-management/
├── controller/
│ ├── CricketerController.java
│ ├── CountryController.java
│ ├── TeamController.java
│ └── UserController.java
├── entity/
│ ├── Cricketer.java
│ ├── Country.java
│ ├── Team.java
│ └── User.java
├── repository/
│ └── (Your JPA repositories)
├── service/
│ ├── CricketerService.java
│ ├── CountryService.java
│ ├── TeamService.java
│ └── UserService.java
└── CricketPlayerManagementApplication.java

pgsql
Copy
Edit

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- REST API
- Postman (for testing)
- Maven

---

## 🔐 Entity Overview and API Endpoints

### 🧑‍🎓 Cricketer
| Method | URL                              | Description                        |
|--------|----------------------------------|------------------------------------|
| POST   | `/api/cricketer/save`            | Save a single cricketer           |
| POST   | `/api/cricketer/saveall`         | Save a list of cricketers         |
| GET    | `/api/cricketer/findbyid/{id}`   | Get cricketer by ID               |
| GET    | `/api/cricketer/findall`         | Get all cricketers                |
| PUT    | `/api/cricketer/update`          | Update cricketer info             |
| DELETE | `/api/cricketer/deletebyid/{id}` | Delete cricketer by ID            |
| GET    | `/api/cricketer/name`            | Search by full name               |
| GET    | `/api/cricketer/role`            | Search by role                    |
| GET    | `/api/cricketer/batting-style`   | Search by batting style           |
| GET    | `/api/cricketer/bowling-style`   | Search by bowling style           |
| GET    | `/api/cricketer/age-range/{minAge}/{maxAge}` | Cricketers in age range |
| GET    | `/api/cricketer/top-batsmen`     | Top batsmen list                  |
| GET    | `/api/cricketer/top-bowlers`     | Top bowlers list                  |
| GET    | `/api/cricketer/email`           | Get cricketer by email            |
| GET    | `/api/cricketer/recent`          | Recently added players            |
| GET    | `/api/cricketer/distinct-roles`  | All distinct roles                |
| GET    | `/api/cricketer/strike-rate-above?rate=100` | Strike rate filter       |

---

### 🌍 Country
| Method | URL                              | Description                        |
|--------|----------------------------------|------------------------------------|
| POST   | `/api/country/save`              | Save a country                     |
| POST   | `/api/country/saveall`           | Save multiple countries            |
| GET    | `/api/country/findbyid/{id}`     | Get country by ID                  |
| GET    | `/api/country/findall`           | Get all countries                  |
| PUT    | `/api/country/update`            | Update country                     |
| DELETE | `/api/country/deletebyid/{id}`   | Delete country by ID               |
| GET    | `/api/country/searchByName?keyword=India` | Search by name           |
| GET    | `/api/country/findByCode?code=IND` | Search by country code           |

---

### 🏏 Team
| Method | URL                                  | Description                      |
|--------|--------------------------------------|----------------------------------|
| POST   | `/api/team/save`                     | Save a team                      |
| POST   | `/api/team/saveall`                  | Save multiple teams              |
| GET    | `/api/team/findbyid/{id}`            | Get team by ID                   |
| GET    | `/api/team/findall`                  | Get all teams                    |
| PUT    | `/api/team/update`                   | Update team                      |
| DELETE | `/api/team/deletebyid/{id}`          | Delete team by ID                |
| GET    | `/api/team/searchbyname?keyword=Royals` | Search teams by name         |
| GET    | `/api/team/findByName?name=MI`       | Get team by name                 |
| GET    | `/api/team/searchByCoach?coachName=Ricky` | Search by coach name       |
| GET    | `/api/team/searchByOwner?ownerName=Ambani` | Search by owner           |
| GET    | `/api/team/findByTitlesGreaterThan?titles=2` | Teams with more than titles |

---

### 👤 User (For Authentication)
| Method | URL                      | Description                  |
|--------|--------------------------|------------------------------|
| POST   | `/api/user/save`         | Register user                |
| POST   | `/api/user/saveall`      | Register multiple users      |
| POST   | `/api/user/login`        | Login and get status         |

---

## ⚙️ Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/cricket-player-management.git
   cd cricket-player-management
Configure MySQL in application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/cricketdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Build and Run the Project

bash
Copy
Edit
mvn spring-boot:run
Test APIs using Postman or Swagger (if integrated).

📩 Contact
Made with ❤️ by Nagesh Salunkhe
🔗 LinkedIn
📧 salunkhenagesh575@gmail.com

