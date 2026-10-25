TMMC Programming Assignment - Vertical Line Counter

Counts the vertical black lines in a black and white JPG image.
Requires Java 8 or newer.

Compile (from this folder):
    javac -d out src\VerticalLineCounter.java

Run:
    java -cp out VerticalLineCounter "C:\TMMC_interview_assignment\img_1.jpg"

Prints the number of vertical lines. Prints an error message if the
argument count is wrong or the file can't be read.

Expected results for the provided images (in test-images):
    img_1.jpg: 1
    img_2.jpg: 3
    img_3.jpg: 1
    img_4.jpg: 7
