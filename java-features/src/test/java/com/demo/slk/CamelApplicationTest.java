package com.demo.slk;

/*@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CamelApplicationTest extends CamelTestSupport {
 
    @Autowired
    private CamelContext camelContext;
 
    @Override
    protected CamelContext createCamelContext() throws Exception {
        return camelContext;
    }
 
    @EndpointInject(uri = "direct:myEndpoint")
    private ProducerTemplate endpoint;
 
    @Override
    public void setUp() throws Exception {
        super.setUp();
        RouteDefinition definition = context().getRouteDefinitions().get(0);
        definition.adviceWith(context(), new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                onException(Exception.class).maximumRedeliveries(0);
            }
        });
    }
 
    @Override
    public String isMockEndpointsAndSkip() {
            return "myEndpoint:put*";
    }
 
    @Test
    public void shouldSucceed() throws Exception {
        assertNotNull(camelContext);
        assertNotNull(endpoint);
         
        String expectedValue = "expectedValue";
        MockEndpoint mock = getMockEndpoint("mock:myEndpoint:put");
        mock.expectedMessageCount(1);
        mock.allMessages().body().isEqualTo(expectedValue);
        mock.allMessages().header(MY_HEADER).isEqualTo("testHeader");
        endpoint.sendBodyAndHeader("test", MY_HEADER, "testHeader");
         
        mock.assertIsSatisfied();
    }
}*/

