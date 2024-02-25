# Minerva Europass (WIP)

Minerva Europass (alias IT Europass) allows, as you can understand, to generate your own Resume. Currently there is only one resume template.

## Configure and run the application
- copy the `application.yml` and create `application-dev.yml`
- set `spring.profiles.active=dev` as Environment Variable of your IDE
- edit the the `application-dev.yml` and set the `image-path` property to an existing path, like the Desktop path
- run the project as Spring Boot project
---
- open Postman ad import the collection file `Minerva Europass.postman_collection.json`
- edit the json by inserting your information
- after clicking on the `Send` button, the application will generate the PDF
- click on `View more actions` (3 dots) and save the response as PDF file