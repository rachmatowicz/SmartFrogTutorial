This example shows the concurrent start of 4 components.

starting
--------
sfStart localhost TEST Compound.sf

Look to the logs to see that each of the four completes its
sfDeploy before any starts its sfStart() (and so on).

terminating
-----------
We can see the termination sequence by using the management interface
to terminate a single Prim component in the compound component.
The one we terminate will terminate; the others will terminate quietly.

