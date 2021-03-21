package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._


abstract class Parameter[T](var k : String, var d : List[T])(implicit tag : TypeTag[T]) extends Ordered[Parameter[T]]{
  var data : List[T] = data;
  var key : String = key;
  val classType : TypeTag[T]=tag;
  var shortDescription : String = "Tooltip content goes here";
  var longDescription : String = "Something suitable for a dialog box";
  var description : String = "Larger document for the extended help topic (a complete web page?)";
  var rule : SyntaxChecker[T] = SyntaxChecker.create[T];
  def prototype[T](key:String, data : List[T])(implicit tag : TypeTag[T]):Parameter[T];
  
}


object Parameter{
  def create[T](implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T];
  def create[T](name : String, o : T*)(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](name,o.toList);
  def create[T](name:String,o:List[T])(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](name,o);
  def create[T](param :Parameter[T])(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](param);
  def create[T](param :Property[T])(implicit tag : TypeTag[T]) : Parameter[T] = BasicParameter.create[T](param);
}