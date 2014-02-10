println GPoly.make {
	//randomSeed 10
	//_settings << [twovalues:[remove:false]]
	//_settings << [remove:false]
    noun = [apple, banana]
    animal = [ape, horse]
    verb = [eats, launches]
    range = 1..3
    subject = animal
    phrase = ['1 ${subject} ${verb} ${range} ${noun}','2 ${subject} ${verb} ${range}  ${noun}','3 ${subject} ${verb} ${range} ${noun}']
}.output('${phrase}')