# Registration tool
  Regitration tool is Java project designed for add/change client registration data and personal data.
  This is one of my homework, while i`m taking Java cources at itvdn.com

## Application features
- [Add client registration data](#add-client-registration-data)
- [Change password](#change-password)
- [Change personal data](#change-personal-data)
- [Return personal data](#return-personal-data)
- [Logging](#logging)

## Additional info
-User class(#user-class)
-Input json(#input-json)

### Add client registration data
Project checks /Input folder in project folder. If client data that already in the database it return exception.
In another case if all data is valid(only favourite colour field is optional), it add client data to database by creating (if not already exist) a /UserDB/_login_.json file with personal information.
Client data consist of:
- Login (uses for checking if this client already in the database)
- Password (required field)
- E-mail
- Birthdata (like 2022-01-30) (required field)
- Secret question (required field)
- Answer for secret question (required field)
- Favourite colour (optional field)
  Fields login, secret question, answer for secret question and favourite colour is case insensitive.
  Passwords stores in the same Json file as char array and modified depending on login hashcode.

### Change password
To change password client should send login, password (as he remember it), personal data. In the case password and other data match at least 70%, perform changing data, in the other way return exception.
Matching calculate for each field, dependings on fields value. Fields value stores in the file ????

### Change personal data
For changing personal data, client should send login, password and personal data to change. If login and password is invalid returns exception.

### Return personal data
To achieve personal data, client should send login and password. If login and password is invalid returns exception.

### Logging
Any action (changing password, personal data, registration, sending data with incorrect password, sending invalid data) would be logged in the /logs/_LocalDate.now()_log.txt.
Log file creates for each day, and every log information appends to it.

### User class
User class have only private fields, the common structure is:
>public class User {
private String login;
private char[] password;
private char[] NewPassword;
private String email = null;
private LocalDate birthday;
private String secretQuestion;
private String secretAnswer;
private String favoriteColour;
}

### Input json
Input json consist of two parts, first is action what had to be done, and second json information about user
Common structure is:

>SENDDATA
{
"login": "login",
"password": [
"1",
"2",
"3",
"4"
],
"email": "mail",
"birthday": {
"year": 2022,
"month": 1,
"day": 29
},
"secretQuestion": "another question",
"secretAnswer": "answer",
"favoriteColour": "red"
}