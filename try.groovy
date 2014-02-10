println GPoly.make {
	//randomSeed 10
	//_settings << [twovalues:[remove:false]]
	//_settings << [remove:false]
    noun = [apple, banana]
    adjectif = [red, green, yellow, big, small]
    animal = [ape, horse]
    verb = new File("verbs.json")
    //adverb = "https://raw2.github.com/ifnull/buzzwords/master/data/adverbs.json".toURL()
    adverb = [frequently, fully]
    range = 1..3
    subject = [animal, '${adjectif} ${animal}']
    object = [noun, '${adjectif} ${noun}']
    phrase = '${subject} ${verb} ${range} ${object} ${adverb}'
}.output('${phrase}')