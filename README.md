voms-info-provider
==================

Experimental information provider for VOMS. This is a proof of concept to see whether the current info provider can be replaced by our own, 
and that it is easy to do it in Java using Spring LDAP.

The project contains a main class which is meant to be executed periodically by a cron script, and updates voms service information in the underlying bdii (slapd).

A running bdii instance is needed, and configuration information must be filled directly into src/main/resources/applicationContext.xml.

The project is missing any launch infrastructure at the momento but can be used within eclipse.

##ÊTODO

- Add configuration
- Add bash script to launch the main class
- AdminService and CoreService logic that reads configuration, check the service status, etc
- Top level service publication
- Policy publication for each endpoint
- Tests for the ldap interaction 