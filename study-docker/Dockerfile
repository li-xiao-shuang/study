FROM java:8
VOLUME /Users/lixiaoshuang/logs
ADD target/study-docker-0.0.1-SNAPSHOT.jar docker.jar
RUN bash -c 'touch /docker.jar'
ENTRYPOINT ["java","-jar","/docker.jar"]