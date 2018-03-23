#include <FirebaseArduino.h>
 #include <ESP8266WiFi.h>
char input[12];
int count=0;
const char* ssid     = "baal chero";
const char* password = "arko1234";
#define FIREBASE_HOST "node-mcu-b24f6.firebaseio.com"
#define FIREBASE_AUTH "NcWYwOPdHR2EUET7g2JlAoJRU0KNyCl3XgeRDI1b"


int wifiStatus;

void setup() {
  
  Serial.begin(9600);
 // delay(200);
  
   WiFi.begin(ssid, password);
      
      while (WiFi.status() != WL_CONNECTED) {
        delay(500);
        Serial.print(".");
      }
     Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
}

void loop() {

   
  
   if(Serial.available())
  {
    count=0;
    while(Serial.available()&& count<12)
    {
      input[count]=Serial.read();
      count++;
      delay(5);
    }
    Serial.println("Data Read :");
    for(int i=0;i<12;i++)
    Serial.print(input[i]); 
    Firebase.pushString("RFID",input);
    Serial.println();
  }
}
