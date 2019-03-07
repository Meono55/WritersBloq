# WritersBloq Back-end
## Description
This application is designed to provide amateur writers with a platform to write, publish and read stories. This is a description of the back-end implementation of the application.
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
1. **[Search for stories](#story-search)**
2. **[Select story](#select-story)**
3. **[Log into an account](#log-into-an-account)**
4. **[Register a new account](#register-a-new-account)**

---
### Registered Users
#### What is a Registered User
Registered users run the application while logged into a registered account. Registered users become anonymous when they log out of their account.
#### Applicable Actions
1. **[Search for stories](#story-search)**
2. **[Select story](#select-story)**
3. **[Comment on selected story](#comment-on-selected-story)**
4. **[Create new story](#create-new-story)**
5. **[Work on created story](#work-on-created-story)**
6. **[Update story status](#update-story-status)**
7. **[Log out of account](#log-out-of-account)**

---
### Action Descriptions
#### Story Search
#### Select Story
#### Comment on Selected Story
#### Create New Story
#### Update Story Status
#### Work on Created Story
#### Register a New Account
#### Log Into an Account
#### Log out of Account
