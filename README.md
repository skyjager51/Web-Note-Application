
# 📝 Web Note Application: Local Setup Guide

This guide will walk you through setting up and running the Web Note Application locally on your machine. This project requires **Java 17 (JDK 17)** and **Maven**.

## Step 1. Get the Application Code

You have two options to download the source code:

### Option A: Download ZIP (Easiest)

1.  Go to the project's GitHub page (replace with your actual link if different):
    `https://github.com/skyjager51/Web-Note-Application`
2.  Click the **green `Code` button** --> **`Download ZIP`**.
3.  **Extract** the ZIP file to your desired location (e.g., your desktop). This will create a project folder named `Web-Note-Application`.

### Option B: Clone with Git (Advanced)

If you have Git installed, open your terminal and run the following command:

```bash
git clone https://github.com/skyjager51/Web-Note-Application.git
```

-----

## Step 2. Install Java 17 (JDK 17)

This project was developed using **JDK 17** and requires it to run correctly.

### On Windows (using Chocolatey)

1.  Open **PowerShell as Administrator**.
2.  **Install Chocolatey** (Skip if you already have it):
    ```powershell
    Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
    ```
3.  **Install JDK 17:**
    ```powershell
    choco install temurin17 -y
    ```

### On macOS (using Homebrew)

1.  Open the **Terminal**.
2.  **Install Homebrew** (Skip if you already have it):
    ```bash
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    ```
3.  **Install Java 17:**
    ```bash
    brew install temurin@17
    ```

### On Linux (Mint/Debian-based)

1.  Update your package list:
    ```bash
    sudo apt update
    ```
2.  Install Java 17:
    ```bash
    sudo apt install openjdk-17-jdk -y
    ```
    *(Optional: If you have issues with Java versions, you can switch using: `sudo update-alternatives --config java`)*

### Verify Installation

Run the following command to ensure Java 17 is installed correctly:

```bash
java -version
```

It should output a version string starting with `openjdk version "17..."`.

-----

## Step 3. Install Maven

Maven is required to build and run the Spring Boot project.

### On Windows (using Chocolatey)

```powershell
choco install maven -y
```

### On macOS (using Homebrew)

```bash
brew install maven
```

### On Linux (Mint/Debian-based)

```bash
sudo apt install maven -y
```

-----

## Step 4. Setup Visual Studio Code (VS Code)

### Install VS Code

1.  Go to: `https://code.visualstudio.com/` and download the installer for your operating system.
2.  Follow the installation steps.

### Install Required Extensions

Open VS Code and install the following extensions from the Extensions tab (`Ctrl+Shift+X` or `Cmd+Shift+X`):

1.  **Java Extension Pack**
2.  **Spring Boot Extension Pack**

-----

## Step 5. Open and Run the Project

### Open the Project

You can open the project folder in two ways:

  * **From VS Code:** Click `File` --> `Open Folder` and select the `Web-Note-Application` directory.
  * **From Terminal:** Navigate to the project folder and run:
    ```bash
    cd Web-Note-Application
    code .
    ```
  * *(If a notification pops up in the bottom-right asking to configure Java or Maven, click **Yes** or **Allow**.)*

### Run the Application

You have a few ways to start the server:

1.  **Easiest Way (VS Code Button):**
    Click the **Run/Debug (triangle)** icon in the top-right corner of the VS Code window. This will open a new terminal showing the server logs.

2.  **Using VS Code Command Palette:**
    Press `Ctrl + Shift + P` (or `Cmd + Shift + P` on macOS) and type: **`Spring Boot: Run`**

3.  **Using Terminal (Recommended):**
    Ensure you are inside the `Web-Note-Application` folder in your terminal and run:

    ```bash
    ./mvnw spring-boot:run
    ```

    *(If the command above fails, try: `mvn spring-boot:run`)*

-----

## Step 6. Access Your Web Note Application

Once the terminal shows the message "Started Application..." (or similar), the application is running and accessible on your machine.

1.  Open any web browser (Chrome, Firefox, etc.).
2.  In the address bar, type: http://localhost:8080

You are all set\! You should now see the interface for your Web Note Application. Feel free to start creating notes\!