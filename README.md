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
  * [Import/export functions:](#import-export-functions-)
- [Version control](#version-control)
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

# Configrations
To run the program, intellij，Mysql workbanch, Mysql installer are required.
1. Set the MySQL root password: 2000lqy.
2. Open the file called "itproject.sql", then connect it to the database in the Mysql workbanch.

Here's the location of database```/database```.

<p float="left">
  <img src="/databse/d.jpg" /
  <img src="/databse/e.jpg" />
</p>

3. Open the Mysql connection server in Mysql workbanch.
Here's the location of database```/database```.

<p float="left">
  <img src="/databse/f.jpg" /
</p>

4. Open the itproject.sql file
Here's the location of database```/database```.

<p float="left">
  <img src="/databse/g.jpg" /
</p>

5. Click the yellow flash
Here's the location of database```/database```.

<p float="left">
  <img src="/databse/h.jpg" /
</p>

6. Open intellij and click the pom.xml file then click reload project
Here's the location of database```/database```.

<p float="left">
  <img src="/databse/a.jpg" /
</p>

7. Make sure the JRE is version 1.8, then run the program
Here's the location of database```/database```.

<p float="left">
  <img src="/databse/b.jpg" /
  <img src="/databse/c.jpg" /
  <img src="/databse/i.jpg" /
</p>

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).

# FrontEnd

## Mockup

###### DashBoard

The dashboard has two parts: task and project, Each part has search , add , delete , modify function.
Here's the location of Dashboard Mockup ```/Mockup/Dashboard```.

<p float="left">
  <img src="/Mockup/Dashboard/Dashboard.png" />
  <img src="/Mockup/Dashboard/Project overview.png" />
</p>


###### Calendar
You can see all the calendar for the month, and clicking on a day will show you the task for that day, you can also add a task here.
Here's the location of Calendar Mockup```/Mockup/Calendar```.

<p float="left">
  <img src="/Mockup/Calendar/Calendar.png" />
  <img src="/Mockup/Calendar/Calendar - schedule details.png" />
</p>

###### Contact
A list of contacts is displayed here, along with details about each contact, you can import or export contacts in batches and send them email.
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
1. New, delete contacts in the page
2. Edit the information of a contact in the page
3. Search the contact by name or team name
4. Add mark status to the contacts

Moreover, in order to improve the efficiency and the users' experience
we decided to add a sorting function and using binary search, therefore
the following is the bonus functions and is not required by the clients.

5. Sorting the contact by name, phone, email or team name 

## Schedule functions:
1. New, delete schedule in the page
2. Edit the information of a schedule in the page
3. Show future schedules
4. Notify the related contacts

Moreover, in order to improve the efficiency and the users' experience
we decided to add a sorting function and using binary search, therefore
the following is the bonus functions and is not required by the clients.

5. Sorting a schedule by name or time
6. Search the contact by name

## Email sending functions:
The CRM could let an user send emails to contacts, or providing one or 
more valid emails

## Import/export functions:
The system support to create the information of contacts or schedules by 
reading a csv file. Or export the information to a csv file

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
Version 1.0 - Added class: emailSender, whcih provided the methods to send email
Version 1.0 - Added the relationship between class User and EmailSender, and tested
Version 1.0 - Allowed users to send more than one email at the same time
Version 1.0 - Fixed the bug of sending email form an user

# Contributing
The UI interface is written by Ling Huang and Jinjie Ding.  
Java codes are written by Yanming Guo.  
DataBase was built by Quanying Lyu.
Thanks for the testing and advice
by all people who contribute
<a href="https://github.com/Yanmingg/IT/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Yanmingg/IT" />
</a>
