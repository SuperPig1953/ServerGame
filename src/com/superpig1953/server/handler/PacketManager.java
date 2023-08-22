package com.superpig1953.server.handler;

public class PacketManager {

    /**
     * Handles a packet received from the client and performs the appropriate action
     * @param packet The packet to handle
     */
    public static void handlePacket(String packet) {
        System.out.println("Packet received: " + packet);
    }

}
