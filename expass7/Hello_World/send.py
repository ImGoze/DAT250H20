# send

import pika


# Establish connection
connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()

# Recipient-queue, in this case hello-queue
channel.queue_declare(queue='hello')

# Specify which queue the message should go to, in this case "hello"
channel.basic_publish(exchange='', routing_key='hello', body='Hello World!')
print(" [x] Sent 'Hello World!'")

# closing connection
connection.close()