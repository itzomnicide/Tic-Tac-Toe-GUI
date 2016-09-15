cd acceptance
javac -cp .;..\build\classes\main TicTacToeKeywords.java
java -cp .;..\build\classes\main;C:\RobotFramework\robotframework-2.9.jar;C:\RobotFramework\swinglibrary-1.9.5.jar org.robotframework.RobotFramework TicTacToeGUITests.txt
cd ..