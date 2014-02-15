@GrabResolver(name='java.net-m2', 
          root='https://repository.jboss.org/nexus/content/repositories/java.net-m2')
     @Grab(
       group='org.mobicents.external.freetts', 
       module='freetts', 
       version='1.0'
     )
     @Grab(
       group='captcha-sound', 
       module='kevin-voice', 
       version='1.0'
     )
     @Grab(
       group='captcha-sound', 
       module='lexicon', 
       version='1.0'
     )
          @Grab(
       group='captcha-sound', 
       module='voice-en', 
       version='1.0'
     )


import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

def storia = GPoly.make {
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

println storia

Voice voice;
  VoiceManager voiceManager = VoiceManager.getInstance();
  voiceManager.getVoiceInfo()
  voice = voiceManager.getVoice("kevin");
  voice.allocate();
  voice.speak(storia);