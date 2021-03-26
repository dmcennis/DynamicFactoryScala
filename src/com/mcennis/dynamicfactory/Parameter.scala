package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._
import scala.collection.immutable.Map
import scala.collection.immutable.List

abstract class Parameter[T](val key : String, val data : List[T])(implicit tag : TypeTag[T]) {//extends AbstractConfigGeneric with  Ordered[Parameter[T]] {
  val classType : String = tag.getClass.getPackage+"."+tag.getClass.getName;
  val shortDescription : String = "Tooltip content goes here";
  val longDescription : String = "Something suitable for a dialog box";
  val description : String = "Larger document for the extended help topic (a complete web page?)";
  val rule : SyntaxChecker[T] = SyntaxChecker.create[T];
  
  def prototype(key:String, data:List[T]):Parameter[T];
  def prototype(key:String,data:List[T],sd : String, d:String, ld:String,r:SyntaxChecker[T]):Parameter[T];
};

class ParameterConfig {
  
};

object Parameter{//extends factory[Parameter[AnyRef]]{
//  val a  = BasicParameter
//  val b  = ParameterInternal
//  val c  = Parameter
//  map : Map[String,(x: String): Parameter[T]] = ("Basic"->BasicParameter.create[T](x : Properties))
//  def create[T](implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T]
  def create[T](name : String, o : T*)(implicit tag : TypeTag[T]) : Parameter[T] = new BasicParameter[T](name,o.toList,"","","",SyntaxChecker.create[T])
//  def create[T](name:String,o:List[T])(implicit tag : TypeTag[T]) : Parameter[T] = new BasicParameter[T](name,o)
  def create[T](param :Parameter[T])(implicit tag : TypeTag[T]) : Parameter[T] = new BasicParameter[T](param.key,param.data,"","","",SyntaxChecker.create[T])
  def create[T](param :Property[T])(implicit tag : TypeTag[T]) : Parameter[T] = new BasicParameter[T](param.key,param.data,"","","",SyntaxChecker.create[T])
  
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

object ParameterConfig{
  
};