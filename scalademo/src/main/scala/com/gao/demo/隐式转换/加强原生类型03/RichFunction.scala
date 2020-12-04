package com.gao.demo.隐式转换.加强原生类型03

import java.io.File

object RichFunction {
  implicit def file2RichFile(file: File): RichFileDemo = new RichFileDemo(file)
}
