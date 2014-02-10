package org.smartfrog.examples.tutorial.sequence;


import java.rmi.RemoteException;

import org.smartfrog.sfcore.common.SmartFrogException;
import org.smartfrog.sfcore.prim.Prim;
import org.smartfrog.sfcore.prim.PrimImpl;
import org.smartfrog.sfcore.prim.TerminationRecord;
import org.smartfrog.sfcore.utils.ComponentHelper;

public class SequenceElement extends PrimImpl implements Prim {

    /* any component specific declarations */
    public SequenceElement() throws RemoteException {

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

        sfLog().out("SmartFrog " + sfCompleteName() + " working");

 		/* delay */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        sfLog().out("SmartFrog " + sfCompleteName() + " finished working");

        // sfSelfDetatchOrTerminate(String terminationType, String terminationMessage, Reference refid, Throwable thrown) ;
        // attrributes in component to specify desired action: sfShouldDetatch, sfShouldTerminate, sfShouldTerminateQuietly
        // terminationType = "normal", "abnormal" "externalReferenceDead"

        // new ComponentHelper(this).sfSelfDetachAndOrTerminate(null, "SequenceElement", this.sfCompleteNameSafe(), null);
        new ComponentHelper(this).sfSelfDetachAndOrTerminate("normal", "SequenceElement", this.sfCompleteNameSafe(), null);

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


 	/* any component specific methods go here */

}

