 FROM adoptopenjdk/openjdk11:ubi
 ARG JAR_FILE=target/*.jar
 COPY ${JAR_FILE} app.jar
 EXPOSE 5000
 ENV JAVA_TOOL_OPTIONS "-Dcom.sun.management.jmxremote.ssl=false \
  -Dcom.sun.management.jmxremote.authenticate=false \
  -Dcom.sun.management.jmxremote.port=5000 \
  -Dcom.sun.management.jmxremote.rmi.port=5000 \
  -Dcom.sun.management.jmxremote.host=0.0.0.0 \
  -Djava.rmi.server.hostname=0.0.0.0 \
  -Dspring.profiles.active=docker \
  -javaagent:/usr/share/jmx-exporter/jmx_prometheus_javaagent-0.16.1.jar=1234:/usr/share/jmx-exporter/kafka_client.yml"
 ENTRYPOINT ["java","-jar","/app.jar"]