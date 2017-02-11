/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserver;

import java.net.InetAddress;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.*;

/**
 *
 * @author ghisl
 */
public class UDPServerController implements Initializable {

    @FXML
    private Button Button_Start;
    @FXML
    private Button Button_Stop;
    @FXML
    private Label label_UDPServer;
    @FXML
    private Label label_Server_IP;
    @FXML
    private Label label_Server_Port;
    @FXML
    private Label label_UDPClient;
    @FXML
    private Label label_Client_IP;
    @FXML
    private Label label_Client_Port;
    @FXML
    private Label label_Datagarm_in;
    @FXML
    private Label label_Datagarm_out;
    @FXML
    private TextField Text_Datagram_in;
    @FXML
    private TextField Text_Datagram_out;
    @FXML
    private TextField IP_Address_Server;
    @FXML
    private TextField IP_Address_Client;
    @FXML
    private TextField Server_Port;
    @FXML
    private TextField Client_Port;

    DatagramSocket serverSocket;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        System.out.println("You clicked me!");
        //todo
        // he verhinderen dat 2de keer socket wordt aangemaakt 
        //
        serverSocket = new DatagramSocket(5555);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        int i = 0;

        while (true) {
            i = i + 1;
            //
            System.out.println("wachten!");
            //
            //waarom komt dat hieronder niet op het scherm 
            //
            label_UDPServer.setText("wachten op data");
            //
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println("RECEIVED: " + i + " " + sentence + " " + IPAddress.toString());
            IP_Address_Client.setText(IPAddress.toString());
            Text_Datagram_in.setText(sentence);
            Client_Port.setText(Integer.toString(port));
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            Text_Datagram_out.setText(capitalizedSentence);
            DatagramPacket sendPacket
                    = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);

            //
            //anders geen aangepast scherm
            //
            break;
        }
        //label.setText("Hello World!");
    }

    @FXML
    private void handleButtonStop(ActionEvent event) {
        System.out.println("Stop program");
        System.exit(0);

    }
    //label.setText("Hello World!");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
