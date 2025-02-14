package dev.prmts.mcusimulator.log;

import java.util.Random;

public class LogUtil {
    public static String randomMACAddress(){
        Random rand = new Random();
        byte[] macAddr = new byte[6];
        rand.nextBytes(macAddr);

        macAddr[0] = (byte)(macAddr[0] & (byte)254);  //zeroing last 2 bytes to make it unicast and locally adminstrated

        StringBuilder sb = new StringBuilder(18);
        for(byte b : macAddr){

            if(!sb.isEmpty())
                sb.append(":");

            sb.append(String.format("%02x", b));
        }

        return sb.toString().toUpperCase();
    }
}
