val input = Array("1 2 3 4", "5 6 7 8")
val split1 = input.map(_.split(" "))
val split2 = split1.flatten
val split12 = input.flatMap(_.split(" "))

// show split 1
for(arrV<-split1){
  println
  for(valV<-arrV){
    println(valV)
  }
}


val input2 = Array("one","two")
var count = 0
val map1 = input2.map(x => {
  count = count + 1
  (count, x)
})
