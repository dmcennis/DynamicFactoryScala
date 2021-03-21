package com.mcennis.dynamicfactory

abstract class PropertiesInternal extends Properties{
      def set(value : Parameter[AnyRef]) : PropertiesInternal;
      def add(t:String,value:AnyRef*) : PropertiesInternal 
      def add(t:String,value:Property[AnyRef]) : PropertiesInternal
      def add(t:String,value:Parameter[AnyRef]) : PropertiesInternal
      def add(t:String,value:List[AnyRef]) : PropertiesInternal
      def merge(props : Properties) : PropertiesInternal     
      def mergeDefaults(props : Properties) : PropertiesInternal
    

}

object PropertiesInternal{
  def create : Properties = PropertiesImplementation.create
}