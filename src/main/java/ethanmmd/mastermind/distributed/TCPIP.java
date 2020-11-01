package ethanmmd.mastermind.distributed;

import ethanmmd.mastermind.models.Color;
import ethanmmd.mastermind.models.Combination;
import ethanmmd.mastermind.models.ProposedCombination;
import ethanmmd.utils.AbstractTCPIP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPIP extends AbstractTCPIP {


    public TCPIP(Socket socket) {
        super(socket);
    }

    public TCPIP(ServerSocket serverSocket, Socket socket) {
        super(serverSocket, socket);
    }

    public static TCPIP createClientSocket() {
        try {
            Socket socket = new Socket("localhost", 2020);
            System.out.println("Client has stablished connection");
            return new TCPIP(socket);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TCPIP createServerSocket() {
        try {
            ServerSocket serverSocket = new ServerSocket(2020);
            System.out.println("Servidor> Esperando conexion...");
            Socket socket = serverSocket.accept();
            System.out.println("Servidor> Recibida conexion de " + socket.getInetAddress().getHostAddress() + ":"
                    + socket.getPort());
            return new TCPIP(serverSocket, socket);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ProposedCombination receiveProposedCombination() {

        ProposedCombination proposedCombination = new ProposedCombination();

        for (int i = 0; i < Combination.getWidth(); i++) {
            int color = this.receiveInt();
            proposedCombination.getColors().add(Color.values()[color]);
        }

        return proposedCombination;
    }

    public void sendProposedCombination(ProposedCombination proposedCombination) {
        for (Color color : proposedCombination.getColors()) {
            this.send(color.ordinal());
        }
    }


}
