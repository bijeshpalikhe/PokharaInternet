package com.pinet.app.web.controller

/**
 * Created by bijesh on 7/24/2017.
 */
class DefaultControllerTest extends spock.lang.Specification {
    def DefaultController controller = new DefaultController()

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
        message.equalsIgnoreCase("test message");

    }
}

