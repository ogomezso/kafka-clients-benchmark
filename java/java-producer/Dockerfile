FROM adoptopenjdk/openjdk11:ubi
RUN dnf update
RUN dnf install -y maven

WORKDIR /java-producer

# Prepare by downloading dependencies
ADD pom.xml /java-producer/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /java-producer/src
ADD config /java-producer/config

RUN ["mvn", "package"]

EXPOSE 38080

EXPOSE 5000

ENV JAVA_TOOL_OPTIONS "-Dcom.sun.management.jmxremote.ssl=false \
  -Dcom.sun.management.jmxremote.authenticate=false \
  -Dcom.sun.management.jmxremote.port=5000 \
  -Dcom.sun.management.jmxremote.rmi.port=5000 \
  -Dcom.sun.management.jmxremote.host=0.0.0.0 \
  -Djava.rmi.server.hostname=0.0.0.0 \
  -javaagent:/usr/share/jmx-exporter/jmx_prometheus_javaagent-0.16.1.jar=1234:/usr/share/jmx-exporter/kafka_client.yml \
  -javaagent:/usr/share/opentelemetry/opentelemetry-javaagent.jar \
     -Dotel.resource.attributes=service.name=java-producer \
     -Dotel.metrics.exporter=none \
     -Dotel.logs.exporter=none \
     -Dotel.traces.exporter=jaeger \
     -Dotel.exporter.jaeger.endpoint=http://jaeger:14250"

CMD ["java", "-jar", "target/java-client-jar-with-dependencies.jar","config/application-docker.yml"]