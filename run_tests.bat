@echo off
cd /d "%~dp0"
REM Compiles the app, then runs it on each test image.
if not exist out mkdir out
javac -d out src\VerticalLineCounter.java || (pause & exit /b 1)

for %%f in (img_1 img_2 img_3 img_4) do (
    echo | set /p="%%f.jpg: "
    java -cp out VerticalLineCounter "%~dp0test-images\%%f.jpg"
)
pause
