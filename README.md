Movie List App - Android Final Project 🚀

Hi this is My Final project for android class in university this is a simple android app with kotlin and jetpack compose that can fetch the movies list with api from the server and show the list in a LazyColumn

🌟 Features

    Fetch movies from a remote API with one tap: Easily retrieve movie data from an online source.

    Display movie title, director, and release year: Presents essential movie information clearly.

    Sorted and beautiful list using Jetpack Compose’s LazyColumn: Provides a smooth and visually appealing scrolling experience.

    Shows loading indicator on network request: Informs the user when data is being fetched.

    Error/empty-list messages for a great user experience: Handles various network and data scenarios gracefully.

    Can easily be adapted for any similar data API: Designed for flexibility and reusability with other API endpoints.


🚀 Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites

Before building/running this project, ensure you have:

    Android Studio: Latest version recommended.

    Java Development Kit (JDK) 17 or later: This is typically bundled with Android Studio's Java Runtime (JBR).

    Internet access: Required on your device/emulator to fetch data from the API.

    API Servers Running: This Android app relies on external backend services. Ensure that your API projects (10-api-1 and 11-api-2 mentioned in the original context of your project) are running and accessible from your development environment.

Dependencies

Core libraries and frameworks used in this project:

    Kotlin and Jetpack Compose: For modern Android application development and declarative UI.

    Ktor HTTP client (io.ktor:ktor-client-core): For making asynchronous API calls.

Kotlin Serialization (org.jetbrains.kotlinx:kotlinx-serialization-json): For efficient JSON parsing.

    Material3: For a modern and consistent design system.

    Gradle: The build automation tool.

🌐 API Endpoints

By default, movies are fetched from:
Plaintext

http://45.139.11.115:5852/api/collections/movie/records

i don't know whene you want to use this but i think that won't work at that time so change it with your own api key

Each item returned by the API typically contains the following structure:
JSON

{
  "title": "Inception",
  "director": "Christopher Nolan",
  "time": "2010"
}

This project integrates with two distinct APIs, likely simulating different data sources or backend services, as part of its end-of-term requirements:

    API 1 (Main Project Context): Based on the provided context, this API aligns with the project at https://github.com/Android-Montazeri-03-04/10-api-1. 

API 2 (Main Project Context): This API is referenced as part of the project at https://github.com/Android-Montazeri-03-04/11-api-2. 

Note on API URLs: If you are running your backend API locally, you might need to adjust the API endpoint in the Android project to http://10.0.2.2:PORT/ for emulator access, or your machine's local IP address for a physical device.

🏃 How to Run

    Clone the repository to your local machine:
    Bash

git clone https://github.com/hamidreza-83/Project-Server-Android.git

(Remember to replace YOUR_USERNAME with your actual GitHub username after pushing the project).

Open the project in Android Studio. Android Studio will automatically import the Gradle project and sync dependencies.

Ensure you have internet permission. Verify your AndroidManifest.xml file includes the following line within the <manifest> tag:
XML

    <uses-permission android:name="android.permission.INTERNET" />

    Build and Run the project on your emulator or a connected Android device.

💡 Usage

    Click on the "Click To Get Movies" button to initiate the data fetch.

    The app will fetch the latest movie list from the API.

    See each movie’s title, director, and release year displayed in a stylish, scrollable list.

    A loading spinner appears during fetching to provide visual feedback.

    Error/empty messages are shown for a good user experience (e.g., if there's no internet connection or no movies are found).

👩‍💻 Code Highlights

    Network: Utilizes Ktor with Kotlin Serialization for asynchronous API calls and efficient JSON parsing.

    UI: Built with Jetpack Compose, leveraging LazyColumn for performant lists, Material3 components, and responsive layouts for a modern look and feel.

    Clean State Management: Employs Compose's remember and mutableStateListOf for effective UI state management, including handling loading, error, and empty states.

⚙️ Customization

You can easily:

    Change the API endpoint in the code to point to your own server or a different data source.

    Adjust the UI design and theming to suit your specific needs by modifying the Jetpack Compose UI code and Material3 themes.

    Extend movie model fields to display more information, such as posters, genres, ratings, or other relevant data.

🎯 Educational Goals

This project serves as an excellent learning resource, helping you understand:

    How to connect Android applications to REST APIs using Ktor.

    Parsing and displaying structured JSON data with Kotlin Serialization.

    Building modern UI with Jetpack Compose and Material3 components.

    Managing various UI states: loading, error, empty, and content display.

📧 Contact

For any questions or inquiries, please feel free to reach out to hamidrezafatemi383@gmail.com or @sudo_space on telegram.
