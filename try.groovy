println GPoly.make {
	//randomSeed 10
	//_settings << [twovalues:[remove:false]]
	//_settings << [remove:false]
    noun = [apple, banana]
    animal = [ape, horse]
    verb = [eats, launches]
    subject = animal
    phrase = ['1 ${subject} ${verb} ${noun}','2 ${subject} ${verb} ${noun}','3 ${subject} ${verb} ${noun}']
}.output('${phrase}')