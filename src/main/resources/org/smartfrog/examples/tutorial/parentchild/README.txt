THis example uses two SF components, a Parent and a Child, to show
the difference between:

* static deployment, where all contained components are parsed, deployed and
are deployed in accoddance with the SF lifecycle
* dynamic deployment, where all components are parsed, but LAZY components
and not de[ployed as part of the lifecycle and can be deployed dynamically

LAZY is the keyword used to indicate that a value for an attribiute
should be parsed, but not deployed. The value is almost always a SF
component.

