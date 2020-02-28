# file to clean up the non istio deplyoment
kubectl delete -f /Users/jens/springboottutorial/nonIstioKubernetes/deployment.yml 
echo "kubectl get all --all-namespaces"
kubectl get all --all-namespaces  