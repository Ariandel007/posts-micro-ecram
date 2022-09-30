FROM eclipse-temurin:11.0.14.1_1-jdk-alpine
COPY build/libs/*.jar /app/posts-micro-ecram.jar
WORKDIR /app
# ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=dockerdev", "posts-micro-ecram.jar"]
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dockerdev", "posts-micro-ecram.jar"]
#docker build -t ecram/posts-micro:0.0.1-SNAPSHOT .
#docker run -e CLOUDINARY_APISECRET -e CLOUDINARY_APIKEY -e CLOUDINARY_CLOUDNAME -m 256m -d --name posts-micro-ecram  -p 30002:30002 ecram/posts-micro:0.0.1-SNAPSHOT
#docker stop posts-micro-ecram
#docker push ecram/posts-micro:0.0.1-SNAPSHOT
#docker pull ecram/posts-micro:0.0.1-SNAPSHOT