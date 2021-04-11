package com.mcennis.dynamicfactory

import scala.reflect.runtime.universe._
import scala.collection.immutable.List
import java.lang.reflect.Field

class BasicParameter[T] (
    key:String, 
    data : List[T],
    shortDescription:String="",
    description:String="", 
    longDescription:String="", 
    rule:SyntaxChecker[T])
    (implicit tag : TypeTag[T])
    extends Parameter[T](
        key,
        data) 
        {
//  rule = PropertyRestriction
  def prototype[K](k:String, d : List[K])(implicit tag:TypeTag[K]):Parameter[K] = new BasicParameter[K](
      k,
      d,
      shortDescription,
      description,
      longDescription,
      null);
  def prototype[K](k:String, d : List[K], sD:String,de:String,lD:String,r:SyntaxChecker[K])(implicit tag:TypeTag[K]):Parameter[K] = new BasicParameter[K](
      k,
      d,
      sD,
      de,
      lD,
      r)
  def setKey(k:String):Parameter[T] = new BasicParameter[T](k,data,shortDescription,description,longDescription,rule)
  def setShortDescription(sd:String):Parameter[T] = new BasicParameter[T](key,data,sd,description,longDescription,rule)
  def setDescription(d:String):Parameter[T] = new BasicParameter[T](key,data,shortDescription,d,longDescription,rule)
  def setLongDescription(ld:String):Parameter[T] = new BasicParameter[T](key,data,shortDescription,description,ld,rule)
  def setRule (r:SyntaxChecker[T]):Parameter[T] = new BasicParameter[T](key,data,shortDescription,description,longDescription,r)
  def set(value: List[T]): Parameter[T] = new BasicParameter[T](key,value,shortDescription,description,longDescription,rule)
  def set(value: T): Parameter[T] = new BasicParameter[T](key,List[T](value),shortDescription,description,longDescription,rule)
  def set(prop: Property[T]): Parameter[T] = new BasicParameter[T](prop.key,prop.data,shortDescription,description,longDescription,rule)
 
  def add(value: List[T]): Parameter[T] = new BasicParameter[T](key,data ++ value,shortDescription,description,longDescription,rule)
  def add(value: T): Parameter[T] = new BasicParameter[T](key,value :: data,shortDescription,description,longDescription,rule)
  def clear: BasicParameter[T] = new BasicParameter[T](key,Nil,shortDescription,description,longDescription,rule)  
  def compare(right: Parameter[T]): Int = {
    var answer:Int=0;
    answer = key.compareTo(right.key);
    if(answer !=0){
      return answer;
    }
    answer = data.lengthCompare(right.data.length)
    if (answer != 0) {
      return answer;
    }

    if(data.isEmpty){
      return -1;
    }
//        if(tag..isInstanceOf[Comparable]){
//          return 0;
//        }
//                if(tag.isInstanceOf[Ordered[T]]) {
//                  
//        for(pair : (T,T) <- data.zip(right.data)){
//          if(pair._1.asInstanceOf(Ordered). != pair._2){
//            return 1;
//          }
//        }
//                }
    0
  }
  def add(r:SyntaxChecker[T]):BasicParameter[T] = new BasicParameter[T](key,data,shortDescription,description,longDescription,r)
  def getObject: BasicParameter.type = BasicParameter;
};

class ConfigBasicParameter[T](     
    override val className:Parameter[String],
    override val shortDescription:Parameter[String],
    override val description:Parameter[String],
    override val longDescription:Parameter[String],
    override val rule:Parameter[SyntaxChecker[T]],
    val key:Parameter[String],
    val data:Parameter[T]  
)
   extends AbstractConfigGeneric(
       className,
       shortDescription,
       description,
       longDescription)
{
  def this() = {
    this(
        new BasicParameter[String](
        "ClassName", 
        List("Default"),
        "Which version of this class to instantiate",
        "String of the desired class to instantiate which must be this interface's type or that of a subclass",
        "Provide the constructor the string representing the classname of the desired subclass (or current class or interface) to implement. When creating a ConfigBasicParameter object, this will construct a configuration object specific to that type which can then be matched and constructed, then its singelton factory called, then construct the object from within a (possibly unknown, without source code) subclass.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   ),
 
        new BasicParameter[String](
        "ShortDescription", 
        List("Default"),
        "A short description suitable for a tooltip",
        "Provides a relatively short - under one sentence - designed to b displayed in a hover tooltip or other extremely short display space.",
        "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the shortest version, designed for quick, terse display of relatively small amounts of data about this object.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   ),
 
    new BasicParameter[String](
        "Description", 
        List("Default"),
        "A description suitable for a dialog box",
        "Provides a consise description of this object - designed to be displayed in a single dialog box with moderate space constraints.",
        "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the mid-length version, designed for on-the-fly display of relatively complete data about this object.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   ),
  
    new BasicParameter[String](
        "LongDescription", 
        List("Default"),
        "A long description suitable for a helpfile entry",
        "Provides a lengthy, in-depth description of the object suitable for a book or extensive help file system.",
        "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the extended version, designed to provide every possible detail in extended and verbose documentation.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   ),
     
    null,
    
    new BasicParameter[String](
        "Key", 
        List("BasicParameter"),
        "The hashtag String of defining this parameter's name",
        "The String providing a unique name within at least the context of this configuration class serving as a hashtag for finding and reading configuration parameters for this object.",
        "The 'Key' is a String provided for each and every paramter object. While enforcement of uniqueness is usually not present, a common key String forces the assumption that thye represent the same content and conflicting versions should either be merged or a SyntaxError constructe and thrown.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   ),
  
    null
  );
  }
//    val shortDescription:ParameterInternal[String] = new BasicParameter[String](
//        "ClassName", 
//        List("Default"),
//        "The Location of the name of the class to instantiate",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
//  
//    val description:ParameterInternal[String] = new BasicParameter[String](
//        "ClassName", 
//        List("Default"),
//        "The Location of the name of the class to instantiate",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
//  
//    val longDescription:ParameterInternal[String] = new BasicParameter[String](
//        "ClassName", 
//        List("Default"),
//        "The Location of the name of the class to instantiate",
//        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
//        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
//        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
def getObject: AbstractConfigGenericSingleton = return ConfigBasicParameter;
  
  def merge[K](source:AbstractConfigGeneric)(implicit tag:TypeTag[K]): AbstractConfigGeneric = {
      val k = {
        if(this.key==null){
        source match {
          case x:ConfigBasicParameter[T] =>  x.key match{
            case y: BasicParameter[String] =>  y;
            case _ => null
          }
          case _ =>  null;
        };
      }
      null;
      };
      val d = {
        if(this.data==null){
          source match {
            case x:ConfigBasicParameter[K] =>  if(x.data!=null){
              x.data;
            }
          };
          null;
        }
        this.data match {
          case x:ConfigBasicParameter[K] =>  if(x.data!=null){
            source match {
              case y:ConfigBasicParameter[K] =>  if(y.data!=null){
                this.data.data ::: x.data.data;
              }
            }
          }
        };        
        this.data;
      };
      val sh = {
                if(this.shortDescription==null){
          source match {
            case x:ConfigBasicParameter[T] =>  if(x.shortDescription!=null){
              x.shortDescription  ;
            }
          };
          null;
        }
        this.shortDescription;
      };
      val md = {
                if(this.description==null){
          source match {
            case x:ConfigBasicParameter[T] =>  if(x.description!=null){
              x.description  ;
            }
          };
          null;
        }
        this.description;
      };
      val ld = {
                if(this.longDescription==null){
          source match {
            case x:ConfigBasicParameter[T] =>  if(x.longDescription!=null){
              x.longDescription  ;
            }
          };
          null;
        }
        this.longDescription;
      };
      val r = {
        if(this.rule==null){
          source match {
            case x:ConfigBasicParameter[T] =>  if(x.rule!=null){
              x.rule  ;
            }
          };
          null;
        }
        // TODO combine rules inot new rule if possible
//        source match {
//          case x:ConfigBasicParameter[T] =>  if(x.rule!=null){
//            this.rule;
//          }
//        };        
        this.rule;
      };
      val cn = {
        if(this.className==null){
          source match {
            case x:ConfigBasicParameter[T] =>  if(x.className!=null){
              x.className  ;
            }
          };
          null;
        }
           
        this.className;
      };

      new ConfigBasicParameter[T](cn,sh,md,ld,r,k,d);
  }
/** As seen from class ConfigBasicParameter, the missing signatures are as follows.
 *  For convenience, these are usable as stub implementations.
 */
  // Members declared in com.mcennis.dynamicfactory.AbstractConfigGeneric
  def merge[K](implicit tag: reflect.runtime.universe.TypeTag[K]): com.mcennis.dynamicfactory.AbstractConfigGeneric = {
    ConfigBasicParameter.defaultSettings.data.head match{
      case x:ConfigBasicParameter[K] => this.merge[K](x);
      case _ => new ConfigBasicParameter[K](
          new BasicParameter[String]("Error",List("Error"),"","","",null),
         new BasicParameter[String]("Error",List("Error"),"","","",null),
          new BasicParameter[String]("Error",List("Error"),"","","",null),
          new BasicParameter[String]("Error",List("Error"),"","","",null),
          null,
          new BasicParameter[String]("Error",List("Error"),"","","",null),
          null);
    }
  }
  
  // Members declared in com.mcennis.dynamicfactory.ConfigBasicParameter
  def merge: com.mcennis.dynamicfactory.AbstractConfigGeneric = ???
//  def setData(d: com.mcennis.dynamicfactory.Parameter[T]): com.mcennis.dynamicfactory
  
//  def setData(d:Parameter[T]):AbstractConfigGeneric 
};


object BasicParameter {
    
  def create[T](config:ConfigBasicParameter[T])(implicit tag:TypeTag[T]) : BasicParameter[T] = return new BasicParameter[T](
      config.key.data.head,
      config.data.data,
      config.shortDescription.data.head,
      config.description.data.head,
      config.longDescription.data.head,
      config.rule.data.head);
      
};

object ConfigBasicParameter extends AbstractConfigGenericSingleton{
    default = new BasicParameter[String](
        "Default", 
        List("BasicParameter"),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1));
    
    defaultSettings = new BasicParameter[ConfigBasicParameter[String]](
        "Default", 
        List(new ConfigBasicParameter[String]),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        null);

    availableClasses = new BasicParameter[ConfigBasicParameter[String]](
        "availableClasses",
        List(new ConfigBasicParameter[String]),
        
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[ConfigBasicParameter[String]].setMinCount[ConfigBasicParameter[String]](1).setMaxCount[ConfigBasicParameter[String]](Int.MaxValue) );

       shortDescription = new BasicParameter[String](
        "shortDescription", 
        List("Default"),
        "A short description suitable for a tooltip",
        "Provides a relatively short - under one sentence - designed to b displayed in a hover tooltip or other extremely short display space.",
        "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the shortest version, designed for quick, terse display of relatively small amounts of data about this object.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
 
    description = new BasicParameter[String](
        "description", 
        List("Default"),
        "A description suitable for a dialog box",
        "Provides a consise description of this object - designed to be displayed in a single dialog box with moderate space constraints.",
        "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the mid-length version, designed for on-the-fly display of relatively complete data about this object.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );
  
    longDescription = new BasicParameter[String](
        "longDescription", 
        List("Default"),
        "A long description suitable for a helpfile entry",
        "Provides a lengthy, in-depth description of the object suitable for a book or extensive help file system.",
        "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the extended version, designed to provide every possible detail in extended and verbose documentation.",
        PropertyRestriction.create[String].setMinCount[String](1).setMaxCount[String](1)   );

    def mapConfig[T](default:Parameter[ConfigBasicParameter[AnyRef]])(implicit tag:TypeTag[T]):Parameter[ConfigBasicParameter[T]] = return new BasicParameter[ConfigBasicParameter[T]](
        "Default", 
        List(new ConfigBasicParameter[T]),
        "The default class type created in this factory",
        "When choosing between classes of a given interface, this variant is the default if no other is chosen",
        "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
        PropertyRestriction.create[ConfigBasicParameter[T]].setMinCount[ConfigBasicParameter[T]](0).setMaxCount[ConfigBasicParameter[T]](Int.MaxValue));
    
    

    def prototype[T](implicit tag:TypeTag[T]):ConfigBasicParameter[T]  = new ConfigBasicParameter[T]

    def prototype[T](props:Parameter[_ <: ConfigBasicParameter[T]] )(implicit tag:TypeTag[T]) : ConfigBasicParameter[T] = new ConfigBasicParameter[T]()

    override def getObject: BasicParameter.type = BasicParameter;
    
    def geParameter: List[Object] = {
      var ret : List[Object] = Nil
        for(entry:Field  <- this.getClass().getDeclaredFields if entry.getClass.getName.contains("Parameter")){
          ret = entry :: ret
        }
        ret;
    }
    
    def getParameter(t:String): Object = {
        for(entry:Field  <- this.getClass().getDeclaredFields if entry.getClass.getName.contains("Parameter")){
          if(entry.getName.equals(t)){
            return entry.get()
          }
        }
        return this;
    }
    
    def addType(t:String,proto:ConfigBasicParameter[String]): ConfigBasicParameter.type = {
        if(proto == null){
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No org.dynamicfactory.property obejct provided");
          throw new Exception("Null Factory Provided")
        }
        
        this.availableClasses = new BasicParameter[AbstractConfigGeneric](
            this.availableClasses.key,
            proto :: this.availableClasses.data,
            this.availableClasses.shortDescription,
            this.availableClasses.description,
            this.availableClasses.longDescription,
            this.availableClasses.rule);
        this;
//        if(t == null){
////            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Null org.dynamicfactory.property class name added");
//        }   
        
    }
    
    def check( props: AbstractConfigGeneric):Boolean = {
        var good:Boolean = true;
//        for(p <-  props.get() if !this.defaultSettings.check(p)){
//          false;
//        }
        true       
    }
    
    def check(parameter:Parameter[AnyRef]):Boolean = {
        // override with config specifics
        return true;
        //return properties.check(parameter);
    }

    def create[T](implicit tag:TypeTag[T]):Parameter[T] = return create[T](default.data.head,new ConfigBasicParameter[T]);

    def create[T](name:String)(implicit tag:TypeTag[T]):Parameter[T] = return this.create[T](name,(new ConfigBasicParameter[T]))
    
    def create[T](name:String, props:ConfigBasicParameter[T] )(implicit tag:TypeTag[T]):Parameter[T]= {
      for(a <- ConfigBasicParameter.availableClasses.data if a.getClass.getName.equals(name)){
        // verify the classname is a valid ConfigBasicParameter subclass
        a.getObject.getObject match{
          case builder: BasicParameter.type => builder.create(props);
        }
        // verify the configuration file is compatible wth the subclass constructor
        
        
//          return ((a.getObject).getObject).create[T](props);
      }
      return BasicParameter.create[T](props);
    }
    
    
    def create[R]( props:ConfigBasicParameter[R])(implicit tag:TypeTag[R]) : Parameter[R] = create[R](default.data.head,props);
};






