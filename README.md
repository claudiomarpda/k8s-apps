# Commands
```shell run
docker stop internal-app
docker rm internal-app
docker build .\internal-app\ -t internal-app:0.0.1
docker run -p 8081:8081 --name internal-app internal-app:0.0.1 
```

```shell useful
docker ps -a
docker images 
docker rm container_id
docker rmi image_id

```