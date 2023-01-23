# **Appium open source - code examples**
Java-appium project for native applications.

## **Notes**
* The tests are running on two applications: Eribank and UIcatalog. Therefore, make sure that you have these apps\
in your cloud.
* Between different application versions can be changes in xpaths. If one the test is failing on xpath,\
you should change it to the correct one.


## **Android and iOS testing**
In this project we focus mostly on android tests. All the commands and capabilities can be used on ios platform\
by making the desired changes in the test. The ios tests examples in the project are:
* [quickstarttests/iosquickstarttest.java](src/test/java/quickStartTests/IOSQuickStartTest.java)
* [advancedcommands/setlocation/setlocationiostest.java](src/test/java/advancedCommands/setLocation/SetLocationIOSTest.java)
  
Use these examples or change them according to your needs.

## **Project structure**
###Package & classes details:

#### 1. Quickstarttests: this package includes basic tests for android and ios.
        Some basic appium commands is present in this package like click(), findelement(), sendkeys() etc.


##### 2. Optionalcapabilities: in this package we are using optional capabilities that can be used to run appium test.
         Except the mandatory capabilities, we can set the following optional capabilities:
         
         - buildversion: install/launch the app by build version.
         - commandscreenshot: in video report - will take a screenshot also before and after every action when commandscreenshot capability set to true.
         - donotgohomeonquit: the device will remain in the last left state even after ending the test when dontgohomeonquit capability set to true.
         - installonlyforupdate: re-installs app only if an older version already installed on the device.
         - releasedevice: gives the capability to not release a device after performing driver.quit().
         - releaseversion: install/launch the app by release version.
         - reportdisable: use this capability in order to choose if a report would be generated or not.


##### 3. Advancedcommands: in this package we are using special commands using the executescript command.
         Each package include android test example:
         - adbpushandpullfile: 
         - audioplay: start playing an audio file.
         - audiorecording: start recording to a file, from the device.
         - installapp: install the application with given name/unique name/build version/release version/both build and release version.
         - loggingdevice: startloggingdevice and stoploggingdevice commands are used to start and stop device log will be written to the path provided by the user.
         - performancetransactionforapplication: start performance transaction collects data on duration, cpu, battery, memory of the specified application on the device.
         - report: adds a step to the generated report.
         - sendkeyswithbt: 
         - setauthenticationreply: simulates different authentication responses on applications that request a user fingerprint authentication.
         - setlocation: set the current geo location.
         - setreportstatus: overrides the final report status.
         - simulatecapture: the command allows users to test applications that use the camera on a mobile device.
                            the command injects an image file to the camera preview screen.
         - startstopstepsgroup: startstepsgroup begins a group marks (and stopstepsgroup ends it).
