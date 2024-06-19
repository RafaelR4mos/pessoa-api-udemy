//package com.study.rafael.curso_rest_spring.configuration.integrationtests.testcontainers;
//
//import org.springframework.context.ApplicationContextInitializer;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.core.env.ConfigurableEnvironment;
//import org.springframework.core.env.MapPropertySource;
//import org.springframework.test.context.ContextConfiguration;
//import org.testcontainers.containers.OracleContainer;
//import org.testcontainers.lifecycle.Startables;
//
//import java.util.Map;
//import java.util.stream.Stream;
//
//@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
//public class AbstractIntegrationTest {
//
//    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//        static OracleContainer oracle = new OracleContainer();
//
//        private static void startContainers() {
//            Startables.deepStart(Stream.of(oracle)).join();
//        }
//
//        private static Map<String, String> createConnectionConfiguration() {
//            return Map.of(
//                    "spring.datasource.url", oracle.getJdbcUrl(),
//                    "spring.datasource.username", oracle.getUsername(),
//                    "spring.datasource.password", oracle.getPassword()
//            );
//        }
//
//        @SuppressWarnings({"unchecked", "rawtypes"})
//        @Override
//        public void initialize(ConfigurableApplicationContext applicationContext) {
//            startContainers();
//            ConfigurableEnvironment environment = applicationContext.getEnvironment();
//            MapPropertySource testcontainers = new MapPropertySource(
//                    "testcontainers",
//                    (Map) createConnectionConfiguration());
//            environment.getPropertySources().addFirst(testcontainers);
//        }
//    }
//}
