package org.smartfrog.examples.tutorial.basic;

import java.rmi.RemoteException;

import org.smartfrog.sfcore.common.SmartFrogException;
import org.smartfrog.sfcore.common.SmartFrogResolutionException;
import org.smartfrog.sfcore.prim.Prim;
import org.smartfrog.sfcore.prim.PrimImpl;
import org.smartfrog.sfcore.prim.TerminationRecord;

public class MyPrim extends PrimImpl implements Prim {

	/* any component specific declarations */
	public MyPrim() throws RemoteException {

	}

	public synchronized void sfDeploy() throws 
		RemoteException, SmartFrogException {

		super.sfDeploy() ;
		/* any component specific initialization code */
		sfLog().out("SmartFrog " + sfCompleteName() + " deployed") ;
	}

	public synchronized void sfStart() throws 
		RemoteException, SmartFrogException {

		super.sfStart() ;
		/* any component specific start-up code */
		sfLog().out("SmartFrog " + sfCompleteName() + " started") ;

		try {
			String fred = (String) sfResolve("sfFred") ;
			System.out.println("sfFred = " + fred) ;
		}
		catch(ClassCastException e) {
			sfLog().out("Class cast exception occurred") ;
		}
		catch(SmartFrogResolutionException e) {
			sfLog().out("SF Resolution  exception occurred") ;
		}
		catch(RemoteException e) {
			sfLog().out("Remote RMI exception occurred") ;
		}
	}

	public synchronized void sfTerminateWith(TerminationRecord tr) {

		sfLog().out("SmartFrog " + sfCompleteNameSafe() + " terminating") ;
		/* any component specific initialization code */
		super.sfTerminateWith(tr) ;
	}

	public synchronized void sfTerminateQuietlyWith(TerminationRecord tr) {

		sfLog().out("SmartFrog " + sfCompleteNameSafe() + " terminating quietly") ;
		/* any component specific initialization code */
		super.sfTerminateWith(tr) ;
	}


	/* any component specific methods go here */
}
