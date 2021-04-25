package mvc.controller;

import client.socket.SingleTCPEchoClientHybrid;
import mvc.graphics.InterfaceTournament;

public class ControllerForApp {

    private InterfaceTournament interfaceTournament;
    private SingleTCPEchoClientHybrid singleTCPEchoClientHybrid;

    public ControllerForApp() {
        new InterfaceTournament();
        new SingleTCPEchoClientHybrid();
    }

    public static void main(String[] args) {
        new ControllerForApp();
    }
}
