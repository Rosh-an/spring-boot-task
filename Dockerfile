FROM openjdk:11
WORKDIR usr/src

# ENV MYSQL_DATABASE=movie

# ENV MYSQL_USER=roshan
# ENV MYSQL_PASSWORD=stackroute123
# ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/movie
ADD ./target/userservice-0.0.1-SNAPSHOT.jar /usr/src/userservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","userservice-0.0.1-SNAPSHOT.jar"]


