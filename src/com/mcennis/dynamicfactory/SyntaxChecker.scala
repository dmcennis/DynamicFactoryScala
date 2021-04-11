package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._

abstract class SyntaxChecker[+T](implicit tag:TypeTag[T]) {
    def check : Boolean;
//    def check(property : Property[T]) : Boolean;
//    def  check( property : Property[T], value: AnyRef) : Boolean;    
    def  check( t : String,  value: AnyRef) : Boolean;  
//    def  check( t : String, value : List[T]) : Boolean;
//    def  check( property : Property[T], value : List[T]) : Boolean;
//    def  check( param : Parameter[T]) : Boolean;
    def  getMinCount() : Int;
    def  getMaxCount() : Int;
//    def getClassType() : TypeTag[T];
     def setMinCount[T](minCount:Int)(implicit tag:TypeTag[T]) : SyntaxChecker[T];
     def setMaxCount[T](maxCount:Int)(implicit tag:TypeTag[T]) : SyntaxChecker[T];
}

object SyntaxChecker {//extends factory[SyntaxChecker[AnyRef]]{
  def create[T](implicit tag:TypeTag[T]) : SyntaxChecker[T] = PropertyRestriction.create[T]
}