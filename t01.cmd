cd /d %~dp0
javac -d bin src\javase01\t01\logic\Logic.java
javac -d bin -cp bin src\javase01\t01\main\Main.java
java -cp bin  javase01.t01.main.Main 