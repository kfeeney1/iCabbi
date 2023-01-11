# apiAutomation

To run tests, run TestRunner

Tests included
    apiGet
        check for http status code = 200
        check for user ‘id’ key value in the json response = 2
    apiPost
        Add two users with Post
        check for http status code = 201
        check for correct values of “name” and “job” appear in the json response

Technologies used   
    Java
    REST-Assured
    cucumber