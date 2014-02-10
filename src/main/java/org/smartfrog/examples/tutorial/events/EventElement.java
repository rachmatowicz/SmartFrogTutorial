package org.smartfrog.examples.tutorial.events;

// package org.smartfrog.examples.tutorial.sequence ;

import java.rmi.RemoteException;

import org.smartfrog.sfcore.common.SmartFrogException;
import org.smartfrog.sfcore.prim.TerminationRecord;
import org.smartfrog.sfcore.workflow.eventbus.EventPrimImpl;

public class EventElement extends EventPrimImpl{

    /* any component specific declarations */
    public EventElement() throws RemoteException {

    }

    public synchronized void sfDeploy() throws
            RemoteException, SmartFrogException {

        super.sfDeploy();
    /* any component specific initialization code */
        sfLog().out("SmartFrog " + sfCompleteName() + " deployed");
    }

    public synchronized void sfStart() throws
            RemoteException, SmartFrogException {

        super.sfStart();

	/* any component specific start-up code */
        sfLog().out("SmartFrog " + sfCompleteName() + " started");

// 	    sendEvent("Event1") ;
// 	    sendEvent("Event2") ;
// 	    sendEvent("Event3") ;

	/* delay */
// 	try {
// 	    sendEvent("Event1") ;
// 	    sendEvent("Event2") ;
// 	    sendEvent("Event3") ;
// 	}
// 	catch(InterruptedException e) {}

    }

    public synchronized void sfTerminateWith(TerminationRecord tr) {

        sfLog().out("SmartFrog " + sfCompleteNameSafe() + " terminating");
	/* any component specific initialization code */
        super.sfTerminateWith(tr);
    }

    public synchronized void sfTerminateQuietlyWith(TerminationRecord tr) {

        sfLog().out("SmartFrog " + sfCompleteNameSafe() + " terminating quietly");
	/* any component specific initialization code */
        super.sfTerminateWith(tr);
    }

    /* handle events received */
    public void handleEvent(Object o) {
        String event = (String) o;
        sfLog().out("SmartFrog " + sfCompleteNameSafe() + " event received = " + event);
    }
}