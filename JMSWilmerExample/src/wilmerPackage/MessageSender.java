package wilmerPackage;
import javax.jms.*;

public class MessageSender {

    private final MessageProducer producer;
    private final Session session;
    private final Connection con;

    public MessageSender () throws JMSException {
        ConnectionFactory factory = JmsProvider.getConnectionFactory();
        this.con = factory.createConnection();
        con.start();

        this.session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("queue");
        this.producer = session.createProducer(queue);
    }

    public void sendMessage (String mensaje) throws JMSException {
        System.out.printf("Enviando mensaje: %s %n", mensaje);
        TextMessage texto = session.createTextMessage(mensaje);
        producer.send(texto);
    }

    public void destroy () throws JMSException {
        con.close();
    }
}