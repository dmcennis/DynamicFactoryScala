package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._

abstract class ParameterInternal[T](key:String,data:List[T])(implicit tag:TypeTag[T])  extends Parameter[T](key,data){
//  def add(value : T) : Parameter[T];
//  def add(value : List[T]) : Parameter[T];  
//  def set(prop: Property[T]) : Parameter[T];
//  def set(value : T):Parameter[T];
//  def set(value : List[T]):Parameter[T];
  def clear():Parameter[T];
  
}

object ParameterInternal {//extends factory[ParameterInternal[AnyRef]]{
  def create[T](param :Parameter[T])(implicit tag : TypeTag[T]) : ParameterInternal[T] = new BasicParameter[T](param.key,param.data,param.shortDescription,param.description,param.longDescription,param.rule);

}