# Installation Instructions

This is a document that describes how to install the different programs for contributing and how to download the code to be able to run OpenFB.

## Prerequisites

This project requires that you have a website with a connected database. You can use any service for this, but we chose to use these:
* DigitalOcean - Website with Java classes and servlets
* MySQL - Database used to store data
* phpMyAdmin - Used to directly administrate/manipulate the database
All of these services are open source alternatives.

## Program Installation

To be able to contribute to this project, there are certain programs that has to be downloaded and installed on the computer beforehand. The mobile application is written in Android Studios version 3.3.2 and the code for the Arduino is written in Arduino IDE version 1.8.9. Below is the installation guide for each of these programs.

### Android Studios installation guide

1. Download [Android Studios](https://developer.android.com/studio).
1. Run the downloaded file and follow the installation wizard

### Arduino IDE installation guide

1. Download [Arduino IDE](https://www.arduino.cc/en/main/software).
1. Run the downloaded file and follow the installation wizard

## Deployment

Once all necessary programs are installed on the computer, the code can be either cloned or downloaded directly from our GitHub. Follow one of the two approaches below.

1. Clone the repository via GitBash. To do this, run the following code in GitBash:

```
git clone http://github.com/N0RdmannFraN0Rge/IS-213
```

2. Download a zip file directly from our GitHub repository and extract the downloaded files from the zip folder.

Now that all the code has been downloaded locally on the computer, simply open the files in their respective programs. Contribution to the project can now be made.

### Arduino setup

To set up the arduino and WiFi module, follow this table:

|Arduino UNO|ESP8266|
|:---------:|:-----:|
|RX|TX|
|TX|RX|
|GND|GND|
|3.3V|VCC|
|3.3V|CHPD|

* RX and TX is in the arduino code - set to 6 and 7 respectively.
* Output 10, 11 and 12 are connected to the different LEDs (remember to use 220 Ohm resistors between the LED's cathode and ground).

The setup should look something like this:

<img src="https://user-images.githubusercontent.com/35686045/57137669-d400ba80-6db0-11e9-8377-9df8f1f4c8f9.jpg" width="50%"></img>

### Android App

1. Run Android studio
2. Make an empty activity
3. Paste/replace in the code from MainActivity.Java, Androidmanifest.xml. Inside the Res folder, paste in the code from res/layout/activty_main.xml. If you want the logos we have created, include the entire res folder into your project.
