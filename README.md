# k8s-apps

This is an educational hands-on.</br>
Kubernetes configuration for an application which connects to a database, both internally available. 
The application receives redirected requests from an Ingress Nginx. It also exposes metrics API to be scraped by Prometheus.

## Build and Deployment

internal-app environment variables
```shell
MONGODB_URL
MONGODB_USERNAME
MONGODB_PASSWORD
```

### Commands

build and run with docker
```shell
docker build .\internal-app\ -t internal-app:0.0.1
docker run -p 8081:8081 --name internal-app internal-app:0.0.1
docker ps -a
docker images 
docker rm container_id
docker rmi image_id
docker stop internal-app
docker rm internal-app
```

```shell - build docker image and deploy with k8s
docker build .\internal-app\ -t internal-app:0.0.1
kubectl apply -f .\kubernetes\internal-app\deployment.yaml
kubectl port-forward deployments/internal-app-deployment 8081
kubectl delete deployment internal-app 
kubectl config set-context --current --namespace=k8s-apps
kubectl apply -f .\kubernetes\ingress.yaml
```

kubectl get deploy
```shell
kubectl run -i --tty --rm debug --image=busybox --restart=Never -- sh -n k8s-apps
wget -qO- http://localhost:8081/hello
kubectl describe service internal-app   
kubectl get pods --show-labels
kubectl get service -o yaml
kubectl exec --stdin --tty podname -- /bin/bash
kubectl exec --stdin --tty internal-app-deployment-f4c8cdb45-qlvq2 -- /bin/bash
kubectl exec -it internal-app-deployment-f4c8cdb45-qlvq2 -- ls /bin/bash
kubectl exec -it internal-app-deployment-f4c8cdb45-qlvq2 -- echo "Hello, World!"
```

kubectl delete
```shell
# delete by resource
kubectl delete --all rs
kubectl delete --all deploy
kubectl delete --all svc
kubectl delete --all prometheus
kubectl delete --all ingress
kubectl delete --all configmap
kubectl delete --all secret
kubectl delete all --all -n k8s-apps
# delete by file
kubectl delete -f .\kubernetes\namespace.yaml
kubectl delete -f .\kubernetes\ingress.yaml
kubectl delete -f .\kubernetes\internal-app
kubectl delete -f .\kubernetes\internal-db
kubectl delete -f .\kubernetes\prometheus
```

kubectl deploy
```shell
kubectl apply -f .\kubernetes\namespace.yaml
kubectl apply -f .\kubernetes\internal-app\deployment.yaml
kubectl apply -f .\kubernetes\internal-app\configmap.yaml
kubectl apply -f .\kubernetes\internal-app\service.yaml
kubectl port-forward deployments/internal-app-deployment 8081
kubectl expose deployment internal-app-deployment --type=ClusterIP --name=terminal-service
kubectl get all --all-namespaces
kubectl get all -n k8s-apps
kubectl apply -f .\kubernetes\namespace.yaml
kubectl apply -f .\kubernetes\ingress.yaml
kubectl apply -f .\kubernetes\internal-app
kubectl apply -f .\kubernetes\internal-db
kubectl apply -f .\kubernetes\prometheus
```

configure nginx ingress controller
```shell
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.9.6/deploy/static/provider/cloud/deploy.yaml
kubectl apply -f .\kubernetes\ingress.yaml
kubectl get ingress
```

configure prometheus
```shell
kubectl apply -f https://raw.githubusercontent.com/prometheus-operator/prometheus-operator/master/bundle.yaml
kubectl apply -f kubernetes/prometheus/rbac.yaml
kubectl apply -f .\kubernetes\prometheus\prometheus.yaml
kubectl apply -f .\kubernetes\prometheus\cluster.yaml
kubectl get crds
kubectl apply -f kubernetes/internal-app/service-monitor.yaml
```
