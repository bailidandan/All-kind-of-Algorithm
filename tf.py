#coding:utf-8

#第一种实现 tf.nn
import tensorflow as tf
import tensorflow.contrib.slim as slim

tf.reset_default_graph()
image = tf.random_normal([1, 112, 96, 3])
in_channels = 3
out_channels = 32
kernel_size = 5

conv_weight = tf.Variable(tf.truncated_normal([kernel_size,kernel_size,in_channels,out_channels],
                                              stddev=0.1, dtype=tf.float32))

bias = tf.Variable(tf.zeros([out_channels], dtype=tf.float32))
conv = tf.nn.conv2d(image, conv_weight, strides=[1, 2, 2, 1], padding='SAME')
conv = tf.nn.bias_add(conv,bias)


with tf.Session() as sess:
    sess.run(tf.global_variables_initializer())
    convres = sess.run(conv)
    print (convres)
    print (conv.get_shape())


#第二种实现 tf.layers
truncated_norm_init = tf.truncated_normal_initializer(stddev=0.1, dtype=tf.float32)
zero_init = tf.zeros_initializer(dtype=tf.float32)
l2_regularizer = tf.contrib.layers.l2_regularizer(1.0)
conv = tf.layers.conv2d(image, out_channels, [kernel_size, kernel_size], strides=[2, 2], padding='SAME',
                        kernel_initializer=truncated_norm_init, bias_initializer=zero_init,
                        kernel_regularizer=l2_regularizer, bias_regularizer=l2_regularizer)

with tf.Session() as sess:
    sess.run(tf.global_variables_initializer())
    convres = sess.run(conv)
    print (convres)
    print (conv.get_shape())

#第三种实现 slim
conv = slim.conv2d(image, out_channels, [kernel_size, kernel_size], scope='conv1_1')
with tf.Session() as sess:
    sess.run(tf.global_variables_initializer())
    convres = sess.run(conv)
    print (convres)
    print (conv.get_shape())