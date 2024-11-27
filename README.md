# transportexchangegroup

Total Test Cases -> 11 Test cases

## Basic Practice -> 
LoginPageTests.java ->  \test-automation-framework\src\test\java\testFiles\LoginPageTests.java
	###Positive Tests
		positive1_logoText -> checking text of logo -> find expected text
		positive2_ValidCred -> checking logo with valid credentials ->  should  loging
		positive3_logOut -> checking logout -> should logour\
	###Negative Test
		negative1_InvalidUserName -> checking with invalid username but valid password ->  should not loging
		negative2_InvalidPassword->checking with invalid password but valid username-> should not loging
		negative3_lockedUser-> checking with locked user> should not loging
	###LocalStorage
		localStorage-> finding session related key not available in LocalStorage
	###DataProvider Test
		dataUsingDataProvider-> using dataProvider for credentials ->  should  loging


## Advanced Practice ->
AdvanceTask.java -> \test-automation-framework\src\test\java\testFiles\AdvanceTask.java
	###positive4_Cookie -> covering #1,4-> validate session-username, screenshots 
	###validateOverRideGetText - > covering #2,3-> override method implementation and use in logo text

# How to run:
1. using testng.xml -> \test-automation-framework\testng.xml
2. using individuals File -> LoginPageTests.java, AdvanceTask.java
3. using individual Tests
4. using pom
5. using cmd prompt-> go to project directory > open cmd-> run mvn clean test

# Reports:
target/
test-output

# Features:
- Parallel by classes Execution avaiable using testng-parallel.xml
- Screenshot fuctionlaity by method call
- All test cases are independent
- Framewor is POM model with Page Factory
- DataProvider available
- ThreadLocal used to handle parallel Execution
- Can we execute by multiple way as mentioned in How to run section
