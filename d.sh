#!/bin/bash
MODULE=$(basename $(dirname $(realpath $0)))
echo $MODULE

#UUID=$(uuidgen)
UUID=$(RANDOM)
UUID=latest
#ECR=192.168.31.22:32000
ECR2=docker.io/jojang91
IMG=${ECR2}/${MODULE}:${UUID}
echo Image Name:${IMG}
mvn clean package -DskipTests
echo Module Name:${MODULE}
docker build -t ${IMG} .
## #$(aws ecr get-login --no-include-email --region ap-northeast-2)
#docker login docker.io #-u jojang91 -p Jepari91!
docker login docker.io
echo Module Name:${MODULE}
docker push ${IMG}

kubectl delete deploy ${MODULE}
# kubectl set image deploy ${MODULE} ${MODULE}=${IMG}
docker rmi $(ku docker images -q)
#mvn clean
echo Module Name:${MODULE}



     cp deployment.yaml deployment_t.yaml
     cp service.yaml service_t.yaml

     sed -i -e "s/_PROJECT_NAME/${MODULE}/g" deployment_t.yaml service_t.yaml
#     sed -i -e "s/_REPO/${ECR2}/g" deployment_t.yaml service_t.yaml
#     sed -i -e "s/_VERSION/${UUID}/g" deployment_t.yaml service_t.yaml
     kubectl apply -f deployment_t.yaml
     kubectl apply -f service_t.yaml
     rm deployment_t.yaml
     rm service_t.yaml

#     kubectl delete hpa ${MODULE}
#     kubectl autoscale deployment ${MODULE} --cpu-percent=50 --min=1 --max=9