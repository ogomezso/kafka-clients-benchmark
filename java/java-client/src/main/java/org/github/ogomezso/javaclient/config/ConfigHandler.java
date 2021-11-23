package org.github.ogomezso.javaclient.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class ConfigHandler {

  public AppConfig getAppConfig(String configFileName)
      throws URISyntaxException, FileNotFoundException {

//    System.out.println(getClass().getResource(configFileName).toString());
//    URI resourceUri = Objects
//        .requireNonNull(getClass().getResource(configFileName)).toURI();
    File configFile = new File(configFileName);
    Constructor constructor = new Constructor(AppConfig.class);
    Yaml yaml = new Yaml(constructor);

    return yaml.load(new FileInputStream(configFile));
  }

}
