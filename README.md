# Quest_Manager_ANSQUER_RAYAN

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
