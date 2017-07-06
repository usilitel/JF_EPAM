cd /d %~dp0
javac -d bin logic\Logic.java
javac -d bin -cp bin main\Main.java
java -cp bin  javase01_intro.t01.main.Main