# Transparent Accounts Android App

Android application displaying transparent account data through the Erste Group Developer Portal
API.

## Features

- **Transparent accounts list** - display all available transparent accounts
- **Account detail** - detailed information about selected transparent account

## Technologies

- **Jetpack Compose** - UI toolkit
- **Kotlin** - programming language
- **Koin** - dependency injection
- **Ktor** - HTTP client for network communication
- **Material Design 3** - design system
- **Architecture Components** - ViewModel, StateFlow

## Architecture

The app uses **Clean Architecture** with layer separation:

```
├── domain/          # Business logic (Use Cases)  
├── data/            # Data layer (Repository, API)
├── model/          # Business models
├── ui/            # UI layer (Compose screens)
├── presentation/     # Presentation layer (ViewModels, UI states)
└── system/          # System implementations
```

## API

The app communicates with **Erste Group Developer Portal API**:

- **Base URL**: `https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v3`
- **Endpoints**:
  - `GET /transparentAccounts` - list of transparent accounts
  - `GET /transparentAccounts/{accountNumber}` - account detail
  - `GET /transparentAccounts/{accountNumber}/transactions` - transactions for given account

### Authentication

API requires `WEB-API-key` header for authentication. The key can be obtained from https://developers.erstegroup.com/.

## Setup

App requires Android API 24+ (Android 7.0)

```bash
# Clone repository
git clone git@github.com:janveprek/Homework.git
cd homework

# Build and install
./gradlew installDebug
```

## Screenshots

### Accounts List

![Accounts List](screenshots/Screenshot_20250720_220659.png)

### Account Detail

![Account Detail](screenshots/Screenshot_20250720_220708.png)

## Future Development / TODO
Due to time constraints, some features have not been implemented in this project.
These features are pagination, modularization, and tests. 
In a real-world application they would be properly implemented.