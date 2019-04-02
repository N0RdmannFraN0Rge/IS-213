# OpenRT

OpenRT (Open Remote Trigger) is a system for remotely triggering various events.
In our project we want the trigger to remote control different lights that are placed on a lecturers desc. All the students in the room can use their own phone and our application to indicate on what level they understand what the lecturer is teaching. The lights on the desc will then light up to show the lecturer if something needs to be repeated or if everything is clear. Due to the fact that many students are shy and afraid of speaking out loud when something is not clear, this gives them the opportunity to give feedback anonymously. 
The product of the project can also be used for other purposes like triggering a sound, a motor or other devices. 

The aim of this project is mainly to provide a tool for the lecturer to recieve feedback while teaching. 

Firmware used in this project:

* **Hardware:**
  * Arduino UNO starter kit
  * ESP8266 WiFi module

* **Software:**
  * Arduino IDE
  * Android Studio

## Contributing

This part of the document describes how to contribute to this project and what standards should be followed. Changes or suggestions should be uploaded to their respective branch and will be evaluated before being implemented.

### Summary

1. Write your contribution
1. Review the code to make sure you follow the [standards](#standards).
1. Send the code for evaluation by submitting a pull request from the correct branch to master.

### Roles

In this documentation we mention two different roles. To avoid confusion we describe these below:

1. *Contributor* - The individual who writes the changes to the code and submits them for evaluation.
1. *Reviewer* - The individual who checks and makes sure that changes are legit and follows the given standards.

### Branches

In this repository there are two different types of branches:

1. Master branch
1. Topic branches

There are four topic branches. When contributing, make sure you are working in the correct branch:

1. Branch for phone application code
1. Branch for Arduino code
1. Branch for OpenMV code
1. Branch for WiFi module code

### Standards

These are the standards that are expected to be followed when contributing to OpenRT. Reviewers are also expected to check that submitted code follows these standards.

#### Code Standards

* Follow basic programming principles. These includes:
 * Class, method, variable names should be descriptive
 * Class names should use camel case, first letter capitalized (e.g. ClassName)
 * Method and variable names should use camel case, first letter lower case (e.g. methodName)
 * Low degree of code duplication
 * High degree of cohesion
 * Low degree of coupling

**Code example**
[Insert snapshot of code here]

#### Testing standards

### Program Installation

To be able to contribute to this project, there are certain programs that has to be downloaded and installed on the computer beforehand. The mobile application is written in Android Studios version 3.3.2, the code for the Arduino is written in Arduino IDE version 1.8.9 and the code for the camera is written in OpenMV IDE version 2.1.0. Below is the installation guide for each of these programs.

#### Android Studios installation guide

1. Download the program from this website: https://developer.android.com/studio
1. Run the downloaded file and follow the installation wizard

#### Arduino IDE installation guide

1. Download the program from this website: https://www.arduino.cc/en/main/software
1. Run the downloaded file and follow the installation wizard

#### OpenMV IDE installation guide

1. Download the program from this website: https://openmv.io/pages/download
1. Run the downloaded file and follow the installation wizard

### Deployment

Once all necessary programs are installed on the computer, the code can be either cloned or downloaded directly from our GitHub. Follow one of the two approaches below.

1. Clone the repository via GitBash. To do this, run the following code in GitBash:

```
git clone http://github.com/N0RdmannFraN0Rge/IS-213
```

2. Download a zip file directly from our GitHub repository and extract the downloaded files from the zip folder.

Now that all the code has been downloaded locally on the computer, simply open the files in their respective programs. Contribution to the project can now be made.

