# Quest_Manager_ANSQUER_RAYAN


Before do<ing project, let's check if required datas are installed :

After installation, verify the JDK folder location by running in PowerShell:
 
```powershell
dir "C:\Program Files\Eclipse Adoptium"
```
 
This should show a folder named `jdk-21.0.x.x-hotspot`.
 
---
 
### 2. Set the JAVA_HOME environment variable
 
If "where java" returns nothing in the terminal, "JAVA_HOME" is not set.
Run the following commands in **PowerShell as Administrator**:
 
```powershell
[System.Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot", "Machine")
```
 
```powershell
[System.Environment]::SetEnvironmentVariable("Path", $env:Path + ";C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot\bin", "Machine")
```
 
> ⚠️ Replace the path with your actual JDK folder name if different.
 
---
 
### 3. Verify the installation
 
Close and reopen VSCode, then run in the terminal:
 
```powershell
echo $env:JAVA_HOME
where.exe java
java -version
```
 
Expected output:
```
C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot
C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot\bin\java.exe
openjdk version "21.0.x" ...
```

Project Creation (Maven)
 
### 1. Create the Maven project in VSCode
 
Open the command palette with `Ctrl+Shift+P`, then:
 
1. Type **Maven: Create Maven Project**
2. Select **maven-archetype-quickstart**
3. Select version **1.4**
4. Fill in the following properties:
   - Group ID: `com.questmanager`
   - Artifact ID: `questmanager`
   - Version: `1.0-SNAPSHOT` *(press Enter to confirm default)*
   - Package: `com.questmanager` *(press Enter to confirm default)*
5. Choose your project folder as the destination
Maven will automatically download the required dependencies from Maven Central and generate the project structure.
