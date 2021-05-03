package com.mcennis.dynamicfactory

import scala.collection.immutable.List
import scala.reflect.runtime.universe._

abstract class Parameter[+T](val key: String, val data: List[T])(implicit tag: TypeTag[T]) { //extends AbstractConfigGeneric with  Ordered[Parameter[T]] {
  val classType: String = tag.getClass.getPackage + "." + tag.getClass.getName;
  val shortDescription: String = "Tooltip content goes here";
  val longDescription: String = "Something suitable for a dialog box";
  val description: String = "Larger document for the extended help topic (a complete web page?)";
  val rule: SyntaxChecker[T] = SyntaxChecker.create[T];
};

class ParameterConfig {
  // TODO This is the entry point, rather than BasicParameter, for constructing Parameter objects
};

trait ParameterTrait{
  //  Object functions from above
  def prototype[K](obj : Parameter[K], k: String, d: List[K])(implicit tag: TypeTag[K]): Parameter[K];

  def prototype[K](obj : Parameter[K], k: String, d: List[K], sd: String, de: String, ld: String, r: SyntaxChecker[K])(implicit tag: TypeTag[K]): Parameter[K];

  def setKey[T](obj : Parameter[T], k: String)(implicit tag:TypeTag[T]): Parameter[T];

  def setShortDescription[T](obj : Parameter[T], sd: String)(implicit tag:TypeTag[T]): Parameter[T];

  def setDescription[T](obj : Parameter[T], d: String)(implicit tag:TypeTag[T]): Parameter[T];

  def setLongDescription[T](obj : Parameter[T], ld: String)(implicit tag:TypeTag[T]): Parameter[T];

  def setRule[T](obj : Parameter[T], r: SyntaxChecker[T ])(implicit tag:TypeTag[T]): Parameter[ T];
}

object Parameter {



  //extends factory[Parameter[AnyRef]]{
  // TODO Swapping these for the create statements in BasicParameter's object 
  def create[T](name: String, o: T*)(implicit tag: TypeTag[T]): Parameter[T] = new BasicParameter[T](name, o.toList, "", "", "", SyntaxChecker.create[T])

  def create[T](name: String, o: List[T])(implicit tag: TypeTag[T]): Parameter[T] = new BasicParameter[T](name, o, "", "", "", SyntaxChecker.create[T]);

  def create[T](param: Parameter[T])(implicit tag: TypeTag[T]): Parameter[T] = new BasicParameter[T](param.key, param.data, "", "", "", SyntaxChecker.create[T])

  def create[T](param: Property[T])(implicit tag: TypeTag[T]): Parameter[T] = new BasicParameter[T](param.key, param.data, "", "", "", SyntaxChecker.create[T])

  //  def create[T](cl:String, name:String,o:List[T])(implicit tag : TypeTag[T]) : Parameter[T] = {
  //    if(cl.equals("BasicParameter"){
  //      println("Basic Parameter Called")
  //      BasicParameter.create[T](name,o)
  //    }else if(cl.equals("ParameterInternal"){
  //      println("Parameter Internal Called")
  //      ParameterInternal.create[T](name,o)
  //    }else if(cl.equals("Parameter"){
  //      println("Parameter Called")
  //      Parameter.create[T](name,o)
  //    }
  //  }

};

object ParameterConfig {
  // TODO Swapping content in BasicParamter's ConfigBasicParameter object file for this location
};