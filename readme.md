# Inventory Management System
The objective of this project is to create an Inventory Management System. The data is stored in mySQL and using
Java the database can be created, updated, deleted and read. JDBC is applied to connected mySQL and Java.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
Programs required:
-MySQL using GCP
-Eclipse
-Java
-Git
-Maven
- Jenkins instance using GCP

### Installing
-create a folder
-open Git Bash in the folder
-Enter these in the Git Bash:
      -git init
      -git add remote origin https://github.com/ashima521/IMS.git
      -git pull origin master
-The project is then downloaded in your folder created
-Open Eclipse
-Import project into Eclipse (right click in package explorer -> import)
-Run the project using Runner class in source code folder

## Running the tests
To run the test:
-create instance of Ubuntu in GCP which allows http and https
-add jenkins and mysql tags in firewall
-open SSH of instance and install jenkins, maven, java(jdk)
-apply settings.xml in jenkins library repository
-restart jenkins and close instance
-click on the instance ip and add ':8080' at the end of url and remove 's' from https
-create jenkins user and then a project
-click on configure and select git on source code management
-specify branch as master
-add poll SCM: * * * * *
-enter 'mvn test', 'mvn deploy' and
 mvn sonar:sonar -Dsonar.host.url=http://35.189.123.196/sonarqube -Dsonar.login=your userid -Dsonar.password=your password
-save the configuration and click on build now
-Access your sonarqube which shows the test coverage.

### Unit Tests
-Each unit 'Tests' tests the methods in each class with Mockito framework.
-Run the tests as jUnit tests.

### And coding style tests
-coding style cab be checked using SonarQube

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning
We use [SemVer](http://semver.org/) for versioning.

## Authors
* **Ashima Ghale** -Initial work*- {AshimaGhale}(https://github.com/ashima521/IMS.git)

## License
This project is licensed under the MIT license 
 * Apache License, Version 2.0
 Copyright [2020] [name of copyright owner]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License

 * MIT license   
 MIT License

Copyright (c) [2020] [Christopher Perrins]

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

## Acknowledgments
* Christopher Perrins
* Taiwo Aina-badejo
* Laurence Garcia
* Haziq Mahmood
* My family
