**#TestAssignment**

This is automation suite is designed to test the webapplication.The tech stack used for this project are:

1.JAVA as the programming language for writing test code

2.Page object model as framework

3.Eclipse as the preferred IDE for writing java code.

4.JDK1.8

Project can be clone from github and AzureRepo. 

[**git clone**] (https://github.com/pujaverma89/TestAssignment) 

[**Azure clone**]  (https://dev.azure.com/pujavrma110340/TestAssignmentUI)


Prerequisite:

	1.Java

	2.Maven

	3.Selenium/WebDriver

	4.TestNg

	5.Browsers (Firefox, Chrome)- bydefault selected chrome

	6.Eclipse 
	
*Usecases executed:* 

1.Launched chrome browser and navigate to https://cloud.tacx.com/

2.Selected Create Account option

3.Entered details and click on sign up button to create new Tacx account 

4.Verified the URL in App dashboard 

5.Selected “Create workout” menu item from left pane in dashboard

6.Selected Power workout and then select distance as target and then select continue

7.set the distance to 12 KM and save the workout with title name 

8.Then navigated to “Workouts” menu item and verify the created new Workout with mentioned title name

9.Logout from Account

10.Generate the test report
	

*Step to follow to run the test*

Test can run the tests directly from the eclipse, by right-clicking from TestNG class and Run as TestNG.

From commandLine: mvn clean test 








