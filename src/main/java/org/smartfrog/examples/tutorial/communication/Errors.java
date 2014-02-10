package org.smartfrog.examples.tutorial.communication;

import java.rmi.*;

public interface Errors extends java.rmi.Remote {

    /*
     * return the error message corresponding to an error code
     * error codes: from 1-5
     * error messages: "one","two", etc.
     */
    public String getMessageForError(int i)
            throws RemoteException;

}


