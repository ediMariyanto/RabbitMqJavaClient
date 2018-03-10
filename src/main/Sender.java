package main;

import com.rabbitmq.client.*;

public class Sender {
	private static final String EXCHANGE_NAME = "TOPIC_LOGS";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");

		Connection connection = factory.newConnection();

		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");

		String message = "Coba Kirim Edi";
		for (int i = 0; i < 1000000; i++) {
			channel.basicPublish("", EXCHANGE_NAME, null, message.getBytes("utf-8"));

			System.out.println(" [x] Sent '" + "':'" + message + "'");
		}
		channel.close();
		connection.close();

	}

}
