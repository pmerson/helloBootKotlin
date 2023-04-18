


hello-ms - Hello World microservice 
-------------------------------------------------------

Hello World microservice to give a simple example of the use of:
 
* Kotlin
* Spring Boot
* Gradle
* Docker



#### Build
`gradlew clean build`

#### Create docker image
`docker build -t pmerson/hello-boot-kotlin:latest .`

#### Run with docker
`docker run -d -p 80:8080 -e "SPRING_PROFILES_ACTIVE=dev" pmerson/hello-boot-kotlin:latest`
    
#### Calling using curl
`curl --data "Paulo" --header "Content-Type: text/plain" --request POST http://localhost:80/api/greeting`

#### Stop the container
```
docker ps
docker stop <containerId>
```

#### Run with docker mounting a volume
`docker run -d -p 80:8080 -e "SPRING_PROFILES_ACTIVE=dev" --rm -v c:/TEMP:/data pmerson/hello-boot-kotlin:latest`

`docker run -d -p 80:8080 -e "SPRING_PROFILES_ACTIVE=dev" --rm -v c:/saturn/helloBootKotlin/data:/data pmerson/hello-boot-kotlin:latest`
    

#### Push to docker hub
`docker push pmerson/hello-boot-kotlin`

It's the same as:
`docker push docker.io/pmerson/hello-boot-kotlin:latest`

#### Pull from docker hub
`docker pull pmerson/hello-boot-kotlin:v2`

#### List stopped containers
`docker ps -a`

#### Kill stopped containers
`docker rm <containerId>`

#### Remove image
`docker image <rm imageId>`


# Deploy to K8S

#### Create EKS cluster and node group using the CF template

#### Open Cloudshell

#### Test what cluster is kubectl pointing to
`kubectl config get-contexts`

#### Make kubectl point to the EKS cluster
`aws eks update-kubeconfig --region us-east-1 --name book-store-eks-cluster`

#### Test if there's any pod running
`kubectl get pods`

`kubectl get pods -n hello-ms-ns`

#### If you see access denied errors...
`aws sts get-caller-identity --query Arn`

#### Create the namespace
`kubectl get namespaces`

`kubectl apply -f k8s/hello-ms-ns.yaml`

#### Create the K8S service 
`kubectl get services -n hello-ms-ns`

`kubectl apply -f k8s/hello-ms-svc-lb.yaml`

#### Create the K8S deployment, which defines the pod
`kubectl get pods -n hello-ms-ns`

`kubectl apply -f k8s/hello-ms-deploy.yaml`

#### To access the service
`kubectl get services`

EXTERNAL-IP might be "none".

`kubectl get services -o=wide`

If EXTERNAL-IP is still "none", copy cluster load balancer domain name from the console.  

#### Test if the service is reachable
```
curl --data "Paulo" --header "Content-Type: text/plain" --request POST http://a2a276c5dd5ba495eb466cedd1380f7d-821479061.us-east-1.elb.amazonaws.com/api/greeting
```

#### Force version update 
