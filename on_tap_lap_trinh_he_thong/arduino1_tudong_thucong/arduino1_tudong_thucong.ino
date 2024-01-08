#define BLYNK_TEMPLATE_ID "TMPL6Zr1U8qtL"
#define BLYNK_TEMPLATE_NAME "DEMO"
#define BLYNK_AUTH_TOKEN "CI7uAHjLwcF1ylMZJe1hQ5C7IacFpLnv"

#include <ESP8266WiFi.h>
#include <BlynkSimpleEsp8266.h>
#include <DHT.h>

char auth[] = "CI7uAHjLwcF1ylMZJe1hQ5C7IacFpLnv";

char ssid[] = "tenwifi";

char pass[] = "passwifi";

#define led D1
int button_tudong;
int button;
int sensorPin = A0;
int sensorValue;

void setup() {
  Serial.begin(115200);
  pinMode(led, OUTPUT);
  pinMode(sensorPin, INPUT);
}

BLYNK_WRITE(V0){
  button_tudong = param.asInt();
  if(button_tudong == 1){
    sensorValue = analogRead(sensorPin);
    Blynk.virtualWrite(V2, sensorValue);
    if (sensorValue > 500) {
      digitalWrite(led, LOW);
    } else {
      digitalWrite(led, HIGH);
    }
  }
}

BLYNK_WRITE(V1){
  button_tudong = param.asInt();
  if(button_tudong == 0){
    button = param.asInt();
    if(button==1){
      digitalWrite(led, HIGH);
    }else{
      digitalWrite(led, LOW);
    }
  }
}


void loop() {
  Blynk.run();
}



