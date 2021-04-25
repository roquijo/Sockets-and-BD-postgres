package mvc.controller;

import client.socket.SingleTCPEchoClientHybrid;
import mvc.graphics.InterfaceTournament;

public class ControllerForInterface {

    private static ControllerForInterface controllerForInterface = null;

    public static void getInstance(){

        if(controllerForInterface == null){
            new InterfaceTournament();
            ControllerForClient.getInstance(null);
        }
    }

    public static void main(String[] args) {
        getInstance();
    }
}
