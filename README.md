# Commands

```shell run
docker stop internal-app
docker rm internal-app
docker build .\internal-app\ -t internal-app:0.0.1
docker run -p 8081:8081 --name internal-app internal-app:0.0.1
kubectl delete deployment internal-app 
kubectl apply -f .\kubernetes\internal-app\deployment.yaml
kubectl port-forward deployments/internal-app-deployment 8081
```

```shell useful
docker ps -a
docker images 
docker rm container_id
docker rmi image_id
kubectl get deploy
kubectl run -i --tty --rm debug --image=busybox --restart=Never -- sh -n k8s-apps
wget http://localhost:8081/hello
kubectl describe service internal-app   
kubectl get pods --show-labels
kubectl get service -o yaml
```

```shell kubectl delete
kubectl delete --all rs
kubectl delete --all deploy
kubectl delete --all services
kubectl delete --all prometheus
```

```shell kubectl deploy
kubectl apply -f .\kubernetes\namespace.yaml
kubectl apply -f .\kubernetes\internal-app\deployment.yaml
kubectl apply -f .\kubernetes\internal-app\service.yaml
#kubectl port-forward deployments/internal-app-deployment 8081
#kubectl expose deployment internal-app-deployment --type=ClusterIP --name=terminal-service
```

```shell prometheus
kubectl apply -f https://raw.githubusercontent.com/prometheus-operator/prometheus-operator/master/bundle.yaml
kubectl apply -f kubernetes/prometheus/rbac.yaml
kubectl apply -f .\kubernetes\prometheus\prometheus.yaml
kubectl apply -f .\kubernetes\prometheus\cluster.yaml
kubectl get crds
kubectl apply -f kubernetes/internal-app/service-monitor.yaml
```