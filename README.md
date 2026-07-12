# Calculator Android App

A simple yet functional calculator Android application built with Java and Gradle.

## Features

- Basic arithmetic operations (addition, subtraction, multiplication, division)
- Decimal point support
- Clear button to reset calculations
- Clean and intuitive UI with a dark theme
- Automatic GitHub Actions CI/CD build pipeline

## Project Structure

```
calculator-android-app/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/calculator/
│   │   │   │   └── MainActivity.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml
│   │   │   │   └── values/
│   │   │   │       ├── colors.xml
│   │   │   │       ├── strings.xml
│   │   │   │       └── themes.xml
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   └── build.gradle
├── .github/
│   └── workflows/
│       └── build.yml
├── build.gradle
├── settings.gradle
└── README.md
```

## Build Instructions

### Prerequisites
- Java 11 or higher
- Android SDK

### Local Build

1. Clone the repository:
```bash
git clone https://github.com/dealabs000/calculator-android-app.git
cd calculator-android-app
```

2. Build the project:
```bash
./gradlew build
```

3. Build the APK:
```bash
./gradlew assembleRelease
```

The generated APK will be located at:
```
app/build/outputs/apk/release/app-release-unsigned.apk
```

## Continuous Integration

This project includes a GitHub Actions workflow that automatically:
- Builds the application on every push and pull request
- Runs tests
- Generates APK artifacts

The workflow is configured in `.github/workflows/build.yml`

## Usage

1. Launch the app on an Android device or emulator
2. Tap number buttons to enter values
3. Tap operator buttons (+, −, ×, ÷) to select an operation
4. Tap decimal (.) to add decimal points
5. Tap = to calculate the result
6. Tap C to clear the display

## Technical Details

- **Language**: Java
- **Build System**: Gradle
- **Min SDK**: 21 (Android 5.0)
- **Target SDK**: 34 (Android 14)
- **Android Components**: AppCompat, Material Design

## License

This project is open source and available under the MIT License.

## Contributing

Feel free to fork this repository and submit pull requests for any improvements.
