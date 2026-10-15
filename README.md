# Software Development Tools · Kotlin

> A collection of practical Kotlin projects, exercises, and experiments developed for the **Software Development Tools** module at **South East Technological University (SETU)**.

[![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/Build-Gradle-02303A?logo=gradle&logoColor=white)](https://gradle.org/)
[![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ_IDEA-000000?logo=intellijidea&logoColor=white)](https://www.jetbrains.com/idea/)
[![GitHub](https://img.shields.io/badge/Version_Control-Git_%26_GitHub-181717?logo=github&logoColor=white)](https://github.com/Safrolomancer/SoftwareDevelopmentTools-Kotlin--1-2026)
[![Notes App](https://img.shields.io/badge/Notes_App-V1.0-2ea44f)](https://github.com/Safrolomancer/SoftwareDevelopmentTools-Kotlin--1-2026/releases/tag/V1.0)

---

## Overview

This repository is my workspace for learning software development practices through hands-on Kotlin applications. It brings together course exercises and small projects covering programming fundamentals, debugging, application structure, console interaction, and version control.

Rather than being a single application, **this repository contains several independent projects**, each in its own directory.

## Projects

| Project | Description | Location |
| :--- | :--- | :--- |
| **Notes App** | Menu-driven console app with create, read, update, and delete operations for notes. | [`notes-app/notes-app`](./notes-app/notes-app) |
| **Employee App** | Kotlin coursework project for practising employee-related application logic. | [`employee-app`](./employee-app) |
| **Debugging Project** | Exercises for exploring, diagnosing, and fixing issues in code. | [`debugging-project`](./debugging-project) |

### Notes App · V1.0

The Notes App is a Kotlin command-line application for managing a collection of notes.

**Current features**

- **Create** a note with a title, body, priority, and category.
- **Read** notes in a clear, individually formatted listing.
- **Update** existing notes by ID, including their archived status.
- **Delete** notes by ID.
- **Validate console input** using reusable `UserInput` helper functions.
- **Log application activity** using Kotlin Logging.

Each note contains an **ID, title, body, priority, category, and archived status**. Notes are held in an in-memory `ArrayList`, so they are **not persisted between application runs**.

**How it is organised**

- `model.Note` — represents a note and defines its formatted output with `toString()`.
- `service.NoteService` — manages the collection and CRUD operations.
- `utils.UserInput` — provides reusable console input functions.
- `Main.kt` — displays the menu and connects user actions to the service.

**Latest tagged release:** [Notes App V1.0](https://github.com/Safrolomancer/SoftwareDevelopmentTools-Kotlin--1-2026/releases/tag/V1.0)

## Repository Structure

```text
SoftwareDevelopmentTools-Kotlin--1-2026/
├── debugging-project/     # Debugging exercises
├── employee-app/          # Employee application
├── notes-app/
│   └── notes-app/         # Notes application
├── .gitignore
└── README.md              # Repository documentation
```

## Getting Started

### Requirements

- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- A **JDK** compatible with the project you want to run
- [Git](https://git-scm.com/) (for cloning the repository)

### Clone the repository

```bash
git clone https://github.com/Safrolomancer/SoftwareDevelopmentTools-Kotlin--1-2026.git
cd SoftwareDevelopmentTools-Kotlin--1-2026
```

### Run a project

1. Open **IntelliJ IDEA**.
2. Select **Open** and choose the project directory you want to work with (for Notes App, `notes-app/notes-app`).
3. Allow IntelliJ to import or sync the Gradle project if prompted.
4. Locate the Kotlin entry point (for Notes App, `Main.kt`) and click **Run**.
5. Follow the instructions shown in the console.

> **Note:** These are separate coursework projects, not one combined application. Open and run the relevant project individually.

## Skills & Topics

`Kotlin` · `Object-Oriented Programming` · `CRUD` · `Collections` · `Input Validation` · `Logging` · `Debugging` · `Gradle` · `Git` · `GitHub` · `Markdown`

## Releases & Progress

| Release | Project | Highlights |
| :--- | :--- | :--- |
| [**V1.0**](https://github.com/Safrolomancer/SoftwareDevelopmentTools-Kotlin--1-2026/releases/tag/V1.0) | Notes App | CRUD, console input utilities, logging, and improved note listing. |

New exercises and improvements will be added as the module progresses.

## Author

**Safrolomancer** · [GitHub Profile](https://github.com/Safrolomancer)

---

*Created for learning and coursework. This README will evolve alongside the projects.*


## Author

**Matvii Krylov**
**20118691**
**SSD**
**Group: W1**
