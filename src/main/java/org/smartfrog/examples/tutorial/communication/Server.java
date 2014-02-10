package org.smartfrog.examples.tutorial.communication;

import java.net.InetAddress;
import java.rmi.RemoteException;

import org.smartfrog.sfcore.common.SmartFrogException;
import org.smartfrog.sfcore.prim.Prim;
import org.smartfrog.sfcore.prim.PrimImpl;
import org.smartfrog.sfcore.prim.TerminationRecord;

public class Server extends PrimImpl implements Prim, Errors, Management {

    String serverID;

    public Server() throws RemoteException {
        serverID = null;
        sfLog().out("Server constructor called");
    }

    public void sfDeploy() throws RemoteException, SmartFrogException {

        super.sfDeploy();

        try {
            sfLog().out("SmartFrog " + sfCompleteName() + "deploying");
            sfLog().out("SmartFrog server process deployed");
        } catch (Throwable t) {
            t.printStackTrace();
            throw SmartFrogException.forward(t);
        }

    }

    public void sfStart() throws RemoteException, SmartFrogException {

        String hostname;
        String ipaddress;

        try {
            super.sfStart();

            sfLog().out("SmartFrog server process starting");

            // get the fully qualified name of the host
            hostname = ((InetAddress) sfResolve("sfHost")).getCanonicalHostName();
            sfLog().out("Hostname is " + hostname);

            // get the IP address of this host
            ipaddress = ((InetAddress) sfResolve("sfHost")).getHostAddress();
            sfLog().out("IP address is " + ipaddress);

            sfLog().out("SmartFrog server process started");

        } catch (Throwable t) {
            t.printStackTrace();
            throw SmartFrogException.forward(t);
        }

    }

    public void sfTerminateWith(TerminationRecord tr) {

        try {
            sfLog().out("SmartFrog server process terminating");
        } catch (Exception e) {
        }

        super.sfTerminateWith(tr);
    }

    //
    // Errors interface
    //
    public String getMessageForError(int i) throws RemoteException {

        String[] messages = {"one", "two", "three", "four", "five"};
        String message = null;

        try {
            sfLog().out("SmartFrog server process:getting message for error number " + i);
            message = messages[i];
        } catch (Exception e) {
        }

        return message;
    }

    //
    // Management interface
    //
    public void resetServerID(String s) throws RemoteException {

        try {
            sfLog().out("SmartFrog server process: updating serverID");
            serverID = s;
        } catch (Exception e) {
        }
    }
}

