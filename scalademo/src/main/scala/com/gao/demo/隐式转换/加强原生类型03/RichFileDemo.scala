package com.gao.demo.隐式转换.加强原生类型03

import java.io.File

import scala.io.Source


class RichFileDemo(file: File) {
  def read = {
    Source.fromFile(file.getPath).mkString
  }
}

