# **Appium Open Source - Code Examples**
This project demonstrates how to use Java Appium for native applications.

## **Notes**
* The tests run on two applications: Eribank and UIcatalog. Therefore, make sure that you have these apps\
in your cloud.
* Different versions of different applications can have differences in the xpath.  If one test fails on xpath,\
 change it to the correct one.


## **Android and iOS Testing**
Most commands and capabilities have two implementations: one for Android and the other for IOS.


## **Project structure**
### Package & Classes details:

- QuickstartTests: This package includes basic tests for android and ios. Some basic appium commands are present in this package such as click(), findElement(), ND sendKeys().


- OptionalCapabilities: This package uses optional capabilities that can be used to run the Appium test.
         Except the mandatory capabilities, we can set the following optional capabilities:
         
    - buildVersion: Install/launch the app by build version.
    - commandScreenshot: In video report, take a screenshot before and after every action when commandScreenshot is set to true.
    - doNotGoHomeOnQuit: Device remains in the last state even after ending the test when dontGoHomeOnQuit is set to true.
    - installOnlyForUpdate: Install the app only if an older version is already installed on the device.
    - releaseDevice: Gives the capability to not release a device after performing driver.quit().
    - releaseVersion: Install/launch the app by release version.
    - reportDisable: Do not generate a report.


- AdvancedCommands: These are special commands using the executeScript command.  Each package includes the Android test example:
  - adbPushFile: Perform the ADB push file to device command.
  - adbPullFile: Perform the ADB pull file from device command.
  - audioPlay: Play an audio file.
  - audioRecording: Record to a file, from the device.
  - installApp: Install the application with given name/unique name/build version/release version/both build and release version.
  - loggingDevice: startLoggingDevice and stopLoggingDevice commands are used to start and stop device log will be written to the path provided by the user.
  - performanceTransactionForApplication: Start performance transaction collects data on duration, cpu, battery, memory of the specified application on the device.
  - report: Adds a step to the generated report.
  - sendKeysWithBT: This command sends keyboard events to the Bluetooth keyboard on the device.
  - setAuthenticationReply: Simulate different authentication responses on applications that request a user fingerprint authentication.
  - setLocation: Set the current geo location.
  - setReportStatus: Override the final report status.
  - simulateCapture: Simulate use of the camera by injecting an image file to the camera preview screen.
  - startStepsGroup: Start a group mark.
  - stopStepsGroup: End a group mark.


## Documentation
To find out more about CT usage, features and best practices, see [Test Execution Home](https://docs.experitest.com/display/TE/Test+Execution+Home)

## Support
If you encounter an issue that is not covered here or in our online documentation, contact us at [support@digital.ai](mailto:support@digital.ai).