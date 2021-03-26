package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._

abstract class SyntaxObject[+T] extends SyntaxChecker[T]{
    def setRestriction[T](key:String, restriction: PropertyRestriction[T])(implicit tag:TypeTag[T]) : SyntaxObject[T] 
    def setDefaultRestriction[T](restriction:PropertyRestriction[T])(implicit tag:TypeTag[T]) : SyntaxObject[T]    
    def setMinCount[T](minCount:Int)(implicit tag:TypeTag[T]) : SyntaxObject[T]   
    def setMaxCount[T](maxCount:Int)(implicit tag:TypeTag[T]) : SyntaxObject[T]
    //def setTest(test:propertyQuery[T])(implicit tag:TypeTag[T]) : SyntaxObject[T]   
    //def getTest[T](implicit tag:TypeTag[T]) : propertyQuery[T]  
    def prototype[T](implicit tag:TypeTag[T]) : SyntaxObject[T]
}

object SyntaxObject {// extends factory[SyntaxObject[AnyRef]]{
  def getDefaultRestriction[T](implicit tag : TypeTag[T]) : PropertyRestriction[T] = PropertyRestriction.create[T]
  def create[T](implicit tag : TypeTag[T]) : SyntaxObject[T] = PropertyRestriction.create[T]
}