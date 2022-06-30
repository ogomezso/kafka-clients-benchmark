# Kafka Clients Benchmark

Open Telemetry is a collection of tools and libraries to collect, analyze, and visualize telemetry data.

* [Open telemetry](https://github.com/open-telemetry/opentelemetry-collector) collector is a tool to collect telemetry.

* [Jaeger](https://www.jaegertracing.io/) is a tracing system for distributed applications.

* [Zipkin](https://zipkin.io/) is a tracing system for distributed applications.

Docker compose: 

* Apps + [Opent Telemetry Java](https://github.com/open-telemetry/opentelemetry-java-instrumentation) agent > Open Telemetry Collector > Jaegger / Zipkin

```sh
cd environment 
```

Environment:

 * Zookeeper
 * Confluent Kafka
 * Confluent Schema Registry
 * Confluent Connect
    * Datagen - Source - Generate ratings
    * HTTP - Sink - ratings to HTTP service
 * Confluent Control Center
 * Prometheus
 * Grafana
 * Jaeger
 * Zipkin
 * Java Producer / Consumer sample app 
 * Spring-Kafka app 
 * Golang HTTP Service (log request bogy and headers)
 * Golang Kafka consumer (consume ratings) 


- Build apps:

```sh
docker-compose build
```

or 

```sh
docker-compose up -d --force-recreate --build
```

- Environment UP:

```sh
docker-compose up -d
```

## Metrics

[Confluent Metrics](https://docs.confluent.io/platform/current/kafka/monitoring.html)

[Open Telemetry Contrib](https://github.com/open-telemetry/opentelemetry-collector-contrib)

This is a repository for OpenTelemetry Collector components that are not suitable for the core repository of the collector.

Different scenarios, one per branch, for exporting metrics:

### feature/jmxexporter

Branch [feature/jmxexporter](https://github.com/mcolomerc/kafka-clients-benchmark/tree/feature/jmxexporter)

Open telemetry collector with [JMX Metric Gatherer](https://github.com/open-telemetry/opentelemetry-java-contrib/tree/main/jmx-metrics)
This utility provides an easy framework for gathering and reporting metrics based on queried MBeans from a JMX server.  
Prometheus JMX exporter is not included with this scenario. 

### feature/remoteprometheus

Branch: [feature/remoteprometheus](https://github.com/mcolomerc/kafka-clients-benchmark/tree/feature/remoteprometheus)

Open telemetry collector scraps data from all the JMX servers and exports them to Prometheus.

[Prometheus Receiver](https://github.com/open-telemetry/opentelemetry-collector-contrib/tree/main/receiver/prometheusreceiver)

### feature/dynatrace 

Branch [feature/dynatrace](https://github.com/mcolomerc/kafka-clients-benchmark/tree/feature/dynatrace)

[Dynatrace exporter](https://github.com/open-telemetry/opentelemetry-collector-contrib/tree/main/exporter/dynatraceexporter) 