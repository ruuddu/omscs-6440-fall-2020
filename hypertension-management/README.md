### Steps to import project into local environment:
#### Clone repo by running the following command
- git clone https://github.gatech.edu/gt-cs6440-hit-fall2020/Hypertension-Management-App.git

#### Download IntelliJ (Community version)
- https://www.jetbrains.com/idea/download/

#### Import project
- Open IntelliJ and select *Import Project*
- Navigate to Hypertension-Management-App and hit *Open*
- Select Maven (it's default option) and hit *Next*
- Check the box *Import Maven projects automatically* and hit *Next*
- Hit one more *Next*
- If you already have Java SDK 1.8, select it and click Next, if not, download it here https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html (You might be asked to create an account for old version of SDK)
- Hit *Finish*

#### The project should be ready now

### Start the application
- Navigate to Hypertension-Management-App/src/main/java/gatech/scrubs26/hypertensionmanagement/
- Open HypertensionmanagementApplication file
- Hit play button (green button) at line 9 : public class....
- Open browser and hit http://localhost:8080, you should see the login page
