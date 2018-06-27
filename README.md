# PublicPortalUIAutomation
There are two separate Eclipse based maven projects.
1. PortalTestFramework
2. PublicPortalTests
3. Draft Test Plan.docx
and 
4. PageFreezer_PubPortal_TestExecution.mp4  the test execution screen cast

Please download as you see fit.

The PortalTestFramework project is developed as an abstraction of the public portal web app and has the webdriver API and the driver itself bundled in the project.

The PublicPortalTests project is developed to have only the TestNG based tests with PortalTestFramework as a dependency. Currently this is a snapshot version with the snapshot jar included in the dependencies.

How to run the tests:
Currently the tests have been set up to run from inside Eclipse.
1. Download both the projects on to your PC
2. Using Eclipse, add the two projects as "Existing Maven Projects"
3. Maven-update both projects
right click on any project name and select "Maven > Update Project" from the context menu. Select checkboxes for both projects and click OK
3. After update finishes Right click on project PublicPortalTests and from the context menu select "Run As > TestNG Test"

This will launch the TestNG test runner and complete a test execution of all tests found under this project.
