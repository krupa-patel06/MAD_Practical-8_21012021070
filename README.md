# MAD_Practical-8_21012011072

Aim:
What is BroadcastReceiver? Difference between Service and BroadcastReceiver. Create an Alarm application by using service & BroadcastReceiver by following below instructions.

1. Create MainActivity according to below UI design.

2. Create AlarmBroadcastReceiver class

3. Create AlarmService Class

4. Add android.permission.SCHEDULE_EXACT_ALARM Permission in Manifest file

Ans:- 

Broadcast in android is the system-wide events that can occur when the device starts, when a message is received on the device or when incoming calls are received, or when a device goes to airplane mode, etc. Broadcast Receivers are used to respond to these system-wide events. Broadcast Receivers allow us to register for the system and application events, and when that event happens, then the register receivers get notified.

Apps can use services to do long-running processes in the background, such as downloading files from a server, or checking for email, or checking your location. Although services don't show up or interact with you directly, they still show up in the "Running apps" list. Broadcast receivers are the third kind of component. Like services, they only exist in the background and don't interact with you directly. But unlike services, they can't stay running or perform long tasks: they exist to respond to events. And unlike activities and services, more than one broadcast receiver can be started in one go.

# Output 

![image](https://github.com/Divy484/MAD_Practical-8_21012011072/assets/98522523/9ba54e8d-89bd-497b-913d-9185c4fd10f9)
![image](https://github.com/Divy484/MAD_Practical-8_21012011072/assets/98522523/faf48b46-5bb1-483e-9776-338726edb895)
![image](https://github.com/Divy484/MAD_Practical-8_21012011072/assets/98522523/4620be39-1d9b-483f-97d7-d54b08fc25bc)
