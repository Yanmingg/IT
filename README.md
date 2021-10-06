- [Personal-CRM](#personal-crm)
- [Installation](#installation)
  * [Project setup](#project-setup)
    + [Compiles and hot-reloads for development](#compiles-and-hot-reloads-for-development)
    + [Compiles and minifies for production](#compiles-and-minifies-for-production)
    + [Run your tests](#run-your-tests)
    + [Lints and fixes files](#lints-and-fixes-files)
    + [Customize configuration](#customize-configuration)
- [Configrations](#configrations)
- [FrontEnd](#frontend)
  * [Mockup](#mockup)
          + [DashBoard](#dashboard)
          + [Calendar](#calendar)
          + [Contact](#contact)
          + [Setting](#setting)
- [Backend](#backend)
- [Description of the project (BackEnd)](#description-of-the-project--backend-)
  * [Contact functions:](#contact-functions-)
  * [Schedule functions:](#schedule-functions-)
  * [Email sending functions:](#email-sending-functions-)
  * [Import/export functions:](#import-export-functions-)
- [Version control](#version-control)
- [Version control Policy](#version-control-policy)
- [Merging policy](#merging-policy)
  * [Plan](#plan)
  * [The parts that need to merge](#the-parts-that-need-to-merge)
  * [Problems](#problems)
  * [Problem-solving process](#problem-solving-process)
- [Contributing](#contributing)


# Personal-CRM
Comp30022 assignment

# Installation

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Run your tests
```
npm run test
```

### Lints and fixes files
```
npm run lint
```
### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).

# Configrations
To run the program, intellij，Mysql workbench, Mysql installer are required.
1. Set the MySQL root password: 2000lqy.
2. Open the file called "itproject.sql", then connect it to the database in the Mysql workbench.  

Here's the location of database```/database```.

<p float="left">
  <img src="/database/d.jpg" />
  <img src="/database/e.jpg" />
</p>

3. Open the Mysql connection server in the Mysql workbench.  
Here's the location of database```/database```.  

<p float="left">
  <img src="/database/f.jpg" />
</p>

4. Open the itproject.sql file  
Here's the location of database```/database```.  

<p float="left">
  <img src="/database/g.jpg" />
</p>

5. Click the yellow flash  
Here's the location of database```/database```.  

<p float="left">
  <img src="/database/h.jpg" />
</p>

6. Open IntelliJ and click the pom.xml file then click reload the project  
Here's the location of database```/database```.

<p float="left">
  <img src="/database/a.jpg" />
</p>

7. Make sure the JRE is version 1.8, then run the program  
Here's the location of database```/database```.

<p float="left">
  <img src="/database/b.jpg" />
  <img src="/database/c.jpg" />
  <img src="/database/i.jpg" />
</p>

# FrontEnd

## Mockup

###### DashBoard

The dashboard has two parts: task and project, Each part has search, add, delete, modify functions.
Here's the location of Dashboard Mockup ```/Mockup/Dashboard```.

<p float="left">
  <img src="/Mockup/Dashboard/Dashboard.png" />
  <img src="/Mockup/Dashboard/Project overview.png" />
</p>


###### Calendar
You can see all the calendars for the month, and clicking on a day will show you the task for that day, you can also add a task here.
Here's the location of Calendar Mockup```/Mockup/Calendar```.

<p float="left">
  <img src="/Mockup/Calendar/Calendar.png" />
  <img src="/Mockup/Calendar/Calendar - schedule details.png" />
</p>

###### Contact
A list of contacts is displayed here, along with details about each contact, you can import or export contacts in batches and send them an email.
Here's the location of Contact Mockup```/Mockup/Contact```.
<p float="left">
  <img src="/Mockup/Contact/Contact.png" />
  <img src="/Mockup/Contact/Contact-details-1.png" />
  <img src="/Mockup/Contact/Contact- BAR.png" />
</p>

###### Setting
You can modify your personal information, reminder time, font size, email, password...
Here's the location of Setting Mockup```/Mockup/Setting```.
<p float="left">
  <img src="/Mockup/Setting/Setting- Account.png" />
</p>


# Backend
This file is the code for the back-end which is written by Java, for dealing with
operation for the system by the requirements of the clients.

# Description of the project (BackEnd)
The project aims to build a CRM system that could deal with the relationship with
Contact or schedule, there are three main functions showing below.

## Contact functions:
1. New, delete contacts on the page
2. Edit the information of a contact on the page
3. Search the contact by name or team name
4. Add mark status to the contacts

Moreover, in order to improve the efficiency and the users' experience
we decided to add a sorting function and using binary search, therefore
the following is the bonus functions and is not required by the clients.

5. Sorting the contact by name, phone, email or team name 

## Schedule functions:
1. New, delete schedule on the page
2. Edit the information of a schedule on the page
3. Show future schedules
4. Notify the related contacts

Moreover, in order to improve the efficiency and the users' experience
we decided to add a sorting function and using binary search, therefore
the following is the bonus functions and is not required by the clients.

5. Sorting a schedule by name or time
6. Search the contact by name

## Email sending functions:
The CRM could let a user send emails to contacts, or providing one or 
more valid emails

## Import/export functions:
The system support creating the information of contacts or schedules by reading a csv file. Or export the information to a csv file

# Version control
Version 1.0 - Start constructing the structor followed by desgin diagram  
Version 1.0 - Added strategy pattern  
Version 1.0 - Improve the pettern design  
Version 1.0 - Added classes: Contact, Schedule  
Version 1.0 - Added classes: ContactPage, SchedulePage  
Version 1.0 - Added new, delete methods  
Version 1.0 - Added sorting and searching algorithm for the attribute name  
Version 1.0 - Redesign of the system, adding inheritance to follow GRASP principle  
Version 1.0 - Sign ContactPage and SchedulePage to inherit CRMObjectPage class  
Version 1.0 - Fixed the bug of searching algorithm  
Version 1.0 - Added import and export csv algorithm for the system  
Version 1.0 - Done with information edit functions  
Version 1.0 - Added comments to the system  
Version 1.0 - Redesign the sorting algorithm and improve the design of inheritance  
Version 1.0 - Added class: email sender, which provided the methods to send email  
Version 1.0 - Added the relationship between class User and EmailSender, and tested  
Version 1.0 - Allowed users to send more than one email at the same time    
Version 1.0 - Fixed the bug of sending email from a user  
Version 1.0 - Upload a springBoots structure
Version 1.0 - Rewrite the spring boots structure

# Version control Policy
1. Our team employs a version-control policy to ensure the accuracy and integrity of all
documentation.  
2. All out of date documentation is removed from the current folder and archived.  
3. The version control helps the team to understand each other's work well.  

# Merging policy
## Plan
JingJie Ding wrote contact and the overall code structure, Vuex framework and Store part.  
Ling Huang wrote dashboard and Axios part of contact and Dashboard.   
Quanying Lv writes the @Mapping which front-end interaction parts of the back end of SpringBoot.   
Yanming Guo writes about the implementation of specific functions on the back end

## The parts that need to merge
1. Merge Dashboard into a framework.  
2. All Axios parts merge into the store.  
3. merge the back-end functionality with the framework parts.  
4. Merge the front and back end.  

## Problems
1. The Scss failure to NPM install on JingJieDing 's laptop causes the dashboard's CSS to be lost. (resolved)  
 2. Cannot update the data in real-time after changing the database and need to refresh the page. (resolve)  
3. Logo cannot be shrunk as a sidebar.  
4. Dashboard's edit page has an all-black background.  
5. Axios cannot get data correctly, and POST cannot work properly. (resolved)  
6. The rear end cannot connect to the front end. (resolved)  

## Problem-solving process
A needs to merge the code with B, B needs to take A to look over THE whole code of B.
Then they discuss together where to add the code of A. If problems occur after the merge, 
discuss where problems are likely to arise and solve them together.

# Contributing
The UI interface is written by Ling Huang and Jinjie Ding.  
Java codes are written by Yanming Guo.  
The database was built by Quanying Lyu.
Thanks for the testing and advice
by all people who contribute
<a href="https://github.com/Yanmingg/IT/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Yanmingg/IT" />
</a>
