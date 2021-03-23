package com.mcennis.dynamicfactory

//import scala.reflect.runtime.universe._
//
//abstract class Properties {
//    
//    var defaultRestriction : SyntaxChecker[_ <: AnyRef];
//    def prototype() : Properties;
//    def get() : List[String] ;
//    def check(t : Parameter[AnyRef]) : Boolean ;
//    def check(props : Properties): Boolean;
////    def getQuick(s : String) : AnyRef;
////    def quickGet(s : String) : AnyRef = getQuick(s);
//    def quickCheck[Value](S : String)(implicit tag : TypeTag[Value])  : Boolean;
//}
//
//object Properties {//extends factory[Properties]{
//  def create : Properties = PropertiesImplementation.create
//}