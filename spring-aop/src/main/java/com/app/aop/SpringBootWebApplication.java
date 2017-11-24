package com.app.aop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-cli-command-line-completion
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy
public class SpringBootWebApplication{
    public static void main(String[] args) {
    	//System.setProperty("spring.devtools.restart.enabled", "false");
    	//SpringApplication.setRegisterShutdownHook(false))
        SpringApplication application = new SpringApplication(SpringBootWebApplication.class);
    	//application.setBannerMode(Banner.Mode.OFF);
    	//application.setBanner(new CustomBanner());
    	application.run(args);
    }
   /*
    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);//-1 means unlimited
            }
        });
        return tomcat;
    }
    */
    
	

	
	
/*	@Bean   
  CommandLineRunner init(MongoQueryDemo mongoQueryDemo) {
     return args -> {
    	 mongoQueryDemo.mongoQueryOperation();
     };
     }*/
	
//    @Bean   
//    CommandLineRunner init(DomainRepository domainRepository) {
//       return args -> {
    	   /*Domain dm=new Domain();
    	   String uid=UUID.randomUUID().toString().replace("-", "");
    	   dm.setId(UUID.randomUUID().toString().replace("-", ""));
    	   dm.setDomainId(uid);
    	   dm.setDomain("mkyong2.com");
    	   domainRepository.save(dm);
            Domain obj = domainRepository.findOne(uid);
            System.out.println(obj);

            Domain obj2 = domainRepository.findFirstByDomain("mkyong2.com");
            System.out.println(obj2);

            obj2.setDisplayAds(true);
            String uid1=UUID.randomUUID().toString().replace("-", "");
            obj2.setDomainId(uid1);
            obj2.setId(UUID.randomUUID().toString().replace("-", ""));
            domainRepository.save(obj2);

            int n = domainRepository.updateDomain("mkyong3.com", true);
            System.out.println("Number of records updated : " + n);

            Domain obj3 = domainRepository.findOne(uid1);
            System.out.println(obj3);

            Domain obj4 = domainRepository.findCustomByDomain("google.com");
            System.out.println(obj4);

            List<Domain> obj5 = domainRepository.findCustomByRegExDomain("google");
            obj5.forEach(x -> System.out.println(x));*/

            /*    CommandLineRunner init(RestApiService requestProcessor) {
            return args -> {
            
     */ 
    //RestApiService
    	   /*ObjectMapper mapper=new ObjectMapper();
    	   ApiRequest<Account>  apiRequest = new  ApiRequest<Account>();// mapper.readValue(jsonData, new TypeReference<ApiRequest<Account>>() {});
    	   apiRequest.setOprationOn("account");
    	   apiRequest.setBody(new Account());
    	   String json=mapper.writeValueAsString(apiRequest);
    	   @SuppressWarnings("unchecked")
		   ApiResponse<Account> apiResponse= (ApiResponse<Account>) requestProcessor.processRequest(json);
    	   System.out.println(apiResponse);*/
//
//            Domain obj = domainRepository.findOne(7L);
//            System.out.println(obj);
//
//            Domain obj2 = domainRepository.findFirstByDomain("mkyong.com");
//            System.out.println(obj2);
//
//            //obj2.setDisplayAds(true);
//            //domainRepository.save(obj2);
//
//            //int n = domainRepository.updateDomain("mkyong.com", true);
//            //System.out.println("Number of records updated : " + n);
//
//            //Domain obj3 = domainRepository.findOne(2000001L);
//            //System.out.println(obj3);
//
//            //Domain obj4 = domainRepository.findCustomByDomain("google.com");
//            //System.out.println(obj4);
//
//            //List<Domain> obj5 = domainRepository.findCustomByRegExDomain("google");
//            //obj5.forEach(x -> System.out.println(x));
//
     //  };
//
      // }

    //remove _class
        /*MappingMongoConverter converter =
                new MappingMongoConverter(mongoDbFactory, new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));*/
   /*
    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory,
                                       MongoMappingContext context) {

        MappingMongoConverter converter =
                new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);
        
        return mongoTemplate;

    }
    */

}
