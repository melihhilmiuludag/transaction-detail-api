package tr.mhu.core.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.util.concurrent.Executor;

/**
 * @author muludag on 5.01.2020
 */

@SpringBootApplication
@ComponentScan(basePackages = {"tr.mhu.core.*"})
@EnableJpaRepositories("tr.mhu.core.data")
@EntityScan("tr.mhu.core.domain.*")
@EnableAsync
@Slf4j
public class ApiMain {
	public static void main(String[] args) {
		SpringApplication.run(ApiMain.class, args);
		log.info("Started App! Hi Bro.");
	}

	@Bean
	public DataSource dataSource() {
		//jdbc:hsqldb:mem:transaction_report
		EmbeddedDatabase db = null;
		try {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			db = builder.setType(EmbeddedDatabaseType.H2)
					.addScript("sql/init.sql")
					.build();
			log.debug("created script");
		} catch (Exception e) {
			log.error("failed init sql!!! error message: {}", e.getMessage());
		}
		return db;
	}

	@Bean
	public Executor threadPoolTaskExecutor() {
		return new ThreadPoolTaskExecutor();
	}
}
