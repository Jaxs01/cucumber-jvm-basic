Introduction
============
This is a model project that can be used to start off using Cucumber JVM / Selenium.

There are four layers that is being demonstrated here 
1. Page object layer. [POM] 
2. Actions and utility layer 
3. Step definitions layer or the business process layer 
4. Feature layer.
*Remark: The site used in for demonstration and the scenarios are not good example representation of the best way of writing business scenarios but used just for the demonstration purposes. The scenarios should be written in high level business terms.  


Pre requisites;
--------------
1.	JDK 1.8 (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2.	Maven 3.3 or higher (https://maven.apache.org/download.cgi?Preferred=ftp://mirror.reverse.net/pub/apache/)
3.	Eclipse or Intellij Idea Community Edition (https://www.jetbrains.com/idea/download/#section=windows)
4.	GIT (https://git-scm.com/download/win)

Once you install the above add the following two plugins to Idea IDE (File>Settings>Plugins>InstallJetBrainPlugins>...)
1.	Cucumber for java
2.	Gherkin

•	Clone the project using the following @ the project folder $ git clone https://goonawardanan@bitbucket.org/Assurity/cucumber-jvm-basic.git $ cd cucumber-jvm-basic
•	To run the tests from command line : 
•	$ mvn clean test -Dtest=RunSampleFeature
•	You can import the project into Idea as a maven project; File > Open > Select the pom.xml
•	You can find the sample feature file at <project folder>\src\test\resources\nz\co\assurity\test
•	Right click on a scenario and select "Run scenario" to execute the scenario.
•	You can find the reports at <project folder>\target\cucumber-html-report\

