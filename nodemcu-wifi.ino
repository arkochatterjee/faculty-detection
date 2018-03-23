 #include <ESP8266WiFi.h>

const char* ssid     = "baal chero";
const char* password = "arko1234";

int wifiStatus;

void setup() {
  
  Serial.begin(115200);
  delay(200);
  
   WiFi.begin(ssid, password);
      
      while (WiFi.status() != WL_CONNECTED) {
        delay(500);
        Serial.print(".");
      }
}

void loop() {
  
   wifiStatus = WiFi.status();

      if(wifiStatus == WL_CONNECTED){
         Serial.println("");
         Serial.println("Your ESP is connected!");  
         Serial.println("Your IP address is: ");
         Serial.println(WiFi.localIP());  
      }
      else{
        Serial.println("");
        Serial.println("WiFi not connected");
      }
      delay(1000); 


}
