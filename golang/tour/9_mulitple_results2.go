package main

import "fmt"

func swap(x, y string) (string, string) {
  return y, x
}

func main() {
  var a = "hello"
  var b = "world"
  c, d := swap(a, b)
  //fmt.Println(a, b)
  fmt.Println(c, d)
}