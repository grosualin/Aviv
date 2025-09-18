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

- Presentation Layer : UI, ViewModels, Models, State (StateFlow, Coroutines)
    - Responsible for displaying data and handling user interactions.
    - Uses usecases to interact with data and maps domain model to ui models.
- Domain Layer: UseCases, Interfaces, Business Models
    - Holds usecases and business models.
    - Responsible for business logic and data processing.
    - A usecase combines one or multiple repositories and performs a specific business operation by implementing business logic.
- Data Layer: Remote (API services, DTOs), Mappers
    - One data source: remote apis
    - Responsible for fetching data.
    - Maps data layer models to domain layer models.
- Dependency Injection Layer: Modules
    - Provides a mechanism for injecting dependencies into classes.
    - Uses Hilt for dependency injection.
    - A module tells Hilt how to provide dependencies to other objects.

## Tech Stack:
- Kotlin 2.2+ 
- Material Design 3
- Flow (reactive data handling)
- Coroutines (asynchronous programming)
- Hilt (dependency injection)
- Jetpack Compose (UI framework)


## 👤 Author
Developed by Alin Grosu as a comprehensive Android project for Aviv technical assessment.