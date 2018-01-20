package com.ny.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket managerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/foo/.*"))
                .build()
//                .pathMapping("/common/.*")
//                .directModelSubstitute(LocalDate.class,
//                        String.class)
//                .genericModelSubstitutes(ResponseEntity.class)
//                .alternateTypeRules(
//                        newRule(typeResolver.resolve(DeferredResult.class,
//                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
//                                typeResolver.resolve(WildcardType.class)))
//                .useDefaultResponseMessages(false)
//                .globalResponseMessage(RequestMethod.GET,
//                        newArrayList(new ResponseMessageBuilder()
//                                .code(500)
//                                .message("500 message")
//                                .responseModel(new ModelRef("Error"))
//                                .build()))
//                .securitySchemes(newArrayList(apiKey()))
//                .securityContexts(newArrayList(securityContext()))
//                .enableUrlTemplating(true)
//                .globalOperationParameters(
//                        newArrayList(new ParameterBuilder()
//                                .name("接口为对象，请补充Swagger注解")
//                                .description("该参数应为对象， 请补充Swagger ApiOperation")
//                                .modelRef(new ModelRef("string"))
//                                .parameterType("query")
//                                .required(true)
//                                .build()))
//               .apiInfo(apiInfo())
//                .tags(new Tag("Pet Service", "All apis relating to pets"))
//                .additionalModels(typeResolver.resolve(AdditionalModel.class))
                ;
    }

    // private ApiInfo apiInfo() {
    //     Contact contact = new Contact("倪耀,弓玉生,杨懿嵩", "", "");
    //     ApiInfo apiInfo;
    //     apiInfo = new ApiInfo("TRADE API",//大标题
    //             "底层Manager接口，供各Service进行调用，请各位后台开发人员认真规范文档，同时可以在此进行接口测试",//小标题
    //             "0.1-SNAPSHOT",//版本
    //             "",
    //             contact,//作者
    //             "",//链接显示文字
    //             ""//网站链接
    //     );
    //     return apiInfo;
    // }
}
