import tensorflow as tf
sess=tf.Session()

# a = tf.constant([-1.0, 2.0])
# with tf.Session() as sess:
#     b = tf.nn.relu(a)
#     print(sess.run(b))
# features=tf.range(-2,3)
# a=sess.run([features,tf.nn.relu(features)])
# print(a)
# features=tf.to_float(tf.range(-1,3))
# print(sess.run([features,tf.sigmoid(features)]))
batch_size=1
input_height=3
input_width=3
input_channels=1
layer_input=tf.constant([
	[
		[[1.0],[0.2],[1.5]],
		[[0.1],[1.2],[1.4]],
		[[1.1],[0.4],[0.4]]
	]
	])
kernel=[batch_size,input_height,input_width,input_channels]

max_pool=tf.nn.max_pool(layer_input,kernel,[1, 1, 1, 1],"VALID")

print(sess.run(max_pool))