# WritersBloq Back-end
## Description
This application is designed to provide amateur writers with a platform to write, publish and read stories. This is a description of the back-end implementation of the application.
## Technolgies Used
- Spring Boot
- Maven
- Hibernate
- Postgresql
- AWS
- RDS
- EC2
- GitHub
- Jenkins
## Backend Structure
Requests from the front-end are handled by a controller bean within the back-end. The method that is used to handle the request is determined by the request type (Post, Put, Get) and the url of the request. 

When the controller bean method is called, a method from a service bean is called. The service bean method handles the creation of auto-generated values. The service bean will finally call a method from a repository bean.

The repository bean method is responsible for interacting with the database using Hibernate.

    Story Controller                   Story Services          Story Repo         Database
        ____                               ______                ______          __------__
       |    |                             |      | -----------> |      | -----> |--______--|
       |    |             C               |______| <----------- |______| <----- |          |
       |    |             O                                                     |--______--|
       |    |             N            Comment Services        Comment Repo     |          |
       |____|             T                ______                ______         |--______--|
                          R               |      | -----------> |      | -----> |          |
                          O               |______| <----------- |______| <----- |--______--|
                          L  R                                                  |          |
    Chapter Controller    L  E                                                  |--______--|
        ____              E  F       Chapter Services          Chapter Repo     |          |
       |    |             R  E            ______                 ______         |--______--|
       |    |             S  R           |      | ------------> |      | -----> |          |
       |    |                E  S        |______| <------------ |______| <----- |--______--|
       |    |                N  E                                               |          |
       |____|                C  R     Content Services         Content Repo     |--______--|
                             E  V         ______                 ______         |          |
                             S  I        |      | ------------> |      | -----> |--______--|
    Auth Controller             C        |______| <------------ |______| <----- |          |
        ____                    E                                               |--______--|
       |    |                   S       Auth Services          Auth Repo        |          |
       |    |                             ______                 ______         |--______--|
       |    |                            |      | ------------> |      | -----> |          |
       |____|                            |______| <------------ |______| <----- \--______--/ 
                                                                                 
## Actions
The back end will use different CRUD operations depending on whether or not said user has an account registered on the application. Users who have an account are registered users. All other users are anonymous users.

---
### Anonymous Users
#### What is an Anonymous User
Anonymous users run the application while not logged into an account. All users start out as anonymous and change to a registered user when they signup or login to an account.
#### Applicable Actions
1. [Search for stories](#story-search)
2. [Select story](#select-story)
3. [Log into an account](#log-into-an-account)
4. [Register a new account](#register-a-new-account)

---
### Registered Users
#### What is a Registered User
Registered users run the application while logged into a registered account. Registered users become anonymous when they log out of their account.
#### Applicable Actions
1. [Search for stories](#story-search)
2. [Select story](#select-story)
3. [Comment on selected story](#comment-on-selected-story)
4. [Create new story](#create-new-story)
5. [Work on created story](#work-on-created-story)
6. [Update story status](#update-story-status)
7. [Log out of account](#log-out-of-account)

---
### Action Descriptions
#### Story Search
A get request handled by the Story Controller. Gets passed to the Story Services and then to the Story Repository. The Story Repository retrieves the information from the database.

Get stories from the database according to some parameters.
#### Select Story
A get request handled by the Story Controller. Gets passed to the Story Services and then to the Story Repository. The Story Repository retrieves the information from the database.

Select a story from the database.
#### Create New Story
A post request handled by the Story Controller. The request information gets passed to Story Services, where auto-generated information is created. The request information is then passed to the Story Repository. The Story Repository stores the story information to the database.

Creates a new story and adds it to the database.
#### Comment on Selected Story
A post request handled by the Story Controller. The request information gets passed to Comment Services and then to the Comment Repository. The Comment Repository stores the comment information to the database and specifies which story the comment applies to.

Adds a comment about a story to the database.
#### Update Story Status
A put request handled by the Story Controller. The request information gets passed to Story Services and then to the Story Repository. The Story Repository retrieves the current state of the story from the database, applies the changes to that story, and saves the edited story to the database in place of the original story.

Update or edit the title, summary, or publishing status of a story.
#### Work on Created Story
This encompasses creating/updating the chapter of a story and the creating/updating the contents of a chapter.
- Story Chapter
    - Creating a Chapter

        Creating a chapter is a post request handled by the Story Controller. The request information gets passed to Chapter Services, where the auto-generated values are set. The request information is then sent to the Chapter Repository which adds the chapter to the database as well as to the story the chapter belongs to.
    
    - Updating a Chapter
    
        Updating a chapter is a put request handled by the Chapter Controller. The request information gets passed to Chapter Services and then to the Chapter Repository. The Chapter Repository gets the current state of the chapter from the database, applies the changes to that chapter, and saves the edited chapter back into the database.
- Chapter Content
    - Creating New Chapter Content
    
        Adding more content to a chapter is a post request handled by the Chapter Controller. The request information gets passed to Content Services and then to the Content Repository. The Content Repository adds the new content to the database and adds the content to the appropriate chapter.
    
    - Updating Chapter Content
    
        Updating the content is a put request handled by the Chapter Controller. The request information gets passed to the Content Services and then to the Content Repository. The Content Repository gets the current state of the content from the database, applies the changes to that content, and saves the edited content back into the database.
    
#### Register a New Account
A post request handled by the Story Controller. The request information gets passed to Auth Services and then to the Auth Repository. The Auth Repository stores the account information into the database. The Auth Repository also creates a new token for the account to keep track of the newly logged in account.

Register a new account for the service and log the account in.
#### Log Into an Account
A post request handled by the Auth Controller. The request information gets passed to Auth Services and then to the Auth Repository. The Auth Repository retrieves the account information from the database based on the credentials in the request.

Log into a currently registered account.
#### Log out of Account
A delete request hendled by the Auth Controller. The request information gets passed to Auth Services and then to the Auth Repository. The Auth Repository removes from the database the token associated with a logged in account.

Log out a currently logged in user.
