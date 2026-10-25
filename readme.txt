TMMC Programming Assignment - Vertical Line Counter
====================================================

A Windows console application, written in Java, that counts the number
of vertical black lines in a black and white JPG image made in MS Paint.


Requirements
------------
Java 8 or newer (JDK to compile, JRE/JDK to run).
Check your version with:   java -version
No external libraries are used.


Build
-----
Double-click build.bat, or from a command prompt in this folder run:

    javac -d out src\VerticalLineCounter.java

This creates the compiled class in the "out" folder.


Run
---
From a command prompt in this folder:

    java -cp out VerticalLineCounter "C:\TMMC_interview_assignment\img_1.jpg"

The program prints a single number: the count of vertical lines.

Wrap the path in quotes if it contains spaces.


Error handling
--------------
- If the number of arguments is not exactly 1, a message and usage
  example are printed.
- If the file does not exist or is not a readable image, an error
  message is printed.
- Any other exception is caught and printed. The program does not crash.


Testing
-------
Run run_tests.bat to build the app and run it against the four
provided images in the test-images folder. Expected results:

    img_1.jpg   1
    img_2.jpg   3
    img_3.jpg   1
    img_4.jpg   7


Project layout
--------------
src\VerticalLineCounter.java   Source code
test-images\                   The four provided test images
build.bat                      Compiles the app
run_tests.bat                  Builds and runs all four test images
readme.txt                     This file
problems_summary.txt           Notes on problems found while programming
