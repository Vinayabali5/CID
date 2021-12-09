CID Template
============

The current way that the template application works is by hosting static HTML, CSS and JavaScript files from a Spring MVC Webserver. 

To configure the application you can provide an application.yml file (or application-{profile}.yml file to use with Spring profile). This yml file will contain the following parameters:

* apiUrl: the URL to use for the API requests
* reportUrl: the URL for the Microsoft SQL Reporting Services server
* studentImagesUrl: the URL for the location of student images
* debug: this is use to turn on or off the debug level of console logging

These settings also need to be present but current do nothing practical.
* profile: 
* location: 

The CID Template application can be run without specifying a profile as the majority of the configuration is done in the application.yml file. The current set of profiles available on the CID Template project are dev, and prod. 

## Development Profile (dev):

The development profile will load the web server onto port: 10201

## Production Profile (prod):

The production profile will load the web server onto port: 10209

