package com.pinet.app.web.controller

import org.junit.Test

/**
 * Created by bijesh on 7/24/2017.
 */
class DefaultControllerTest extends spock.lang.Specification{
    def DefaultController controller = new DefaultController()

    @Test
    def "message should not be null"() {
        when:
        String message = controller.testMessage()
        then:
        message != null;

    }
    @Test
    def "message should exactly the same"() {
        when:
        String message = controller.testMessage()
        then:
        message.equalsIgnoreCase("test message");

    }
}

