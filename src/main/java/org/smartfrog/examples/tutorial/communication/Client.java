package org.smartfrog.examples.tutorial.communication;

import java.rmi.* ;
import org.smartfrog.sfcore.common.* ;
import org.smartfrog.sfcore.prim.* ;

public class Client extends PrimImpl implements Prim {

	public Client() throws RemoteException {
		sfLog().out("Client constructor called") ;
	}

	public void sfDeploy() throws RemoteException, SmartFrogException {
		super.sfDeploy() ;
		try {
			sfLog().out("SmartFrog " + sfCompleteName() + "deploying") ;
			sfLog().out("SmartFrog client process deployed") ;
		}
		catch (Throwable t) {
			t.printStackTrace() ;
			throw SmartFrogException.forward(t) ;
		}
	}

	public void sfStart() throws RemoteException, SmartFrogException {
		try {
			super.sfStart() ;
			sfLog().out("SmartFrog client process starting") ;

			// get the RMI interfaces from the server
			Errors errorInterface = (Errors) sfResolve("serverProxy") ;
			Management mgmtInterface = (Management) sfResolve("serverProxy") ;

			// test Errors interface
			String message = null ;
			int error = 0 ;

			message = errorInterface.getMessageForError(error) ;
			sfLog().out("Client finds message for error " + error + " = " + message) ;

			// test management interface
			String serverID = "fred's Server" ;
			mgmtInterface.resetServerID(serverID) ;
			sfLog().out("Client sets serverID = " + serverID) ;

			sfLog().out("SmartFrog client process stopping") ;
		}
		catch (Throwable t) {
			t.printStackTrace() ;
			throw SmartFrogException.forward(t) ;
		}

	}

	public void sfTerminateWith(TerminationRecord tr) {
		try {
			sfLog().out("SmartFrog client process terminating") ;
		}
		catch (Exception e) {
		}
		super.sfTerminateWith(tr) ;
	}
}

