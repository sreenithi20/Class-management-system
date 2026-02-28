# Class-management-system
A Management System Implementation to perform standard operations for teacher and the student user's for a classroom. 

#### use case:class-management-system

## **actor**
- student,teacher
  
## description

<b> Implementation of Class Management System </b>

## preconditions
- student must be registered and must have valid user name and password
- teacher must be registered and must have valid user name and password

## postconditions
- student is rediredted to the menu after sign up
- teacher is rediredted to the menu after sign up

## **main flow**

### student
- student sign up the login page with valid credentials
- system grants access and show the menu
- student selects the choice from the menu and the corresponding operation is performed
- student exits

### teacher
- teacher sign up  the login page with valid credentials
- teacher grants access and show the menu
- teacher selects the choice from the menu and the corresponding operation is performed
- teacher exits
## **alternate main flow**
- if student sign up with invalid creditions the access is denied
- if teacher sign up with invalid creditions the access is denied
