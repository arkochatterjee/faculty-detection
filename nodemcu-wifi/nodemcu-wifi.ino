 #include <ESP8266WiFi.h>
char input[12];
int count=0;
const char* ssid     = "baal chero";
const char* password = "arko1234";

int wifiStatus;

void setup() {
  
  Serial.begin(9600);
 // delay(200);
  
   WiFi.begin(ssid, password);
      
    /*  while (WiFi.status() != WL_CONNECTED) {
        delay(500);
        Serial.print(".");
      }*/
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

    Serial.println();
  }
  

}
