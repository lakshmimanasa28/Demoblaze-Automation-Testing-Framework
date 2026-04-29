# Design Document – Demoblaze Automation Testing Framework

## 1. Project Objective

To automate testing of Demoblaze E-Commerce website using Selenium WebDriver and TestNG.

The framework validates:

- User Authentication
- Product Selection
- Cart Management
- Order Placement
- Form Validations

---

## 2. Technology Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Eclipse IDE
- Page Object Model (POM)

---

## 3. Framework Architecture

The framework follows Layered Design with Page Object Model.

### Layers:

1. Test Layer
2. Page Layer
3. Base Layer
4. Utility Layer

---

## 4. Project Structure

src/test/java

base/
- BaseTest.java
- BasePage.java

pages/
- HomePage.java
- LoginPage.java
- ProductPage.java
- CartPage.java
- OrderPage.java

tests/
- AuthTest.java
- ProductTest.java
- CartTest.java
- OrderTest.java
- FormValidationTest.java

utils/
- ScreenshotUtil.java
- ExtentManager.java

---

## 5. Module Design

## Base Layer

### BaseTest.java

Responsibilities:

- Launch browser
- Open application URL
- Close browser
- Driver management

### BasePage.java

Reusable Methods:

- click()
- type()
- getText()
- waitForVisibility()
- waitForClickability()

---

## 6. Page Classes

### HomePage.java

- Navigate categories
- Open phones/laptops/monitors

### ProductPage.java

- Select product
- Add to cart
- Accept alert popup

### CartPage.java

- Open cart page
- Delete product

### OrderPage.java

- Open place order modal
- Enter customer details
- Purchase order
- Verify confirmation message

### LoginPage.java

- Enter username/password
- Login validation

---

## 7. Test Execution Flow

1. Browser Launch
2. Navigate to Demoblaze
3. Execute TestNG test cases
4. Capture results
5. Generate reports

---

## 8. Wait Strategy

Explicit Wait used for:

- Element visibility
- Button clickable
- Alert popup
- Success messages

---

## 9. Error Handling

Handled using:

- Try-Catch blocks
- TimeoutException handling
- Alert exception handling

---

## 10. Results Summary

Tests Executed: 11  
Passed: 10  
Failed: 0  
Skipped: 1

---

## 11. Advantages

- Reusable framework
- Easy maintenance
- Scalable architecture
- Clear reporting
- Real-time validations

---

## 12. Future Enhancements

- Data Driven Testing
- Cross Browser Execution
- Jenkins CI/CD Integration
- Parallel Execution
- Allure Reports

---

## 13. Conclusion

The automation framework successfully validates major functionalities of Demoblaze website using a clean and scalable Selenium-TestNG architecture.