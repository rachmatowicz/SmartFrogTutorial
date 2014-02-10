package org.smartfrog.examples.tutorial.communication;

import java.rmi.*;

public interface Management extends java.rmi.Remote {

    /*
     * reset the ID of the server, which appears in error messages
     */
    public void resetServerID(String s)
            throws RemoteException;

}

