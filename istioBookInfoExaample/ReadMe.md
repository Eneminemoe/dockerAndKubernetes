This is a how to about istio
Refere to istio.io/docs/examples/ for further info.

Be sure that you have a basic understanding of containerization, i.e. docker and in docker orchestration, i.e. k8s
Try to understand the problems regarding microservices and a microservice architecture(MA) has.
Try to understand the need for service meshes when MA is used.

Visit istio.io for installation guides. This file referes to the BookInfoApplication.

Run Istio in your cluster:

Make sure that your istio installation uses automatic sidecar injection(asi). 

To use asi is needed to label the namspace
```kubectl label namespace YOURNAMESPACE istio-injection=enabled   //to try the sample use default as namespacename```

Run the application in your cluster via ```kubectl create -f samples/bookinfo/platform/kube/bookinfo.yaml```

Check your services and pods:
```kubectl get pods```
```Kubectl get services```

Check the functionality: ```kubectl exec -it $(kubectl get pod -l app=ratings -o jsonpath='{.items[0].metadata.name}') -c ratings -- curl productpage:9080/productpage | grep -o "<title>.*</title>"```
Output should be similiar to:
<title>Simple Bookstore App</title>

Check your gateway: ```kubectl get gateway```

To set up the gateway use ```export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}')```
and
```export SECURE_INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="https")].nodePort}')```
and
```export INGRESS_HOST=$(minikube ip)```
and
```export GATEWAY_URL=$INGRESS_HOST:$INGRESS_PORT```

check ```curl -s http://${GATEWAY_URL}/productpage | grep -o "<title>.*</title>"``` to see if the cluster is available from outside

make sure to apply destintation rules
```kubectl apply -f samples/bookinfo/networking/destination-rule-all.yaml```

