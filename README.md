# swagger-knife4j
# swagger集成knife4j
## 1.添加pom
```xml
<!-- swagger -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>

		<dependency>
			<groupId>com.github.xiaoymin</groupId>
			<artifactId>knife4j-spring-boot-starter</artifactId>
			<version>2.0.2</version>
			<exclusions>
				<exclusion>
					<artifactId>swagger-models</artifactId>
					<groupId>io.swagger</groupId>
				</exclusion>
			</exclusions>
		</dependency>
```
## 2. 配置swagger
```java

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
        .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("项目API文档")
                .build();
    }
}
```
### 3.使用注解
```java

@Api(tags = "测试控制器说明")
@RestController
@RequestMapping(value = "/test")
public class TestController {
    /* 方法注解 */
    @ApiOperation("home方法说明")
    @GetMapping("/home")
    public String home() {
        return "返回值";
    }

    @ApiOperation("post方法说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="主键"),
            @ApiImplicitParam(name="name",value="名称")
    })
    @PostMapping("/post")
    public void post(@RequestParam String id,@RequestParam String name) {

    }
}
```
