package com.UserServiceAppi.monitoring;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Controller
public class DummyServiceHealthCheck implements HealthIndicator {
    @Autowired
    private Environment environment;
    @Override
    public Health health()
    {
        try{
            if(isServiceUp())
            {
                return Health.up().withDetail("Dummy Service","is working good").build();
            }else
            {
                return Health.down().withDetail("Dummy Service","is Down").build();
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
    private boolean isServiceUp() throws IOException
    {
        String address1=environment.getProperty("dummyService.address");
        String port=environment.getProperty("dummyService.port");
        return isAddressReachable(address1,Integer.parseInt(port),3000);
    }
    private static boolean isAddressReachable(String address1,int port,int timeout) throws IOException
    {
        Socket isSocket=new Socket();
        try{
            isSocket.connect(new InetSocketAddress(address1,port),timeout);
            return true;
        } catch (IOException exception)
        {
            exception.printStackTrace();
            //Return false if connection fails
            return false;
        } finally {
            isSocket.close();
        }
    }

}
