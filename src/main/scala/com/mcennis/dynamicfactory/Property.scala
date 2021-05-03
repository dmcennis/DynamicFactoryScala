package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._

abstract class Property[T](
                            val key: String,
                            val data: List[T])
                          (implicit tag: TypeTag[T])
{
  val classType: TypeTag[T] = tag;

  def prototype[T](key: String, data: List[T])(implicit tag: TypeTag[T]): Property[T];

  def add(item: T): Property[T];

  def setKey(k: String): Property[T];

  def set(item: T): Property[T];

  def set(item:List[T]): Property[T];
}

object Property { //extends factory[Property[AnyRef]]{
}