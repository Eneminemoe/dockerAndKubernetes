#Springboot application

Here is an easy springboot application that returns an string via a webrequest

To containerize the application use:
´´´docker build -t sprt:latest .´´´

To start a container use:
´´´docker run -d -p 80:8080 --name sprt sprt:latest´´´

This starts an image. Type localhost/welcome?name=testname in your webbrowse to see if the application is running.

##additional Notes:

use to remove stopped container:
```docker rm $(docker ps -a -q)```

use to get shell in container:
```docker exec -it sprt /bin/bash```