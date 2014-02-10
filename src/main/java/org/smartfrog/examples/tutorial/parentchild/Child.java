package org.smartfrog.examples.tutorial.parentchild;

import java.rmi.* ;
import org.smartfrog.sfcore.common.* ;
import org.smartfrog.sfcore.prim.* ;

public class Child extends PrimImpl implements Prim {

	public Child() throws RemoteException {

	}

	public void sfDeploy() throws RemoteException, SmartFrogException {
		super.sfDeploy() ;
		try {
			sfLog().out("SmartFrog " + sfCompleteName() + "deploying") ;
			sfLog().out("SmartFrog child process deployed") ;
		}
		catch (Throwable t) {
			t.printStackTrace() ;
			throw SmartFrogException.forward(t) ;
		}
	}

	public void sfStart() throws RemoteException, SmartFrogException {
		try {
			super.sfStart() ;
			sfLog().out("SmartFrog child process starting") ;
		}
		catch (Throwable t) {
			t.printStackTrace() ;
			throw SmartFrogException.forward(t) ;
		}
	}

	public void sfTerminateWith(TerminationRecord tr) {
		try {
			sfLog().out("SmartFrog child process terminating") ;
		}
		catch (Exception e) {
		}
		super.sfTerminateWith(tr) ;
	}
}

