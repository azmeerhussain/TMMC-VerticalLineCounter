@echo off
cd /d "%~dp0"
REM Builds the app, then runs it on each provided test image.
call build.bat || (pause & exit /b 1)
echo.
echo Expected: img_1=1, img_2=3, img_3=1, img_4=7
echo.
for %%f in (img_1 img_2 img_3 img_4) do (
    echo | set /p="%%f.jpg: "
    java -cp out VerticalLineCounter "%~dp0test-images\%%f.jpg"
)
echo.
pause
