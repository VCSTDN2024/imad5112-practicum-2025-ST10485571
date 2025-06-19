MomoLo 

Developer: Sabelo Kagiso Gwele 

Student Number: ST10485571 

Group: 1 

Course: HAW1 

Subject: IMAD5112 

Links 

GitHub Repository: https://github.com/VCSTDN2024/imad5112-practicum-2025-ST10485571/new/main?filename=README.md 

Project Overview 

The MomoLo is a mobile application developed as part of an assignment in the IMAD5112 subject. This application was created using Kotlin and Android Studio. The app's primary purpose is to The app is designed to help users manage and rate personalized music playlists. Users can select a playlist, view its songs, and assign a rating through an interactive spinner. The app calculates and displays the average rating, allowing users to keep track of their listening preferences and experiences. 

The app was developed to meet the requirements of the assignment, which includes creating a functional mobile app and utilizing GitHub for version control and CI/CD automation using GitHub Actions. 

 

Purpose and Features 

Purpose: The main goal of this app is to The app is designed to help users manage and rate personalized music playlists. Users can select a playlist, view its songs, and assign a rating through an interactive spinner. The app calculates and displays the average rating, allowing users to keep track of their listening preferences and experiences. Key Features: 

Feature 1: Playlist Selection, e.g., "Display a playlist chosen by the user." 

Feature 2: Rating System, e.g., "Allows the user to rate the playlist." 

Feature 3: Input Validation, e.g.,"" 

These features aim to provide users with a simple and interactive platform to explore pre-defined music playlists, view song lists, and assign ratings to each playlist, enabling a more personalized and enjoyable music experience. 

Design Considerations 

The design of the MomoLo was based on the following key considerations: 

User Experience (UX): The app was designed with the goal of providing an intuitive and easy-to-navigate user interface, ensuring a seamless user experience. 

Responsiveness: The app was built to ensure it performs well on different screen sizes, with particular attention to device compatibility. 

Simplicity: The design is minimalistic, focusing on core features without overwhelming the user. 

Performance: Code optimization was considered to ensure fast response times and low battery usage. 

 

GitHub and GitHub Actions 

This project was managed using GitHub for version control, where all code changes were committed and pushed regularly. GitHub enabled collaborative coding, allowing me to keep track of changes and maintain project integrity. 

GitHub Actions: I utilized GitHub Actions to automate the build and deployment process. This includes: 

Running automated tests to ensure the app’s functionality. 

Uploading these build artifacts to GitHub for easy access. 

The workflow ensures that my project is automatically built and tested every time I push changes, and it simplifies the process of delivering the final APK/AAB files for submission. 

 

Screenshots 

App Screenshots: Screenshot 

Screenshot 1:
![image](https://github.com/user-attachments/assets/94590235-8c89-4dbc-a67a-24924cbbbaa1)

Screenshot 2:
![image](https://github.com/user-attachments/assets/74498c18-be07-4962-8ab6-0dc81e247a57)

Screenshot 3:
![image](https://github.com/user-attachments/assets/4d7a6669-8738-49e3-9604-eb15459c3860)

Screenshot 4:
![image](https://github.com/user-attachments/assets/53b5010c-1e9c-475f-a471-701ade998485)

Screenshot 5:
![image](https://github.com/user-attachments/assets/a47df006-84d1-45f6-a3a3-81cdc0ffbc33)

Screenshot 6:
![image](https://github.com/user-attachments/assets/1c5495a1-8982-4d46-97f8-451dd8013f77)

Screenshot 7:
![image](https://github.com/user-attachments/assets/7922f111-6d93-4acc-9e31-afaaf5ebc18b)

Screenshot 8:
![image](https://github.com/user-attachments/assets/abe77801-51e1-450e-8f6b-72bff026bc36)

Screenshot 9:
![image](https://github.com/user-attachments/assets/6754b9f9-de51-4fcc-aeec-95286f2a556b)

Screenshot 10:
![image](https://github.com/user-attachments/assets/9b18d046-a467-4cb5-99e3-d52530b23768)


 

Challenges and Learnings 

During the development of this project, I encountered several challenges, including: 

Challenge: Displaying Playlist Songs Dynamically 

Problem: Mapping playlist names to a list of songs and displaying them when selected. Solution: Used a Map<String, List> to associate each playlist name with its corresponding songs. When the “Display” button is clicked, the selected playlist is used as a key to fetch and display its songs in a TextView. 

⸻ 

Challenge: Collecting and Calculating Ratings 

Problem: Ensuring the spinner rating selection is correctly captured and converted for calculation. Solution: Used a Spinner with input validation to prevent invalid selections like “Select Rating”. Ratings are parsed from string to float and then displayed as the average in a TextView. 

⸻ 

Challenge: Handling Missing or Incorrect Playlist Selection 

Problem: App could crash or behave unexpectedly if no playlist was selected. Solution: Added checks to disable buttons and show helpful error messages if no valid playlist is received from the intent. 

From these challenges, I learned important lessons in debugging, using version control, and automating build processes with GitHub Actions. 

 

References 

K.Garanganga.,2025. Introduction To Mobile Application Development[IMAD5112].[online via internal VLE] The Independent Institution Of Education. Accessed 28 March 2025 

 

List of Figures 

Figure 1: Screenshot of the app's home screen. 
![image](https://github.com/user-attachments/assets/f601285d-df99-483f-ad3a-33d9c0385dec)

-image, Picture -Picture of my App running in the home screen. 

Figure 2: Screenshot of the user profile screen. 
![image](https://github.com/user-attachments/assets/04d42b7e-2bc8-4771-9f01-647c9833423a)

image, Picture of detailed view screen by the user

User profile screen 

 

Disclosure of AI Usage in My Assessment 

In the development of this project, I have used generative AI tools to assist in various parts of the assignment. Below is a detailed disclosure of where and how these tools were used: 

AI Usage Disclosure 

This project was developed with the assistance of ChatGPT, an AI language model by OpenAI. The AI was used to: • Generate written content such as the app’s purpose, features, aim, challenges and solutions, and documentation sections. • README document. 

 
