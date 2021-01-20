package com.ca.cdd.dummy.robot;

import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

@RobotKeywords
public class RESTClient {
    @RobotKeyword("Rest Call")
    static public String restCall(String method, String url) {
        Client httpClient = ClientBuilder.newClient();
        Response response = httpClient.target(url).request().method(method);
        if (response == null) {
            throw new RuntimeException(url + ": No response");
        }

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException(url + ": Response is: " + response.getStatus());
        }
        return response.readEntity(String.class);
    }
}
