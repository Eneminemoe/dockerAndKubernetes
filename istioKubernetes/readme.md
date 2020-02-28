use ```minikube start``` to start local cluster
use ```minikube tunnel``` to provide external loadbalancer for istio
use ```minikube ssh``` to connect to cluster
use ```top```to see the clusters setting and resource usage
use```minikubel tunnel --cleanup```to force tunnel network clean up 
use ```istioctl manifest apply --set profile=demo``` to install demo profile
use ```sh showservicesAndPods.sh```to check the state of istio
use ```istioctl manifest generate --set profile=demo | kubectl delete -f -```to uninstall istio from the cluster. Make sure to remove all deployments. Or use ```sh cleanup.sh```instead