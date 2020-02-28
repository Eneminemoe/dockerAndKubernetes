color='\x1B[92m'
endcolor='\x1B[0m'
echo "${color}kubectl config view${endcolor}"
kubectl config view
echo "${color}kubectl get all -o wide --all-namespaces${endcolor}"
kubectl get all -o wide --all-namespaces
echo "${color}kubectl get virtualservices -o yaml --all-namespaces${endcolor}"
kubectl get virtualservices -o yaml --all-namespaces
echo "${color}kubectl get gateways -o yaml --all-namespaces${endcolor}"
kubectl get gateways -o yaml --all-namespaces
echo "${color}kubectl get destinationrules -o yaml --all-namespaces${endcolor}"
kubectl get destinationrules -o yaml --all-namespaces
echo "${color}kubectl get policies -o yaml --all-namespaces${endcolor}"
kubectl get policies -o yaml --all-namespaces
