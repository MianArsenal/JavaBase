package io.nio.selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo {

    private final int port;
    private final Selector selector;

    public SelectorDemo(int port) throws Exception {
        this.port = port;
        this.selector = getSelector();
    }

    private Selector getSelector() throws Exception {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        serverSocket.bind(address);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        return selector;
    }

    public void listen() {
        System.out.println("listen on " + port);
        try {
            while (true) {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = keys.iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();
                    process(key);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(SelectionKey key) throws Exception {
        if (key.isAcceptable()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel channel = serverSocketChannel.accept();
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int len = socketChannel.read(buffer);
            if (len > -1) {
                buffer.flip();
                String content = new String(buffer.array(), 0, len);
                SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_WRITE);
                selectionKey.attach(content);
            } else {
                socketChannel.close();
            }
            buffer.clear();
        } else if (key.isWritable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            String content = (String) key.attachment();
            ByteBuffer byteBuffer = ByteBuffer.wrap(("输入内容：" + content).getBytes());
            if (null != byteBuffer) {
                channel.write(byteBuffer);
            } else {
                channel.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SelectorDemo selectorDemo = new SelectorDemo(7777);
        selectorDemo.listen();
    }

}
