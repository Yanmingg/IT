- [Personal-CRM (Backend)](#personal-crm--backend-)
- [Description of the project](#description-of-the-project)
  * [Contact functions:](#contact-functions-)
  * [Schedule functions:](#schedule-functions-)
  * [Import/export functions:](#import-export-functions-)
- [Version control](#version-control)
- [Contributing](#contributing)

# Personal-CRM (Backend)
This file is the code for the back-end which is written by Java, for dealing with
operation for the system by the requirements of the clients.

# Description of the project
The project aims to build a CRM system that could deal with the relationship with
Contact or schedule, there are three main functions showing below.

## Contact functions:
1. New, delete contacts in the page
2. Edit the information of a contact in the page
3. Search the contact by name or team name
4. Add mark status to the contacts
5. Send email to a contact

Moreover, in order to improve the efficiency and the users' experience
we decided to add a sorting function and using binary search, therefore
the following is the bonus functions and is not required by the clients.

6. Sorting the contact by name, phone, email or team name 

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

# Contributing
This part of the project is written by Yanming Guo, thanks for the testing and advice
by all people who contribute
<a href="https://github.com/Yanmingg/IT/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Yanmingg/IT" />
</a>
