package mvc.controller;

import client.socket.SingleTCPEchoClientHybrid;
import mvc.graphics.InterfaceTournament;

public class ControllerForInterface {

    private InterfaceTournament interfaceTournament;


    public ControllerForInterface() {
        new InterfaceTournament();
        
    }

    public static void main(String[] args) {
        new ControllerForInterface();
    }
}
