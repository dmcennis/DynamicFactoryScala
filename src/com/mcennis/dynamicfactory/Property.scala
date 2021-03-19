package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._

abstract class Property[T] (var key:String, var data : List[T])(implicit tag : TypeTag[T]){
  val classType : TypeTag[T]=tag;
  def prototype[T](key:String, data : List[T])(implicit tag : TypeTag[T]):Property[T];
  def add(item : T):Property[T];
}

object Property{
  ;
}