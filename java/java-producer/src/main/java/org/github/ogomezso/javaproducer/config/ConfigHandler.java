package org.github.ogomezso.javaproducer.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfigHandler {

  public AppConfig getAppConfig(String configFileName)
      throws FileNotFoundException {

    File configFile = new File(configFileName);
    Constructor constructor = new Constructor(AppConfig.class, new LoaderOptions());
    Yaml yaml = new Yaml(constructor);

    return yaml.load(new FileInputStream(configFile));
  }

}
