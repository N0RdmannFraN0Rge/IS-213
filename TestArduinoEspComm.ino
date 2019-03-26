void setup() {
  // put your setup code here, to run once:
  pinMode(6, INPUT);
  pinMode(10, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  if(digitalRead(6) == HIGH){
    digitalWrite(10, HIGH);
  }
  if(digitalRead(6) == LOW){
    digitalWrite(10, LOW);
  }

}
