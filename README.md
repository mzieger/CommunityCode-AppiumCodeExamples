# **Appium open source - code examples**
Java-Appium project for native applications.

## **Notes**
* The tests are running on two applications: Eribank and UIcatalog. Therefore, make sure that you have these apps\
in your cloud.
* Between different application versions can be changes in xpaths. If one of the test is failing on xpath,\
you should change it to the correct one.


## **Android and iOS testing**
In this project we focus mostly on android tests. All the commands and capabilities can be used on ios platform\
by making the desired changes in the test. The ios tests examples in the project are:
* [quickstarttests/iosquickstarttest.java](src/test/java/quickStartTests/IOSQuickStartTest.java)
* [advancedcommands/setlocation/setlocationiostest.java](src/test/java/advancedCommands/setLocation/SetLocationIOSTest.java)
  
Use these examples or change them according to your needs.

## **Project structure**
###Package & Classes details:

#### 1. QuickstartTests: this package includes basic tests for android and ios.
        Some basic appium commands are present in this package like click(), findElement(), sendKeys() etc.


##### 2. OptionalCapabilities: in this package we are using optional capabilities that can be used to run appium test.
         Except the mandatory capabilities, we can set the following optional capabilities:
         
         - buildVersion: Install/launch the app by build version.
         - commandScreenshot: In video report - will take a screenshot before and after every action when commandScreenshot capability set to true.
         - doNotGoHomeOnQuit: The device will remain in the last left state even after ending the test when dontGoHomeOnQuit capability set to true.
         - installOnlyForUpdate: Re-installs app only if an older version already installed on the device.
         - releaseDevice: Gives the capability to not release a device after performing driver.quit().
         - releaseVersion: Install/launch the app by release version.
         - reportDisable: Use this capability in order to choose if a report would be generated or not.


##### 3. AdvancedCommands: in this package we are using special commands using the executeScript command.
         Each package include android test example:
         - adbPushAndPullFile: ADB push File to device command and ADB pull File from device command.
         - audioPlay: Start playing an audio file.
         - audioRecording: Start recording to a file, from the device.
         - installApp: Install the application with given name/unique name/build version/release version/both build and release version.
         - loggingDevice: startLoggingDevice and stopLoggingDevice commands are used to start and stop device log will be written to the path provided by the user.
         - performanceTransactionForApplication: Start performance transaction collects data on duration, cpu, battery, memory of the specified application on the device.
         - report: Adds a step to the generated report.
         - sendKeysWithBT: This command sends keyboard events to the Bluetooth keyboard on the device.
         - setAuthenticationReply: Simulates different authentication responses on applications that request a user fingerprint authentication.
         - setLocation: Set the current geo location.
         - setReportStatus: Overrides the final report status.
         - simulateCapture: The command allows users to test applications that use the camera on a mobile device.
                            The command injects an image file to the camera preview screen.
         - startStopStepsGroup: startStepsGroup begins a group marks (and stopStepsGroup ends it).
