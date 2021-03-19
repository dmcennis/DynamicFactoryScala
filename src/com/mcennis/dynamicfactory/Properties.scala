package com.mcennis.dynamicfactory

abstract class Properties {
    var map : Map[String,Parameter[AnyRef]]
    def prototype() : Properties;
    
    def get() : List[Parameter[AnyRef]] ;

    def get(s : String) : Parameter[AnyRef] ;

//    def getDefaultRestriction() : SyntaxChecker ;

    def check(t : Parameter[AnyRef]) : Boolean ;
    
    def check(props : Properties): Boolean;

    def merge(props : Properties) : PropertiesInternal;
    
    def mergeDefaults(props : Properties) : PropertiesInternal;
    
    def getQuick(s : String) : Parameter[AnyRef];
    
    def quickGet(s : String) : Parameter[AnyRef] = getQuick(s);
    
    
}

object Properties {
  def create : Properties = PropertiesImplementation.create
}