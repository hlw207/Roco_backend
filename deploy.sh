#! /bin/bash
name="roco_backend"

docker container stop ${name}
docker rm ${name}
docker rmi ${name}:latest

echo "卸载缓存成功"

docker build -t ${name} .
echo "镜像构建成功"

docker run -d -p 8081:8081 --name ${name} ${name}