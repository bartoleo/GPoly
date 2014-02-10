GPoly.make {
	//randomSeed 10
	//_settings << [twovalues:[remove:false]]
	//_settings << [remove:false]
    constantset = a
    constantmethod b
    twovalues = ["bbb","ccc"]
    value = twovalues
    println output("constantset ${constantset} constantmethod ${constantmethod} value ${value} twovalues ${twovalues} twovalues ${twovalues}")
}