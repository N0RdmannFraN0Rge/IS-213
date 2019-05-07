// Include the libraries
#include <SoftwareSerial.h>
#include "WiFiEsp.h"

// Declare and initialise global arrays for WiFi settings
char ssid[] = "Test";
char pass[] = "123456789";

// Set radio status 
int status = WL_IDLE_STATUS;

// Declare and initialise global variables/arrays for Thingspeak connection
const char server[] = "thingspeak.com";
const char thingspeakAPIKey[] = "XYEKN50D8GIVDUB9";

static const char* host = "api.thingspeak.com";
static const char* apiKey = "xxxxxxxxxxxxxxxxxxxxxxxxxx";
long postingInterval = 30000;

// Declare global variable for timing
long lastConnectionTime;

// Declare and initialise data variable
long myData = 0;

// Create client object
WiFiEspClient client;

// Connect WiFi module object on GPIO pin 6 (RX) and 7 (TX)
SoftwareSerial Serial1(6, 7);

void setup() {
  
  // Initialize serial for debugging
  Serial.begin(115200);
  
  // Initialize serial for ESP module
  Serial1.begin(9600);
  
  // Initialize ESP module
  WiFi.init(&Serial1);

  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
  pinMode(12, OUTPUT);
  
  // Attempt to connect to WiFi network
  while ( status != WL_CONNECTED) {
    Serial.print("Attempting to connect to SSID: ");
    Serial.println(ssid);
    
    // Connect to WPA/WPA2 network
    status = WiFi.begin(ssid, pass);
  }

  Serial.println("You're connected to the network");
  printWifiStatus();
}

void loop(){
  
  Serial.println("[Connectiong to");
  String line = "";
  Serial.print(host);
  if(client.connect(host,80)){
    
    Serial.println("[Sending a request]");
    
    String url = "/apps/thinghttp/send_request?api_key=XYEKN50D8GIVDUB9";
    
    client.print(String("GET /") + url + " HTTP/1.1\r\n" +
                  "Host: " + host + "\r\n" +
                  "Connection: close\r\n\r\n");
                  
    Serial.println("[Response;]");
    while(client.connected()){
      line = client.readStringUntil('\r');
    }
  }

  int i = 0;
  Serial.println(line);
  int sig = line.toInt();

  if(sig > 8 && sig <= 10){
    digitalWrite(10, HIGH);
    digitalWrite(11, LOW);
    digitalWrite(12, LOW);
  }else if(sig <= 8 && sig > 4){
    digitalWrite(10, LOW);
    digitalWrite(11, HIGH);
    digitalWrite(12, LOW);
  }else if(sig <= 4 && sig > 0){
    digitalWrite(10, LOW);
    digitalWrite(11, LOW);
    digitalWrite(12, HIGH);
  }else if( sig == 0){
    digitalWrite(10, LOW);
    digitalWrite(11, LOW);
    digitalWrite(12, LOW);
  }

  delay(1000);
}

void sendThingspeak(long value){
  if (client.connectSSL(server, 443)) {
    Serial.println("Connected to server");
    client.println("GET /update?api_key=" + String(thingspeakAPIKey) + 
    "&field1=" + String(value) + " HTTP/1.1");
    client.println("Host: api.thingspeak.com");
    client.println("Connection: close");
    client.println();
    Serial.println("Sent to server");
  }  
}

void printWifiStatus() {
  
  // Print the SSID of the network
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());

  // Print the IP address
  IPAddress ip = WiFi.localIP();
  Serial.print("IP Address: ");
  Serial.println(ip);
}
