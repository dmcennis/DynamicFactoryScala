package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._

class PropertyRestriction[T](implicit tag : TypeTag[T]) extends SyntaxObject[T]{

  /** As seen from class PropertyRestriction, the missing signatures are as follows.
 *  For convenience, these are usable as stub implementations.
 */
  def check(): Boolean = true;
  def check(param: Parameter[T]): Boolean = return true;
  def check(property: Property[T],value: List[T]): Boolean = return true;
  def check(t: String,value: List[T]): Boolean = return true;
  def check(t: String,value: AnyRef): Boolean = return true;
  def check(property: Property[T],value: AnyRef): Boolean = return true;
  def check(property: Property[T]): Boolean = return true;
  def getClassType(): reflect.runtime.universe.TypeTag[T] = return tag;
  def getMaxCount(): Int = return 1;
  def getMinCount(): Int = return 1;
  
  def setRestriction[T](key:String, restriction: PropertyRestriction[T])(implicit tag:TypeTag[T]) : SyntaxObject[T] = new PropertyRestriction[T]
  def setDefaultRestriction[T](restriction:PropertyRestriction[T])(implicit tag:TypeTag[T]) : SyntaxObject[T] = new PropertyRestriction[T]   
  def setMinCount[T](minCount:Int)(implicit tag:TypeTag[T]) : SyntaxObject[T] = new PropertyRestriction[T] 
  def setMaxCount[T](maxCount:Int)(implicit tag:TypeTag[T]) : SyntaxObject[T] = new PropertyRestriction[T]
    //def setTest(test:propertyQuery[T])(implicit tag:TypeTag[T]) : SyntaxObject[T]   
    //def getTest[T](implicit tag:TypeTag[T]) : propertyQuery[T]  
  def prototype[T](implicit tag:TypeTag[T]) : SyntaxObject[T] = new PropertyRestriction[T]

}

object PropertyRestriction{
  def create[T](implicit tag : TypeTag[T]) : PropertyRestriction[T] = new PropertyRestriction[T];
}