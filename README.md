# Demoblaze Automation Testing Framework

## Project Overview
This project is an Automation Testing Framework developed using Java, Selenium WebDriver, TestNG, and Maven for testing the Demoblaze E-Commerce website.

The framework follows the Page Object Model (POM) design pattern for better code reusability, maintainability, and scalability.

## Website Tested
https://www.demoblaze.com

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Extent Reports (Optional)
- Git / GitHub

---

## Project Features

- Home Page Validation
- Product Selection
- Add Product to Cart
- Cart Validation
- Place Order Functionality
- Positive and Negative Test Cases
- Cross Browser Support (Optional)
- Screenshot Capture on Failure (Optional)
- Reports Generation

---

## Project Structure

```text
DemoblazeAutomationFramework/
│── pom.xml
│── testng.xml
│── README.md
│── DesignDocument.md
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/
│   │       │   ├── BasePage.java
│   │       │   └── BaseTest.java
│   │       │
│   │       ├── pages/
│   │       │   ├── HomePage.java
│   │       │   ├── ProductPage.java
│   │       │   ├── CartPage.java
│   │       │   └── OrderPage.java
│   │       │
│   │       └── utils/
│   │           ├── ScreenshotUtil.java
│   │           └── ExtentManager.java
│
├── test/
│   └── java/
│       └── tests/
│           ├── LoginTest.java
│           ├── CartTest.java
│           └── OrderTest.java
│
├── screenshots/
│   └── (failure screenshots stored here)
│
├── reports/
│   ├── ExtentReport.html
│   └── TestNGReports/
│
└── target/
    └── (generated after execution)
```

# Test Scenarios Covered – Demoblaze Automation Framework

## 1. Authentication Module

### Login Test Cases

1. Verify login with valid credentials  
   - Username: Manasa  
   - Password: Password123

2. Verify login with invalid credentials  
   - Username: invalidUser  
   - Password: wrongPass

---

## 2. Product Module

### Product Test Cases

3. Verify product selection from category page

---

## 3. Cart Module

### Cart Test Cases

4. Verify add product to cart successfully

5. Verify delete product from cart successfully

---

## 4. Order Module

### Order Test Cases

6. Verify successful order placement with valid details

7. Verify order with empty mandatory fields

---

## 5. Form Validation Module

### Validation Test Cases

8. Verify login with empty username

9. Verify signup form fields retain entered values

10. Verify signup with already existing user

---

## Summary

Total Test Classes: 5

- Auth Tests
- Product Tests
- Cart Tests
- Order Tests
- Form Validation Tests

Total Methods Executed: 11  
Passed: 10  
Failed: 0  
Skipped: 1
---

## Design Pattern Used

Page Object Model (POM)

Each webpage has separate Java class containing:

- Web Elements
- Methods
- Actions

Benefits:

- Easy maintenance
- Reusable code
- Cleaner test scripts

---

## How to Run Project

### Using Eclipse

1. Import project as Maven Project
2. Update Maven dependencies
3. Open testng.xml
4. Run as TestNG Suite

### Using Maven

```bash
mvn clean test
