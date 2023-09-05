package org.hotdog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.hotdog.sample"})
public class RootConfig {

}
