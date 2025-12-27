@Bean
public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .info(new Info()
                    .title("Demo API")
                    .version("1.0")
                    .description("Demo Spring Boot API"));
}
