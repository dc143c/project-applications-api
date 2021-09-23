# Project Applications API
REST API for Digital Innovation One - Java Developer Bootcamp Project

Technologies: Java, JPA, Map Structure, H2, Spring, JAVAX Validation, Lombok.
# How to use this API?
For this API we have the four essential URL Methods (GET, PUT, DELETE and POST)
All requests should be done to ```https://project-application-api.herokuapp.com/api/v1/project/```

By GET request on ```https://project-application-api.herokuapp.com/api/v1/project/status``` you get the API status, where if not error, then it's online and usable.
By GET request on ```https://project-application-api.herokuapp.com/api/v1/project/``` you receive a full list of projects on our H2 database.
By GET request on ```https://project-application-api.herokuapp.com/api/v1/project/{id}``` you receive a project on our H2 database where the ID is the URL parameter.
By POST request on ```https://project-application-api.herokuapp.com/api/v1/project/``` you create a new project with a full list of applications open for developers.
By PUT request on ```https://project-application-api.herokuapp.com/api/v1/project/{id}``` you update a project and it's full list of applications.
By DELETE request on ```https://project-application-api.herokuapp.com/api/v1/project/{id}``` you delete a project and it's full list of applications.

The applications are set up with few informations, where links are always unique, types are required and divided as four types: ENTERPRISE, FULLTIME, PARTTIME, VOLUNTEER - and status, that are also divided as two types: OPEN and CLOSED.
Application example:
```	{
		"name": "FullStack Developer",
		"type": "FULLTIME",
		"applicationURL": "linkedin.com/test/application_link"
  }
```
As projects can have many applications, the Project Object have as requirements:
Name, Owner and gitURL.
Project example: 
```
{
	"name": "Fake Project",
	"owner": "Jhony Terra",
	"gitURL":  "https://github.com/dc143c/fake_project",
	"applicationList": [
		{
		"name": "FullStack Developer",
		"type": "FULLTIME",
		"applicationURL": "linkedin.com/test/application_link"
		},
		{
		"name": "FullStack Developer",
		"type": "PARTTIME",
		"applicationURL": "linkedin.com/test/application_link2"
		},
		{
		"name": "FullStack Developer",
		"type": "ENTERPRISE",
		"applicationURL": "linkedin.com/test/application_link3"
		}
	]
}
```
