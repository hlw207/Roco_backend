# 使用OpenJDK作为基础镜像
FROM openjdk

# 将构建好的JAR文件拷贝到容器中
COPY target/*.jar /app/app.jar

# 定义容器启动命令
CMD ["java", "-jar", "/app/app.jar"]
