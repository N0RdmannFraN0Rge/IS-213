# IS-213 - Open-source software

This is CDDJJT's repository for the course IS-213 - Open-source software at UiA. The purpose of this repository is to share our project and the following report. The project can be found in the directories outside of this README-file and the report can be found below.

# Report

This is the report following our open-source project. It consists of an introduction and working plan, the working process and a conclusion.

## Foreword

The purpose of this report is to describe and inform the reader of our work process and thoughts throughout this project. The task we were given was to plan and develop a project as open-source software.

We are a group of 6 students and call ourselves *CDDJJT*. The name is just the first letter in our names in alphabetical order. Five of us created this group during the first semester and we have stuck together since then. Jørgen joined the group during the third semester. Working with each other for such a long time have revealed the strengths and weaknesses of each member and taught us that we work best while combining our skills. Some of us are good at writing detailed reports while others are good at coding. Great teamwork has proven to produce fantastic results.

| Firstname | Lastname  |
| --------- | --------  |
| Christian | Kittilsen |
| Daniel  | Lindemann |
| Daniel  | Reisæter  |
| Jarle | Johnsen |
| Jørgen  | Lefdal  |
| Thomas  | Theissen  |

Firmware used in this project:

__*Hardware:__
  * Arduino UNO starter kit
  * OpenMV M7 camera
  * ESP8266 WiFi module

*__Software:__
  * Arduino IDE
  * Android Studio
  * Google Firebase
  * GitHub

## Introduction

The task ...

This report is a detailed account on how we worked to achieve the goals that we set for this project. The goals we had in the beginning were: 
* Learn more about OSS
* Learn more about Arduino
* Create a device using both Arduino and different open source software
* Create a working phone application

### Project idea

**The “problem”**
Using a pincode for doors are becoming more common nowadays. As we can see there are not many norwegian companies that can deliver a door lock system with facial recognition. As this is a nice feature we believe that there should also be some other way of opening the door such as an application in addition to a physical key. 
Coming home from work and the store with your hands full of groceries it would be nice to be able to open the door without having to use a key. 
If someone else is to enter your house while you are not at home it would be easier to just open the door for them with an application rather than giving them a key to your house. 

**The idea**
Our project idea is to use facial recognition to open a door lock. To do this we set up a camera with machine learning and use arduino attached to a servo motor to send the signal to open the lock. 
We also want to set up a webserver and create a phone application to be able to send Open/close signals to the arduino. 

As we are large group we want to work on both approaches with facial recognition and phone application at the same time. 
 
