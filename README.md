# Mobile Computing Project - Undergrad Group 9 

REFERENCES:
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




