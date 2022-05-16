# ado_sca
# To launch the project: with docker
Step 1 :
docker-compose up

Step 2 : Access Backend url

Open your navigator or postman :
http://127.0.0.1:8080/welcome

Step 3: Access Frontend url

Open your navigator or postman :
http://127.0.0.1:8081/

To shutdown the project:

docker-compose down

# To launch the project: with kubernetes

To start launch minikube:

minikube start --driver=docker

- Execute configuration file for backend

Step 1 : access repository ado_backend and execute this command:

kubectl apply -f backend-configMap.yaml

kubectl apply -f backend-deployment.yaml

kubectl apply -f backend-service.yaml

- Execute configuration file for backend
Step 2 : access repository ado_frontend and execute this command:

kubectl apply -f frontend-configMap.yaml

kubectl apply -f frontend-deployment.yaml

kubectl apply -f frontend-service.yaml

To launch the project to localhost execute this command on powershell:

kubectl port-forward svc/adofrontend-service 8081:8081

Open your navigator and write : http://127.0.0.1:8081

