Author: David Scully
Company: Expert Software Test

## Information
1. To start up the selenium Hub and node (the browser automation) run the batch file found here:
`{this-project}/scripts/1-start-selenium-server.bat`

OR manually:

2. From the `{this-project}/scripts/` folder run the following: 
`java -jar selenium-server-standalone-2.53.1.jar -role hub -timeout 0` to start the Selenium Hub 
`java -jar selenium-server-standalone-2.53.1.jar -role node -nodeConfig chromeNodeConfig.json`  to start the Selenium 
Node (using Chrome configuration) 

The tests are set up to run using the Chrome browser (this is set in the test's BeforeClass and the launched Selenium 
node)

There is 2 options to run the tests and generate the report (the site phase builds the Allure report):
1. From the project's root directory run via a terminal or command line: `mvn clean test site`
2. Run the script found here (this does the exact same thing as 1 above): `{this-project}/scripts/2-run-tests.bat`


The reports can be found in the target directory under the allure-report directory
`{this-project}/target/allure-report`.
To view the report simply open the index.html found in this location in any browser to view the Allure report

The test data used can be found in JSON file format in:
`{this-project}/src/main/resources/test-data.json`. A test will run for each object in this file.


## Assumptions made + Notes:
- For the assertion of the expected converted amount and the actual converted amount,
 I am allowing a delta of 0.02 (I allow for a difference of 0.02 between them) due to floating point calculations not 
 being exact (my rounding up of the values to 2 decimal places).
 
- A better solution would be to use the BigDecimal class to handle currency parsing and evaluation instead of doubles
 
- I added in a Retry implementation due to the fluctuation of the Exchange Rate and the slow response time of the web 
site. 

- The provided test data must not contain any comma separated numbers for the amount. I am not currently parsing this 
value.

