# Branch Github User Api Integration

A Kotlin SpringBoot application integrating with the GitHub User API.

## Endpoints
    GET /{userName}
Returns user and repository details in JSON format.

If user does not exist or there was an issue fetching the data a `HTTP 500 InternalServerError` will be returned

    

## Instructions for running locally
_Requirements: Git_

Clone this repository to a local directory with: 

`git clone https://github.com/brendan-robert-1/branch-github-api.git`

Navigate into the root of this project using `cd branch-github-api`

_Windows_ - `gradlew.bat bootRun`

_Linux/Mac_ - `./gradlew bootRun`

*You may need to change permissions to be able to run `gradlew` this can be done with: `chmod +x gradlew`

You can then access this application from the following host and default port `localhost:8080`
An example call from postman could look like:

`GET http://localhost:8080/octocat`

or using the command tool "CUrl":

`curl http://localhost:8080/octocat`

or just using any browser:

`http://localhost:8080/octocat`

_*Note that using a browser will also attempt to download assets like the favicon which will log some errors_.


## Instruction for building 
A linter was included in this application. Linting can be run with

`./gradlew ktLintFormat`

Once linted you can build with the following command:

`./gradlew clean build`

## Architecture and tooling decisions
I decided to implement this exercise using a Kotlin SpringBoot application. I chose Kotlin primarily
because I like it a little more than vanilla Java. I chose SpringBoot because it is the framework
I am most familiar with.

This application follows the typical Controller -> Service -> Client approach to responsibility separation.
I used the Kotlin Extensions language feature to handle the pojo mapping from the source (GitHub api) to the 
api model that I am exposing. I also used the `@JsonAlias` and `@JsonProperty` to handle json field name de/serialization.

I used spring `RestTemplate` to execute the call to the GitHub api. I also used JUnit for unit testing.

There was no specific ask for HTTP error code mappings for different scenario (NotFound vs InternalServerError). So I return all
as a `500`. I would ask for further clarity on this to see if you want to map a NotFound to a `404` or otherwise.
