echo "minikube start"
minikube start
echo "Starting kubernetes deployments.."
kubectl apply -f /Users/jens/springboottutorial/istioKubernetes/deplyoment.yml
echo "istioctl manifest apply --set profile=demo"
istioctl manifest apply --set profile=demo
echo "sh showServicesAndPods.sh"
sh /Users/jens/springboottutorial/istioKubernetes/showServicesAndPods.sh
echo "sh initIstio.sh"
sh /Users/jens/springboottutorial/istioKubernetes/initIstio.sh
echo "kubectl label namespace default istio-injection=enabled"
kubectl label namespace default istio-injection=enabled
echo "kubectl apply -f ingressconfig.yml"
kubectl apply -f /Users/jens/springboottutorial/istioKubernetes/ingressconfig.yml


echo "kubectl get pods --all-namespaces"
kubectl get pods --all-namespaces --show-labels
echo "kubectl -n istio-system port-forward $(kubectl -n istio-system get pod -l app=grafana -o jsonpath='{.items[0].metadata.name}') 3000:3000 &"
kubectl -n istio-system port-forward $(kubectl -n istio-system get pod -l app=grafana -o jsonpath='{.items[0].metadata.name}') 3000:3000 &
echo "open -a 'Google Chrome' http://localhost:3000/dashboard/db/istio-mesh-dashboard"
open -a 'Google Chrome' http://localhost:3000/dashboard/db/istio-mesh-dashboard
