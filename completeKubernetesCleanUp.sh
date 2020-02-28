#script used to kill all runnnig pods and configs from kubernetes cluster
echo "Deleting all kubernetes pods and services etc."
sh nonIstioKubernetes/cleanup.sh
sh istioKubernetes/cleanup.sh