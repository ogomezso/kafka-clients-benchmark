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
 * Confluent Connect - Data Generator
 * Confluent Control Center
 * Prometheus
 * Grafana
 * Jaeger
 * Zipkin
 * Java Producer / Consumer sample app 
 * Spring-Kafka app 


- Environment UP:

```sh
docker-compose up -d
```

## Clients

## Java Consumer

This example implements a Circuit Breaker pattern to mitigate the effects of continuous reconnection retry on case of broker failure based of configuration optimization, to achieve this we will be playing with the following config parameters:

* [reconnect.backoff.ms](https://docs.confluent.io/platform/current/installation/configuration/consumer-configs.html#reconnect-backoff-ms): Base amount of time to wait for attempting to reconnect to a failing broker.
* [reconnect.backoff.max.ms](https://docs.confluent.io/platform/current/installation/configuration/consumer-configs.html#reconnect-backoff-max-ms): Max amount of time to wait for reconnection attempt. After every failing attempt you will add a 20% from base backoff configuration to this max.
* [retry.backoff.ms](https://docs.confluent.io/platform/current/installation/configuration/consumer-configs.html#retry-backoff-ms): Amount of time to wait until reconnect to a given topic partition.

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