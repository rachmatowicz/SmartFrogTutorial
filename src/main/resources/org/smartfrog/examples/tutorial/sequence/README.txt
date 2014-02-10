Try to determine the effect of Sequence on lifecycle.

mySequence extends Sequence {

  A extends Prim {
    sfClass a ;
  }
  B extends Prim {
    sfClass b ;
  }
  C extends Prim {
    sfClass c ;
  }
}

and print out the lifecycle messages to see which lifecycle phases
are executed in sequence.

