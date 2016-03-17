This proof of concept demonstrates using acceptance test frameworks to do web searches so that one can see different the different/similar implementations of layering:

 - cucumber 
 - cucumber-jvm 
 - concordion
 - concordion.net
 - FitLibraryWeb 
 - and an initial attempt at Thucydides

Tested on Mozilla 10 (OS X) (Note: concordion/webdriver has been known not to work on Mozilla 11 OS X) and Win 7 (for .net implementation)

Cucumber
========

Also, you may want to look at [this tutorial](http://watir.com/2011/01/22/simple-cucumber-watir-page-object-pattern-framework/)
and [this blog series](http://www.cheezyworld.com/2010/12/16/ui-tests-putting-it-all-together/)

Ensure that you are in the cucumber/ folder.

Installation
------------

This code is written in ruby and tested on 1.8.7

    $ ruby -v
    ruby 1.8.7 (2010-01-10 patchlevel 249) [universal-darwin10.0]

You will also require the installation of the following GEMS via the commands:

    gem install rake
    gem install rspec
    gem install watir-webdriver
    gem install cucumber
  
    $ gem list
  
    *** LOCAL GEMS ***
  
    childprocess (0.3.1, 0.1.9)
    cucumber (1.1.8, 0.3.97, 0.2.3, 0.1.12, 0.1.10)
    multi_json (1.0.4)
    rake (0.8.7, 0.8.3)
    rspec (2.6.0, 1.3.0, 1.2.8, 1.2.2, 1.1.11, 1.1.8, 0.5.15)
    rspec-core (2.6.3)
    rspec-expectations (2.6.0)
    rspec-mocks (2.6.0)
    rspec_generator (0.5.15)
    rubygems-update (1.3.6, 1.3.5, 1.3.1, 1.3.0)
    selenium-webdriver (2.19.0, 0.2.0)
    term-ansicolor (1.0.7, 1.0.4, 1.0.3)
    watir-webdriver (0.5.3)

Test using Rake
---------------

  Ensure that you have rake installed and then to see the tests available, from the root directory run rake with the option to show tasks

    cucumber $ rake -T
    
    rake default  # Run Cucumber features
    rake prod     # Run Cucumber features

Sample run
----------

    cucumber $ rake
    
    (in /Users/todd/Documents/src/AutomationTutorial)
    /System/Library/Frameworks/Ruby.framework/Versions/1.8/usr/bin/ruby -I "/Library/Ruby/Gems/1.8/gems/cucumber-1.1.8/lib:lib" "/Library/Ruby/Gems/1.8/gems/cucumber-1.1.8/bin/cucumber"  --profile default
    Using the default profile...
    Code:
      * features/support/env.rb
      * config/config_common.rb
      * config/config_dev.rb
      * features/pages/bing_search_page.rb
      * features/pages/google_search_page.rb
      * features/step_definitions/search_steps.rb
    
    Features:
      * features/search.feature
    Parsing feature files took 0m0.047s
    
    Feature: 
      Potential Assurity customers need to be able to find company information, services and address details when searching on the internet
    
    Scenario:                                                                       # features/search.feature:4
      Given I am using google                                                       # features/step_definitions/search_steps.rb:1
      When I search for 'Assurity'                                                  # features/step_definitions/search_steps.rb:5
      Then the top result should be 'Assurity - Ensuring Software Health - Welcome' # features/step_definitions/search_steps.rb:10
  
    Scenario:                                      # features/search.feature:9
      Given I am using google                      # features/step_definitions/search_steps.rb:1
      When I search for 'test agile new zealand'   # features/step_definitions/search_steps.rb:5
      Then the results include the text 'Assurity' # features/step_definitions/search_steps.rb:14
    
    2 scenarios (1 pending, 1 passed)
    6 steps (1 pending, 5 passed)
    0m8.368s

Cucumber-jvm
============
The tests can be run from the command line using Gradle, or through an Integrated Development Environment (IDE) such as Eclipse. 

You will need to have Firefox installed (the code could be modified to use other browsers, but would require more setup).

Gradle
------
1. Open a command prompt, and cd to the root of the project
1. To see whether Gradle is already installed, type *gradle -version*
1. If Gradle was not found, or the version is earlier than 1.0, you will need to [download](http://www.gradle.org/downloads.html) and [install](http://www.gradle.org/installation.html) Gradle (this has been tested with Gradle 1.0). 
1. *cd cucumber-jvm*
1. *gradle test*

This should start the browser, run some tests and display success or failure status on the command prompt.

To view the output, open the file target/cucumber/index.html.

Eclipse
-------
1. Ensure Gradle is installed (see above)
1. Ensure [Eclipse](http://www.eclipse.org) is installed
1. Open a command prompt, and cd to the root of the project
1. *cd concordion*
1. *gradle eclipse*
1. Load into Eclipse workspace:

		File > Import > Existing Projects into Workspace > Select the path to this project > Select cucumber-jvm checkbox > Finish

1. In the cucumber-jvm project in Eclipse, expand the src/test/java node. 
1. Expand assurity.web.presence to show AssuritySearchTest.java.
1. Right click on this file and select *Run As* > *JUnit Test*

This should start the browser, run some tests and display success or failure on the console.

Check the test results in the Eclipse Console and JUnit views (tabs). To view the output, open the file target/cucumber/index.html.


Concordion
==========
The tests can be run from the command line using Gradle, or through an Integrated Development Environment (IDE) such as Eclipse. 

You will need to have Firefox installed (the code could be modified to use other browsers, but would require more setup).

Gradle
------
1. Open a command prompt, and cd to the root of the project
1. To see whether Gradle is already installed, type *gradle -version*
1. If Gradle was not found, or the version is earlier than 1.0, you will need to [download](http://www.gradle.org/downloads.html) and [install](http://www.gradle.org/installation.html) Gradle (this has been tested with Gradle 1.0). 
1. *cd concordion*
1. *gradle test*

This should start the browser, run some tests and display success or failure status on the command prompt.

To view the output, open the file build/reports/spec/assurity/web/presence/AssuritySearch.html.

Eclipse
-------
1. Ensure Gradle is installed (see above)
1. Ensure [Eclipse](http://www.eclipse.org) is installed
1. Open a command prompt, and cd to the root of the project
1. *cd concordion*
1. *gradle eclipse*
1. Load into Eclipse workspace:

		File > Import > Existing Projects into Workspace > Select the path to this project > Select concordion checkbox > Finish

1. In the concordion project in Eclipse, expand the src/test/java node. 
1. Expand assurity.web.presence to show AssuritySearchTest.java.
1. Right click on this file and select *Run As* > *JUnit Test*

This should start the browser, run some tests and display success or failure on the console.

It also shows the location of the Concordion output file on the console. Open this file (eg. from Windows Explorer) to view the output.


Concordion.net
==============

Ensure that you are in the concordion.net/ folder (and running in .net)

Installation
------------

Ensure that you have Visual Studio with .Net 4 installed

Sample Run
----------

Run from commandline or from GUI.

		> run-spec-with-echo.cmd
		
		Microsoft (R) Build Engine Version 4.0.30319.1
		[Microsoft .NET Framework, Version 4.0.30319.1]
		Copyright (C) Microsoft Corporation 2007. All rights reserved.

		Build started 1/03/2012 9:33:29 p.m..
		Project "Z:\Documents\src\AutomationTutorial\concordion.net\Concordion.sln" on
		node 1 (default targets).
		ValidateSolutionConfiguration:
		  Building solution configuration "Debug|Any CPU".
		Project "Z:\Documents\src\AutomationTutorial\concordion.net\Concordion.sln" (1)
		 is building "Z:\Documents\src\AutomationTutorial\concordion.net\src\concordion
		.spec\Concordion.Spec.csproj" (2) on node 1 (default targets).
		GenerateTargetFrameworkMonikerAttribute:
		Skipping target "GenerateTargetFrameworkMonikerAttribute" because all output fi
		les are up-to-date with respect to the input files.
		CoreCompile:
		Skipping target "CoreCompile" because all output files are up-to-date with resp
		ect to the input files.
		_CopyOutOfDateSourceItemsToOutputDirectory:
		Skipping target "_CopyOutOfDateSourceItemsToOutputDirectory" because all output
		 files are up-to-date with respect to the input files.
		_CopyOutOfDateSourceItemsToOutputDirectoryAlways:
		  Copying file from "Z:\Documents\src\AutomationTutorial\concordion.net\src\con
		  cordion.spec\Google\AssuritySearch.html" to "bin\Debug\Google\AssuritySearch.
		  html".
		CopyFilesToOutputDirectory:
		  Concordion.Spec -> Z:\Documents\src\AutomationTutorial\concordion.net\src\con
		  cordion.spec\bin\Debug\Concordion.Spec.dll
		Done Building Project "Z:\Documents\src\AutomationTutorial\concordion.net\src\c
		oncordion.spec\Concordion.Spec.csproj" (default targets).

		Done Building Project "Z:\Documents\src\AutomationTutorial\concordion.net\Conco
		rdion.sln" (default targets).


		Build succeeded.
		    0 Warning(s)
		    0 Error(s)
		
		Time Elapsed 00:00:00.48
		!!! You must have Gallio installed and have Gallio.Echo.exe in the PATH to run t
		his batch file !!!
		
		Gallio Echo - Version 3.2 build 744
		Get the latest version at http://www.gallio.org/
		
		Start time: 9:31 p.m.
		Initializing the runtime and loading plugins.
		Verifying test files.
		Initializing the test runner.
		Running the tests.
		[failed] Fixture Concordion.Spec/AssuritySearchTest
		Disposing the test runner.
		Stop time: 9:31 p.m. (Total execution time: 23.486 seconds)

		1 run, 0 passed, 1 failed, 0 inconclusive, 0 skipped
		

FitLibraryWeb
=============

FitLibraryWeb has been picked over Fitnesse or Slim because it provides a DSL for interacting with web pages. It will demonstrate the layering of the wiki pages with out the complexity of writing fixtures. Without it, you would use the the Java or C# implementation of the Google search and result page classes.

Ensure that you are in the fitlibraryweb/ folder.

Installation
------------

This code was tested on java version 1.6

		$ java -version
		java version "1.6.0_29"
		Java(TM) SE Runtime Environment (build 1.6.0_29-b11-402-10M3527)
		Java HotSpot(TM) 64-Bit Server VM (build 20.4-b02-402, mixed mode)
		
Run the installation script. This will download a prepackaged fitnesse, update the wiki, start Fitnesse and open a browser at the correct page. 

		fitlibraryweb $ chmod +x install.sh
		fitlibraryweb $ install.sh
		$ ./install.sh 
		  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
		                                 Dload  Upload   Total   Spent    Left  Speed
		100 43.1M  100 43.1M    0     0   131k      0  0:05:34  0:05:34 --:--:--  336k
		Archive:  Fitnesse-Apr2011.zip
		  inflating: Fitnesse-Apr2011/build.xml  
		  inflating: Fitnesse-Apr2011/fitlibrary.jar  
		  inflating: Fitnesse-Apr2011/FitLibraryLogger.properties  
		  inflating: Fitnesse-Apr2011/fitnesse.jar  
		   creating: Fitnesse-Apr2011/FitNesseRoot/
			...
		  inflating: Fitnesse-Apr2011/log4j.properties  
		  inflating: Fitnesse-Apr2011/releaseWebREAD-ME.html  
		  inflating: Fitnesse-Apr2011/run.bat  
		
			FitNesse (v20110104) Started...
				port:              8980
				root page:         fitnesse.wiki.FileSystemPage at ./FitNesseRoot
				logger:            none
				authenticator:     fitnesse.authentication.PromiscuousAuthenticator
				html page factory: fitnesse.html.HtmlPageFactory
				page version expiration set to 0 days.
				
This will also open a browser that you should then refresh and press the test button!

Sample run via browser
--------------------------

Ensure that have run the installation and you should be at the sample google page. The test will use the Spider Fixture.

    fitlibraryweb $ chmod +x ./run-test.sh
		fitlibraryweb $ ./run-test.sh
		
This will open the browser and run the test in the browser

Sample run via commandline
--------------------------

		fitlibraryweb $ chmod +x run-test.sh
		fitlibraryweb $ ./run-test.sh
		
		FitNesse (v20110104) Started...
			port:              9123
			root page:         fitnesse.wiki.FileSystemPage at ./FitNesseRoot
			logger:            none
			authenticator:     fitnesse.authentication.PromiscuousAuthenticator
			html page factory: fitnesse.html.HtmlPageFactory
			page version expiration set to 14 days.
		Executing command: FitLibraryWeb.SpiderFixture.TestAssurity?test&format=text
		-----Command Output-----

		Starting Test System: fit using fitlibrary.suite.FitLibraryServer.
		. 13:57:37 R:10   W:0    I:0    E:0    TestAssurity	(FitLibraryWeb.SpiderFixture.TestAssurity)	12.829 seconds
		--------
		1 Tests,	0 Failures	15.046 seconds.
		0
		Exit-Code: 0

Thucydides
==========
The tests must be run using Maven to generate the reports. The project includes tests in both the JUnit and easyB format.

You will need to have Firefox installed (the code could be modified to use other browsers, but would require more setup).

1. Install Maven, if not already installed.
1. Edit the Maven settings.xml file and add *<pluginGroup>net.thucydides.maven.plugins</pluginGroup>*
1. From a command prompt, run *mvn test thucydides:aggregate*. This seems to run the easyB tests in test/stories/nz/co/assurity/AssuritySearch.story.
1. View the output in _target/site/thucydides/index.html_. Currently this file isn't being generated if the tests fail, so you will need to view the other _.html_ files in this folder.