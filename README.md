# OpenRT

OpenRT (Open Remote Trigger) is a system for remotely triggering various events. In our specific project we use this solution to open and close a door lock, but it can be used for a lot of other activities as well. In addition, we want to trigger the event by using facial recognition. The usage area for this system is mainly the home, but since it can be used for such a wide range of activities, it is not limited to this area.

Firmware used in this project:

* **Hardware:**
  * Arduino UNO starter kit
  * OpenMV M7 camera
  * ESP8266 WiFi module

* **Software:**
  * Arduino IDE
  * Android Studio
  * Google Firebase
  * GitHub

## Project idea

**The “problem”**
Using a pincode for doors are becoming more common nowadays. As we can see there are not many norwegian companies that can deliver a door lock system with facial recognition. As this is a nice feature we believe that there should also be some other way of opening the door such as an application in addition to a physical key. 
Coming home from work and the store with your hands full of groceries it would be nice to be able to open the door without having to use a key. 
If someone else is to enter your house while you are not at home it would be easier to just open the door for them with an application rather than giving them a key to your house. 

**The idea**
Our project idea is to use facial recognition to open a door lock. To do this we set up a camera with machine learning and use arduino attached to a servo motor to send the signal to open the lock. 
We also want to set up a webserver and create a phone application to be able to send Open/close signals to the arduino. 

As we are large group we want to work on both approaches with facial recognition and phone application at the same time.

## Contributing

This part of the document describes how to contribute to this project and what standards should be followed. Changes or suggestions should be uploaded to their respective branch and will be evaluated before being implemented.

### Summary

1. Write your contribution
1. Review the code to make sure you follow the standards (hyperlink).
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
 * 
