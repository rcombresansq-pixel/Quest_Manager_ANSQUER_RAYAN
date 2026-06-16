#  QuestManager
 
A gamified task manager desktop application built in Java.
Manage your tasks as RPG quests, earn XP, level up your character!
 
---
 
##  Tech Stack
 
| Technology | Usage |
|---|---|
| Java 21 (Eclipse Adoptium) | Main programming language |
| Swing | Desktop GUI framework |
| Gson | JSON serialization / deserialization |
| Maven | Build tool & dependency management |
| VSCode | IDE (with Extension Pack for Java) |
| Git + GitHub | Version control |
 
---
 
##  Architecture
 
This project follows the **MVC pattern** split into distinct Java packages:
 
```
src/main/java/com/questmanager/
├── model/          # Business logic and data (Player, Quest, Reward...)
├── view/           # Swing UI components (MainWindow, QuestPanel...)
├── controller/     # Coordination between model and view
├── repository/     # JSON data access (QuestRepository, PlayerRepository)
└── exception/      # Custom business exceptions
```
 
> **Rule:** The view layer never accesses the repository directly. All actions go through the controller. All data reads/writes go through the repository.
 
---
 
##  Git Branch Strategy
 
```
main          ← stable code only
└── develop   ← integration branch
    ├── feature/model       ← data model classes
    ├── feature/repository  ← JSON persistence
    ├── feature/controller  ← business logic
    └── feature/view        ← Swing interface
```
 
---
 
##  Installation & Environment Setup (Windows)
 
### 1. Install Java (Eclipse Adoptium JDK 21)
 
Download and install **Java 21 LTS** from [https://adoptium.net](https://adoptium.net).
 
After installation, verify the JDK folder location by running in PowerShell:
 
```powershell
dir "C:\Program Files\Eclipse Adoptium"
```
 
This should show a folder named `jdk-21.0.x.x-hotspot`.
 
---
 
### 2. Set the JAVA_HOME environment variable
 
If `where java` returns nothing in the terminal, `JAVA_HOME` is not set.
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
 
---
 
##  Project Creation (Maven)
 
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
 
### 2. Expected project structure
 
```
questmanager/
├── src/
│   └── main/
│       └── java/
│           └── com/questmanager/
│               └── App.java
├── pom.xml
└── README.md
```
 
---
 
##  Install Maven
 
### 1. Download Maven
Download **Binary zip archive** from [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi) and extract it.
 
### 2. Add Maven to PATH
Run in **PowerShell as Administrator**:
 
```powershell
[System.Environment]::SetEnvironmentVariable("Path", $env:Path + ";C:\path\to\apache-maven-3.9.x\bin", "Machine")
```
 
> ⚠️ Replace the path with your actual Maven folder location.
 
### 3. Verify Maven installation
Close and reopen the terminal, then run:
 
```powershell
mvn -version
```
 
Expected output:
```
Maven home: C:\...\apache-maven-3.9.x
Java version: 21.0.x, vendor: Eclipse Adoptium
```
 
### 4. Fix pom.xml Java version
Make sure your `pom.xml` uses Java 21:
 
```xml
<maven.compiler.source>21</maven.compiler.source>
<maven.compiler.target>21</maven.compiler.target>
```
 
### 5. Run Maven from terminal
Since `mvn` may not be recognized in VSCode terminal, use the full path:
 
```powershell
& "C:\path\to\apache-maven-3.9.x\bin\mvn.cmd" compile
```
 
---
 
## ⚙️ Prerequisites
 
- [Java 21 LTS](https://adoptium.net) (Eclipse Adoptium)
- [VSCode](https://code.visualstudio.com) with:
  - Extension Pack for Java
  - Maven for Java
- `JAVA_HOME` environment variable set to your JDK installation path
---
 
##  Getting Started
 
### 1. Clone the repository
```bash
git clone https://github.com/your-username/QuestManager.git
cd QuestManager
```
 
### 2. Build the project
```bash
mvn clean install
```
 
### 3. Run the application
```bash
mvn exec:java -Dexec.mainClass="com.questmanager.Main"
```
 
---
 
##  RPG Features
 
-  **Quests** — tasks with title, description, difficulty and XP reward
-  **Daily Quests** — recurring tasks that reset every day
-  **One-Time Quests** — unique tasks to accomplish once
- 🧙 **Player** — name, level, XP with automatic level-up logic
- 🎖️ **Rewards** — titles unlocked at each level milestone
- 📊 **Quest Status** — `TODO`, `IN_PROGRESS`, `DONE`
