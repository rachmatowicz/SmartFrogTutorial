package org.smartfrog.examples.tutorial.parentchild;

import java.rmi.* ;
import java.net.InetAddress ;
import org.smartfrog.sfcore.common.* ;
import org.smartfrog.sfcore.prim.* ;
import org.smartfrog.sfcore.compound.* ;
import org.smartfrog.sfcore.componentdescription.* ;

public class Parent extends CompoundImpl implements Compound {

	ComponentDescriptionImpl child = null ;

	public Parent() throws RemoteException {

	}

	public void sfDeploy() throws RemoteException, SmartFrogException {
		super.sfDeploy() ;
		try {
			sfLog().out("SmartFrog " + sfCompleteName() + "deploying") ;

			child = (ComponentDescriptionImpl) sfResolve("myChild") ;

			sfLog().out("Child configuration reference found") ;
			sfLog().out("SmartFrog parent process deployed") ;
		}
		catch (Throwable t) {
			t.printStackTrace() ;
			throw SmartFrogException.forward(t) ;
		}
	}

	public void sfStart() throws RemoteException, SmartFrogException {
		String hostname ;
		String ipaddress ;

		try {
			super.sfStart() ;
			sfLog().out("SmartFrog parent process starting") ;

			// get the fully qualified name of the host
			hostname = ((InetAddress)sfResolve("sfHost")).getCanonicalHostName() ;
			sfLog().out("Hostname is " + hostname) ;

			// get the IP address of this host
			ipaddress = ((InetAddress)sfResolve("sfHost")).getHostAddress() ;
			sfLog().out("IP address is " + ipaddress) ;

			sfCreateNewChild("Child", child, null) ;

			sfLog().out("SmartFrog parent process started") ;
		}
		catch (Throwable t) {
			t.printStackTrace() ;
			throw SmartFrogException.forward(t) ;
		}

	}

	public void sfTerminateWith(TerminationRecord tr) {
		try {
			sfLog().out("SmartFrog parent process terminating") ;
		}
		catch (Exception e) {
		}
		super.sfTerminateWith(tr) ;
	}
}

