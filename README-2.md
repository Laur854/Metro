
# Metro Project

This project is composed of two parts: Framework and Tests. The framework is a Selenium TestNG framework.





## Documentation



The project has the following components:

Gradle for dependency management.

TestNG for test execution.

Selenide for Selenium.

ReportPortal UI: 5.0 - Reporting Engine Service

ReportPortal Java Agent: 5.0.8 - Reporting Engine Agent for TestNG.

## Environment

Platform: macOS Monterey

IDE: IntelliJ IDEA 2019.3.1 (Community Edition)

Intellij configuration

Because the project uses the Lombok library, some configuration needs to be done to Intellij in order for the code to compile. This is only an issue for development since running the tests will work without installing Lombok.

Install the Lombok plugin

Enable annotation processing



Java: 1.8.0_211

Gradle: 6.7.1

Docker: 19.03.5
## Getting Started

Clone the repository.

Deploy ReportPortal With Docker

Install Docker, Docker Machine

Bash completion is a bash function that allows you to auto complete commands or arguments by typing partially commands or arguments, then pressing the [Tab] key. 
This will help you when writing the bash command in terminal.

$ brew install bash-completion

Docker for Mac is best installed with Homebrew and Homebrew Cask.
 For other ways to install on MacOS, see Install Docker for Mac in Docker's docs.

$ brew cask install docker

Download the Docker Machine binary and extract it to your PATH.

$ base=https://github.com/docker/machine/releases/download/v0.16.0 && curl -L $base/docker-machine-$(uname -s)-$(uname -m) >/usr/local/bin/docker-machine && chmod +x /usr/local/bin/docker-machine


Start Docker desktop community.

$ open /Applications/Docker.app

Deploy ReportPortal

By the following official instructions here, you can do that in shortly.

Navigate repository root.

$ cd selenide-testng-reportportal-example

Download the latest compose descriptor.

$ curl https://raw.githubusercontent.com/reportportal/reportportal/master/docker-compose.yml -o docker-compose.yml

Start the application using the following command.

$ docker-compose -p reportportal up -d --force-recreate

Setup ReportPortal UI

Get current IP on your mac machine (For ethernet in this case).

Ngoans-Mac:~ ngoanh2n$ ipconfig getifaddr en0
192.168.1.5

Open your browser with an IP address of the deployed environment at port 8080. In my case: http://192.168.1.5:8080/ui/#login







![Logo](https://github.com/ngoanh2n/selenide-testng-reportportal-example/raw/master/images/login.png?raw=true)

Use below accounts to access:

default/1q2w3e

superadmin/erebus

Now, I use account superadmin/erebus to create a project named selenide-testng-reportportal-example

Navigate to Projects Management in URL http://192.168.1.5:8080/ui/#administrate/projects

![Logo](https://github.com/ngoanh2n/selenide-testng-reportportal-example/raw/master/images/navigate-projects-management.png?raw=true)

Create a project:

![Logo](https://github.com/ngoanh2n/selenide-testng-reportportal-example/blob/master/images/create-project.png?raw=true)

Add a user as ngoanh2n to project selenide-testng-reportportal-example

![Logo](https://github.com/ngoanh2n/selenide-testng-reportportal-example/raw/master/images/add-user.png?raw=true)

Now I use account ngoanh2n to join project as role tester.

![Logo](https://github.com/ngoanh2n/selenide-testng-reportportal-example/raw/master/images/navigate-user-profile.png?raw=true)

Copy and replace personal properties into reportportal.properties in resources folder.

![Logo](https://github.com/ngoanh2n/selenide-testng-reportportal-example/raw/master/images/user-profile.png?raw=true)


## Running Tests



Running from Intellij:

Open the project.

Wait for indexing and dependencies installing to be done.

Go to Scenarios package -> Class Tests

## Screenshots

![App Screenshot](https://i.ibb.co/8YPV226/Project.png[/img][/url])

Run the test suite using the green start button:

![App Screenshot](https://i.ibb.co/ZGPvqB0/ss2.png[/img][/url])
