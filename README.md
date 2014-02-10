SmartFrogTutorial
=================

using the components
---------------------
- this jar contains sample smartfrog components which can be deployed
- e.g. in order to deploy a very basic component:

-- start a smartfrog daemon one one or more nodes (in this case, the node localhost)
> sfDaemon

-- deploy the component MyPrimTest onto that node
> sfStart localhost TEST org/smartfrog/examples/tutorial/basic/MyPrimTest.sf

-- now undeploy the deployment
> sfTerminate localhost TEST

executing test cases
--------------------
- the ant build.xml file is used to support executing ant targets for deploying and undeploying
 SmartFrog instances
