package CommonClasses;

import java.io.Serializable;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;



import java.net.InetAddress;
import java.nio.channels.DatagramChannel;

    public class FirstTimeConnectedData implements Serializable {

        private SocketAddress socketAddress = null;

        public void setSocketAddress(SocketAddress socketAddress) {
            this.socketAddress = socketAddress;
        }

        public SocketAddress getSocketAddress() {
            return socketAddress;
        }
    }


