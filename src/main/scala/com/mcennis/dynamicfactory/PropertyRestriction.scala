package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._

class PropertyRestriction[T](implicit tag: TypeTag[T]) extends SyntaxChecker[T] {


}

object PropertyRestriction extends SyntaxCheckerTrait{ //extends factory[PropertyRestriction[AnyRef]]{
  def create[T](implicit tag: TypeTag[T]): PropertyRestriction[T] = new PropertyRestriction[T];

  //TODO Implementation
  def check[T](obj: SyntaxChecker[T])(implicit tag: TypeTag[T]): Boolean = true;

  def check[T](obj: SyntaxChecker[T],param: Parameter[T])(implicit tag: TypeTag[T]): Boolean = return true;

  def check[T](obj: SyntaxChecker[T],property: Property[T], value: List[T])(implicit tag: TypeTag[T]): Boolean = return true;

  def check[T](obj: SyntaxChecker[T],t: String, value: List[T])(implicit tag: TypeTag[T]): Boolean = return true;

  def check[T](obj: SyntaxChecker[T],t: String, value: T)(implicit tag: TypeTag[T]): Boolean = return true;

  def check[T](obj: SyntaxChecker[T],property: Property[T], value: T)(implicit tag: TypeTag[T]): Boolean = return true;

  def check[T](obj: SyntaxChecker[T],property: Property[T])(implicit tag: TypeTag[T]): Boolean = return true;

  def getClassType[T](obj: SyntaxChecker[T])(implicit tag: TypeTag[T]): reflect.runtime.universe.TypeTag[T] = return tag;

  def getMaxCount[T](obj: SyntaxChecker[T])(implicit tag: TypeTag[T]): Int = return 1;

  def getMinCount[T](obj: SyntaxChecker[T])(implicit tag: TypeTag[T]): Int = return 1;

  def setRestriction[T](obj: SyntaxChecker[T],key: String, restriction: PropertyRestriction[T])(implicit tag: TypeTag[T]): SyntaxChecker[T] = new PropertyRestriction[T]

  def setDefaultRestriction[T](obj: SyntaxChecker[T],restriction: PropertyRestriction[T])(implicit tag: TypeTag[T]): SyntaxChecker[T] = new PropertyRestriction[T]

  def setMinCount[T](obj: SyntaxChecker[T],minCount: Int)(implicit tag: TypeTag[T]): SyntaxChecker[T] = new PropertyRestriction[T]

  def setMaxCount[T](obj: SyntaxChecker[T],maxCount: Int)(implicit tag: TypeTag[T]): SyntaxChecker[T] = new PropertyRestriction[T]

  //def setTest(test:propertyQuery[T])(implicit tag:TypeTag[T]) : SyntaxChecker[T]
  //def getTest[T](implicit tag:TypeTag[T]) : propertyQuery[T]
  def prototype[T](obj: SyntaxChecker[T])(implicit tag: TypeTag[T]): SyntaxChecker[T] = new PropertyRestriction[T]

}