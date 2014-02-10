println GPoly.make {
	//randomSeed 10
	//_settings << [twovalues:[remove:false]]
	//_settings << [remove:false]
    noun = [apple, banana]
    animal = [ape, horse]
    //verb = [eats, launches]
    verb = new File("verbs.json")
    adverb = "https://raw2.github.com/ifnull/buzzwords/master/data/adverbs.json".toURL()
    range = 1..3
    subject = animal
    phrase = ['1 ${subject} ${verb} ${range} ${noun} ${adverb}','2 ${subject} ${verb} ${range} ${noun} ${adverb}','3 ${subject} ${verb} ${range} ${noun} ${adverb}']
}.output('${phrase}')