package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._

class BasicProperty[T] (key:String, data : List[T])(implicit tag : TypeTag[T]) extends Property(key:String, data : List[T]) {
  def prototype():Property[T] = return new BasicProperty(key,data);
  def add(item : T):Property[T] = {
    //data = (item :: data);
    return this;
  }
  def prototype[T](k:String, d : List[T])(implicit tag : TypeTag[T]):Property[T] = new BasicProperty[T](k,d);
}

object BasicProperty{
  def create[T](implicit tag : TypeTag[T]):BasicProperty[T] = new BasicProperty[T]("",Nil)
  def create[T](key:String,data:List[T])(implicit tag : TypeTag[T]):BasicProperty[T] = new BasicProperty(key,data)
  def create[T](key:String,data:T*)(implicit tag : TypeTag[T]):BasicProperty[T] = new BasicProperty(key,data.toList)
}