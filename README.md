
# 📦 Amazon Product Search & Lazy Loading Automation using Selenium and TestNG

## Project Objective

The objective of this project is to automate and validate the following Amazon search functionalities:

* Product search using category and keyword
* Verification of search results page
* Retrieval of the *n*th product from search results
* Display of all products currently visible on the screen
* Validation of lazy loading through page scrolling

---

## Technologies Used

* Java 8+
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Explicit Waits (WebDriverWait)
* Eclipse / IntelliJ IDEA
* Git & GitHub

---

## Framework Features

* Page Object Model (POM) architecture
* Selenium WebDriver-based UI automation
* TestNG test execution with priorities
* Explicit waits using `WebDriverWait`
* Dynamic element handling
* Lazy loading validation using scrolling
* Exception handling for stale and missing elements
* Modular and reusable page classes
* Maven dependency management

---

## Automated Test Scenarios

### 1. Search Product and Verify Results

* Launch the Amazon homepage.
* Search for a product within a selected category.
* Wait for the search results page to load.
* Validate that the page title contains the searched product name.

---

### 2. Retrieve the Nth Product

* Locate the search results.
* Retrieve the specified (Nth) product.
* Display the product title.
* Handle dynamically changing DOM elements using exception handling.

---

### 3. Retrieve All Visible Products

* Collect all products currently displayed on the screen.
* Print each product title.
* Handle non-standard product blocks gracefully.

---

### 4. Validate Lazy Loading

* Scroll the search results page multiple times.
* Trigger dynamic loading of additional products.
* Verify that more products become available after scrolling.
* Confirm successful lazy loading behavior.

---

## Project Structure

```text
Amazon-LazyLoading-Automation/
│
├── src
│   ├── main
│   │   └── java
│   │       ├── PageObject
│   │       │     └── AmazonSearchPage.java
│   │       │
│   │       └── utils
│   │             └── BaseTest.java
│   │
│   └── test
│       └── java
│             └── test
│                   └── AmazonLazyLoadingTest.java
│
├── pom.xml
└── README.md
```

---

## Test Cases Covered

* ✅ Search for a product using category and keyword
* ✅ Verify search results page title
* ✅ Retrieve the Nth product from search results
* ✅ Display all visible products
* ✅ Validate infinite scroll / lazy loading functionality
* ✅ Handle dynamic web elements using explicit waits
* ✅ Handle stale and missing element exceptions

---

## Design Patterns Used

* Page Object Model (POM)
* Base Test for WebDriver initialization
* Explicit Wait Strategy
* Modular Page Classes
* Reusable Selenium methods

---

## Running the Project

Clone the repository:

```bash
git clone <repository-url>
```

Install dependencies and execute the tests:

```bash
mvn clean test
```

Alternatively, run the TestNG test class directly from your IDE.

---

## Learning Outcomes

This project demonstrates how to automate dynamic web applications using Selenium WebDriver and TestNG. It highlights best practices for implementing the Page Object Model, handling dynamically loaded content, synchronizing tests with explicit waits, managing runtime exceptions, and validating lazy loading behavior commonly found in modern e-commerce applications.
