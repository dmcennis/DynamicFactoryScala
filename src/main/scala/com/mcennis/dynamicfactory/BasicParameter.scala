package com.mcennis.dynamicfactory

import java.lang.reflect.Field
import scala.collection.immutable.List
import scala.reflect.runtime.universe._

class BasicParameter[+T](
                          key: String,
                          data: List[T],
                          shortDescription: String = "",
                          description: String = "",
                          longDescription: String = "",
                          rule: SyntaxChecker[T])
                        (implicit tag: TypeTag[T])
  extends Parameter[T](
    key,
    data) {
  //          val shortDescription: String;
  //          val description: String;
  //          val longDescription: String;
  //  rule = PropertyRestriction

  def getObject: BasicParameter.type = BasicParameter;
};

class ConfigBasicParameter[+T <: Any](
                                       override val className: Parameter[String],
                                       override val shortDescription: Parameter[String],
                                       override val description: Parameter[String],
                                       override val longDescription: Parameter[String],
                                       override val rule: Parameter[SyntaxChecker[T]],
                                       val key: Parameter[String],
                                       val data: Parameter[T]
                                     )
  extends AbstractConfigGeneric(
    className,
    shortDescription,
    description,
    longDescription) {
  def this() = {
    this(
      new BasicParameter[String](
        "ClassName",
        List("Default"),
        "Which version of this class to instantiate",
        "String of the desired class to instantiate which must be this interface's type or that of a subclass",
        "Provide the constructor the string representing the classname of the desired subclass (or current class or interface) to implement. When creating a ConfigBasicParameter object, this will construct a configuration object specific to that type which can then be matched and constructed, then its singelton factory called, then construct the object from within a (possibly unknown, without source code) subclass.",
        PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1)),

      new BasicParameter[String](
        "ShortDescription",
        List("Default"),
        "A short description suitable for a tooltip",
        "Provides a relatively short - under one sentence - designed to b displayed in a hover tooltip or other extremely short display space.",
        "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the shortest version, designed for quick, terse display of relatively small amounts of data about this object.",
        PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1)),

      new BasicParameter[String](
        "Description",
        List("Default"),
        "A description suitable for a dialog box",
        "Provides a consise description of this object - designed to be displayed in a single dialog box with moderate space constraints.",
        "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the mid-length version, designed for on-the-fly display of relatively complete data about this object.",
        PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1)),

      new BasicParameter[String](
        "LongDescription",
        List("Default"),
        "A long description suitable for a helpfile entry",
        "Provides a lengthy, in-depth description of the object suitable for a book or extensive help file system.",
        "As part of 'documentation is code', this parameter provides code-queryable human documentation of this object so external tools can present documentation on unknown new modules without customizing these kits for these modules. This extends Model-View-Contrroller including all documentation of a class or interface into a syntax for querying the object itself. This is the extended version, designed to provide every possible detail in extended and verbose documentation.",
        PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1)),

      null,

      new BasicParameter[String](
        "Key",
        List("BasicParameter"),
        "The hashtag String defining this parameter's name",
        "The String providing a unique name within at least the context of this configuration class serving as a hashtag for finding and reading configuration parameters for this object.",
        "The 'Key' is a String provided for each and every paramter object. While enforcement of uniqueness is usually not present, a common key String forces the assumption that thye represent the same content and conflicting versions should either be merged or a SyntaxError constructe and thrown.",
        PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1)),

      null
    );
  }

  override def getObject: ConfigBasicParameter.type = return ConfigBasicParameter;

  /** As seen from class ConfigBasicParameter, the missing signatures are as follows.
   * For convenience, these are usable as stub implementations.
   */
  // Members declared in com.mcennis.com.mcennis.dynamicfactory.AbstractConfigGeneric
  def merge[K](implicit tag: reflect.runtime.universe.TypeTag[K]): AbstractConfigGeneric = {
    ConfigBasicParameter.defaultSettings.data.head match {
      case x: ConfigBasicParameter[K] => this.merge[K](x);
      case _ => new ConfigBasicParameter[K](
        new BasicParameter[String]("Error", List("Error"), "", "", "", null),
        new BasicParameter[String]("Error", List("Error"), "", "", "", null),
        new BasicParameter[String]("Error", List("Error"), "", "", "", null),
        new BasicParameter[String]("Error", List("Error"), "", "", "", null),
        null,
        new BasicParameter[String]("Error", List("Error"), "", "", "", null),
        null);
    }
  }

  def merge[K](source: AbstractConfigGeneric)(implicit tag: TypeTag[K]): AbstractConfigGeneric = {
    val k = {
      if (this.key == null) {
        source match {
          case x: ConfigBasicParameter[T] => x.key match {
            case y: BasicParameter[String] => y;
            case _ => null
          }
          case _ => null;
        };
      }
      null;
    };
    val d = {
      if (this.data == null) {
        source match {
          case x: ConfigBasicParameter[K] => if (x.data != null) {
            x.data;
          }
        };
        null;
      }
      this.data match {
        case x: ConfigBasicParameter[K] => if (x.data != null) {
          source match {
            case y: ConfigBasicParameter[K] => if (y.data != null) {
              this.data.data ::: x.data.data;
            }
          }
        }
      };
      this.data;
    };
    val sh = {
      if (this.shortDescription == null) {
        source match {
          case x: ConfigBasicParameter[T] => if (x.shortDescription != null) {
            x.shortDescription;
          }
        };
        null;
      }
      this.shortDescription;
    };
    val md = {
      if (this.description == null) {
        source match {
          case x: ConfigBasicParameter[T] => if (x.description != null) {
            x.description;
          }
        };
        null;
      }
      this.description;
    };
    val ld = {
      if (this.longDescription == null) {
        source match {
          case x: ConfigBasicParameter[T] => if (x.longDescription != null) {
            x.longDescription;
          }
        };
        null;
      }
      this.longDescription;
    };
    val r = {
      if (this.rule == null) {
        source match {
          case x: ConfigBasicParameter[T] => if (x.rule != null) {
            x.rule;
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
      if (this.className == null) {
        source match {
          case x: ConfigBasicParameter[T] => if (x.className != null) {
            x.className;
          }
        };
        null;
      }

      this.className;
    };

    new ConfigBasicParameter[T](cn, sh, md, ld, r, k, d);
  }

  // Members declared in com.mcennis.com.mcennis.dynamicfactory.ConfigBasicParameter
  def merge: AbstractConfigGeneric = ???
  //  def setData(d: com.mcennis.com.mcennis.dynamicfactory.Parameter[T]): com.mcennis.com.mcennis.dynamicfactory

  //  def setData(d:Parameter[T]):AbstractConfigGeneric
};


object BasicParameter extends ParameterTrait {

  def prototype[K](obj:Parameter[K],k: String, d: List[K])(implicit tag: TypeTag[K]): Parameter[K] = new BasicParameter[K](
    k,
    d,
    shortDescription = obj.shortDescription,
    description = obj.description,
    longDescription = obj.longDescription,
    rule = null);

  def prototype[K](obj:Parameter[K],k: String, d: List[K], sD: String, de: String, lD: String, r: SyntaxChecker[K])(implicit tag: TypeTag[K]): Parameter[K] = new BasicParameter[K](
    k,
    d,
    sD,
    de,
    lD,
    r)

  def setKey[T](obj : Parameter[T],k: String)(implicit tag:TypeTag[T]): Parameter[T] = new BasicParameter[T](k, obj.data, obj.shortDescription, obj.description, obj.longDescription, obj.rule)

  def setShortDescription[T](obj : Parameter[T],sd: String)(implicit tag:TypeTag[T]): Parameter[T] = new BasicParameter[T](obj.key, obj.data, sd, obj.description, obj.longDescription, obj.rule)

  def setDescription[T](obj : Parameter[T],d: String)(implicit tag:TypeTag[T]): Parameter[T] = new BasicParameter[T](obj.key, obj.data, obj.shortDescription, d, obj.longDescription, obj.rule)

  def setLongDescription[T](obj : Parameter[T],ld: String)(implicit tag:TypeTag[T]): Parameter[T] = new BasicParameter[T](obj.key, obj.data, obj.shortDescription, obj.description, ld, obj.rule)

  def setRule[T](obj : Parameter[T],r: SyntaxChecker[T])(implicit tag: TypeTag[T]): Parameter[T] = new BasicParameter[T](obj.key, obj.data, obj.shortDescription, obj.description, obj.longDescription, r)

  def set[T](obj : Parameter[T],value: List[T])(implicit tag:TypeTag[T]): Parameter[T] = new BasicParameter[T](obj.key, value, obj.shortDescription, obj.description, obj.longDescription, obj.rule)

  def set[T](obj : Parameter[T],value: T)(implicit tag:TypeTag[T]): Parameter[T] = new BasicParameter[T](obj.key, List[T](value), obj.shortDescription, obj.description, obj.longDescription, obj.rule)

  def set[T](obj : Parameter[T],prop: Property[T])(implicit tag:TypeTag[T]): Parameter[T] = new BasicParameter[T](prop.key, prop.data, obj.shortDescription, obj.description, obj.longDescription, obj.rule)

  def add[T](obj : Parameter[T],value: List[T])(implicit tag:TypeTag[T]): Parameter[T] = new BasicParameter[T](obj.key, obj.data ++ value, obj.shortDescription, obj.description, obj.longDescription, obj.rule)

  def add[T](obj : Parameter[T],value: T)(implicit tag:TypeTag[T]): Parameter[T] = new BasicParameter[T](obj.key, value :: obj.data, obj.shortDescription, obj.description, obj.longDescription, obj.rule)

  def clear[T](obj : Parameter[T])(implicit tag:TypeTag[T]): BasicParameter[T] = new BasicParameter[T](obj.key, Nil, obj.shortDescription, obj.description, obj.longDescription, obj.rule)

  def compare[T](obj:Parameter[T],right: Parameter[T])(implicit tag:TypeTag[T]): Int = {
    var answer: Int = 0;
    answer = obj.key.compareTo(right.key);
    if (answer != 0) {
      return answer;
    }
    answer = obj.data.lengthCompare(right.data.length)
    if (answer != 0) {
      return answer;
    }

    if (obj.data.isEmpty) {
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

  def add[T](obj:BasicParameter[T],r: SyntaxChecker[T])(implicit tag:TypeTag[T]): BasicParameter[T] = new BasicParameter[T](obj.key, obj.data, obj.shortDescription, obj.description, obj.longDescription, r)


  def create[T](config: ConfigBasicParameter[T])(implicit tag: TypeTag[T]): BasicParameter[T] = return new BasicParameter[T](
    config.key.data.head,
    config.data.data,
    config.shortDescription.data.head,
    config.description.data.head,
    config.longDescription.data.head,
    config.rule.data.head);

};

object ConfigBasicParameter extends AbstractConfigGenericSingleton {
  default = new BasicParameter[String](
    "Default",
    List("BasicParameter"),
    "The default class type created in this factory",
    "When choosing between classes of a given interface, this variant is the default if no other is chosen",
    "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
    PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[String],1),1));

  defaultSettings = new BasicParameter[ConfigBasicParameter[String]](
    "Default",
    List(new ConfigBasicParameter[String]),
    "The default class type created in this factory",
    "When choosing between classes of a given interface, this variant is the default if no other is chosen",
    "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
    null);

  availableClasses = new BasicParameter[(String, ConfigBasicParameter[String])](
    "availableClasses",
    List(("BasicParameter", new ConfigBasicParameter[String])),

    "The default class type created in this factory",
    "When choosing between classes of a given interface, this variant is the default if no other is chosen",
    "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
    PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[(String, ConfigBasicParameter[String])],1),Int.MaxValue));


  def mapConfig[T](default: Parameter[ConfigBasicParameter[T]])(implicit tag: TypeTag[T]): Parameter[ConfigBasicParameter[T]] = return new BasicParameter[ConfigBasicParameter[T]](
    "Default",
    List(new ConfigBasicParameter[T]),
    "The default class type created in this factory",
    "When choosing between classes of a given interface, this variant is the default if no other is chosen",
    "As the master factory, this default object type is what is produced if there is no class in this factory matching the one provided, or if an object is created without specifying anything. The parameters needed to construct a reasonable deault of this type are programmed into the deault properties objet and mixed in with any supplied properties prior to construction. These properties are mutable and changeable.",
    PropertyRestriction.setMaxCount(PropertyRestriction.setMinCount(PropertyRestriction.create[ConfigBasicParameter[T]],1),Int.MaxValue));


  def prototype[T](implicit tag: TypeTag[T]): ConfigBasicParameter[T] = new ConfigBasicParameter[T]

  def prototype[T](props: Parameter[_ <: ConfigBasicParameter[T]])(implicit tag: TypeTag[T]): ConfigBasicParameter[T] = new ConfigBasicParameter[T]()

  override def getObject: BasicParameter.type = BasicParameter;

  def getParameter: List[Object] = {
    var ret: List[Object] = Nil
    for (entry: Field <- this.getClass().getDeclaredFields if entry.getClass.getName.contains("Parameter")) {
      ret = entry :: ret
    }
    ret;
  }

  def getParameter(t: String): Object = {
    for (entry: Field <- this.getClass().getDeclaredFields if entry.getClass.getName.contains("Parameter")) {
      if (entry.getName.equals(t)) {
        return entry.get()
      }
    }
    return this;
  }

  def addType(t: String, proto: ConfigBasicParameter[String]): ConfigBasicParameter.type = {
    if (proto == null) {
      //            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No org.com.mcennis.dynamicfactory.property obejct provided");
      throw new Exception("Null Factory Provided")
    }

    this.availableClasses = new BasicParameter[(String, AbstractConfigGeneric)](
      this.availableClasses.key,
      (t, proto) :: this.availableClasses.data,
      this.availableClasses.shortDescription,
      this.availableClasses.description,
      this.availableClasses.longDescription,
      this.availableClasses.rule);
    this;
    //        if(t == null){
    ////            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Null org.com.mcennis.dynamicfactory.property class name added");
    //        }

  }

  def check(props: AbstractConfigGeneric): Boolean = {
    var good: Boolean = true;
    //        for(p <-  props.get() if !this.defaultSettings.check(p)){
    //          false;
    //        }
    true
  }

  def check(parameter: Parameter[Any]): Boolean = {
    // override with config specifics
    return true;
    //return properties.check(parameter);
  }

  def create[T](implicit tag: TypeTag[T]): Parameter[T] = return create[T](default.data.head, new ConfigBasicParameter[T]);

  def create[T](name: String)(implicit tag: TypeTag[T]): Parameter[T] = return this.create[T](name, (new ConfigBasicParameter[T]))

  def create[T](name: String, props: ConfigBasicParameter[T])(implicit tag: TypeTag[T]): Parameter[T] = {
    for (a <- ConfigBasicParameter.availableClasses.data if a._1.equals(name)) {
      // verify the classname is a valid ConfigBasicParameter subclass
      a._2.getObject.getObject match {
        case builder: BasicParameter.type => builder.create[T](props);
      }
      // verify the configuration file is compatible wth the subclass constructor


      //          return ((a.getObject).getObject).create[T](props);
    }
    return BasicParameter.create[T](props);
  }


  def create[R](props: ConfigBasicParameter[R])(implicit tag: TypeTag[R]): Parameter[R] = create[R](default.data.head, props);
};






