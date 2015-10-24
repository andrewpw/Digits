![screenshot](https://raw.githubusercontent.com/andrewpw/Digits/master/public/images/Digits%20screenshot.png)

Overview
--------

A [Play Application](http://playframework.com) that allows a user to store phone contacts.  This was a class project to practice making a mobile friendly, web application with basic form and database functionality. It also utilizes basic security functionality by leaving an option to mask the admin email and password as system environment variables.  This option can be found in the application.conf file.


Installation
------------

 - Download the zip file, unzip and cd into the file. Invoke the play command and execute the "activator run" command to see the application at http://localhost9000 (note: although you can simply call run, it usually works best to type "activator" first, then ";clean;compile;run"). 

 - Play seems to have difficulties loading resources (I.E. the header photo).  Sometimes it shows the first time, but sometimes you must go to the source code and change the header div and save.  Even adding whitespace seems to make the picture load correctly most times.

Usage
-----

Create an account or use the default credentials - E-mail: admin, Password: password
Use the navbar to navigate to an inner page an add a contact

Credits
-------

Thank you ICS 314, fall 2013 for support
  


