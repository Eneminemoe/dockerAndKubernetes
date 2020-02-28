echo "kubectl delete -f ingressconfig.yml"
kubectl delete -f /Users/jens/springboottutorial/istioKubernetes/ingressconfig.yml
echo "Uninstalling istio with: istioctl manifest generate --set profile=demo | kubectl delete -f -"
istioctl manifest generate --set profile=demo | kubectl delete -f -
echo "kubectl delete -f deplyoment.yml"
kubectl delete -f /Users/jens/springboottutorial/istioKubernetes/deplyoment.yml
echo "kubectl get all --all-namespaces"
kubectl get all --all-namespaces