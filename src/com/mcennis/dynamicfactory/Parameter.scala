package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._
import scala.collection.immutable.Map


abstract class Parameter[T](var key : String, var data : List[T])(implicit tag : TypeTag[T]) extends Ordered[Parameter[T]]{
  val classType : TypeTag[T]=tag;
  var shortDescription : String = "Tooltip content goes here";
  var longDescription : String = "Something suitable for a dialog box";
  var description : String = "Larger document for the extended help topic (a complete web page?)";
  var rule : SyntaxChecker[T] = SyntaxChecker.create[T];
  def prototype[T](key:String, data : List[T])(implicit tag : TypeTag[T]):Parameter[T];
  
}


object Parameter {//extends factory[Parameter[AnyRef]]{
  val a  = BasicParameter
  val b  = ParameterInternal
  val c  = Parameter
//  map : Map[String,(x: String): Parameter[T]] = ("Basic"->BasicParameter.create[T](x : Properties))
  def create[T](implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T]
  def create[T](name : String, o : T*)(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](name,o.toList)
  def create[T](name:String,o:List[T])(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](name,o)
  def create[T](param :Parameter[T])(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](param)
  def create[T](param :Property[T])(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](param)
  
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

}