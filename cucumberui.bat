ECHO OFF
ECHO Automation Starts
:: Change the project location
set projectPath=D:\Softwares\karimun\CerebrumInfotechSeasiaProject
cd %projectPath%

call mvn test verify "-Dcucumber.options=--tags @loginfunc" -f pom.xml
call mvn allure:serve
call mvn allure:report
PAUSE