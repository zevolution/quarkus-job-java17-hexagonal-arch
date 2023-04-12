<p align="center">
<img src="https://user-images.githubusercontent.com/36534847/231480387-ad1c7cf9-c303-4b0e-9d57-bb666a1693ef.png" alt="FlixHexaArch-Logo" width="700">
<h1 align="center">Quarkus Job</h1>

## Table of contents
- [About the project](#about-the-project)
- [Description](#description)
- [Built with](#built-with)
- [Installation](#installation)
- [Requirements to run](#requirements-to-run)
- [Run](#run)
- [License](#license)

## About the project
This project was created as a simple example to show how we can create a quarkus job. This project use Hexagonal Architecture as described in [zevolution/netflix-hexagonal-architecture](https://github.com/zevolution/netflix-hexagonal-architecture)

## Description
This project has as a business rule to get all software from one or more authors in the main cloud DVCS such as Github, Gitlab and Bitbucket
<br>

## Built with
* [Java 17](https://openjdk.java.net/projects/jdk/17)
* [Maven](https://maven.apache.org/)
* [Quarkus 2.16.5.Final](https://quarkus.io/blog/quarkus-2-16-5-final-released/)
* [MapStruct](https://mapstruct.org/documentation/stable/reference/html/)
* [Panache](https://quarkus.io/guides/hibernate-orm-panache)
* [SmallRye Health](https://quarkus.io/guides/smallrye-health)

## Installation

To clone and run this application, you'll need Git installed on your computer(or no, if you want to download **.zip**). From your command line:
```bash
# Git CLI
git clone https://github.com/zevolution/quarkus-job-java17-hexagonal-arch.git

# Github CLI
gh repo clone zevolution/quarkus-job-java17-hexagonal-arch
```

## Requirements to run
* If you use Windows OS, is strongly recommended that you use WSL2 to perform all operations.
* [Docker Engine](https://www.docker.com/get-started)
* [Docker Compose](https://docs.docker.com/compose/install/)
* OpenJDK 17

## Run
1. After open project in your IDE, run `mvn clean package` to generate fat-jar
2. Run `docker-compose build && docker-compose up`

## License
[MIT](https://choosealicense.com/licenses/mit/)