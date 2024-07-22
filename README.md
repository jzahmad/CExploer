## JobBoost - A Job Search and Resume Building App for Students

JobBoost is a mobile application designed for students to search for jobs, build resumes, and connect with potential
employers. The app provides a user-friendly interface for students to manage their profiles, search and filter job
postings, and build professional resumes.

### Features

* **Student Profile Management:**
* Create and edit user profiles with personal information, academic background, work experience, and skills.
* Upload profile pictures for a personalized touch.
* **Job Search and Filter:**
* Search for relevant job postings based on keywords, location, job field, and duration.
* Filter job results by various criteria like job title, company name, and application deadline.
* **Job Posting Details:**
* View detailed information about each job posting, including company description, responsibilities, qualifications,
pay, and application instructions.
* Apply for jobs directly through the app (currently using a placeholder URL for demonstration).
* **Resume Builder:**
* Create professional-looking resumes with different templates (Minimalist, Clean, Executive).
* Fill in personal details, work experience, education, and portfolio information.
* Generate PDF resumes that can be saved and shared.
* **Chatbot (ChatGPT):**
* Access the ChatGPT platform directly within the app to get assistance with resumes, cover letters, interview
preparation, and more.
* **Review System:**
* Allow students to leave reviews on companies and employers.
* View existing reviews to gain insights about employers.
* **Notification Settings:**
* Enable and customize job notifications based on specific job fields or keywords.

### Tech Stack

* **Languages:** Kotlin, Java
* **Framework:** Android Studio, Android SDK
* **Libraries:**
* CircleImageView (for profile pictures)
* RecyclerView (for displaying job listings, resume templates, and review list)
* SearchView (for search functionality)
* SQLiteOpenHelper (for database management)
* WebView (for accessing ChatGPT and job application pages)
* SharedPreferences (for user data storage)
* PDFDocument (for resume generation)
* AndroidX (for modern Android development practices)

### Installation and Setup

1. **Clone the repository:**
```bash
git clone https://github.com/your-username/JobBoost.git
```
2. **Open the project in Android Studio:**
* Launch Android Studio and select "Open an existing Android Studio project."
* Navigate to the cloned repository directory and click "Open."
3. **Install dependencies:**
* Android Studio will automatically resolve dependencies. If you encounter any issues, ensure that you have the Android
SDK installed and your project's `build.gradle` files are correctly configured.
4. **Run the project:**
* Click the green "Run" button in the toolbar.
* Select a connected Android device or emulator.
* The app will install and launch on the selected device or emulator.

### Configuration

* **Database:**
* The app utilizes an SQLite database for storing user data and job postings.
* You might need to configure the database file path or create the database if it doesn't exist.
* **ChatGPT Integration:**
* The app uses a WebView to load the ChatGPT website.
* You might need to adjust the WebView settings to handle cookies, cache, and potentially security configurations.
* **Job Application URL:**
* The `ApplyJobActivity` currently uses a placeholder URL for job application.
* You need to replace this placeholder with a real job application URL or implement a custom job application flow.

### Testing

* **Unit Testing:**
* The project includes basic unit tests for some core functionalities.
* You can extend the tests to cover more features and functionalities.
* **UI Testing:**
* Consider using Espresso or UI Automator for testing the user interface.

### Contributing

Contributions are welcome! Here's how to contribute:

1. **Fork the repository.**
2. **Create a branch for your feature or bug fix.**
3. **Make your changes and commit them with a clear description.**
4. **Push your changes to your fork.**
5. **Create a pull request from your fork to the original repository.**

### Licensing

This project is licensed under the [MIT License](LICENSE).

### REFERENCES:

[1] H. Dodenhof, "CircleImageView," GitHub, [Online]. Available: https://github.com/hdodenhof/CircleImageView. Accessed on: November 14, 2023.

[2] "Academic Programs," Dalhousie University, [Online]. Available: https://www.dal.ca/academics/programs.html. Accessed on: November 14, 2023.

[3] Sigmund, "woman in white and blue checked dress shirt," on Unsplash, [Online]. Available: https://unsplash.com/photos/jzz_3jWMzHA. Accessed on: November 25, 2023.

[4] C. Munje, "Generate PDF File in Android using Kotlin", GeeksForGeeks, August 29, 2022. [Online]. Available: https://www.geeksforgeeks.org/generate-pdf-file-in-android-using-kotlin/. Accessed on: November 26, 2023.

[5] Android Developers, "Paint", Android Developers, 2023. [Online]. Available: https://developer.android.com/reference/android/graphics/Paint. Accessed on: November 25, 2023.

[6] Indeed, "Senior Software Engineer", 2023. [Online]. Available: https://ca.indeed.com/viewjob?jk=a7b728790a756451&tk=1hg5vk7gujqt4800&from=serp&vjs=3. Accessed on: November 25, 2023.

[7] M. Y. Suraki. (2023). Adapters. [PowerPoint slides]. Available: https://dal.brightspace.com/d2l/le/content/285435/viewContent/3901793/View

[8] M. Y. Suraki. (2023). Navigation Panel ViewPager TabView. [PowerPoint slides]. Available: https://dal.brightspace.com/d2l/le/content/285435/viewContent/3901796/View

[9] M. Y. Suraki. (2023). Android Data and File Storage. [PowerPoint slides]. Available: https://dal.brightspace.com/d2l/le/content/285435/viewContent/3901798/View


NOTES ABOUT REFERENCES:
- Reference [1] is for the hdodenhof CircleImageView Library (https://github.com/hdodenhof/CircleImageView) which we used to create a CircleImageView to contain a profile picture in the XML file associated with the StudentProfileActivity (i.e., activity_student_profile.xml)

- Reference [2] is for Dalhousie University's “Academic Programs” page (https://www.dal.ca/academics/programs.html) which we used to generate the programs_of_study string array in the project’s strings.xml file which was used for the entries in the “Program of Study” spinner in the ProfileCreationFormActivity’s XML file (i.e., activity_profile_creation_form.xml) 

- Reference [3] is for the female_profile_picture.jpg image that we stored in the application's drawable folder and set as the image source in the CircleImageView in the StudentProfileActivity's XML file (i.e., activity_student_profile.xml)

- Reference [4] was utilized in the functionality of ResumeBuilderActivity.kt as the basis of generating a pdf file in android studio.

- Reference [5] was utilized to implement the paint functionality in ResumeBuilderActivity.kt file to draw different types of resume templates.

- Reference [6] was utilized in redirecting user to job posting in ApplyJobActivity.kt to apply for a job posting. 

- Reference [7] for set up the RecyclerView.

- Reference [8] for Navigation bar and menu.

- Reference [9] for database.


NOTES REGARDING CHATBOT FUNCTIONALITY IN APPLICATION:
- Google's policies do not allow logging into websites via Gmail through an Android Studio emulator. Therefore, when using the Chatbot functionality (i.e., the ChatGPT page in the application) you must avoid third-party logins. Only login via a ChatGPT specific username and password.
	
- The Chatbot functionality (i.e., the ChatGPT page in the application) requires that the emulator running the application have an API of 31 or higher.  

- We have created a fake gmail account and created a ChatGPT account using that fake email for the sake of testing the application's Chatbot functionality (i.e., the ChatGPT page in the application). The credentials for that fake gmail account are as follows (these are the same credentials that we used to create the ChatGPT account):
--> Email: jdoe89668@gmail.com 
--> Password: dummyaccount-pass

- For Search and Filter function, we must notice that when we create the job, please set up the job_duration as "Intern" or "CO-OP" since this app only has these 2 kinds of jobs. Therefore, if you click on the "Intern" or "CO-OP" button on the Search and Filter page. For Search and Filter function, after users input something or click the buttons, it will show the Company Name, Job Title, Job Responsibilities, and Company Contact Information in RecyclerView [7] [8] [9].




