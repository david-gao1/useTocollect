package com.gao.demo.隐式转换.自动引入之伴生类01

case class Dog(name: String)

object Dog {

  /**
   * 方法只是简化了对象的创建
   * 所以也可以没有
   *
   * @param name
   * @return
   */
  def apply(name: String): Dog = {
    new Dog(name)
  }

  /**
   * 隐式转换：当需要使用到cat的方法时，编译器会自动扫面此方法，并执行（进行类型转换）
   *
   * @param obj
   * @return
   */
  implicit def object2Cat(obj: Object): Cat = {
    if (obj.getClass == classOf[Dog]) {
      val dog = obj.asInstanceOf[Dog]
      new Cat(dog.name)
    }
    else Nil
  }
}

