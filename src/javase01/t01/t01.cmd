cd /d %~dp0
javac -d bin logic\Logic.java
javac -d bin -cp bin main\Main.java
java -cp bin  javase01.t01.main.Main 