package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._

abstract class ParameterInternal[T](key:String,data:List[T])(implicit tag:TypeTag[T])  extends Parameter[T](key,data){
  
}

object ParameterInternal{
  def create[T](implicit tag : TypeTag[T]) : ParameterInternal[T] = BasicParameter.create[T];
  def create[T](name : String, o : T*)(implicit tag : TypeTag[T]) : ParameterInternal[T] = BasicParameter.create[T](name,o.toList);
  def create[T](name:String,o:List[T])(implicit tag : TypeTag[T]) : ParameterInternal[T] = BasicParameter.create[T](name,o);
  def create[T](param :Parameter[T])(implicit tag : TypeTag[T]) : ParameterInternal[T] = BasicParameter.create[T](param);

}