int progr=0
Random random = new Random()
100.times{
  def dati = GPoly.make {
    //randomSeed 10
    //_settings << [twovalues:[remove:false]]
    //_settings << [remove:false]
      progr++
      cognome = ['ROSSI','RUSSO','FERRARI','ESPOSITO','BIANCHI','ROMANO','COLOMBO','RICCI','MARINO','GRECO','BRUNO','GALLO','CONTI','DE LUCA','MANCINI','COSTA','GIORDANO','RIZZO','LOMBARDI','MORETTI','BARBIERI','FONTANA','SANTORO','MARIANI','RINALDI','CARUSO','FERRARA','GALLI','MARTINI','LEONE','LONGO','GENTILE','MARTINELLI','VITALE','LOMBARDO','SERRA','COPPOLA','DE SANTIS','MARCHETTI','PARISI','VILLA','CONTE','FERRARO','FERRI','FABBRI','BIANCO','MARINI','GRASSO','VALENTINI','MESSINA','SALA','DE ANGELIS','GATTI','PELLEGRINI','PALUMBO','SANNA','FARINA','RIZZI','MONTI','CATTANEO','MORELLI','AMATO','SILVESTRI','MAZZA','TESTA','GRASSI','PELLEGRINO','CARBONE','GIULIANI','BENEDETTI','BARONE','ROSSETTI','CAPUTO','MONTANARI','GUERRA','PALMIERI','BERNARDI','MARTINO','FIORE','DE ROSA','FERRETTI','BELLINI','BASILE','RIVA','DONATI','PIRAS','VITALI','BATTAGLIA','SARTORI','NERI','COSTANTINI','MILANI','PAGANO','RUGGIERO','SORRENTINO','ORLANDO','DAMICO','NEGRI']
      nome = ['Paolo','Marco','Mario','Giovanni','Luigi','Giacomo','Matteo','Maria','Paola','Roberta','Silvia']
      citta = ['Roma','Torino','Milano','Firenze','Bologna','Genova','Venezia','Napoli','Palermo']
      via = ['Via','Piazza','Corso','Vicolo']
      numero = 1..100
      attivo = random.nextInt(7)?1:0
      record = 'CLI${cognome.padRight(20)}${nome.padRight(20)}${citta.padRight(30)}${(via+" "+citta+", 0"+numero).padRight(40)}${attivo}'+progr.toString().padLeft(10,'0')
  }.output('${record}')
  println dati
}
