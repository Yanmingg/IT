- [Personal-CRM](#personal-crm)
- [Installation](#installation)
  * [Project setup](#project-setup)
    + [Compiles and hot-reloads for development](#compiles-and-hot-reloads-for-development)
    + [Compiles and minifies for production](#compiles-and-minifies-for-production)
    + [Run your tests](#run-your-tests)
    + [Lints and fixes files](#lints-and-fixes-files)
    + [Customize configuration](#customize-configuration)
- [Configrations](#configrations)
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
- [Review checklist](#review-checklist)
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

6. Open IntelliJ and click the pom.xml file then click reload the project.   
Here's the location of database```/database```.

<p float="left">
  <img src="/database/a.jpg" />
</p>

7. Make sure the JRE is version 1.8, then run the program.  
Here's the location of database```/database```.

<p float="left">
  <img src="/database/b.jpg" />
  <img src="/database/c.jpg" />
  <img src="/database/i.jpg" />
</p>

8. To set the java.mail library to using email sending functions by clicking 
libraries in project structure.  
Here's the location of database```/database```.
<p float="left">
  <img src="/database/j.jpg" />
</p>

# FrontEnd

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

## Review Checklist
When reviewing a pull request, there are some key aspects that the reviewer should consider. These are encapsulated in the following review checklist:

1. Code formatting: check the code formatting for readability, ensure that proper naming conventions have been followed (e.g. camelCase), and that lines are not too long.  
2. DRY (Do not Repeat Yourself) principle: the same code should not be repeated multiple times
Commenting: the code should be properly commented for readers to easily understand what the code is doing.  
3. Testing: the code should pass all tests (unit tests, integration tests), and be easy to test (refactor into separation functions if required).  
4. Dependencies: new dependencies must be included in the pom.xml file.  
5. Sanity Checks: when reviewing make sure to see that sanity checks are present, for example, no one is simply getting the data back from the database in a variable and using it without validating it.  
6. Error Handling: there should be proper exception handling done to ensure that the code doesn’t crash. Exception handling is mandatory whenever trying to access database for CRUD operations. Also ensure that appropriate messages are sent to the frontend in case of an exception.  
7. Code Cleanup: if changes have been made to the flows and some piece of code has become redundant then it should be deleted. This will help ensure the quality of the codebase.  

# Contributing
The UI interface is written by Ling Huang and Jinjie Ding.  
Java codes are written by Yanming Guo.  
The database was built by Quanying Lyu.
Thanks for the testing and advice
by all people who contribute
<a href="https://github.com/Yanmingg/IT/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Yanmingg/IT" />
</a>
