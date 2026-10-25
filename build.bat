@echo off
cd /d "%~dp0"
REM Compiles the application into the "out" folder.
if not exist out mkdir out
javac -d out src\VerticalLineCounter.java
if errorlevel 1 (
    echo Build failed.
    exit /b 1
)
echo Build succeeded.
