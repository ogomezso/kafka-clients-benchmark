package org.github.ogomezso.perftest;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.core.OpenInjectionStep.atOnceUsers;
import static io.gatling.javaapi.http.HttpDsl.http;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class ChuckSaysSimulation extends Simulation {

  Config config = ConfigFactory.load();
  private final int msgs = config.getInt("chuck-says.msgs");
  private final int users = config.getInt("chuck-says.users");
  private final HttpProtocolBuilder httpProtocol = http
      .baseUrl(config.getString("chuck-says.base-url"))
      .inferHtmlResources()
      .acceptHeader("*/*");

  private final ScenarioBuilder scn = scenario("ChuckSays").repeat(msgs).on(
      exec(
          http("Chuck Says")
              .post("/chuck-says")));

  {
    setUp(scn.injectOpen(atOnceUsers(users))).protocols(httpProtocol);
  }
}
