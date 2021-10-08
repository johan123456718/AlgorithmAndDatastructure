/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift5;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Johan Challita
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] packet = {'A', 'B', 'C', 'D', 'E'};
        char[] test = {'E','A','D','B','C'};
        char[] tmpPacket = shufflePacket(packet);
        System.out.print("Shuffled: " + Arrays.toString(test));
        System.out.println("");
        System.out.println(orderPackets(test).length() + " Steps: " + orderPackets(test));
        System.out.println("Ordered: "  + Arrays.toString(packet));
    }
    
    public static String orderPackets(char[] packet){
        return orderPackets(packet, 0, "");
    }
    
    private static String orderPackets(char[] packet, int times, String result){
        char[] answer = {'A', 'B', 'C', 'D', 'E'};
        if(Arrays.equals(packet, answer)){
            return result;
        }else if(times > 15){
            return "failed to fix";
        }else{
            char[] tmpPacketOne = new char[packet.length];
            char[] tmpPacketTwo = new char[packet.length]; // create two temp char arrays in order to seperate the packets
            for(int i = 0; i < packet.length; i++){
                tmpPacketOne[i] = packet[i];
                tmpPacketTwo[i] = packet[i];
            }
            
            String letterS = orderPackets(sConvert(tmpPacketOne), times + 1, result + "s");
            String letterB = orderPackets(bConvert(tmpPacketTwo), times + 1, result + "b");
            if(letterB.length() > letterS.length()){
                return letterS;
            }else{
                return letterB;
            }
        }
    }
    private static char[] sConvert(char[] packet){
        char last = packet[packet.length - 1];
        for(int i = packet.length - 1; i > 0; i--){
            packet[i] = packet[i - 1];
        }
        packet[0] = last;
        return packet;
    }
    
    private static char[] bConvert(char[] packet){
        char first = packet[0];
        packet[0] = packet[1];
        packet[1] = first;
        return packet;
    }
    private static char[] shufflePacket(char[] packet) {
        Random rand = new Random();
        char[] tmpPacket = new char[packet.length];
        for(int i = 0; i < packet.length; i++){
            tmpPacket[i] = packet[i];
        }
        for(int i = 0; i < packet.length; i++){
            int randomPosition = rand.nextInt(packet.length);
            char tmpValue = tmpPacket[i];
            tmpPacket[i] = tmpPacket[randomPosition];
            tmpPacket[randomPosition] = tmpValue;
        }
        return tmpPacket;
    }
}