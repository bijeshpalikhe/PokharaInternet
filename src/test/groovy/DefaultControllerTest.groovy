import com.pinet.app.web.controller.DefaultController
import org.junit.Test

class DefaultControllerTest extends spock.lang.Specification {
    def controller = new DefaultController()

    def "check the message is right or wrong"() {
        given:
        def message = controller.testMessage()

        expect: "Adding two numbers to return the sum"
        message.equals("Greetings from Pinet")
    }

    def "Checking data availability"() {

    }

    def "message should not be null"() {
        when:
        String message = controller.testMessage()
        then:
        message != null;

    }

    def "message should exactly the same"() {
        when:
        String message = controller.testMessage()
        then:
        message.equalsIgnoreCase("Greetings from Pinet");

    }
}


