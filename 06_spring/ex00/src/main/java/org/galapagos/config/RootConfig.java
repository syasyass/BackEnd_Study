package org.galapagos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.galapagos.sample"})
public class RootConfig {

}
