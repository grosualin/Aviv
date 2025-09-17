# Aviv
Technical assessment for Aviv

## 🚀 Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/grosualin/Aviv.git

2. Open the project in Android Studio (Electric Eel or newer).

3. Make sure you have installed:
    - Kotlin 2.2+
    - Java 11+
    - Android Gradle Plugin 8.14.3+
    - Android SDK 36

4. Build and run the project on an emulator or Android device (API level 29+).


## ✅ Features Implemented
✅ List page: a real estate listing page.

✅ Details page: a details page allowing you to explore each item of the list previously created.

## 🏗️ Architecture Overview
The app follows Clean Architecture principles and the MVVM architecture, using Repository pattern.
The app has the following structure and layers:

- Presentation Layer : UI, ViewModels, Models, State (LiveData, RxJava), Custom Views
    - Responsible for displaying data and handling user interactions.
    - Uses usecases to interact with data and maps domain model to ui models.
- Domain Layer: UseCases, Interfaces, Business Models
    - Holds usecases and business models.
    - Responsible for business logic and data processing.
    - A usecase combines one or multiple repositories and performs a specific business operation by implementing business logic.
    - Maps data models to domain models.
- Data Layer: Remote (API services, DTOs), Mappers
    - One data source: remote apis
    - Responsible for fetching data.
- Dependency Injection: Modules, Components
    - Provides a mechanism for injecting dependencies into classes.
    - Uses Dagger 3 for dependency injection.
    - A module tells Dagger how to provide dependencies to other objects.
    - A component tells Dagger which modules to use in order to create objects.

## Tech Stack:
- Kotlin 2.2+
- Material Design 3
- Room (offline persistence)
- RxJava3 (reactive data handling)
- Dagger 3 (dependency injection)
- Jetpack Navigation


## 👤 Author
Developed by Alin Grosu as a comprehensive Android project for Aviv technical assessment.