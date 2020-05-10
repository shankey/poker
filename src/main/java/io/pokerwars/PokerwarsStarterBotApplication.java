package io.pokerwars;

import io.pokerwars.bot.strategies.StrategyConfig;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import io.pokerwars.simultor.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages="io.pokerwars.database")
public class PokerwarsStarterBotApplication {

  public static void main(String[] args) {

    SpringApplication.run(PokerwarsStarterBotApplication.class, args);
  }

  @Bean
  public Client client() {
    return ClientBuilder.newClient();
  }

  @Bean
  public StrategyConfig strategyConfig() {
    return new StrategyConfig();
  }

}
