# 208445957
# hanimoy

compile: bin
	javac -cp biuoop-1.4.jar:src -d bin src/*.java
run:	
	java -cp biuoop-1.4.jar:bin Ass6Game
jar:
	jar cvfm ass6game.jar MANIFEST.MF -C bin .
bin:
	mkdir bin