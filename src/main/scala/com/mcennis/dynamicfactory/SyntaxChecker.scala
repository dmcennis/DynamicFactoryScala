package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._

trait SyntaxCheckerTrait {
//  def create[T](implicit tag: TypeTag[T]): PropertyRestriction[T] = new PropertyRestriction[T];

  //TODO Implementation
  def check[T](obj: SyntaxChecker[T])(implicit tag: TypeTag[T]): Boolean;

  def check[T](obj: SyntaxChecker[T],param: Parameter[T])(implicit tag: TypeTag[T]): Boolean;

  def check[T](obj: SyntaxChecker[T],property: Property[T], value: List[T])(implicit tag: TypeTag[T]): Boolean ;

  def check[T](obj: SyntaxChecker[T],t: String, value: List[T])(implicit tag: TypeTag[T]): Boolean ;

  def check[T](obj: SyntaxChecker[T],t: String, value: T)(implicit tag: TypeTag[T]): Boolean ;

  def check[T](obj: SyntaxChecker[T],property: Property[T], value: T)(implicit tag: TypeTag[T]): Boolean ;

  def check[T](obj: SyntaxChecker[T],property: Property[T])(implicit tag: TypeTag[T]): Boolean ;

  def getClassType[T](obj: SyntaxChecker[T])(implicit tag: TypeTag[T]): reflect.runtime.universe.TypeTag[T];

  def getMaxCount[T](obj: SyntaxChecker[T])(implicit tag: TypeTag[T]): Int ;

  def getMinCount[T](obj: SyntaxChecker[T])(implicit tag: TypeTag[T]): Int ;

  def setRestriction[T](obj: SyntaxChecker[T],key: String, restriction: PropertyRestriction[T])(implicit tag: TypeTag[T]): SyntaxChecker[T]

  def setDefaultRestriction[T](obj: SyntaxChecker[T],restriction: PropertyRestriction[T])(implicit tag: TypeTag[T]): SyntaxChecker[T]

  def setMinCount[T](obj: SyntaxChecker[T],minCount: Int)(implicit tag: TypeTag[T]): SyntaxChecker[T]

  def setMaxCount[T](obj: SyntaxChecker[T],maxCount: Int)(implicit tag: TypeTag[T]): SyntaxChecker[T]

  //def setTest(test:propertyQuery[T])(implicit tag:TypeTag[T]) : SyntaxChecker[T]
  //def getTest[T](implicit tag:TypeTag[T]) : propertyQuery[T]
  def prototype[T](obj: SyntaxChecker[T])(implicit tag: TypeTag[T]): SyntaxChecker[T];

  /////

}

abstract class SyntaxChecker[+T](implicit tag: TypeTag[T]) {
}

object SyntaxChecker { //extends factory[SyntaxChecker[AnyRef]]{
  // TODO Create Hierarchy from SyntaxChecker
  def create[T](implicit tag: TypeTag[T]): SyntaxChecker[T] = PropertyRestriction.create[T]
}