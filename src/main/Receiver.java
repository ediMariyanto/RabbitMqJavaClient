package main;

import java.io.IOException;

import com.rabbitmq.client.*;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Receiver {
	
	private final static String QUEUE_NAME = "TOPIC_LOGS";
	
	public static void main(String[] args) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println("[*] wait for message, to exit press CTRL + C");
		
		Consumer consumer = new Consumer() {
			
			@Override
			public void handleShutdownSignal(String arg0, ShutdownSignalException arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleRecoverOk(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("[x] Receive '" +message+"'");
				
				
			}
			
			@Override
			public void handleConsumeOk(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleCancelOk(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleCancel(String arg0) throws IOException {
				// TODO Auto-generated method stub
				
			}
		};
				
	}

}
