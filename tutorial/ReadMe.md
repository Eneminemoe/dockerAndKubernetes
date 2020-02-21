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


## How to cluster
This describes how this sample application can run on a local kubernetes cluster on minikube.
Make sure that docker and minikube is installed on your machine.

Run minikube via ```minikube start```
Apply the deplyoment and services vie ```kubectl create -f deploymentV2.yml```
THe needed services and deployments are applied to the cluster

Check the services and ips to connect to the service
```kubectl get all```
```minikube ip```
Connect to the service in the browser via clusterip:port/welcome?name=YourName

You should see that the connection takes a long time to establish and ending in failure due to connectionTimeOut.
The reason is that the service you tried to reach tries to connect to aservice interanlly in the cluster but it isn't available yet.

To make it available apply the deplyoment script  ../calculator/deployment.yml
This starts the needed servce and deployment.

Refreshing the page should show you now a welcome message and a different random number each time the page is refreshed.

Congrats, you ran a simple apllcation on a cluster.

