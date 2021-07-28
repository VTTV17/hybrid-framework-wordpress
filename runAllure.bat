set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%lib\LibAllureReport\aspectjweaver-1.9.8.M1.jar" -classpath "%ProjectPath%bin;%ProjectPath%lib\*;%ProjectPath%lib\LibAllureReport\*;%ProjectPath%lib\LibExtentReportVer2\*;%ProjectPath%lib\LibLog4J\*;%ProjectPath%lib\LibReportNG\*;%ProjectPath%lib\LibWebDriverManage\*;" org.testng.TestNG "%ProjectPath%bin\level_14_LogReportHTML.xml"
allure serve .\allure-results\
