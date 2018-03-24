# Mozilla Hackathon 2018 | FacDe - Faculty Detection

[Intro Video](https://www.youtube.com/watch?v=5WDgg-8Gy-U)<br>
 
Life of an Engineer is no less than a continuous war for 4 years, stuck with all the assignments, project work and also the record corrections. But most of the things are being done on the last day or the day before the submission day, now what if the faculty is not in the department when you went there and what if she’s taking class and just came after you left. What if you can get the information whether the teacher is available in the department or not just by a web application. A combination of few technology can now make this happens. A sensor which can detect the RFID if the teachers ID card while they enter the department and sends information to the server and notify as they leave.


### Approach
* The hack is divided into two major portions :
  1. Hardware : RFID Card Reader reads the RFID Tag of the Card and pushes the data to Realtime Firebase Database through NodeMCU which is connected to a WiFi Network.
  2. Software : Data from the Firebase Database is compared with it's last entry and corresponding output event is triggered, i.e whether the faculty is available or unavailable in an Android Application.
  
