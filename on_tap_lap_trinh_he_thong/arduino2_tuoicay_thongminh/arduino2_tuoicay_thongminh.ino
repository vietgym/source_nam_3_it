#define BLYNK_TEMPLATE_ID "TMPL6Zr1U8qtL"
#define BLYNK_TEMPLATE_NAME "demo"
#define BLYNK_AUTH_TOKEN "CI7uAHjLwcF1ylMZJe1hQ5C7IacFpLnv"

#include <ESP8266WiFi.h>
#include <BlynkSimpleEsp8266.h>
#include "DHT.h"

char auth[] = "CI7uAHjLwcF1ylMZJe1hQ5C7IacFpLnv";

char ssid[] = "tenwifi";

char pass[] = "pass";

#define maybom D1
#define DHTPIN D5
#define DHTTYPE DHT11

DHT dht(DHTPIN, DHTTYPE);

int button_tudong;
int button_maybom;
int nhietdo;
int doam;

void setup() {
  Serial.begin(9600);
  Blynk.begin(auth, ssid, pass);
  pinMode(maybom, OUTPUT);
}

BLYNK_WRITE(V0) {
  button_tudong = param.asInt();
  if(button_tudong == 1) {
    doam = dht.readHumidity();
    nhietdo = dht.readTemperature();
    Blynk.virtualWrite(V1, nhietdo);
    Blynk.virtualWrite(V2, doam);
    if(doam<30 || nhietdo>40) {
      digitalWrite(maybom, HIGH);
    } else {
      digitalWrite(maybom, LOW);
    }
  }
}

BLYNK_WRITE(V3) {
  button_tudong = param.asInt();
  if(button_tudong == 0) {
    button_maybom = param.asInt();
    if(button_maybom==1){
      digitalWrite(maybom, HIGH);
    }else{
      digitalWrite(maybom, LOW);
    }
  }
}

void loop() {
  Blynk.run();
}
