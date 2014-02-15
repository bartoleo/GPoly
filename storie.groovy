println GPoly.make {
	//randomSeed 10
	//_settings << [twovalues:[remove:false]]
	//_settings << [remove:false]
    inizio = ['C\'era una volta']
    inizio2 = ['','tanto tempo fa', 'tanto tanto tempo fa', ' tantissimo tempo fa', ]
    inizio3 = ['','in un paese lontano', 'a Marene ']
    nome = [Alice, Luca, Tea, Ivan]
    aggettivo = [ciccione, lecchino]
    verbo = ['voleva ${avverbio} mangiare', 'voleva ${avverbio} leccare']
    avverbio = [sempre, spesso]
    nomeAggettivo = ['${nome}','${nome} ${aggettivo}']
    soggetto = _constant(nomeAggettivo)
    altro =  _constant(nomeAggettivo)
    frase = '${inizio} ${inizio2} ${inizio3} ${soggetto} che ${verbo} ${altro} ma ${altro} non ${verbo} ${soggetto}'
}.output('${frase}')