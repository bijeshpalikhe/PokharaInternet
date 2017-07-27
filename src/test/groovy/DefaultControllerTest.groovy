

import com.pinet.app.web.controller.DefaultController

    class DefaultControllerTest extends spock.lang.Specification {
        def controller = new DefaultController()

        def "check the message is right or wrong"() {
            given:
            def message=controller.testMessage()

            expect: "Adding two numbers to return the sum"
            message.equals("Greetings from Pinet")
        }
         def "Checking data availability"(){

        }
    }


