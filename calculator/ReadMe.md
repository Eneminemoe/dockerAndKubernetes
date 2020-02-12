#Spring application

This is another springapplication with three REST endpoints(all via GET)
Endpoints are:
/add?addOne=0+addTwo=0
/sub?subOne=0+subTwo=0
/random

Random returns a random int value as string
See sourcecode for further information.

To containerize use:
```docker build -t calc:latest .```

Prepare docker networking by creating a new network:
```docker network crate --driver bridge isolated_nw```
Reason:  Docker does not support automatic service discovery on the default bridge network. If you want containers to be able to resolve IP addresses by container name, you should use user-defined networks instead.
Note: this happens in the sourcecode of springboottutorial.

To run use:
```docker run -d -p 8080 --name calc --network=isolated_nw```
Note: Other than stated in the ReadMe from the springboottutorial the springboottutorial container image needs to be run with the ```--network=isolated_nw``` in this step to work properly

Check the setup via
```docker ps```
to see if the containers are running

check the network via
```docker inspect isolated_nw```

Call localhost/welcome?name=Franz in your browser and check the result. You should see a string with a random number at the end.