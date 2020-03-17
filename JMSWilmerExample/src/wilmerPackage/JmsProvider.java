package wilmerPackage;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.ConnectionFactory;

public class JmsProvider {

    public static ConnectionFactory getConnectionFactory () {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");

        return connectionFactory;
    }
}