##  Exercise Solution
This is the solution to the Exchange Rates API skill assessment assignment.

## Prerequisites 
1. Use any JDK 8 or higher. I used 11.0.1
2. Make sure you have access to the internet so that third-party jars can be  downloaded at runtime from [maven central](https://mvnrepository.com/repos/central) 
3. Ensure that maven is installed. I designed and tested this solution using maven 3.6.3.

## Software
All libraries and frameworks used are the latest ones found on [maven central](https://mvnrepository.com/repos/central_)

## Instructions
:computer: -  Please clone this repository to your computer. I used a mac with - macOS Mojave 10.14.6

🧭 -  Navigate to root project directory of project i.e `cd {path-to-project}`

## Manual Test Cases
Manual test cases are documented inside ManualTestCases.docx. Each test case has a unique test case number, 
for example TC_001.

## Running Automated Tests
🧹 -  `mvn clean test` <- Runs all Cucumber JVM scenarios.

🧹 -  `mvn clean test -Dcucumber.filter.tags=@TC_003` <- Runs Cucumber JVM scenario with tag @TC_003.

🧹 -  `mvn clean test -Dcucumber.filter.tags=@historical` <- Runs all Cucumber JVM scenario in 
GetHistoricalRates.feature.

🧹 -  `mvn clean test -Dcucumber.filter.tags=@latest` <- Runs all Cucumber JVM scenario in 
GetLatestRates.feature.

The supported tags are: 
@TC_001, @TC_002.... @TC_015

@latest

@historical

@future

Tags such as @TC_001 map to a manual test case that is described in the ManualTestCases.docx.

## Results
Cucumber reports are available at {path-to-project}/target/cucumber/index.html. 

There is currently a defect as exposed by test case TC-015, this needs to be discussed with the Product Owner.

The date in the response is supposed to be the current date but it is not. 

 
## Logs
I am using REST Assured's built in logging capabilities, with a setting that ensures that log statements are only 
printed out when a test fails.

## Framework Design and Implementation 
I ensured that the framework design and implementation followed:
- Good coding practices 
- Clean code techniques
- Comments and Java doc for complex implementation
- Logging on test failure

## Approach To Testing
A series of manual test cases that cover the different API’s plus the edge case are documented in ManualTestCases.docx 
The test case documentation includes detailed instructions for each test case (pre-conditions, steps, expected results).

All of the test cases in the manual document have been included in the regression pack.

Request for the latest rates return a response that could vary from call to call. As such the manual and automated test
check the format of the rates in the response as opposed to actual values of those rates. 

Request for the future rates return a response that could vary from call to call. As such the manual and automated test
check the format of the rates in the response as opposed to actual values of those rates.

Request for historical rates return a response that is constant. As such the manual and automated test
check the actual rates in the response. 

## Assumptions
1. The tests can be executed on either a windows machine that has the required software installed. I haven't proved this. 

## Additional Work
1. Figure out how to configure REST Assured so that logs are written to disk instead of printed to the console. 
This appears to be straight forward but I think there may be a bug in the version of REST Assured that I am using.
3. Add additional @smoke and @sanity tags to scenarios in the feature files, this way we can run subsets of testcase for
smoke and sanity testing.
2. Prove that test cases run successfully on a windows box.