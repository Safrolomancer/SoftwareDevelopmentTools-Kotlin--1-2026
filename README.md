
# Software Development Tools · Kotlin

> A collection of practical Kotlin projects, exercises, and experiments developed for the **Software Development Tools** module at **South East Technological University (SETU)**.

[![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/Build-Gradle-02303A?logo=gradle&logoColor=white)](https://gradle.org/)
[![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ_IDEA-000000?logo=intellijidea&logoColor=white)](https://www.jetbrains.com/idea/)
[![GitHub](https://img.shields.io/badge/Version_Control-Git_%26_GitHub-181717?logo=github&logoColor=white)](https://github.com/Safrolomancer/SoftwareDevelopmentTools-Kotlin--1-2026)
[![JUnit 5](https://img.shields.io/badge/Testing-JUnit_5-25A162?logo=junit5&logoColor=white)](https://junit.org/junit5/)
[![Notes App V1.0](https://img.shields.io/badge/Notes_App-V1.0-2ea44f)](https://github.com/Safrolomancer/SoftwareDevelopmentTools-Kotlin--1-2026/releases/tag/V1.0)
![Notes App V2.0](https://img.shields.io/badge/V2.0-In_Development-orange)

---

## 📖 Overview

This repository is my workspace for learning software development practices through hands-on Kotlin applications.

It brings together university coursework, exercises, and projects covering programming fundamentals, object-oriented programming, application architecture, automated testing, debugging, and version control.

Rather than being a single application, **this repository contains several independent Kotlin projects**, each organised in its own directory.

### 🎯 Learning Objectives

- Develop practical Kotlin programming skills.
- Understand Object-Oriented Programming (OOP).
- Build applications using service-based architecture.
- Implement CRUD functionality.
- Write and maintain automated JUnit tests.
- Handle console input validation and application logging.
- Improve debugging and problem-solving skills.
- Use Git and GitHub for version control.
- Work with GitHub Issues, Branches, and Pull Requests.
- Manage software releases and documentation.

---

## 📂 Projects

| Project | Description | Location |
| :--- | :--- | :--- |
| **Notes App** | Kotlin console application with CRUD operations, service-layer architecture, and JUnit testing. | [`notes-app/notes-app`](./notes-app/notes-app) |
| **Employee App** | Kotlin coursework project for practising employee-related application logic and programming fundamentals. | [`employee-app`](./employee-app) |
| **Debugging Project** | Exercises focused on debugging, troubleshooting, and resolving code issues. | [`debugging-project`](./debugging-project) |

---

# 📝 Notes App

The **Notes App** is a menu-driven Kotlin console application for creating, organising, updating, and deleting notes.

The project demonstrates service-based application architecture, object-oriented design, reusable input utilities, automated unit testing, and software development workflows.

## 🚀 Version 1.0 — Initial Release

Version 1.0 introduced the fundamental features required to manage notes.

### ✨ Features

- **Create** notes with a title, body, priority, and category.
- **Read** notes using a clear and formatted listing.
- **Update** existing notes using their IDs.
- **Delete** notes using their IDs.
- **Validate console input** through reusable `UserInput` functions.
- **Log application activity** using Kotlin Logging.
- **Display notes** using a customised `toString()` method.
- **Store notes** in an in-memory `ArrayList`.

### 📋 Note Properties

Each note contains the following properties:

| Property | Type | Description |
| :--- | :--- | :--- |
| `id` | `Int` | Unique note identifier |
| `title` | `String` | Title of the note |
| `body` | `String` | Main content of the note |
| `priority` | `Int` | Priority assigned to the note |
| `category` | `String` | Category of the note |
| `isArchived` | `Boolean` | Indicates whether the note is archived |

> **Note:** Notes are stored in memory using an `ArrayList`. Data is not persisted between application runs.

### 📦 Release

**[Download Notes App V1.0](https://github.com/Safrolomancer/SoftwareDevelopmentTools-Kotlin--1-2026/releases/tag/V1.0)**

---

## 🧪 Version 2.0 — Testing & Service Layer Improvements

Version 2.0 focuses on improving application reliability, expanding service-layer functionality, and introducing automated testing.

### ✅ JUnit 5 Testing

Automated unit tests have been introduced to verify the behaviour of the Notes App.

The test suite covers scenarios such as:

- Adding notes to an empty service.
- Adding notes to a populated service.
- Verifying that notes contain the correct values.
- Checking unique note IDs.
- Testing archived status.
- Retrieving notes from empty and populated services.
- Updating existing notes.
- Deleting notes.
- Handling invalid and nonexistent note IDs.
- Finding notes by their unique IDs.

### 🔍 Find Notes by ID

The Notes App now includes a `findNoteById()` function in the service layer.

```kotlin
fun findNoteById(id: Int): Note? {
    return notes.find { it.id == id }
}
```

This function retrieves notes using their unique identifiers instead of accessing them through `ArrayList` indexes.

**Benefits:**

- More reliable note retrieval.
- Improved code readability.
- Safer handling of missing notes.
- Reduced dependency on list positions.
- Better test maintainability.

### 🔢 Counting Functions — V2.0 Development

Additional service-layer functionality is being developed to support note counting and archiving.

| Function | Description |
| :--- | :--- |
| `numberOfNotes()` | Returns the total number of notes. |
| `numberOfArchivedNotes()` | Counts archived notes. |
| `numberOfActiveNotes()` | Counts active notes. |
| `numberOfNotesByCategory()` | Counts notes belonging to a specific category. |
| `numberOfNotesByPriority()` | Counts notes with a specific priority. |
| `archiveNote()` | Archives an active note using its ID. |

These functions use traditional `for` loops as part of the coursework requirements.

JUnit tests are being developed to verify their expected behaviour.

---

## 🏗️ Application Architecture

The Notes App follows a service-based architecture, separating responsibilities into different components.

| Component | Responsibility |
| :--- | :--- |
| `model.Note` | Defines the note model and formatted output. |
| `service.NoteService` | Handles CRUD operations and business logic. |
| `utils.UserInput` | Provides robust console input and validation. |
| `Main.kt` | Displays the menu and processes user actions. |
| `NoteServiceTest.kt` | Contains automated JUnit tests for the service layer. |

### Architecture Overview

```text
              +-------------------+
              |      Main.kt      |
              |   Console Menu    |
              +---------+---------+
                        |
                        v
              +-------------------+
              |    NoteService    |
              |   Business Logic  |
              +---------+---------+
                        |
                        v
              +-------------------+
              |     Note Model    |
              |    Note.kt        |
              +-------------------+

        UserInput ---> Console Validation
        JUnit 5   ---> Service Layer Tests
```

### Why This Architecture?

- Separates user interaction from business logic.
- Improves code organisation and readability.
- Makes individual components easier to maintain.
- Simplifies automated unit testing.
- Supports future improvements and additional functionality.

---

## 🧪 Automated Testing

The Notes App uses **JUnit 5** for automated unit testing.

### JUnit Features Used

| Feature | Purpose |
| :--- | :--- |
| `@Test` | Defines an individual test method. |
| `@BeforeEach` | Initialises test data before each test. |
| `@AfterEach` | Executes cleanup or logging after each test. |
| `@Nested` | Groups related tests together. |
| `assertEquals()` | Compares expected and actual values. |
| `assertTrue()` | Verifies that a condition is true. |
| `assertFalse()` | Verifies that a condition is false. |
| `assertNull()` | Checks for a null result. |
| `assertNotNull()` | Checks for a non-null result. |

### Test Organisation

JUnit tests are organised into nested classes according to the functionality they test.

```text
NoteServiceTest
│
├── AddNotes
│   ├── Adding to an empty service
│   ├── Adding to a populated service
│   ├── Verifying note properties
│   └── Checking unique IDs
│
├── GetNotes
│   ├── Retrieving an empty list
│   └── Retrieving populated notes
│
├── UpdateNotes
│   └── Updating existing notes
│
├── DeleteNotes
│   └── Deleting notes
│
└── FindNotes
    ├── Finding existing notes
    └── Handling invalid IDs
```

Using `@BeforeEach` ensures that each test begins with fresh, predictable data.

This prevents individual tests from interfering with one another.

### Running Tests

Navigate to the Notes App project directory:

```bash
cd notes-app/notes-app
```

Run the full test suite:

```bash
./gradlew clean test
```

Gradle generates an HTML test report at:

```text
build/reports/tests/test/index.html
```

The report provides information about successful tests, failed tests, and execution times.

---

## 🌿 Git & GitHub Workflow

The repository uses Git and GitHub to track changes and organise development.

### GitHub Flow

Development follows a feature-branch workflow:

1. **Create an Issue** describing a feature or problem.
2. **Create a Branch** dedicated to that issue.
3. **Implement Changes** in the feature branch.
4. **Write and Run Tests** to verify functionality.
5. **Commit Changes** with meaningful commit messages.
6. **Push Changes** to GitHub.
7. **Create a Pull Request** for review.
8. **Merge** the feature branch into `main`.
9. **Close the Issue** and delete the completed branch.
10. **Pull** the updated `main` branch locally.

### Example Git Commands

Create a feature branch:

```bash
git switch main
git pull origin main
git switch -c feature/new-functionality
```

Commit and push changes:

```bash
git add .
git commit -m "Add new functionality and unit tests"
git push -u origin feature/new-functionality
```

After merging a Pull Request:

```bash
git switch main
git pull origin main
git fetch --prune
```

### GitHub Features Used

- Issues for task management.
- Feature branches for isolated development.
- Pull Requests for merging changes.
- Commit history for tracking progress.
- Tagged releases for version management.
- README documentation for project information.

---

## 📁 Repository Structure

```text
SoftwareDevelopmentTools-Kotlin--1-2026/
│
├── debugging-project/
│   └── Debugging exercises
│
├── employee-app/
│   └── Employee application
│
├── notes-app/
│   └── notes-app/
│       │
│       ├── src/
│       │   ├── main/
│       │   │   └── kotlin/
│       │   │       ├── model/
│       │   │       │   └── Note.kt
│       │   │       ├── service/
│       │   │       │   └── NoteService.kt
│       │   │       ├── utils/
│       │   │       │   └── UserInput.kt
│       │   │       └── Main.kt
│       │   │
│       │   └── test/
│       │       └── kotlin/
│       │           └── service/
│       │               └── NoteServiceTest.kt
│       │
│       ├── build.gradle.kts
│       ├── settings.gradle.kts
│       └── gradlew
│
├── .gitignore
└── README.md
```

---

## 💻 Getting Started

### Requirements

Before running the projects, ensure the following tools are available:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- A compatible **Java Development Kit (JDK)**.
- [Git](https://git-scm.com/).
- Gradle Wrapper included in the relevant project.

### Clone the Repository

```bash
git clone https://github.com/Safrolomancer/SoftwareDevelopmentTools-Kotlin--1-2026.git

cd SoftwareDevelopmentTools-Kotlin--1-2026
```

### Run a Project

1. Open **IntelliJ IDEA**.
2. Select **Open**.
3. Choose the project directory you want to work with.
4. For Notes App, navigate to `notes-app/notes-app`.
5. Allow IntelliJ to import or sync the Gradle project.
6. Locate `Main.kt`.
7. Click **Run**.
8. Follow the instructions displayed in the console.

> **Important:** These are separate coursework projects, not one combined application. Each project should be opened and run individually.

---

## 🛠️ Technologies Used

| Technology | Purpose |
| :--- | :--- |
| **Kotlin** | Main programming language. |
| **IntelliJ IDEA** | Development environment. |
| **Gradle** | Build automation and dependency management. |
| **JUnit 5** | Automated unit testing. |
| **Kotlin Logging** | Application logging. |
| **Git** | Local version control. |
| **GitHub** | Remote repository and collaboration workflow. |
| **Markdown** | Project documentation. |

---

## 📚 Skills & Topics

`Kotlin` · `Object-Oriented Programming` · `Classes` · `Data Classes` · `Collections` · `ArrayList` · `CRUD` · `Service Layer` · `Application Architecture` · `Input Validation` · `Logging` · `Debugging` · `JUnit 5` · `Unit Testing` · `Test Assertions` · `Refactoring` · `Gradle` · `Git` · `GitHub` · `Branches` · `Issues` · `Pull Requests` · `Markdown`

---

## 📦 Releases & Progress

| Version | Project | Status | Highlights |
| :--- | :--- | :--- | :--- |
| [**V1.0**](https://github.com/Safrolomancer/SoftwareDevelopmentTools-Kotlin--1-2026/releases/tag/V1.0) | Notes App | Released | CRUD functionality, input validation, logging, and improved note listing. |
| **V2.0** | Notes App | In Development | JUnit 5 testing, searching notes by ID, counting functions, and archiving functionality. |

### Development Progress

**Week 2 — Kotlin & GitHub**
- Kotlin programming fundamentals.
- Git and GitHub introduction.
- Employee App development.
- Repository management and version control.

**Week 4 — Notes App V1.0**
- Note model and service-layer architecture.
- CRUD functionality.
- Console input utilities.
- Logging.
- Improved note listing.
- Tagged release V1.0.
- README documentation.

**Week 5 — Notes App V2.0**
- JUnit 5 introduction.
- Automated testing of service-layer functionality.
- Test setup and refactoring.
- Nested test classes.
- Finding notes by ID.
- GitHub Issues and feature branches.
- Pull Requests and merging.
- Counting and archiving functionality in development.

New exercises and improvements will be added as the module progresses.

---

## 🔮 Future Improvements

Possible improvements include:

- Persistent note storage.
- Saving and loading notes from files.
- Searching and filtering notes.
- Improved category management.
- Additional input validation.
- Expanded automated test coverage.
- More advanced application architecture.

---

## 👨‍💻 Author

**Matvii Krylov**

- **Student ID:** 20118691
- **Course:** SSD
- **Group:** W1
- **University:** South East Technological University (SETU)
- **GitHub:** [Safrolomancer](https://github.com/Safrolomancer)

---

### 📄 Academic Project

This repository contains coursework and exercises completed as part of the **Software Development Tools** module at SETU.

The projects are intended for educational purposes and demonstrate the practical application of software development concepts.

---

*Created for learning, experimentation, and academic coursework.*

*This README will continue to evolve as new projects, features, and releases are added.*

