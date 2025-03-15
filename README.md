# Week 2 Assignment: Building a News Reader App with Jetpack Compose

## Project Overview
This project is a News Reader Application built using Jetpack Compose. The app supports both dark and light themes, includes English and Arabic language support, and allows users to view and bookmark news articles. The assignment focuses on implementing LazyColumn, navigation, and theming in Jetpack Compose.

## Setup Instructions
1. Clone this repository:
   ```sh
   git clone <repository_url>
   ```
2. Open the project in Android Studio.
3. Sync the Gradle files and install necessary dependencies.
4. Run the app on an emulator or physical device.

## Features Implemented
### 1. News Feed with LazyColumn (20 Marks)
- Displays a list of static news articles using LazyColumn.
- Shows only news headlines on the main screen.
- Handles click events to navigate to the News Detail Screen.

### 2. News Detail Screen & Bookmarking (25 Marks)
- Displays news title, content, and date on the detail screen.
- Includes a top menu with a bookmark button:
  - Toggles between bookmarked and unbookmarked states.
  - Updates the icon based on the bookmark state.

### 3. Dark Mode & Theming (20 Marks)
- Utilizes MaterialTheme API for typography and color scheme.
- Supports both dark and light themes.
- Includes a theme toggle switch in the app settings.

### 4. Localization & RTL Support (15 Marks)
- Supports both English and Arabic languages.
- Ensures that:
  - News content switches based on the selected language.
  - The app layout supports RTL (Right-to-Left) when in Arabic.

### 5. Project Submission (10 Marks)
- The completed project is hosted on GitHub.
- This README file provides an overview, setup instructions, implemented features, technologies used, and contribution guidelines.

## Technologies Used
- Kotlin
- Jetpack Compose
- MaterialTheme API
- Navigation Component
- Localization Support
- GitHub for version control

## How to Contribute
1. Fork the repository.
2. Create a new branch for your feature or bug fix:
   ```sh
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```sh
   git commit -m "Description of changes"
   ```
4. Push the branch:
   ```sh
   git push origin feature-name
   ```
5. Open a pull request for review.

---
This project is part of the Week 2 Assignment for learning Jetpack Compose. Contributions and improvements are welcome!

